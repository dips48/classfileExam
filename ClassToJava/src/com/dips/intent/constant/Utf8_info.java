package com.dips.intent.constant;

public class Utf8_info extends Constant_info{
	byte[] length=new byte[2];
	byte[] descriptor_index;
	public Utf8_info(){
		setTag(ConstantType.CONSTANT_Utf8);
	}
	public byte[] getLength() {
		return length;
	}
	public void setLength(byte[] length) {
		this.length = length;
	}
	public byte[] getDescriptor_index() {
		return descriptor_index;
	}
	public void setDescriptor_index(byte[] descriptor_index) {
		this.descriptor_index = descriptor_index;
	}
}
