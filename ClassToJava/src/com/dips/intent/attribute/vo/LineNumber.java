package com.dips.intent.attribute.vo;


public class LineNumber {
    byte[] start_pc=new byte[2];
    byte[] line_number=new byte[2];
    
    public byte[] getStart_pc() {
        return start_pc;
    }
    
    public void setStart_pc(byte[] start_pc) {
        this.start_pc = start_pc;
    }
    
    public byte[] getLine_number() {
        return line_number;
    }
    
    public void setLine_number(byte[] line_number) {
        this.line_number = line_number;
    }
}
