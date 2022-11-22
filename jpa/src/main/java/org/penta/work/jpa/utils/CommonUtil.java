package org.penta.work.jpa.utils;

import java.util.UUID;

public class CommonUtil {

	public static Boolean validateUUID(UUID uuid) {
		
		String[] arr = uuid.toString().split("-");
		if(arr.length == 5 && arr[0] != "-" && arr[4] != "-") {
			return true;
		}
		return false;
	}
}
