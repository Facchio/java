package org.facchio.math;

import java.util.ArrayList;

public class FactorizationList {
	
	private NaturalNumber number;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	private ArrayList<ExponentiatedNumber> condensedList = null;
	

	public FactorizationList(NaturalNumber number) {
		this.setNumber(number);
		this.loadList();
	}
	
	public NaturalNumber getNumber() {
		return number;
	}

	private void setNumber(NaturalNumber number) {
		this.number = number;
	}
	
	private void loadList() {
		
		Integer number = this.getNumber().getNumber();
		
		if(number==1) {
			this.list.add(1);
		}else {
			
			ArrayList<Integer> divisors = PrimeNumber.getPrimeNumbersUpTo(number);
			int i = 0;
			
			while(number > 1) {
				if((number % divisors.get(i))==0) {
					this.list.add(divisors.get(i));
					number = number / divisors.get(i);
				}else {
					if((i+1)==divisors.size()) {
						this.list.add(number);
						break;
					}else {
						i++;
					}
					
				}
			}
			
		}		
	}
	
	private void loadCondensedList() {
		if(this.condensedList==null) {
			this.condensedList = new ArrayList<ExponentiatedNumber>();
			
					
			for ( Integer number : this.getList()) {
				Integer sizeList = this.condensedList.size();
				if(sizeList == 0 || this.condensedList.get(sizeList-1).getNumber()!=number) {
					this.condensedList.add(new ExponentiatedNumber(number));
				}else {
					this.condensedList.get(sizeList-1).addExponent();
				}
			}
			
		}
	}
	
	public ArrayList<Integer> getList(){
		return this.list;
	}
	
	public ArrayList<ExponentiatedNumber> getCondensedList(){
		this.loadCondensedList();
		return this.condensedList;
	}
	
	
	

	@Override
	public String toString() {
		return "FactorizationList [list=" + list + "]";
	}
	
	
	

}
