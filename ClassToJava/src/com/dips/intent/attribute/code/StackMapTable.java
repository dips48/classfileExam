package com.dips.intent.attribute.code;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.attribute.stackframe.Append_frame;
import com.dips.intent.attribute.stackframe.Base_frame;
import com.dips.intent.attribute.stackframe.Chop_frame;
import com.dips.intent.attribute.stackframe.Full_frame;
import com.dips.intent.attribute.stackframe.Same_frame;
import com.dips.intent.attribute.stackframe.Same_frame_extended;
import com.dips.intent.attribute.stackframe.Same_locals_1_stack_frame_extended;
import com.dips.intent.attribute.stackframe.Same_locals_1_stack_item_frame;
import com.dips.intent.attribute.stackframe.typeinfo.Double_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Float_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Integer_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Long_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Null_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Object_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Top_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.UninitializedThis_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Uninitialized_variable_info;
import com.dips.intent.attribute.stackframe.typeinfo.Verification_type_info;
import com.dips.intent.startup.ClassReader;


public class StackMapTable extends Attribute_info{
    int start;
    int size;
    Base_frame[] baseFrameArray;
    
    public StackMapTable(Attribute_info attributeinfo){
        super(attributeinfo);
    }
    
    @Override
    public void init(){
        byte[] sizeArray=new byte[2];
        sizeArray[0]=getInfo()[0];
        sizeArray[1]=getInfo()[1];
        size=ClassReader.getLength(sizeArray);
        start=2;
        baseFrameArray=new Base_frame[size];
        for(int i=0;i<size;i++){
            baseFrameArray[i]=getNextFrame();
        }
        toString();
    }
    public Base_frame get(int index){
        if(index>=size){
            return null;
        }
        return baseFrameArray[index];
    }
    public  byte[] buildByte(byte[] byteArray,int length){
        byte[] tempArray=new byte[length];
        for(int i=0;i<length;i++){
            tempArray[i]=byteArray[start];
            start++;
        }
        return tempArray;
    }
    
    public Verification_type_info getNextVariable(){
        Verification_type_info verification_type_info=null;
        byte b=getInfo()[start];
        start++;
        switch(b){
            case 0:
                verification_type_info=new Top_variable_info();
                break;
            case 1:
                verification_type_info=new Integer_variable_info();
                break;
            case 2:
                verification_type_info=new Float_variable_info();
                break;
            case 3:
                verification_type_info=new Double_variable_info();
                break;
            case 4:
                verification_type_info=new Long_variable_info();
                break;
            case 5:
                verification_type_info=new Null_variable_info();
                break;
            case 6:
                verification_type_info=new UninitializedThis_variable_info();
                break;
            case 7:
                verification_type_info=new Object_variable_info();
               ((Object_variable_info)verification_type_info).setCpool_index(buildByte(getInfo(),2));
                break;
            case 8:
                verification_type_info=new Uninitialized_variable_info();
                ((Uninitialized_variable_info)verification_type_info).setOffset(buildByte(getInfo(),2));
                break;
             default:
                 break;
        }
        return verification_type_info;
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

    
    public Base_frame[] getBaseFrameArray() {
        return baseFrameArray;
    }

    
    public void setBaseFrameArray(Base_frame[] baseFrameArray) {
        this.baseFrameArray = baseFrameArray;
    }
    public Base_frame getNextFrame(){
        byte b=getInfo()[start];
        start++;
        if(b<64){
           Same_frame baseFrame=new Same_frame();
           baseFrame.setFrame_type(b);
           return baseFrame;
        }else if(b<128){
            Same_locals_1_stack_item_frame baseFrame=new Same_locals_1_stack_item_frame();
            baseFrame.setFrame_type(b);
            baseFrame.setVerification_type_info(getNextVariable());
            return baseFrame;
        }else if(b==247){
            Same_locals_1_stack_frame_extended baseFrame=new Same_locals_1_stack_frame_extended();
            baseFrame.setOffset_delta(buildByte(getInfo(), 2));
            baseFrame.setVerification_type_info(getNextVariable());
            return baseFrame;
        }else if(b>247&&b<251){
            Chop_frame baseFrame=new Chop_frame();
            baseFrame.setFrame_type(b);
            baseFrame.setOffset_delta(buildByte(getInfo(), 2));
            return baseFrame;
        }else if(b==251){
            Same_frame_extended baseFrame=new Same_frame_extended();
            baseFrame.setOffset_delta(buildByte(getInfo(), 2));
            return baseFrame;
        }else if(b>250&&b<255){
            Append_frame baseFrame=new Append_frame();
            baseFrame.setFrame_type(b);
            baseFrame.setOffset_delta(buildByte(getInfo(), 2));
            int size=b-251;
            Verification_type_info[] verifiacationtypeArray=new Verification_type_info[size];
            for(int j=0;j<size;j++){
                verifiacationtypeArray[j]=getNextVariable();
            }
            baseFrame.setVerificationtypeinfoArray(verifiacationtypeArray);
            return baseFrame;
        }else if(b==255){
            Full_frame baseFrame=new Full_frame();
            baseFrame.setOffset_delta(buildByte(getInfo(), 2));
            baseFrame.setSize_local(ClassReader.getLength(buildByte(getInfo(), 2)));
            Verification_type_info[] verifiacationtypeArrayLocal=new Verification_type_info[baseFrame.getSize_local()];
            for(int j=0;j<baseFrame.getSize_local();j++){
                verifiacationtypeArrayLocal[j]=getNextVariable();
            }
            baseFrame.setVerificationArrayLocal(verifiacationtypeArrayLocal);
            baseFrame.setSize_stack(ClassReader.getLength(buildByte(getInfo(), 2)));
            Verification_type_info[] verifiacationtypeArrayStack=new Verification_type_info[baseFrame.getSize_stack()];
            for(int j=0;j<baseFrame.getSize_local();j++){
                verifiacationtypeArrayStack[j]=getNextVariable();
            }
            baseFrame.setVerificationArrayStack(verifiacationtypeArrayStack);
            return baseFrame;
        }
        return null;
    }
    public String toString(){
        System.out.println("¶ÑÕ»±í£º");
        System.out.println("¶ÑÕ»ÊýÎª£º"+getSize());
        for(int i=0;i<getSize();i++){
            System.out.println(getBaseFrameArray()[i].getFrame_type());
        }
        return "";
    }
}
