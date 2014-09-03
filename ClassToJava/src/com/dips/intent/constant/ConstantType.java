package com.dips.intent.constant;

public enum ConstantType {
	CONSTANT_Class("CONSTANT_Class",7),CONSTANT_Fieldref("CONSTANT_Fieldref",9),CONSTANT_Methdoref("CONSTANT_Methdoref",10),CONSTANT_InterfaceMethodref("CONSTANT_InterfaceMethodref",11),
	CONSTANT_String("CONSTANT_String",8),CONSTANT_Interger("CONSTANT_Interger",3),CONSTANT_Float("CONSTANT_Float",4),CONSTANT_Long("CONSTANT_Long",5),CONSTANT_Double("CONSTANT_Double",6),
	CONSTANT_NameAndType("CONSTANT_NameAndType",12),CONSTANT_Utf8("CONSTANT_Utf8",1),CONSTANT_MethodHandle("CONSTANT_MethodHandle",15),CONSTANT_MethodType("CONSTANT_MethodType",16),
	CONSTANT_InvokeDynamic("CONSTANT_InvokeDynamic",18),CONSTANT_Eempty("CONSTANT_Empty",17);
	private int value;
	private String name;
	private ConstantType(String name,int value){
		this.value=value;
		this.name=name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ConstantType getConstantType(int value){
		for(ConstantType constantType:ConstantType.values()){
			if(constantType.getValue()==value){
				return constantType;
			}
		}
		return null;
	}
}
