/*
 * COPYRIGHT (C) 2023 Art AUTHORS(fxzcloud@gmail.com). ALL RIGHTS RESERVED.
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

package com.art.common.core.model;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 部门的数据权限 Response DTO
 *
 * @author fxz
 */
@Data
public class DeptDataPermissionRespEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 是否可查看全部数据
	 */
	private Boolean all = false;

	/**
	 * 是否可查看自己的数据
	 */
	private Boolean self = false;

	/**
	 * 可查看的部门编号数组
	 */
	private Set<Long> deptIds = new HashSet<>();

}