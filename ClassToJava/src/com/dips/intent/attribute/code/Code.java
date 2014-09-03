package com.dips.intent.attribute.code;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.attribute.vo.ExceptionObj;
import com.dips.intent.startup.ClassReader;


public class Code extends Attribute_info{
    byte[] max_stack=new byte[2];
    byte[] max_locals=new byte[2];
    byte[] code_length=new byte[4];
    byte[] code;
    byte[] exception_length=new byte[2];
    ExceptionObj[] exceptionArray;
    byte[] attribute_count=new byte[2];
    Attribute_info[] attributeArray;
    int start=0;
    
    public Code(Attribute_info attributeinfo){
        super(attributeinfo);
    }
    
    @Override
    public void init(){
        setMax_stack(buildByte(getInfo(), 2));
        setMax_locals(buildByte(getInfo(),  2));
        setCode_length(buildByte(getInfo(),  4));
        setCode(buildByte(getInfo(),  ClassReader.getLength(getCode_length())));
        System.out.println("ExceptionSize"+ClassReader.getLength(getCode_length()));
        setException_length(buildByte(getInfo(), 2));
        int size=ClassReader.getLength(getException_length());
        exceptionArray=new ExceptionObj[size];
        for(int i=0;i<size;i++){
            exceptionArray[i].setStart_pc(buildByte(getInfo(), 2));
            exceptionArray[i].setEnd_pc(buildByte(getInfo(), 2));
            exceptionArray[i].setHandler_pc(buildByte(getInfo(), 2));
            exceptionArray[i].setCatch_type(buildByte(getInfo(), 2));
        }
        setAttribute_count(buildByte(getInfo(), 2));
        size=ClassReader.getLength(getAttribute_count());
        System.out.println("ExceptionSize"+size);
        attributeArray=new Attribute_info[size];
        for(int i=0;i<size;i++){
            Attribute_info attributeinfo=new Attribute_info();
            attributeinfo.setAttribute_name_index(buildByte(getInfo(),2));
            attributeinfo.setAttribute_length(buildByte(getInfo(),  4));
           int  tempsize=ClassReader.getLength(attributeinfo.getAttribute_length());
            System.out.println("ExceptionSize"+tempsize);
            attributeinfo.setInfo(buildByte(getInfo(), tempsize));
            attributeArray[i]=attributeinfo;
        }
        toString();
    }
    
    public byte[] getMax_stack() {
        return max_stack;
    }
    
    public void setMax_stack(byte[] max_stack) {
        this.max_stack = max_stack;
    }
    
    public byte[] getMax_locals() {
        return max_locals;
    }
    
    public void setMax_locals(byte[] max_locals) {
        this.max_locals = max_locals;
    }
    
    public byte[] getCode_length() {
        return code_length;
    }
    
    public void setCode_length(byte[] code_length) {
        this.code_length = code_length;
    }
    
    public byte[] getCode() {
        return code;
    }
    
    public void setCode(byte[] code) {
        this.code = code;
    }
    
    public byte[] getException_length() {
        return exception_length;
    }
    
    public void setException_length(byte[] exception_length) {
        this.exception_length = exception_length;
    }
    
    public ExceptionObj[] getExceptionArray() {
        return exceptionArray;
    }

    
    public void setExceptionArray(ExceptionObj[] exceptionArray) {
        this.exceptionArray = exceptionArray;
    }

    public byte[] getAttribute_count() {
        return attribute_count;
    }
    
    public void setAttribute_count(byte[] attribute_count) {
        this.attribute_count = attribute_count;
    }
    
    public Attribute_info[] getAttributeArray() {
        return attributeArray;
    }
    
    public void setAttributeArray(Attribute_info[] attributeArray) {
        this.attributeArray = attributeArray;
    }
    
    public  byte[] buildByte(byte[] byteArray,int length){
        byte[] tempArray=new byte[length];
        for(int i=0;i<length;i++){
            tempArray[i]=byteArray[start];
            start++;
        }
        return tempArray;
    }
    
    public String toString(){
        System.out.println("Code段：");
        System.out.println("最大堆栈为："+ClassReader.getLength(getMax_stack()));
        System.out.println("最多变量为："+ClassReader.getLength(getMax_locals()));
        System.out.println("代码长度为："+ClassReader.getLength(getCode_length()));
        for(int i=0;i<ClassReader.getLength(getCode_length());i++){
            System.out.print(""+i+"  ");
            System.out.println(getCode()[i]);
        }
        System.out.println("子段有：");
        for(int i=0;i<ClassReader.getLength(getAttribute_count());i++){
            getAttributeArray()[i].toString();
        }
        return "";
    }
}
