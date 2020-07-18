package com.nov.utils;

import java.util.UUID;

public class UUIDHelper {

	public String getUUID() {
		String uuid = UUID.randomUUID().toString().replace("-", "");
		return uuid;
	}

}
