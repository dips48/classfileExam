package com.dips.intent.normalclass;

import java.util.ArrayList;
import java.util.HashMap;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.attribute.base.ConstantValue;
import com.dips.intent.attribute.base.SourceFile;
import com.dips.intent.attribute.code.Code;
import com.dips.intent.attribute.code.LineNumberTable;
import com.dips.intent.attribute.code.LocalVariableTable;
import com.dips.intent.attribute.code.LocalVariableTypeTable;
import com.dips.intent.attribute.code.StackMapTable;
import com.dips.intent.classrela.super_class;
import com.dips.intent.classrela.this_class;
import com.dips.intent.classrela.this_interface;
import com.dips.intent.constant.Class_info;
import com.dips.intent.constant.Constant_info;
import com.dips.intent.constant.Double_info;
import com.dips.intent.constant.Fieldref_info;
import com.dips.intent.constant.Float_info;
import com.dips.intent.constant.Integer_info;
import com.dips.intent.constant.InterfaceMethodref_info;
import com.dips.intent.constant.InvokeDynamic_info;
import com.dips.intent.constant.Long_info;
import com.dips.intent.constant.MethodHandle_info;
import com.dips.intent.constant.MethodType_info;
import com.dips.intent.constant.Methodref_info;
import com.dips.intent.constant.NameAndType_info;
import com.dips.intent.constant.String_info;
import com.dips.intent.constant.Utf8_info;
import com.dips.intent.field.Field_info;
import com.dips.intent.magic.Magic;
import com.dips.intent.method.Method_info;
import com.dips.intent.startup.ClassReader;
import com.dips.intent.version.version_info;

public class Normalclass {

    private Magic                           magic;
    private version_info                    version;
    private int                             counstant_count;
    private ArrayList<Constant_info>        constantArray   = new ArrayList<Constant_info>();
    private this_class                      thisclass;
    private super_class                     superclass;
    private this_interface                  thisinterface;
    private int                       field_count;
    private ArrayList<Field_info>     fieldArray     = new ArrayList<Field_info>();
    private int                       method_count;
    private ArrayList<Method_info>    methodArray    = new ArrayList<Method_info>();
    private int                       attribute_count;
    private ArrayList<Attribute_info> attributeArray = new ArrayList<Attribute_info>();
    private static HashMap<Integer, String> methodhandleMap = new HashMap<Integer, String>();
    static {
        methodhandleMap.put(1, "GET_FIELD");
        methodhandleMap.put(2, "GET_STATIC");
        methodhandleMap.put(3, "PUT_FIELD");
        methodhandleMap.put(4, "PUT_STATIC");
        methodhandleMap.put(5, "INVOKE_VIRTUAL");
        methodhandleMap.put(6, "INVOKE_STATIC");
        methodhandleMap.put(7, "INVOKE_SPECIAL");
        methodhandleMap.put(8, "NEWINVOE_SPECIAL");
    }
    private static HashMap<String,Integer> attributetypeMap = new HashMap<String,Integer>();
    static {
        attributetypeMap.put("ConstantValue",1);
        attributetypeMap.put("Code",2);
        attributetypeMap.put("StackMapTable",3);
        attributetypeMap.put("Exceptions",4);
        attributetypeMap.put("InnerClasses",5);
        attributetypeMap.put("EnclosingMethod",6);
        attributetypeMap.put("Synthetic",7);
        attributetypeMap.put("Signature",8);
        attributetypeMap.put("SourceFile",9);
        attributetypeMap.put("SourceDebugExtension",10);
        attributetypeMap.put("LineNumberTable",11);
        attributetypeMap.put("LocalVariableTable",12);
        attributetypeMap.put("LocalVariableTypeTable",13);
        attributetypeMap.put("Deprecated",14);
        attributetypeMap.put("RuntimeVisibleAnnotations",15);
        attributetypeMap.put("RuntimeInvisibleAnnotations",16);
        attributetypeMap.put("RuntimeVisibleParameterAnnotations",17);
        attributetypeMap.put("RuntimeInvisibleParameterAnnotations",18);
        attributetypeMap.put("AnnotationDefault",19);
        attributetypeMap.put("BootstrapMethods",20);
    }

    public Magic getMagic() {
        return magic;
    }

    public void setMagic(Magic magic) {
        this.magic = magic;
    }

