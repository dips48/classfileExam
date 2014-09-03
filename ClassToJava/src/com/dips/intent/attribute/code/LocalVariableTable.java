package com.dips.intent.attribute.code;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.attribute.vo.LocalVariable;
import com.dips.intent.attribute.vo.LocalVariableType;
import com.dips.intent.startup.ClassReader;


public class LocalVariableTable extends Attribute_info{
    int start;
    int size;
    LocalVariable[] localVariableArray;
    public LocalVariableTable(Attribute_info attributeinfo){
        super(attributeinfo);
    }
    
    @Override
    public void init(){
        byte[] sizeArray=new byte[2];
        sizeArray[0]=getInfo()[0];
        sizeArray[1]=getInfo()[1];
        size=ClassReader.getLength(sizeArray);
        start=2;
        localVariableArray=new LocalVariable[size];
        for(int i=0;i<size;i++){
            localVariableArray[i]=get(i);
        }
        toString();
    }
    public LocalVariable get(int index){
        if(index>=size){
            return null;
        }
        int tstart=start+index*10;
        LocalVariable localVariable=new LocalVariable();
        byte[] btemp=new byte[2];
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariable.setStart_pc(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariable.setLength(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariable.setName_index(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariable.setDescriptor_index(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariable.setIndex(btemp);
        return localVariable;
    }
    
    
    public int getStart() {
        return start;
    }

    
    public void setStart(int start) {
        this.start = start;
    }

    
    public int getSize() {
        return size;
    }

    
    public void setSize(int size) {
        this.size = size;
    }

    
    public LocalVariable[] getLocalVariableArray() {
        return localVariableArray;
    }

    
    public void setLocalVariableArray(LocalVariable[] localVariableArray) {
        this.localVariableArray = localVariableArray;
    }

    public String toString(){
        System.out.println("局部变量表");
        System.out.print("局部变量数为："+getSize());
        return "";
    }
}
