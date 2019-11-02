package com.tingyu.idcard.cxf.entity;

public class Area {
	private Integer code;
	private String name;
	
	public Area() {}

	
	public Area(Integer code, String name) {		
		this.code = code;
		this.name = name;
	}


	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Area [code=" + code + ", name=" + name + "]";
	};
	
}
