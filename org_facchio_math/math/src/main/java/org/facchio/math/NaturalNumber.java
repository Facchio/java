package org.facchio.math;


public class NaturalNumber {
	
	private Integer number;
	private FactorizationList factorizationList = null;
	

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
	
	public FactorizationList getFactorizationList() {
		if(this.factorizationList==null) {
			this.factorizationList = new FactorizationList(this);
		}
		return this.factorizationList;
	}

}
