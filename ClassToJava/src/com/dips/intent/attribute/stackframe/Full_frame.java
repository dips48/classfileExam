package com.dips.intent.attribute.stackframe;

import com.dips.intent.attribute.stackframe.typeinfo.Verification_type_info;


public class Full_frame extends Base_frame{
     byte[] offset_delta=new byte[2];
     int size_local;
     Verification_type_info[] verificationArrayLocal;
     int size_stack;
     Verification_type_info[] verificationArrayStack;
    
    public byte[] getOffset_delta() {
        return offset_delta;
    }
    
    public void setOffset_delta(byte[] offset_delta) {
        this.offset_delta = offset_delta;
    }
    
    public int getSize_local() {
        return size_local;
    }
    
    public void setSize_local(int size_local) {
        this.size_local = size_local;
    }
    
    public Verification_type_info[] getVerificationArrayLocal() {
        return verificationArrayLocal;
    }
    
    public void setVerificationArrayLocal(Verification_type_info[] verificationArrayLocal) {
        this.verificationArrayLocal = verificationArrayLocal;
    }
    
    public int getSize_stack() {
        return size_stack;
    }
    
    public void setSize_stack(int size_stack) {
        this.size_stack = size_stack;
    }
    
    public Verification_type_info[] getVerificationArrayStack() {
        return verificationArrayStack;
    }
    
    public void setVerificationArrayStack(Verification_type_info[] verificationArrayStack) {
        this.verificationArrayStack = verificationArrayStack;
    }
    public Full_frame(){
        setFrame_type((byte)255);
    }
}
