package com.dips.intent.startup;

import java.io.IOException;

import com.dips.intent.normalclass.Normalclass;

public class StartUP {
	
	public static void main(String args[]) throws IOException{
		ClassReader.Prepare("D:\\learn\\082501\\Test\\bin\\Test.class");
		Normalclass myclass=ClassReader.start();
		myclass.getMagic().toString();
		myclass.getVersion().toString();
		System.out.println(myclass.getConstantArray().size());
		System.out.println(myclass.getFieldArray().size());
		System.out.println(myclass.getMethodArray().size());
		System.out.println(myclass.getAttributeArray().size());
		myclass.refreshConstant();
//		myclass.refreshAttribute();
		myclass.TransForm();
	}
}
