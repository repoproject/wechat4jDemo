package com.sample.wechat;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.sword.wechat4j.message.CustomerMsg;
import org.sword.wechat4j.user.UserManager;

/**
 * Servlet implementation class Hello
 */
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Logger logger = Logger.getLogger(Hello.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Hello() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "你好，wechat4j";
		String op = request.getParameter("op");
		if(StringUtils.isNotBlank(op)){
			//主动发送客服消息
			if(op.equals("1")){
				sendMsg();
				result = "已发送";
			}
		}
		response.setCharacterEncoding("UTF-8");//服务器编码
		response.setHeader("content-type", "text/html;charset=UTF-8");//浏览器编码
		PrintWriter out = response.getWriter();
		out.println(result);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String result = "你好，wechat4j";
		response.setCharacterEncoding("UTF-8");
		response.setHeader("content-type", "text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}
	
	/**
	 * 单个发送
	 */
	private void sendMsg(){
		logger.info("主动发送消息demo");
		//获得关注者列表，发送给第一个人消息
		UserManager userManager = new UserManager();
		List<Object> userList = userManager.subscriberList();
		if(userList.size() > 0){
			String toUserOpenId = userList.get(0).toString();
			String content = "主动发送";
			CustomerMsg customerMsg = new CustomerMsg(toUserOpenId);
			customerMsg.sendText(content);
		}
	}


}
