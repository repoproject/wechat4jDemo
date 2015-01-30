package com.sample.wechat;

import org.sword.wechat4j.token.Token;
import org.sword.wechat4j.token.server.CustomerServer;

public class JsApiTicketCustomerServer extends CustomerServer{

	public String find() {
		String jsApiTicket = null;
		//执行数据库操作
//		String sql = "select cfgValue from cfg where cfg.cfgKey = 'jsapi_ticket'";
//		jsApiTicket = DBUtil.query(sql);
		return jsApiTicket;
	}

	/* (non-Javadoc)
	 * @see org.sword.wechat4j.token.DbAccessTokenServer#save()
	 */
	@Override
	public boolean save(Token jsApiTicket) {
		//如果没有需要插入，如果有的就更新，假设已经有了数据库配置项
//		String sql = "update cfg set cfg.cfgValue=" + jsApiTicket.getToken() + 
//				" where cfg.cfgKey= 'access_token'";
//		DBUtil.execute(sql);
		return true;
	}

}
