package com.tingyu.idcard.cxf.dao;
/**
 * 
 * @author Essionshy
 *
 */
public interface IDCardDao {
	/**
	 * 根据行政区域代码查询归属地全称
	 * @param code
	 * @return
	 */
	public String getName(int code);

}
