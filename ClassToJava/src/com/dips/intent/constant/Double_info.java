package com.dips.intent.constant;

public class Double_info extends Constant_info{
	byte[] high_bytes=new byte[4];
	byte[] low_bytes=new byte[4];
	public Double_info(){
		setTag(ConstantType.CONSTANT_Double);
	}
	public byte[] getHigh_bytes() {
		return high_bytes;
	}
	public void setHigh_bytes(byte[] high_bytes) {
		this.high_bytes = high_bytes;
	}
	public byte[] getLow_bytes() {
		return low_bytes;
	}
	public void setLow_bytes(byte[] low_bytes) {
		this.low_bytes = low_bytes;
	}
}