    public version_info getVersion() {
        return version;
    }

    public void setVersion(version_info version) {
        this.version = version;
    }

    public int getCounstant_count() {
        return counstant_count;
    }

    public void setCounstant_count(int counstant_count) {
        this.counstant_count = counstant_count;
    }

    public ArrayList<Constant_info> getConstantArray() {
        return constantArray;
    }

    public void setConstantArray(ArrayList<Constant_info> constantArray) {
        this.constantArray = constantArray;
    }

    public this_class getThisclass() {
        return thisclass;
    }

    public void setThisclass(this_class thisclass) {
        this.thisclass = thisclass;
    }

    public super_class getSuperclass() {
        return superclass;
    }

    public void setSuperclass(super_class superclass) {
        this.superclass = superclass;
    }

    public this_interface getThisinterface() {
        return thisinterface;
    }

    public void setThisinterface(this_interface thisinterface) {
        this.thisinterface = thisinterface;
    }

    public int getField_count() {
        return field_count;
    }

    public void setField_count(int field_count) {
        this.field_count = field_count;
    }

    public ArrayList<Field_info> getFieldArray() {
        return fieldArray;
    }

    public void setFieldArray(ArrayList<Field_info> fieldArray) {
        this.fieldArray = fieldArray;
    }

    public int getMethod_count() {
        return method_count;
    }

    public void setMethod_count(int method_count) {
        this.method_count = method_count;
    }

    public ArrayList<Method_info> getMethodArray() {
        return methodArray;
    }

    public void setMethodArray(ArrayList<Method_info> methodArray) {
        this.methodArray = methodArray;
    }

    public int getAttribute_count() {
        return attribute_count;
    }

    public void setAttribute_count(int attribute_count) {
        this.attribute_count = attribute_count;
    }

    public ArrayList<Attribute_info> getAttributeArray() {
        return attributeArray;
    }

    public void setAttributeArray(ArrayList<Attribute_info> attributeArray) {
        this.attributeArray = attributeArray;
    }

    public void refresh() {

    }

    public void refreshConstant() {
        for (int i = 0; i < constantArray.size(); i++) {
            Constant_info constantinfo = constantArray.get(i);
            System.out.println("第" + (i + 1) + "个常量  " + constantinfo.getTag().getName());
            switch (constantinfo.getTag().getValue()) {
                case 7:
                    refreshClassInfo(constantinfo);
                    break;
                case 9:
                    refreshFieldrefInfo(constantinfo);
                    break;
                case 10:
                    refreshMethodrefInfo(constantinfo);
                    break;
                case 11:
                    refreshIntrfaceMethodrefInfo(constantinfo);
                    break;
                case 8:
                    refreshStringInfo(constantinfo);
                    break;
                case 3:
                    refreshIntegerInfo(constantinfo);
                    break;
                case 4:
                    refreshFloatInfo(constantinfo);
                    break;
                case 5:
                    refreshLongInfo(constantinfo);
                    break;
                case 6:
                    refreshDoubleInfo(constantinfo);
                    break;
                case 12:
                    refreshNameAndTypeInfo(constantinfo);
                    break;
                case 1:
                    refreshUtf8Info(constantinfo);
                    break;
                case 15:
                    refreshMethodHandleInfo(constantinfo);
                    break;
                case 16:
                    refershMethodTypeInfo(constantinfo);
                    break;
                case 18:
                    refershInvokeDynamicInfo(constantinfo);
                    break;
                case 17:
                    System.out.println("Long、Double补全");
                    break;
                default:
                    System.out.println("读取错误");
                    break;
            }
        }
    }

    public void refreshAttribute() {
        for(int i=0;i<fieldArray.size();i++){
            for(int j=0;j<fieldArray.get(i).getAttributes().length;j++){
                getAttributeType(fieldArray.get(i).getAttributes()[j]);
            }
        }
        
        for(int i=0;i<methodArray.size();i++){
            for(int j=0;j<methodArray.get(i).getAttributes().length;j++){
                getAttributeType(methodArray.get(i).getAttributes()[j]);
            }
        }
        
        for(int i=0;i<attributeArray.size();i++){
            getAttributeType(attributeArray.get(i));
        }
    }
   
