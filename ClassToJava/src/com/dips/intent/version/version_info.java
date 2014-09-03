package com.dips.intent.version;

import com.dips.intent.startup.ClassReader;

public class version_info {
	byte[] minor_version=new byte[2];
	byte[] major_version=new byte[2];
	public byte[] getMinor_version() {
		return minor_version;
	}
	public void setMinor_version(byte[] minor_version) {
		this.minor_version = minor_version;
	}
	public byte[] getMajor_version() {
		return major_version;
	}
	public void setMajor_version(byte[] major_version) {
		this.major_version = major_version;
	}
	public String toString(){
		System.out.print("最低版本号为: ");
		System.out.println(ClassReader.getLength(minor_version));
		System.out.print("最高版本号为: ");
		System.out.print(ClassReader.getLength(major_version));
		System.out.println();
		return null;
	}
}
