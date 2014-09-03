package com.dips.intent.attribute.stackframe.typeinfo;


public class Object_variable_info extends Verification_type_info{
    byte[] cpool_index =new byte[2];
    public Object_variable_info(){
        setTag((byte)7);
    }
    
    public byte[] getCpool_index() {
        return cpool_index;
    }
    
    public void setCpool_index(byte[] cpool_index) {
        this.cpool_index = cpool_index;
    }
}
