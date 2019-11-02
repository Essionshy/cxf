package com.tingyu.idcard.cxf.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.tingyu.idcard.cxf.dao.IDCardDao;
import com.tingyu.idcard.cxf.util.JDBCUtils;

public class IDCardDaoImpl implements IDCardDao {

	@Override
	public String getName(int code) {
		String sql="select name from t_country where code=?";
		Object [] params= {code};
		ResultSet rs=JDBCUtils.executeQuery(sql, params);
		try {
			if(rs.next()) {
				return rs.getString("name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			JDBCUtils.close(rs,JDBCUtils.preparedStatement,JDBCUtils.connection);
		}
		return null;
	}

}
