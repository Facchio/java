package org.facchio.math;

import java.util.ArrayList;

public class FactorizationList {
	
	private NaturalNumber number;
	private ArrayList<Integer> list = new ArrayList<Integer>();
	

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
	
	public ArrayList<Integer> getList(){
		return this.list;
	}

	@Override
	public String toString() {
		return "FactorizationList [list=" + list + "]";
	}
	
	
	

}
