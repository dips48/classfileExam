package com.dips.intent.attribute.stackframe;

import com.dips.intent.attribute.stackframe.typeinfo.Verification_type_info;


public class Append_frame extends Base_frame{
    byte[] offset_delta=new byte[2];
    Verification_type_info[] verificationtypeinfoArray;
    
    public byte[] getOffset_delta() {
        return offset_delta;
    }
    
    public void setOffset_delta(byte[] offset_delta) {
        this.offset_delta = offset_delta;
    }
    
    public Verification_type_info[] getVerificationtypeinfoArray() {
        return verificationtypeinfoArray;
    }
    
    public void setVerificationtypeinfoArray(Verification_type_info[] verificationtypeinfoArray) {
        this.verificationtypeinfoArray = verificationtypeinfoArray;
    }

}
