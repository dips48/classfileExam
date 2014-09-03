package com.dips.intent.constant;

public class InvokeDynamic_info extends Constant_info{
	byte[] bootstrap_method_attr_index=new byte[2];
	byte[] name_and_tyoe_index=new byte[2];
	public InvokeDynamic_info(){
		setTag(ConstantType.CONSTANT_InvokeDynamic);
	}
	public byte[] getBootstrap_method_attr_index() {
		return bootstrap_method_attr_index;
	}
	public void setBootstrap_method_attr_index(byte[] bootstrap_method_attr_index) {
		this.bootstrap_method_attr_index = bootstrap_method_attr_index;
	}
	public byte[] getName_and_tyoe_index() {
		return name_and_tyoe_index;
	}
	public void setName_and_tyoe_index(byte[] name_and_tyoe_index) {
		this.name_and_tyoe_index = name_and_tyoe_index;
	}
}
