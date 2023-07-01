/*
 *   COPYRIGHT (C) 2023 Art AUTHORS(fxzcloud@gmail.com). ALL RIGHTS RESERVED.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */

package com.art.common.websocket.core.support.impl.resolver;

import com.art.common.websocket.core.annotation.PathVariable;
import com.art.common.websocket.core.support.MethodArgumentResolver;
import io.netty.channel.Channel;
import org.springframework.beans.TypeConverter;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.core.MethodParameter;

import java.util.Map;

import static com.art.common.websocket.core.support.WebSocketEndpointEventServer.URI_TEMPLATE;

public class PathVariableMethodArgumentResolver implements MethodArgumentResolver {

	private final AbstractBeanFactory beanFactory;

	public PathVariableMethodArgumentResolver(AbstractBeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	@Override
	public boolean support(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(PathVariable.class);
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, Channel channel, Object object) throws Exception {
		PathVariable ann = parameter.getParameterAnnotation(PathVariable.class);
		String name = ann.value();
		if (name.isEmpty()) {
			name = parameter.getParameterName();
			if (name == null) {
				throw new IllegalArgumentException(
						"Name for argument type [" + parameter.getNestedParameterType().getName()
								+ "] not available, and parameter name information not found in class file either.");
			}
		}
		Map<String, String> uriTemplateVars = channel.attr(URI_TEMPLATE).get();
		Object arg = (uriTemplateVars != null ? uriTemplateVars.get(name) : null);
		TypeConverter typeConverter = beanFactory.getTypeConverter();
		return typeConverter.convertIfNecessary(arg, parameter.getParameterType());
	}

}
