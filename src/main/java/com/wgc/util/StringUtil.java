package com.wgc.util;

import org.apache.commons.lang3.StringUtils;

public class StringUtil {
	public static void main(String[] args) throws Exception {
		String b = null;
		if(!StringUtils.isBlank(b)){
			System.out.println("b is not null");
		}else {
			System.out.println("b is null");
		}
	}
}
