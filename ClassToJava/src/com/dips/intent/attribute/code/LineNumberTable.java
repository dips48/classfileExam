package com.dips.intent.attribute.code;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.attribute.vo.LineNumber;
import com.dips.intent.attribute.vo.LocalVariable;
import com.dips.intent.attribute.vo.LocalVariableType;
import com.dips.intent.startup.ClassReader;


public class LineNumberTable extends Attribute_info{
    int start;
    int size;
    LineNumber[] lineNumberArray;
    public LineNumberTable(Attribute_info attributeinfo){
        super(attributeinfo);
    }
    
    @Override
    public void init(){
        byte[] sizeArray=new byte[2];
        sizeArray[0]=getInfo()[0];
        sizeArray[1]=getInfo()[1];
        size=ClassReader.getLength(sizeArray);
        start=2;
       lineNumberArray=new LineNumber[size];
        for(int i=0;i<size;i++){
            lineNumberArray[i]=get(i);
        }
        toString();
    }
    public LineNumber get(int index){
        if(index>=size){
            return null;
        }
        int tstart=start+index*4;
        LineNumber lineNumber=new LineNumber();
        byte[] btemp=new byte[2];
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        lineNumber.setStart_pc(btemp);
        btemp[0]=getInfo()[tstart];
        tstart++;
        btemp[1]=getInfo()[tstart];
        tstart++;
        lineNumber.setLine_number(btemp);
        return lineNumber;
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

    
    public LineNumber[] getLineNumberArray() {
        return lineNumberArray;
    }

    
    public void setLineNumberArray(LineNumber[] lineNumberArray) {
        this.lineNumberArray = lineNumberArray;
    }

    public String toString(){
        System.out.println("LineNumber¶Î£º");
        System.out.println("³¤¶ÈÎª£º"+size);
        for(int i=0;i<size;i++){
            System.out.print(""+i+" ");
            System.out.print(ClassReader.getLength(getLineNumberArray()[i].getLine_number())+"  ");
            System.out.println(ClassReader.getLength(getLineNumberArray()[i].getStart_pc()));
        }
        return "";
    }
}
