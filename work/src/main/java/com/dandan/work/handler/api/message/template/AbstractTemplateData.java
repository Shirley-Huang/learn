package com.dandan.work.handler.api.message.template;

public abstract class AbstractTemplateData {

	private PropertyValue first;
	private PropertyValue remark;
	
	public PropertyValue getFirst() {
		return first;
	}

	public void setFirst(PropertyValue first) {
		this.first = first;
	}

	public PropertyValue getRemark() {
		return remark;
	}

	public void setRemark(PropertyValue remark) {
		this.remark = remark;
	}
	
	public static class PropertyValue {
		private String value;
		private String color;

		public PropertyValue(String value, String color) {
			this.value = value;
			this.color = color;
		}
		
		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getColor() {
			return color;
		}

		public void setColor(String color) {
			this.color = color;
		}
	}
}
