package com.monitor.core.bean.echarts.comp;

public class TextStyle {
	private String color = "#333";
	private String fontStyle = "normal";
	private String fontWeight = "normal";
	private String fontFamily = "sans-serif";
	private String fontSize = "18";
	private String align;
	private String verticalAlign;
	private String lineHeight;
	private String width;
	private String height;
	private String textBorderColor = "transparent";
	private String textBorderWidth = "0";
	private String textShadowColor = "transparent";
	private String textShadowBlur = "0";
	private String textShadowOffsetX = "0";
	private String textShadowOffsetY = "0";
	
	public TextStyle() {
	}
	
	public TextStyle(String color, String fontSize) {
		this.color = color;
		this.fontSize = fontSize;
	}

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getFontStyle() {
		return fontStyle;
	}
	public void setFontStyle(String fontStyle) {
		this.fontStyle = fontStyle;
	}
	public String getFontWeight() {
		return fontWeight;
	}
	public void setFontWeight(String fontWeight) {
		this.fontWeight = fontWeight;
	}
	public String getFontFamily() {
		return fontFamily;
	}
	public void setFontFamily(String fontFamily) {
		this.fontFamily = fontFamily;
	}
	public String getFontSize() {
		return fontSize;
	}
	public void setFontSize(String fontSize) {
		this.fontSize = fontSize;
	}
	public String getAlign() {
		return align;
	}
	public void setAlign(String align) {
		this.align = align;
	}
	public String getVerticalAlign() {
		return verticalAlign;
	}
	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
	}
	public String getLineHeight() {
		return lineHeight;
	}
	public void setLineHeight(String lineHeight) {
		this.lineHeight = lineHeight;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getTextBorderColor() {
		return textBorderColor;
	}
	public void setTextBorderColor(String textBorderColor) {
		this.textBorderColor = textBorderColor;
	}
	public String getTextBorderWidth() {
		return textBorderWidth;
	}
	public void setTextBorderWidth(String textBorderWidth) {
		this.textBorderWidth = textBorderWidth;
	}
	public String getTextShadowColor() {
		return textShadowColor;
	}
	public void setTextShadowColor(String textShadowColor) {
		this.textShadowColor = textShadowColor;
	}
	public String getTextShadowBlur() {
		return textShadowBlur;
	}
	public void setTextShadowBlur(String textShadowBlur) {
		this.textShadowBlur = textShadowBlur;
	}
	public String getTextShadowOffsetX() {
		return textShadowOffsetX;
	}
	public void setTextShadowOffsetX(String textShadowOffsetX) {
		this.textShadowOffsetX = textShadowOffsetX;
	}
	public String getTextShadowOffsetY() {
		return textShadowOffsetY;
	}
	public void setTextShadowOffsetY(String textShadowOffsetY) {
		this.textShadowOffsetY = textShadowOffsetY;
	}
}
