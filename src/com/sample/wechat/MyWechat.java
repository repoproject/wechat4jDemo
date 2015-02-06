package com.sample.wechat;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.sword.wechat4j.WechatSupport;
import org.sword.wechat4j.response.ArticleResponse;
import org.sword.wechat4j.response.MusicResponse;
import org.sword.wechat4j.response.VideoResponse;


/**
 * 微信服务桩
 * @author ChengNing
 * @date   2015年1月7日
 */
public class MyWechat extends WechatSupport {
	
	private static Logger logger = Logger.getLogger(MyWechat.class);

	public MyWechat(HttpServletRequest request) {
		super(request);
	}

	/**
	 * 文本消息
	 */
	@Override
	protected void onText() {
		String content = super.wechatRequest.getContent().trim();
//		String msgId = wechatRequest.getMsgId();
		logger.info(content);
		//文本测试
		if(content.equals("1")){
			responseText("你好，hello world!<a href=\"http://www.baidu.com\">这是链接</a>");
		}
		else if(content.equals("2")){
			responseNew("图文消息", "测试图文消息", "http://upload.qqfuzhi.com/portal/showimg.php?img=e2dnYyk8PHEhIys9Y3t8Z3w9YGd8YXY9YmI9cHx%2BPHtnZ2NMen50f3xydz1wdHosPGFmYX8nTHEuJ3Z2IXFyJnUiICAqcnAnInYhcHJ2InAnKndycidwKyAgdnIqdiN1KitxdyojIysjcSAiJipyK3YqIXd1JCt1JyBxKnIkcCt1JyYkKysicCAjIiokKyogcHd1ICAhcXArciUjI3EhdyYjKiIncSclIiUqJyAkInEgKiV2IiEiJnEgKyp2cXV3cCEmJ3EjcHYqJHIrdytwIyYgIHIicHAgcXFwIiIldyIhNXIuISMrNXEuISMr", 
					"http://www.chengn.com");
			
//			responseNew(title, description, picUrl, url);
//			
//			ArticleResponse item = new ArticleResponse();
//			item.setTitle(title);
//			item.setDescription(description);
//			item.setUrl(url);
//			item.setPicUrl(picUrl);
//			responseNews(item);
//			
//			List<ArticleResponse> items = new ArrayList<ArticleResponse>();
//			items.add(item);
//			responseNews(items);
		}
		else{
			responseText("你好，你的输入为 " + content + "\n"
					+ "请按照如下操作输入:\n"
					+ "1 文本\n"
					+ "2 图文\n");
		}
	}
	/**
	 * 图片消息
	 */
	@Override
	protected void onImage() {
		String picUrl = wechatRequest.getPicUrl();
		String MediaId = wechatRequest.getMediaId();
		String MsgId = wechatRequest.getMsgId();
		
		String result = "图片消息picUrl:" + picUrl + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);
		//responseImage(mediaId);
	}

	/**
	 * 语音消息
	 */
	@Override
	protected void onVoice() {
		String Format = wechatRequest.getFormat();
		String MediaId = wechatRequest.getMediaId();//视频消息媒体id，可以调用多媒体文件下载接口拉取数据
		String MsgId = wechatRequest.getMsgId();
		
		String result = "语音消息Format:" + Format + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);	
		//responseVoice(mediaId);
		
		//回复音乐消息
