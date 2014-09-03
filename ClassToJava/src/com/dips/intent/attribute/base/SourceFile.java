package com.dips.intent.attribute.base;

import com.dips.intent.attribute.Attribute_info;


public class SourceFile extends Attribute_info{
    
    public SourceFile(Attribute_info attributeinfo){
        super(attributeinfo);
    }
    
    public byte[] getSourcefile_index() {
        return getInfo();
    }

    public void setSourcefile_index(byte[] sourcefile_index) {
        this.setInfo(sourcefile_index);
    }
    
}
