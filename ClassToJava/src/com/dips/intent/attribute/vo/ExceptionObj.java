package com.dips.intent.attribute.vo;


public class ExceptionObj {
    byte[] start_pc=new byte[2];
    byte[] end_pc=new byte[2];
    byte[] handler_pc=new byte[2];
    byte[] catch_type=new byte[2];
    
    public byte[] getStart_pc() {
        return start_pc;
    }
    
    public void setStart_pc(byte[] start_pc) {
        this.start_pc = start_pc;
    }
    
    public byte[] getEnd_pc() {
        return end_pc;
    }
    
    public void setEnd_pc(byte[] end_pc) {
        this.end_pc = end_pc;
    }
    
    public byte[] getHandler_pc() {
        return handler_pc;
    }
    
    public void setHandler_pc(byte[] handler_pc) {
        this.handler_pc = handler_pc;
    }
    
    public byte[] getCatch_type() {
        return catch_type;
    }
    
    public void setCatch_type(byte[] catch_type) {
        this.catch_type = catch_type;
    }

}
