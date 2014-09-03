package com.dips.intent.magic;

public class Magic {
	byte[] magic=new byte[4];

	public byte[] getMagic() {
		return magic;
	}

	public void setMagic(byte[] magic) {
		this.magic = magic;
	}
	public String toString(){
		System.out.print("Ä§ÊýÎª:");
		for(int i=0;i<4;i++){
			System.out.print((magic[i]/16%16+16)%16+" ");
			System.out.print((magic[i]%16+16)%16+" ");
		}
		System.out.println();
		return null;
	}
}