    public void refreshClassInfo(Constant_info constantinfo) {
        Class_info classinfo = (Class_info) constantinfo;
        System.out.println("NameIndex为：" + ClassReader.getLength(classinfo.getName_index()));
    }

    public void refreshFieldrefInfo(Constant_info constantinfo) {
        Fieldref_info fieldrefinfo = (Fieldref_info) constantinfo;
        System.out.println("ClassIndex为：" + ClassReader.getLength(fieldrefinfo.getClass_index()));
        System.out.println("Name_and_TypeIndex为：" + ClassReader.getLength(fieldrefinfo.getName_and_type_index()));
    }

    public void refreshMethodrefInfo(Constant_info constantinfo) {
        Methodref_info methodrefinfo = (Methodref_info) constantinfo;
        System.out.println("ClassIndex为：" + ClassReader.getLength(methodrefinfo.getClass_index()));
        System.out.println("Name_and_TypeIndex为：" + ClassReader.getLength(methodrefinfo.getName_and_type_index()));
    }

    public void refreshIntrfaceMethodrefInfo(Constant_info constantinfo) {
        InterfaceMethodref_info methodrefinfo = (InterfaceMethodref_info) constantinfo;
        System.out.println("ClassIndex为：" + ClassReader.getLength(methodrefinfo.getClass_index()));
        System.out.println("Name_and_TypeIndex为：" + ClassReader.getLength(methodrefinfo.getName_and_type_index()));
    }

    public void refreshStringInfo(Constant_info constantinfo) {
        String_info stringinfo = (String_info) constantinfo;
        System.out.println("StringIndex为：" + ClassReader.getLength(stringinfo.getString_index()));
    }

    public void refreshIntegerInfo(Constant_info constantinfo) {
        Integer_info integerinfo = (Integer_info) constantinfo;
        System.out.println("Integer值为：" + ClassReader.getLength(integerinfo.getBytes()));
    }

    public void refreshFloatInfo(Constant_info constantinfo) {
        Float_info floatinfo = (Float_info) constantinfo;
        System.out.println("Float值为：" + getFloat(floatinfo.getBytes()));
    }

    public void refreshLongInfo(Constant_info constantinfo) {
        Long_info longinfo = (Long_info) constantinfo;
        System.out.println("Long值为：" + getLong(longinfo.getHigh_bytes(), longinfo.getLow_bytes()));
    }

    public void refreshDoubleInfo(Constant_info constantinfo) {
        Double_info doubleinfo = (Double_info) constantinfo;
        System.out.println("Double值为：" + getDouble(doubleinfo.getHigh_bytes(), doubleinfo.getLow_bytes()));
    }

    public void refreshNameAndTypeInfo(Constant_info constantinfo) {
        NameAndType_info nameandtypeinfo = (NameAndType_info) constantinfo;
        System.out.println("NameIndex为：" + ClassReader.getLength(nameandtypeinfo.getName_index()));
        System.out.println("DescriptorIndex为：" + ClassReader.getLength(nameandtypeinfo.getDescriptor_index()));
    }

    public void refreshUtf8Info(Constant_info constantinfo) {
        Utf8_info utf8info = (Utf8_info) constantinfo;
        System.out.println("长度为：" + ClassReader.getLength(utf8info.getLength()));
        System.out.println(new String(utf8info.getDescriptor_index()));
    }

    public void refreshMethodHandleInfo(Constant_info constantinfo) {
        MethodHandle_info methodhandleinfo = (MethodHandle_info) constantinfo;
        System.out.println("Reference类型为："
                           + methodhandleMap.get(ClassReader.getLength(methodhandleinfo.getReference_kind())));
        System.out.println("Reference_Index为：" + ClassReader.getLength(methodhandleinfo.getReference_index()));
    }

    public void refershMethodTypeInfo(Constant_info constantinfo) {
        MethodType_info methodtypeinfo = (MethodType_info) constantinfo;
        System.out.println("DescriptorIndex为：" + ClassReader.getLength(methodtypeinfo.getDescriptor_index()));
    }

