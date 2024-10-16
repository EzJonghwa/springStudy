package com.future.my.member.vo;

public class OptionVO {
	
	private int oId;
	private String oContent;
	
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public String getoContent() {
		return oContent;
	}
	public void setoContent(String oContent) {
		this.oContent = oContent;
	}
	
	@Override
	public String toString() {
		return "OptionVO [oId=" + oId + ", oContent=" + oContent + "]";
	}
	
	
}
