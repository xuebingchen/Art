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

package com.art.common.websocket.core.support;

import com.art.common.websocket.core.annotation.WebSocketEndpoint;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.filter.AnnotationTypeFilter;

import java.util.Set;

public class EndpointClassPathScanner extends ClassPathBeanDefinitionScanner {

	public EndpointClassPathScanner(BeanDefinitionRegistry registry, boolean useDefaultFilters) {
		super(registry, useDefaultFilters);
	}

	/**
	 * add scan endpoint
	 * @param basePackages package
	 * @return Set<BeanDefinitionHolder>
	 */
	@Override
	protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
		// add scan
		addIncludeFilter(new AnnotationTypeFilter(WebSocketEndpoint.class));
		return super.doScan(basePackages);
	}

}