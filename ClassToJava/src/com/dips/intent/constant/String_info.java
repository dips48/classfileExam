package com.dips.intent.constant;

public class String_info extends Constant_info{
	byte[] string_index=new byte[2];
	public String_info(){
		setTag(ConstantType.CONSTANT_String);
	}
	public byte[] getString_index() {
		return string_index;
	}
	public void setString_index(byte[] string_index) {
		this.string_index = string_index;
	}
}
