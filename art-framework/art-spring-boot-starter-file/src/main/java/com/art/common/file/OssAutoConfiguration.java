/*
 * COPYRIGHT (C) 2022 Art AUTHORS(fxzcloud@gmail.com). ALL RIGHTS RESERVED.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.art.common.file;

import com.art.common.file.service.OssTemplate;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

/**
 * @author fxz
 */
@AutoConfiguration
@AllArgsConstructor
@EnableConfigurationProperties({ OssProperties.class })
public class OssAutoConfiguration {

	private final OssProperties properties;

	@Bean
	@ConditionalOnMissingBean(OssTemplate.class)
	@ConditionalOnProperty(name = "oss.enable", havingValue = "true", matchIfMissing = true)
	public OssTemplate ossTemplate() {
		return new OssTemplate(properties);
	}

}