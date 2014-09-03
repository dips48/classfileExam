package com.dips.intent.attribute;

public class Attribute_info {
	byte[] attribute_name_index=new byte[2];
	byte[] attribute_length=new byte[4];
	byte[] info;
	
	public Attribute_info(){
	    
	}
	public void init(){
	    
	}
	 public Attribute_info(Attribute_info attributeinfo){
	        this.setAttribute_name_index(attributeinfo.getAttribute_name_index());
	        this.setAttribute_length(attributeinfo.getAttribute_length());
	        this.setInfo(attributeinfo.getInfo());
	    }
	public byte[] getAttribute_name_index() {
		return attribute_name_index;
	}
	public void setAttribute_name_index(byte[] attribute_name_index) {
		this.attribute_name_index = attribute_name_index;
	}
	public byte[] getAttribute_length() {
		return attribute_length;
	}
	public void setAttribute_length(byte[] attribute_length) {
		this.attribute_length = attribute_length;
	}
	public byte[] getInfo() {
		return info;
	}
	public void setInfo(byte[] info) {
		this.info = info;
	}
}
