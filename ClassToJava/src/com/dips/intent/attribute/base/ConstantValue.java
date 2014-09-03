package com.dips.intent.attribute.base;

import com.dips.intent.attribute.Attribute_info;


public class ConstantValue extends Attribute_info{

    public ConstantValue(Attribute_info attributeinfo){
        super(attributeinfo);
    }
     
    public byte[] getConstantvalue_index() {
        return getInfo();
    }
    
    public void setConstantvalue_index(byte[] constantvalue_index) {
        this.setInfo(constantvalue_index);
    }
    
}
