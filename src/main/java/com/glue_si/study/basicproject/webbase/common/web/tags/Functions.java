package com.glue_si.study.basicproject.webbase.common.web.tags;

import java.util.Collection;

import com.glue_si.study.basicproject.webbase.common.constants.SystemCodeConstants.Permissions;
import com.glue_si.study.basicproject.webbase.components.UserInfo;

public class Functions {

	public static boolean contains(Collection<?> collection, Object value) {
		if (collection == null) {
			return false;
		}
		return collection.contains(value);
	}

	public static boolean hasPermission(UserInfo userInfo, String permission) {

		if (userInfo.getPermissions() == null) {
			return false;
		}
		return userInfo.getPermissions().contains(Permissions.valueOf(permission));
	}

}
