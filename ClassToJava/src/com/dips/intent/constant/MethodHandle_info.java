package com.dips.intent.constant;

public class MethodHandle_info extends Constant_info{
	byte[] reference_kind=new byte[2];
	byte[] reference_index=new byte[2];
	public MethodHandle_info(){
		setTag(ConstantType.CONSTANT_MethodHandle);
	}
	public byte[] getReference_kind() {
		return reference_kind;
	}
	public void setReference_kind(byte[] reference_kind) {
		this.reference_kind = reference_kind;
	}
	public byte[] getReference_index() {
		return reference_index;
	}
	public void setReference_index(byte[] reference_index) {
		this.reference_index = reference_index;
	}
}
