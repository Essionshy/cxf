package com.tingyu.idcard.cxf.service.impl;

import com.tingyu.idcard.cxf.dao.IDCardDao;
import com.tingyu.idcard.cxf.dao.impl.IDCardDaoImpl;
import com.tingyu.idcard.cxf.service.IDCardService;

/**
 * 
 * @author Essionshy
 *
 */
public class IDCardServiceImpl implements IDCardService {
	private IDCardDao idcardDao=new IDCardDaoImpl();
	@Override
	public Integer getAge(String idcard) {
		
		
		return null;
	}

	@Override
	public String getBirthday(String idcard) {

		StringBuilder builder = new StringBuilder();
		String year = idcard.substring(6, 10);
		String month = idcard.substring(10, 12);
		String day = idcard.substring(12, 14);
		String birthday = builder.append(year).append("-").append(month).append("-").append(day).toString();
		
		return birthday;
	}

	@Override
	public String getGender(String idcard) {
		int num = Integer.parseInt(idcard.substring(16, 17));
		return num % 2 == 0 ? "女" : "男";
	}

	@Override
	public String getArea(String idcard) {

		int code=getQHDM(idcard);
		String name = idcardDao.getName(code);
		return name;
	}
	/**
	 * QHDM
	 * @return
	 */
	public int getQHDM(String idcard) {
		return Integer.parseInt(idcard.substring(0,6));
		
	}

}
