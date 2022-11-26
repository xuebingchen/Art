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

package com.art.system.manager;

import com.art.system.dao.dataobject.UserRoleDO;
import com.art.system.dao.mysql.UserRoleMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Fxz
 * @version 0.0.1
 * @date 2022/11/26 13:22
 */
@RequiredArgsConstructor
@Component
public class UserRoleManager {

	private final UserRoleMapper userRoleMapper;

	public void deleteUserRoleByRoleId(Long id) {
		userRoleMapper.delete(Wrappers.<UserRoleDO>lambdaQuery().eq(UserRoleDO::getRoleId, id));
	}

	public void deleteUserRolesByUserIds(List<String> userIds) {
		userRoleMapper.delete(Wrappers.<UserRoleDO>lambdaQuery().in(UserRoleDO::getUserId, userIds));
	}

	public List<UserRoleDO> getUserRoleByUserId(Long userId) {
		return userRoleMapper.selectList(Wrappers.<UserRoleDO>lambdaQuery().eq(UserRoleDO::getUserId, userId));
	}

	public void addUserRoles(List<UserRoleDO> list) {
		list.forEach(userRoleMapper::insert);
	}

}
