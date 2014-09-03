package com.dips.intent.constant;

public class MethodType_info extends Constant_info{
	byte[] descriptor_index=new byte[2];
	public MethodType_info(){
		setTag(ConstantType.CONSTANT_NameAndType);
	}
	public byte[] getDescriptor_index() {
		return descriptor_index;
	}
	public void setDescriptor_index(byte[] descriptor_index) {
		this.descriptor_index = descriptor_index;
	}

}
