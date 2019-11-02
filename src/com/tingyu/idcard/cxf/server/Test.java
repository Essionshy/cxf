package com.tingyu.idcard.cxf.server;

import com.tingyu.idcard.cxf.service.IDCardService;
import com.tingyu.idcard.cxf.service.impl.IDCardServiceImpl;

public class Test {
	public static void main(String[] args) {
		IDCardService idCardService = new IDCardServiceImpl();
		String idcard = "533400195810246958";
		String result = idCardService.getGender(idcard);
		String birthday = idCardService.getBirthday(idcard);
		Integer age = idCardService.getAge(idcard);
		int qhdm = idCardService.getQHDM(idcard);
		String area = idCardService.getArea(idcard);
		System.out.println(area);
		System.out.println(qhdm);
		System.out.println(birthday);
		System.out.println(result);
	}
}
