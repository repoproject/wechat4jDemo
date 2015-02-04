package com.sample.wechat;

import org.sword.wechat4j.token.TokenProxy;

public class JsSdk {
	
	/**
	 * 将此方法得到的jsapi_ticket需要放在jsp页面发送到客户端的调用js文件中
	 * @return
	 */
	public String ticket(){
		return TokenProxy.jsApiTicket();
	}

}
