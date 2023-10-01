package org.facchio.math;


public class ExponentiatedNumber {
	
	
	double number = 0;
	Integer exponent = 1;
	


	public ExponentiatedNumber(double number) {
		this(number,1);
	}
	
	public ExponentiatedNumber(double number, Integer exponent) {
		this.number = number;
		this.exponent = exponent;
	}
	
	
	
	public double getNumber() {
		return number;
	}

	public Integer getExponent() {
		return exponent;
	}
	public void setExponent(Integer exponent) {
		this.exponent = exponent;
	}
	
	public double getPower() {
		return java.lang.Math.pow(this.getNumber(), this.getExponent());
	}
	
	public Integer addExponent() {
		this.exponent++;
		return this.getExponent();
	}
	
	public Integer subtractExponent() {
		this.exponent--;
		return this.getExponent();
	}
	
	@Override
	public String toString() {
		return String.format("%f ^ %d", this.getNumber(),this.exponent);
	}



}
