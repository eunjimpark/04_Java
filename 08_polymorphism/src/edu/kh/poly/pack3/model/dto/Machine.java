package edu.kh.poly.pack3.model.dto;

//인터페이스 접점
public interface Machine {
	
	int VOLT = 220;
	
	public abstract void powerOn();
	void powerOff();

}
