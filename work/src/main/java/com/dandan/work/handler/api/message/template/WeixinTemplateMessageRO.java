package com.dandan.work.handler.api.message.template;

import com.alibaba.fastjson.annotation.JSONField;

public class WeixinTemplateMessageRO {
	
	@JSONField(name="touser")
	private String toUser;
	
	@JSONField(name="template_id")
	private String templateId;
	
	private String url;
	
	@JSONField(name="topcolor")
	private String topColor;
	
	private AbstractTemplateData data;
	
	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getTopColor() {
		return topColor;
	}

	public void setTopColor(String topColor) {
		this.topColor = topColor;
	}

	public AbstractTemplateData getData() {
		return data;
	}

	public void setData(AbstractTemplateData data) {
		this.data = data;
	}
	
}
