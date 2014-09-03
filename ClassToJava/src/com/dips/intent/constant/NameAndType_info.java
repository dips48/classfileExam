package com.dips.intent.constant;

public class NameAndType_info extends Constant_info{
	byte[] name_index=new byte[2];
	byte[] descriptor_index=new byte[2];
	public NameAndType_info(){
		setTag(ConstantType.CONSTANT_NameAndType);
	}
	public byte[] getName_index() {
		return name_index;
	}
	public void setName_index(byte[] name_index) {
		this.name_index = name_index;
	}
	public byte[] getDescriptor_index() {
		return descriptor_index;
	}
	public void setDescriptor_index(byte[] descriptor_index) {
		this.descriptor_index = descriptor_index;
	}
}
