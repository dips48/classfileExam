package com.dips.intent.constant;

public class Integer_info extends Constant_info{
	byte[] bytes=new byte[4];
	public Integer_info(){
		setTag(ConstantType.CONSTANT_Interger);
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
