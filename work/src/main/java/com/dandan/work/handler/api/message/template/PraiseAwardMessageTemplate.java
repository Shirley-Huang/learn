package com.dandan.work.handler.api.message.template;

import com.alibaba.fastjson.annotation.JSONField;
import com.dandan.work.handler.api.message.template.AbstractTemplateData.PropertyValue;

public class PraiseAwardMessageTemplate implements IWeixinMessageTemplate {
	private final static String MESSAGE_FIRST = "好评有奖通知";
	private final static String MESSAGE_REMARK = "点击查看工单详情";

	private final String templateId;
	private final String openId;
	private final String orderSummary;
	private final String auditStatus;
	private final String url;

	public PraiseAwardMessageTemplate(String templateId, String openId, String orderSummary, String auditStatus, String url) {
		super();
		this.openId = openId;
		this.templateId = templateId;
		this.orderSummary = orderSummary;
		this.auditStatus = auditStatus;
		this.url = url;
	}

	@Override
	public String getTemplateId() {
		return templateId;
	}

	@Override
	public WeixinTemplateMessageRO toMessage() {
		WeixinTemplateMessageRO mo = new WeixinTemplateMessageRO();
		mo.setToUser(openId);
		mo.setTopColor(WEIXIN_TEMPLATE_MESSAGE_COLOR_RED);
		mo.setTemplateId(templateId);
		mo.setUrl(url);

		OrderCreatedTemplateData orderCanceledMessage = new OrderCreatedTemplateData();
		orderCanceledMessage.setFirst(new PropertyValue(MESSAGE_FIRST, WEIXIN_TEMPLATE_MESSAGE_COLOR_DARK_BLUE));
		orderCanceledMessage.setOrderSummary(new PropertyValue(orderSummary, WEIXIN_TEMPLATE_MESSAGE_COLOR_DARK_BLUE));
		orderCanceledMessage.setAuditStatus(new PropertyValue(auditStatus, WEIXIN_TEMPLATE_MESSAGE_COLOR_DARK_BLUE));
		orderCanceledMessage.setRemark(new PropertyValue(MESSAGE_REMARK, WEIXIN_TEMPLATE_MESSAGE_COLOR_RED));

		mo.setData(orderCanceledMessage);

		return mo;
	}

	public static class OrderCreatedTemplateData extends AbstractTemplateData {
		@JSONField(name = "keyword1")
		private PropertyValue orderSummary;
		//内容
		@JSONField(name = "keyword2")
		private PropertyValue auditStatus;

		public PropertyValue getOrderSummary() {
			return orderSummary;
		}

		public void setOrderSummary(PropertyValue orderSummary) {
			this.orderSummary = orderSummary;
		}

		public PropertyValue getAuditStatus() {
			return auditStatus;
		}

		public void setAuditStatus(PropertyValue auditStatus) {
			this.auditStatus = auditStatus;
		}
	}
	@Override
	public String getOpenId() {
		return this.openId;
	}
}
