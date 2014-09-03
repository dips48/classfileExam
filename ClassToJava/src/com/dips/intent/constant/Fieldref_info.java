package com.dips.intent.constant;

public class Fieldref_info extends Constant_info{
	byte[] class_index=new byte[2];
	byte[] name_and_type_index=new byte[2];
	public Fieldref_info(){
		setTag(ConstantType.CONSTANT_Fieldref);
	}
	public byte[] getClass_index() {
		return class_index;
	}
	public void setClass_index(byte[] class_index) {
		this.class_index = class_index;
	}
	public byte[] getName_and_type_index() {
		return name_and_type_index;
	}
	public void setName_and_type_index(byte[] name_and_type_index) {
		this.name_and_type_index = name_and_type_index;
	}
}
