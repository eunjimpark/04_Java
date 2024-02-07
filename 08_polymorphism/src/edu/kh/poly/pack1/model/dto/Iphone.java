package edu.kh.poly.pack1.model.dto;

public class Iphone extends SmartPhone {

	// IOS 운영체제 버전
	private int iosVersion;
	
	public Iphone() {}

	public Iphone(String display, String newsAgency, String ap, int iosVersion) {
		super(display, newsAgency, ap);
		this.iosVersion = iosVersion;
	}

	public int getIosVersion() {
		return iosVersion;
	}

	public void setIosVersion(int iosVersion) {
		this.iosVersion = iosVersion;
	}
	
	@Override
	public String toString() {
		return "Iphone iosVersion : " + iosVersion + " / " + super.toString();
	}
	
	
	
}
