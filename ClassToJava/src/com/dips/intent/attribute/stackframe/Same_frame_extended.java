package com.dips.intent.attribute.stackframe;


public class Same_frame_extended extends Same_frame{
    byte[] offset_delta=new byte[2];
    public Same_frame_extended(){
        setFrame_type((byte)251);
    }
    
    public byte[] getOffset_delta() {
        return offset_delta;
    }
    
    public void setOffset_delta(byte[] offset_delta) {
        this.offset_delta = offset_delta;
    }
}
