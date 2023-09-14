package org.facchio.math;


public class NaturalNumber {
	
	protected Integer number;
	

	public NaturalNumber(Integer number) {
		this.setNumber(number);
	}
	
	
	public Integer getNumber() {
		return number;
	}

	private void setNumber(Integer number) {
		if(number < 1) {
			throw new ArithmeticException(String.format("%d it's not a natural number!", number));
		}
		
		this.number = number;
	}
	
	public boolean isPrimeNumber() {
		return PrimeNumber.isPrimeNumber(this.getNumber());
	}

}
