package com.dips.intent.field;

import com.dips.intent.attribute.Attribute_info;

public class Field_info {
	byte[] access_flags=new byte[2];
	byte[] name_index=new byte[2];
	public byte[] getAccess_flags() {
		return access_flags;
	}
	public void setAccess_flags(byte[] access_flags) {
		this.access_flags = access_flags;
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
	public byte[] getAttributes_count() {
		return attributes_count;
	}
	public void setAttributes_count(byte[] attributes_count) {
		this.attributes_count = attributes_count;
	}
	public Attribute_info[] getAttributes() {
		return attributes;
	}
	public void setAttributes(Attribute_info[] attributes) {
		this.attributes = attributes;
	}
	byte[] descriptor_index=new byte[2];
	byte[] attributes_count=new byte[2];
	Attribute_info[] attributes;
}
