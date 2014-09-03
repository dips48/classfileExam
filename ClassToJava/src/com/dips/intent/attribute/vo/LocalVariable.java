package com.dips.intent.attribute.vo;


public class LocalVariable {
    byte[] start_pc=new byte[2];
    byte[] length=new byte[2];
    byte[] name_index=new byte[2];
    byte[] descriptor_index=new byte[2];
    byte[] index=new byte[2];
    
    public byte[] getStart_pc() {
        return start_pc;
    }
    
    public void setStart_pc(byte[] start_pc) {
        this.start_pc = start_pc;
    }
    
    public byte[] getLength() {
        return length;
    }
    
    public void setLength(byte[] length) {
        this.length = length;
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
    
    public byte[] getIndex() {
        return index;
    }
    
    public void setIndex(byte[] index) {
        this.index = index;
    }
}
