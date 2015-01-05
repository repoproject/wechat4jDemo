package com.sample.wechat;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.sword.wechat4j.WechatSupport;

public class MyWechat extends WechatSupport {
	
	private static Logger logger = Logger.getLogger(MyWechat.class);


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
		String content = super.wechatRequest.getContent().trim();
		logger.info(content);
		//文本测试
		if(content.equals("1")){
			responseText("你好，hello world!<a href=\"http://www.baidu.com\">这是链接</a>");
		}
		else if(content.equals("2")){
			responseNew("图文消息", "测试图文消息", "http://upload.qqfuzhi.com/portal/showimg.php?img=e2dnYyk8PHEhIys9Y3t8Z3w9YGd8YXY9YmI9cHx%2BPHtnZ2NMen50f3xydz1wdHosPGFmYX8nTHEuJ3Z2IXFyJnUiICAqcnAnInYhcHJ2InAnKndycidwKyAgdnIqdiN1KitxdyojIysjcSAiJipyK3YqIXd1JCt1JyBxKnIkcCt1JyYkKysicCAjIiokKyogcHd1ICAhcXArciUjI3EhdyYjKiIncSclIiUqJyAkInEgKiV2IiEiJnEgKyp2cXV3cCEmJ3EjcHYqJHIrdytwIyYgIHIicHAgcXFwIiIldyIhNXIuISMrNXEuISMr", 
					"http://www.chengn.com");
		}
		else{
			responseText("你好，你的输入为 " + content + "\n"
					+ "请按照如下操作输入:\n"
					+ "1 文本\n"
					+ "2 图文\n");
		}
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

	@Override
	protected void templateMsgCallback() {
		// TODO Auto-generated method stub
		
	}

}
