package com.dandan.work.handler.api.message.template;


public interface IWeixinMessageTemplate {
	
	public final static String WEIXIN_TEMPLATE_MESSAGE_COLOR_RED = "#EC7500";
	public final static String WEIXIN_TEMPLATE_MESSAGE_COLOR_DARK_BLUE = "#173177";
	
	public String getTemplateId();

	public String getOpenId();
	
	public WeixinTemplateMessageRO toMessage();

}
