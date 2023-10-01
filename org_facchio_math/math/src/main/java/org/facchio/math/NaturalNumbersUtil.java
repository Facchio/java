package org.facchio.math;

import java.util.ArrayList;

public class NaturalNumbersUtil {

	
	public static Double getLeastCommonMultiple(Integer[] numbers) {
		if(numbers == null) {
			throw new java.lang.NullPointerException("Numbers can't be null.");
		}
		
		if(numbers.length < 2) {
			throw new java.lang.IllegalArgumentException("At least two natural numbers must be provided to execute the function.");
		}
		
		
		NaturalNumber[] naturalNumber = new NaturalNumber[numbers.length];
		for(int i=0;i<naturalNumber.length;i++) {
			naturalNumber[i] = new NaturalNumber(numbers[i]);
		}
		
			return NaturalNumbersUtil.getLeastCommonMultiple(naturalNumber);
	}
	
	
	public static Double getLeastCommonMultiple(NaturalNumber[] numbers) {
		
		if(numbers == null) {
			throw new java.lang.NullPointerException("Numbers can't be null.");
		}
		
		if(numbers.length < 2) {
			throw new java.lang.IllegalArgumentException("At least two natural numbers must be provided to execute the function.");
		}
		
		
		ArrayList<ExponentiatedNumber> LCMList = new ArrayList<ExponentiatedNumber>();
		
		for(NaturalNumber n: numbers ) {
								
						
			for(ExponentiatedNumber extNum: n.getFactorizationList().getCondensedList()) {
				Boolean nFounded = false;
				
				for(ExponentiatedNumber lcmNum: LCMList) {
					
					if(extNum.getNumber() == lcmNum.getNumber()) {
						nFounded = true;
						
						if(extNum.getExponent() > lcmNum.getExponent()) {
							lcmNum.setExponent(extNum.getExponent());
						}
						
						break;
					}
					
				}
				
				if(nFounded == false) {
					LCMList.add(new ExponentiatedNumber(extNum.getNumber(),extNum.getExponent()));
				}
				
			}
					
		}
		
		Double LCMValue = 1.0;
		for(ExponentiatedNumber item: LCMList) {
			LCMValue *= item.getPower();
		}
		
					
		return LCMValue;
	}
	
	
	public static Double getGreatestCommonDivisor(Integer[] numbers) {
		if(numbers == null) {
			throw new java.lang.NullPointerException("Numbers can't be null.");
		}
		
		if(numbers.length < 2) {
			throw new java.lang.IllegalArgumentException("At least two natural numbers must be provided to execute the function.");
		}
		
		
		NaturalNumber[] naturalNumber = new NaturalNumber[numbers.length];
		for(int i=0;i<naturalNumber.length;i++) {
			naturalNumber[i] = new NaturalNumber(numbers[i]);
		}
		
			return NaturalNumbersUtil.getGreatestCommonDivisor(naturalNumber);
	}
	
	
	public static Double getGreatestCommonDivisor(NaturalNumber[] numbers) {
		
		if(numbers == null) {
			throw new java.lang.NullPointerException("Numbers can't be null.");
		}
		
		if(numbers.length < 2) {
			throw new java.lang.IllegalArgumentException("At least two natural numbers must be provided to execute the function.");
		}
		
		
		ArrayList<ExponentiatedNumber> GCDList = null;
		
		for(NaturalNumber n: numbers ) {
			
			if(GCDList==null) {
				GCDList = n.getFactorizationList().getCondensedList();
				continue;
			}
			
			for(int i = (GCDList.size() - 1); i >= 0; i--) {
				Boolean nFounded = false;			
						
				for(ExponentiatedNumber extNum: n.getFactorizationList().getCondensedList()) {

					if(extNum.getNumber() == GCDList.get(i).getNumber()) {
						nFounded = true;
						
						if(extNum.getExponent() < GCDList.get(i).getExponent()) {
							GCDList.get(i).setExponent(extNum.getExponent());
						}
						
						break;
					}
					
				}
				
				if(nFounded == false) {
					GCDList.remove(i);
				}
			}
					
		}
		
		Double GCDValue = 1.0;
		for(ExponentiatedNumber item: GCDList) {
			GCDValue *= item.getPower();
		}
		
					
		return GCDValue;
		
		
	}
	
	
}
