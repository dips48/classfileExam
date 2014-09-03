package com.dips.intent.attribute.stackframe.typeinfo;


public class Uninitialized_variable_info extends Verification_type_info{
    byte[] offset=new byte[2];
    public Uninitialized_variable_info(){
        setTag((byte)8);
    }
    
    public byte[] getOffset() {
        return offset;
    }
    
    public void setOffset(byte[] offset) {
        this.offset = offset;
    }

}
