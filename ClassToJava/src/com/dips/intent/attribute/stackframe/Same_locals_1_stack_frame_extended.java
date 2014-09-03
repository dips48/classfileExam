package com.dips.intent.attribute.stackframe;

import com.dips.intent.attribute.stackframe.typeinfo.Verification_type_info;


public class Same_locals_1_stack_frame_extended extends Base_frame{
    byte[] offset_delta=new byte[2];
    Verification_type_info verification_type_info;
    
    public byte[] getOffset_delta() {
        return offset_delta;
    }
    
    public void setOffset_delta(byte[] offset_delta) {
        this.offset_delta = offset_delta;
    }
    
    public Verification_type_info getVerification_type_info() {
        return verification_type_info;
    }
    
    public void setVerification_type_info(Verification_type_info verification_type_info) {
        this.verification_type_info = verification_type_info;
    }
    public Same_locals_1_stack_frame_extended(){
        setFrame_type((byte)247);
    }
}
