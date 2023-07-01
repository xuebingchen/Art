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

import com.art.common.websocket.core.annotation.OnMessage;
import com.art.common.websocket.core.support.MethodArgumentResolver;
import io.netty.channel.Channel;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import org.springframework.core.MethodParameter;

public class TextMethodArgumentResolver implements MethodArgumentResolver {

	@Override
	public boolean support(MethodParameter parameter) {
		return parameter.getMethod().isAnnotationPresent(OnMessage.class)
				&& String.class.isAssignableFrom(parameter.getParameterType());
	}

	@Override
	public Object resolveArgument(MethodParameter parameter, Channel channel, Object object) throws Exception {
		TextWebSocketFrame textFrame = (TextWebSocketFrame) object;
		return textFrame.text();
	}

}