//		MusicResponse music = new MusicResponse();
//		music.setTitle(title);
//		music.setDescription(description);
//		music.setMusicURL(musicURL);
//		music.setHQMusicUrl(hQMusicUrl);
//		music.setThumbMediaId(thumbMediaId);
//		responseMusic(music);
//		
//		responseMusic(title, description, musicURL, hQMusicUrl, thumbMediaId);
	}

	/**
	 * 视频消息
	 */
	@Override
	protected void onVideo() {
		String ThumbMediaId = wechatRequest.getThumbMediaId();
		String MediaId = wechatRequest.getMediaId();//语音消息媒体id，可以调用多媒体文件下载接口拉取数据
		String MsgId = wechatRequest.getMsgId();
		
		String result = "视频消息ThumbMediaId:" + ThumbMediaId + ", MediaId:" + MediaId + ", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);
		
		//回复视频消息
//		VideoResponse video = new VideoResponse();
//		video.setTitle(title);
//		video.setDescription(description);
//		video.setMediaId(mediaId);
//		responseVideo(video);
//		
//		responseVideo(mediaId, title, description);
	}
	
	/**
	 * 地理位置消息
	 */
	@Override
	protected void onLocation() {
		String Location_X = wechatRequest.getLocation_X();
		String Location_Y = wechatRequest.getLocation_Y();
		String Scale = wechatRequest.getScale();
		String Label = wechatRequest.getLabel();
		String MsgId = wechatRequest.getMsgId();
		
		String result = "地理位置消息Location_X:" + Location_X + ", Location_Y:" + Location_Y + 
				", Scale:" + Scale + ", Label:" + Label + 
				", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);	
	}
	/**
	 * 链接消息
	 */
	@Override
	protected void onLink() {
		String Title = wechatRequest.getTitle();
		String Description = wechatRequest.getDescription();
		String Url = wechatRequest.getUrl();
		String MsgId = wechatRequest.getMsgId();
		
		String result = "链接消息Title:" + Title + ", Description:" + Description + 
				", Url:" + Url + 
				", MsgId:" + MsgId;
		logger.info(result);
		responseText(result);	
	}
	
	
	/**
	 * 未知消息类型，错误处理
	 */
	@Override
	protected void onUnknown() {
		String msgType = wechatRequest.getMsgType();
		
		String result = "未知消息msgType:" + msgType;
		logger.info(result);
		responseText(result);

	}

	/**
	 * 扫描二维码事件
	 */
	@Override
	protected void scan() {
		String FromUserName = wechatRequest.getFromUserName();
		String Ticket = wechatRequest.getTicket();
		
		String result = "扫描二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;
		logger.info(result);
		responseText(result);
	}

	/**
	 * 订阅事件
	 */
	@Override
	protected void subscribe() {
		String FromUserName = wechatRequest.getFromUserName();
		//用户未关注时扫描二维码事件,会多一个EventKey和Ticket节点
		String Ticket = wechatRequest.getTicket();

		String result = "订阅事件FromUserName:" + FromUserName;
		if(StringUtils.isNotBlank(Ticket)){
			result = "扫描带场景值二维码事件FromUserName:" + FromUserName + ", Ticket:" + Ticket;
		}
		logger.info(result);
		responseText(result);
	}
	
	/**
	 * 取消订阅事件
	 */
	@Override
	protected void unSubscribe() {
		String FromUserName = wechatRequest.getFromUserName();
		String result = "取消订阅事件FromUserName:" + FromUserName;
		logger.info(result);
		responseText(result);
	}
	
	/**
	 * 点击菜单跳转链接时的事件推送
	 */
	@Override
	protected void view() {
		String link = super.wechatRequest.getEventKey();
		logger.info("点击菜单跳转链接时的事件推送link:" + link);
		responseText("点击菜单跳转链接时的事件推送link:" + link);
	}

	/**
	 * 自定义菜单事件
	 */
	@Override
	protected void click() {
		String key = super.wechatRequest.getEventKey();
		logger.info("自定义菜单事件eventKey:" + key);
		responseText("自定义菜单事件eventKey:" + key);
	}
	
	/**
	 * 上报地理位置事件
	 */
	@Override
	protected void location() {
		String Latitude = wechatRequest.getLatitude();
		String Longitude = wechatRequest.getLongitude();
		String Precision = wechatRequest.getPrecision();
		String result = "上报地理位置事件Latitude:" + Latitude + ", Longitude:" + Longitude + ", Precision:" + Precision;
		logger.info(result);
		responseText(result);
	}
	
	/**
	 * 模板消息发送成功推送事件
	 */
	@Override
	protected void templateMsgCallback() {
		String MsgID = wechatRequest.getMsgId();
		String Status = wechatRequest.getStatus();
		String result = "模板消息发送成功推送事件MsgID:" + MsgID + ", Status:" + Status;
		logger.info(result);
	}
	/**
	 * 弹出地理位置选择器的事件
	 */
	@Override
	protected void locationSelect() {
		String Location_X = wechatRequest.getSendLocationInfo().getLocation_X();
		String Location_Y = wechatRequest.getSendLocationInfo().getLocation_Y();
		String Scale = wechatRequest.getSendLocationInfo().getScale();
		String Label = wechatRequest.getSendLocationInfo().getLabel();
		String Poiname = wechatRequest.getSendLocationInfo().getPoiname();
		String result = "弹出地理位置选择器的事件Location_X:" + Location_X + 
				", Location_Y:" + Location_Y+ 
				", Scale:" + Scale+ 
				", Label:" + Label+ 
				", Poiname:" + Poiname;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 弹出拍照或者相册发图的事件
	 */
	@Override
	protected void picPhotoOrAlbum() {
		String Count = wechatRequest.getSendPicsInfo().getCount();
		String PicMd5Sum = "";
		if(StringUtils.isNotBlank(Count) && !Count.equals("0")){
			PicMd5Sum = wechatRequest.getSendPicsInfo().getItem().get(0).getPicMd5Sum();
		}
		String result = "弹出系统拍照发图的事件Count:" + Count + ", PicMd5Sum:" + PicMd5Sum;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 弹出系统拍照发图的事件
	 */
	@Override
	protected void picSysPhoto() {
		String Count = wechatRequest.getSendPicsInfo().getCount();
		String result = "弹出系统拍照发图的事件Count:" + Count ;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 弹出微信相册发图器的事件推送
	 */
	@Override
	protected void picWeixin() {
		String Count = wechatRequest.getSendPicsInfo().getCount();
		String result = "弹出系统拍照发图的事件Count:" + Count ;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 扫码推事件
	 * 
	 */
	@Override
	protected void scanCodePush() {
		String ScanType = wechatRequest.getScanCodeInfo().getScanType();
		String ScanResult = wechatRequest.getScanCodeInfo().getScanResult();
		String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
		logger.info(result);
		responseText(result);
	}
	/**
	 * 扫码推事件且弹出“消息接收中”提示框的事件
	 */
	@Override
	protected void scanCodeWaitMsg() {
		String ScanType = wechatRequest.getScanCodeInfo().getScanType();
		String ScanResult = wechatRequest.getScanCodeInfo().getScanResult();
		String result = "扫码推事件ScanType:" + ScanType + ", ScanResult:" + ScanResult;
		logger.info(result);
		responseText(result);
	}
	



}