    public void refershInvokeDynamicInfo(Constant_info constantinfo) {
        InvokeDynamic_info invokedynamicinfo = (InvokeDynamic_info) constantinfo;
        System.out.println("bootstrap_method_attr_index为："
                           + ClassReader.getLength(invokedynamicinfo.getBootstrap_method_attr_index()));
        System.out.println("Name_and_TypeIndex为：" + ClassReader.getLength(invokedynamicinfo.getName_and_tyoe_index()));
    }
    public String getUtf8Info(Constant_info constantinfo) {
        Utf8_info utf8info = (Utf8_info) constantinfo;
        return new String(utf8info.getDescriptor_index());
    }
    public String toString() {
        return "结构输出完成";
    }

    public static float getFloat(byte[] b) {
        int accum = ClassReader.getLength(b);
        return Float.intBitsToFloat(accum);
    }

    public static Long getLong(byte[] highBytes, byte[] lowBytes) {
        long res = highBytes[0];
        for (int i = 1; i < 4; i++) {
            res = res << 8;
            res = res + highBytes[i];
        }
        for (int i = 0; i < 4; i++) {
            res = res << 8;
            res = res + lowBytes[i];
        }
        return res;
    }

    public static Double getDouble(byte[] highBytes, byte[] lowBytes) {
        long accum = getLong(highBytes, lowBytes);
        return Double.longBitsToDouble(accum);
    }
    public int getAttributeType(Attribute_info attributeinfo){
        int index=ClassReader.getLength(attributeinfo.getAttribute_name_index());
        System.out.println("index:"+index);
        String key=getUtf8Info(constantArray.get(index-1));
        return attributetypeMap.get(key);
    }
    
    public   void TransForm(){
        for(int i=0;i<fieldArray.size();i++){
            for(int j=0;j<fieldArray.get(i).getAttributes().length;j++){
                TransForm(fieldArray.get(i).getAttributes()[j]);
            }
        }
        
        for(int i=0;i<methodArray.size();i++){
            for(int j=0;j<methodArray.get(i).getAttributes().length;j++){
                TransForm(methodArray.get(i).getAttributes()[j]);
            }
        }
        
        for(int i=0;i<attributeArray.size();i++){
            TransForm(attributeArray.get(i));
        }
    }
    
    public   void TransForm(Attribute_info attributeinfo){
        switch(getAttributeType(attributeinfo)){
            case 1:
                attributeinfo=new ConstantValue(attributeinfo);
                attributeinfo.init();
                break;
            case 2:
                attributeinfo=new Code(attributeinfo);
                attributeinfo.init();
                for(int i=0;i<((Code)attributeinfo).getAttributeArray().length;i++){
                    TransForm(((Code)attributeinfo).getAttributeArray()[i]);
                }
                break;
            case 3:
                attributeinfo=new StackMapTable(attributeinfo);
                attributeinfo.init();
                break;
            case 4:
//                attributeinfo=(Exceptions)attributeinfo;
                break;
            case 5:
//                attributeinfo=(InnerClasses)attributeinfo;
                break;
            case 6:
//                attributeinfo=(EnclosingMethod)attributeinfo;
                break;
            case 7:
//                attributeinfo=(Synthetic)attributeinfo;
                break;
            case 8:
//                attributeinfo=(Signature)attributeinfo;
                break;
            case 9:
                attributeinfo=new SourceFile(attributeinfo);
                attributeinfo.init();
                break;
            case 10:
//                attributeinfo=(SourceDebugExtension)attributeinfo;
                break;
            case 11:
                attributeinfo=new LineNumberTable(attributeinfo);
                attributeinfo.init();
                break;
            case 12:
                attributeinfo=new LocalVariableTable(attributeinfo);
                attributeinfo.init();
                break;
            case 13:
                attributeinfo=new LocalVariableTypeTable(attributeinfo);
                attributeinfo.init();
                break;
            case 14:
//                attributeinfo=(Deprecated)attributeinfo;
                break;
            case 15:
//                attributeinfo=(RuntimeVisibleAnnotations)attributeinfo;
                break;
            case 16:
//                attributeinfo=(RuntimeInvisibleAnnotations)attributeinfo;
                break;
            case 17:
//                attributeinfo=(RuntimeVisibleParameterAnnotations)attributeinfo;
                break;
            case 18:
//                attributeinfo=(RuntimeInvisibleParameterAnnotations)attributeinfo;
                break;
            case 19:
//                attributeinfo=(AnnotationDefault)attributeinfo;
                break;
            case 20:
//                attributeinfo=(BootstrapMethods)attributeinfo;
                break;
             default:
                 break;
        }
    }
}
