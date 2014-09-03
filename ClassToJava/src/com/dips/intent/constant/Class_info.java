package com.dips.intent.constant;

public class Class_info extends Constant_info{
	byte[] name_index=new byte[2];
	
	public Class_info(){
		setTag(ConstantType.CONSTANT_Class);
	}
	
	public byte[] getName_index() {
		return name_index;
	}
	public void setName_index(byte[] name_index) {
		this.name_index = name_index;
	}
}
