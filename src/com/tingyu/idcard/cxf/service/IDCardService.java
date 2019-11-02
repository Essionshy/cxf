package com.tingyu.idcard.cxf.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface IDCardService {
	@WebMethod
	@WebResult(name = "Age")
	public Integer getAge(@WebParam(name = "idcard")String idcard);
	@WebMethod
	@WebResult(name = "Birthday")
	public String getBirthday(@WebParam(name = "idcard")String idcard);
	@WebMethod
	@WebResult(name = "Gender")
	public String getGender(@WebParam(name = "idcard")String idcard);
	@WebMethod
	@WebResult(name = "Area")
	public String getArea(@WebParam(name = "idcard")String idcard);
	@WebMethod
	@WebResult(name = "QHDM")
	public int getQHDM(@WebParam(name = "idcard")String idcard);
}
