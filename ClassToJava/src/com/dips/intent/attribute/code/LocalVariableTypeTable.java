package com.dips.intent.attribute.code;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.attribute.vo.LocalVariable;
import com.dips.intent.attribute.vo.LocalVariableType;
import com.dips.intent.startup.ClassReader;


public class LocalVariableTypeTable extends Attribute_info{
    int start;
    int size;
    LocalVariableType[] localVariableTypeArray;
    public LocalVariableTypeTable(Attribute_info attributeinfo){
        super(attributeinfo);
    }
    
    @Override
    public void init(){
        byte[] sizeArray=new byte[2];
        sizeArray[0]=getInfo()[0];
        sizeArray[1]=getInfo()[1];
        size=ClassReader.getLength(sizeArray);
        start=2;
        localVariableTypeArray=new LocalVariableType[size];
        for(int i=0;i<size;i++){
            localVariableTypeArray[i]=get(i);
        }
        toString();
    }
    public LocalVariableType get(int index){
        if(index>=size){
            return null;
        }
        int tstart=start+index*10;
        LocalVariableType localVariableType=new LocalVariableType();
        byte[] btemp=new byte[2];
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariableType.setStart_pc(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariableType.setLength(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariableType.setName_index(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariableType.setSignature_index(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        localVariableType.setIndex(btemp);
        return localVariableType;
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

    
    public LocalVariableType[] getLocalVariableTypeArray() {
        return localVariableTypeArray;
    }

    
    public void setLocalVariableTypeArray(LocalVariableType[] localVariableTypeArray) {
        this.localVariableTypeArray = localVariableTypeArray;
    }
    public String toString(){
        System.out.println("局部变量类型表");
        System.out.print("局部变量类型数为："+getSize());
        return "";
    }
}
