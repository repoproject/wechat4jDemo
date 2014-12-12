package com.sample.wechat;

import javax.servlet.http.HttpServletRequest;

import org.sword.wechat4j.WechatSupport;

public class MyWechat extends WechatSupport {


	public MyWechat(HttpServletRequest request) {
		super(request);
	}

	@Override
	protected void click() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void location() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onImage() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onLink() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onLocation() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onText() {
		responseText("hello world!");
	}

	@Override
	protected void onUnknown() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void scan() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void subscribe() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void unSubscribe() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void view() {
		// TODO Auto-generated method stub

	}

}
