package com.dips.intent.startup;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.dips.intent.attribute.Attribute_info;
import com.dips.intent.classrela.super_class;
import com.dips.intent.classrela.this_class;
import com.dips.intent.classrela.this_interface;
import com.dips.intent.constant.Class_info;
import com.dips.intent.constant.Double_info;
import com.dips.intent.constant.Empty_info;
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
import com.dips.intent.normalclass.Normalclass;
import com.dips.intent.version.version_info;

public class ClassReader {
	private static DataInputStream din;
	private static ArrayList<Object> array = new ArrayList<Object>();
	private static Normalclass normalclass;

	public static Normalclass start() throws IOException {
		normalclass=new Normalclass();
		readMagic();
		readVersion();
		byte[] constant_count = new byte[2];
		din.read(constant_count);
		int size = getLength(constant_count);
		for (int i = 0; i < size-1; i++) {
			if(!readConstant()){
			    i++;
			}
		}
		System.out.println("开始读取class信息");
		readClass();
		byte[] field_count = new byte[2];
		System.out.println("开始读取Field信息");
		din.read(field_count);
		size = getLength(field_count);
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			readField();
		}
		byte[] method_count = new byte[2];
		System.out.println("开始读取方法信息");
		din.read(method_count);
		size = getLength(method_count);
		System.out.println(size);
		for (int i = 0; i < size; i++) {
		    System.out.println("   "+i);
			readMethod();
		}
		byte[] attribute_count = new byte[2];
		System.out.println("开始读取属性信息");
		din.read(attribute_count);
		size = getLength(attribute_count);
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			readAttribute(true);
		}
		return normalclass;
	}
	public static void output(){
		for(int i=0;i<array.size();i++){
			array.get(i).toString();
		}
	}
	public static void Prepare(String filepath) throws IOException {
		File f = new File(filepath);
		array.clear();
		din = new DataInputStream(new FileInputStream(f));
	}

	private static void readMagic() throws IOException {
		Magic magic = new Magic();
		array.add(magic);
		normalclass.setMagic(magic);
		din.read(magic.getMagic());
	}

	private static void readVersion() throws IOException {
		version_info version = new version_info();
		array.add(version);
		normalclass.setVersion(version);
		din.read(version.getMinor_version());
		din.read(version.getMajor_version());
	}

	private static void readClass() throws IOException {
		this_class thisclass = new this_class();
		array.add(thisclass);
		normalclass.setThisclass(thisclass);
		din.read(thisclass.getAccess_flag());
		din.read(thisclass.getThis_class());
		super_class superclass = new super_class();
		array.add(superclass);
		normalclass.setSuperclass(superclass);
		din.read(superclass.getSuper_class());
		this_interface thisinterface = new this_interface();
		array.add(thisinterface);
		normalclass.setThisinterface(thisinterface);
		din.read(thisinterface.getInterfaces_count());
		int size=getLength(thisinterface.getInterfaces_count());
		if(size>0){
		byte[] temp = new byte[size * 2];
		din.read(temp);
		thisinterface.setInterfaces(temp);}
	}

	private static void readField() throws IOException {
		Field_info field = new Field_info();
		array.add(field);
		normalclass.getFieldArray().add(field);
		din.read(field.getAccess_flags());
		din.read(field.getName_index());
		din.read(field.getDescriptor_index());
		din.read(field.getAttributes_count());
		int size = getLength(field.getAttributes_count());
		Attribute_info[] attributeArray=new Attribute_info[size];
		for (int i = 0; i < size; i++) {
			attributeArray[i]=readAttribute(false);
		}
		field.setAttributes(attributeArray);
	}

	private static void readMethod() throws IOException {
		Method_info method = new Method_info();
		array.add(method);
		normalclass.getMethodArray().add(method);
		din.read(method.getAccess_flags());
		din.read(method.getName_index());
		din.read(method.getDescriptor_index());
		din.read(method.getAttributes_count());
		int size = getLength(method.getAttributes_count());
		Attribute_info[] attributeArray=new Attribute_info[size];
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			attributeArray[i]=readAttribute(false);
		}
		method.setAttributes(attributeArray);
	}
	
	private static Attribute_info readAttribute(boolean flag) throws IOException {
		Attribute_info attribute = new Attribute_info();
		array.add(attribute);
		if(flag){
			normalclass.getAttributeArray().add(attribute);
		}
		din.read(attribute.getAttribute_name_index());
		din.read(attribute.getAttribute_length());
		int size = getLength(attribute.getAttribute_length());
		System.out.println(size);
		byte[] info = new byte[size];
		din.read(info);
		attribute.setInfo(info);
		return attribute;
	}
	
	private static boolean readConstant() throws IOException {
	    boolean flag=true;
		int b = din.readByte();
		switch (b) {
		case 7:
			readConstant_Class();
			break;
		case 9:
			readConstant_Fieldref();
			break;
		case 10:
			readConstant_Methodref();
			break;
		case 11:
			readConstant_InterfaceMethodref();
			break;
		case 8:
			readConstant_String();
			break;
		case 3:
			readConstant_Integer();
			break;
		case 4:
			readConstant_Float();
			break;
		case 5:
			readConstant_Long();
			flag=false;
			break;
		case 6:
			readConstant_Double();
			flag=false;
			break;
		case 12:
			readConstant_NameAndType();
			break;
		case 1:
			readConstant_Utf8();
			break;
		case 15:
			readConstant_MethodHandle();
			break;
		case 16:
			readConstant_MethodType();
			break;
		case 18:
			readConstant_InvokeDynamic();
			break;
		default:
			System.out.println("读取错误");
			break;
		}
		return flag;
	}

	private static void readConstant_Class() throws IOException {
		Class_info classinfo = new Class_info();
		array.add(classinfo);
		normalclass.getConstantArray().add(classinfo);
		din.read(classinfo.getName_index());
	}

	private static void readConstant_Fieldref() throws IOException {
		Fieldref_info fieldrefinfo = new Fieldref_info();
		array.add(fieldrefinfo);
		normalclass.getConstantArray().add(fieldrefinfo);
		din.read(fieldrefinfo.getClass_index());
		din.read(fieldrefinfo.getName_and_type_index());

	}

	private static void readConstant_Methodref() throws IOException {
		Methodref_info methodrefinfo = new Methodref_info();
		array.add(methodrefinfo);
		normalclass.getConstantArray().add(methodrefinfo);
		din.read(methodrefinfo.getClass_index());
		din.read(methodrefinfo.getName_and_type_index());
	}

	private static void readConstant_InterfaceMethodref() throws IOException {
		InterfaceMethodref_info interfacemethodrefinfo = new InterfaceMethodref_info();
		array.add(interfacemethodrefinfo);
		normalclass.getConstantArray().add(interfacemethodrefinfo);
		din.read(interfacemethodrefinfo.getClass_index());
		din.read(interfacemethodrefinfo.getName_and_type_index());
	}

	private static void readConstant_String() throws IOException {
		String_info stringinfo = new String_info();
		array.add(stringinfo);
		normalclass.getConstantArray().add(stringinfo);
		din.read(stringinfo.getString_index());
	}

	private static void readConstant_Integer() throws IOException {
		Integer_info integerinfo = new Integer_info();
		array.add(integerinfo);
		normalclass.getConstantArray().add(integerinfo);
		din.read(integerinfo.getBytes());

	}

	private static void readConstant_Float() throws IOException {
		Float_info floatinfo = new Float_info();
		array.add(floatinfo);
		normalclass.getConstantArray().add(floatinfo);
		din.read(floatinfo.getBytes());
	}

	private static void readConstant_Long() throws IOException {
		Long_info longinfo = new Long_info();
		array.add(longinfo);
		Empty_info emptyinfo=new Empty_info();
		normalclass.getConstantArray().add(longinfo);
		normalclass.getConstantArray().add(emptyinfo);
		din.read(longinfo.getHigh_bytes());
		din.read(longinfo.getLow_bytes());
	}

	private static void readConstant_Double() throws IOException {
		Double_info doubleinfo = new Double_info();
		array.add(doubleinfo);
		Empty_info emptyinfo=new Empty_info();
		normalclass.getConstantArray().add(doubleinfo);
		normalclass.getConstantArray().add(emptyinfo);
		din.read(doubleinfo.getHigh_bytes());
		din.read(doubleinfo.getLow_bytes());
	}

	private static void readConstant_NameAndType() throws IOException {
		NameAndType_info nameandtypeinfo = new NameAndType_info();
		array.add(nameandtypeinfo);
		normalclass.getConstantArray().add(nameandtypeinfo);
		din.read(nameandtypeinfo.getName_index());
		din.read(nameandtypeinfo.getDescriptor_index());
	}

	private static void readConstant_Utf8() throws IOException {
		Utf8_info utf8info = new Utf8_info();
		array.add(utf8info);
		normalclass.getConstantArray().add(utf8info);
		din.read(utf8info.getLength());
		int size = getLength(utf8info.getLength());
		byte[] byArray = new byte[size];
		din.read(byArray);
		utf8info.setDescriptor_index(byArray);
	}

	private static void readConstant_MethodHandle() throws IOException {
		MethodHandle_info methodhandleinfo = new MethodHandle_info();
		array.add(methodhandleinfo);
		normalclass.getConstantArray().add(methodhandleinfo);
		din.read(methodhandleinfo.getReference_kind());
		din.read(methodhandleinfo.getReference_index());
	}

	private static void readConstant_MethodType() throws IOException {
		MethodType_info methodtypeinfo = new MethodType_info();
		array.add(methodtypeinfo);
		normalclass.getConstantArray().add(methodtypeinfo);
		din.read(methodtypeinfo.getDescriptor_index());
	}

	private static void readConstant_InvokeDynamic() throws IOException {
		InvokeDynamic_info invokedynamicinfo = new InvokeDynamic_info();
		array.add(invokedynamicinfo);
		normalclass.getConstantArray().add(invokedynamicinfo);
		din.read(invokedynamicinfo.getBootstrap_method_attr_index());
		din.read(invokedynamicinfo.getName_and_tyoe_index());

	}

	public static int getLength(byte[] byteArray) {
		int length = byteArray.length;
		int res = byteArray[0];
		for (int i = 1; i < length; i++) {
			res = res << 8;
			if(byteArray[i]<0){
			    res = res + byteArray[i]+256;  
			}else{
			res = res + byteArray[i];
			}
		}
		return res;
	}
}
