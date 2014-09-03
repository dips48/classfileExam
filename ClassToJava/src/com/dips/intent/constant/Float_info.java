package com.dips.intent.constant;

public class Float_info extends Constant_info{
	byte[] bytes=new byte[4];
	public Float_info(){
		setTag(ConstantType.CONSTANT_Float);
	}
	public byte[] getBytes() {
		return bytes;
	}
	public void setBytes(byte[] bytes) {
		this.bytes = bytes;
	}
}
