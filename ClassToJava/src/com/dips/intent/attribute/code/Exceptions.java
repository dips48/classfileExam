package com.dips.intent.attribute.code;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.attribute.vo.LineNumber;
import com.dips.intent.startup.ClassReader;


public class Exceptions extends Attribute_info{
    int start=0;
    int size;
    public Exceptions(Attribute_info attributeinfo){
        super(attributeinfo);
    }
    @Override
    public void init(){
        byte[] sizeArray=new byte[2];
        sizeArray[0]=getInfo()[0];
        sizeArray[1]=getInfo()[1];
        size=ClassReader.getLength(sizeArray);
        start=2;
    }
    
    public int get(int index){
        if(index>=size){
            return 0;
        }
        int tstart=start+index*2;
        byte[] btemp=new byte[2];
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        return ClassReader.getLength(btemp);
    }
    
    public String toString(){
        return "";
    }
}
