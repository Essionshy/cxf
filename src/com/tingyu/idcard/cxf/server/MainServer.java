package com.tingyu.idcard.cxf.server;

import org.apache.cxf.endpoint.Server;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;

import com.tingyu.idcard.cxf.service.impl.IDCardServiceImpl;

/**
 * 开启服务
 * 
 * @author Essionshy
 *
 */
public class MainServer 
{
	private static final String ADDRESS = "http://localhost:9999/idcard";

	public static void main(String[] args) 
	{
		JaxWsServerFactoryBean jaxWsServerFactoryBean = new JaxWsServerFactoryBean();
		jaxWsServerFactoryBean.setAddress(ADDRESS);
		jaxWsServerFactoryBean.setServiceClass(IDCardServiceImpl.class);
		Server server = jaxWsServerFactoryBean.create();
		server.start();
	}
}
