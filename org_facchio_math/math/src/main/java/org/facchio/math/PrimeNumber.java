package org.facchio.math;

import java.util.ArrayList;

public class PrimeNumber
{
    public static void main( String[] args )
    {
        System.out.println(PrimeNumber.getPrimeNumbersUpTo(111));
        System.out.println(PrimeNumber.getSetOfPrimeNumbersPossibleDivisors(111));
        
        Integer valor = 143;
        System.out.println(PrimeNumber.getFirstDivisor(valor));
        System.out.println(PrimeNumber.isPrimeNumber(valor));
    }
    
    
    public PrimeNumber() {
    	
    }
    
    public static ArrayList<Integer> getPrimeNumbersUpTo(Integer number){
        ArrayList<Integer> listNumbers = new ArrayList<Integer>();

       
        if(number >= 2)
        listNumbers.add(2);
       
        if(number > 2){
            for(int i = 3; i <= number; i = i+2){
                boolean isPrime = true;
               
                for(Integer prime: listNumbers){
                    if((i % prime)==0){
                        isPrime = false;
                        break;
                    }
                }
               
                if(isPrime){
                    listNumbers.add(i);
                }
               
            }
        }
       
        return listNumbers;
    }
    
    public static ArrayList<Integer> getSetOfPrimeNumbersPossibleDivisors(Integer number){
    	ArrayList<Integer> listNumbers = new ArrayList<Integer>();
    	
    	if(number >= 2)
    		 listNumbers.add(2);
    	
    	if(number > 2){
    		Integer lastNumber = 2;
            
    		for(int i = 3; i <= number; i = i+2){
                boolean isPrime = true;
               
                for(Integer prime: listNumbers){
                    if((i % prime)==0){
                        isPrime = false;
                        break;
                    }
                }
               
                if(isPrime){
                                        
                    if((lastNumber * i) > number) {
                    	break; 
                    }else {
                    	listNumbers.add(i);
                    	lastNumber = i;
                    }
                
                }
               
            }
        }
    	
    	listNumbers.add(number);
    	
    	return listNumbers;
    }
    
    public static Integer getFirstDivisor(Integer number){
        if(number < 1){return -1;}
        if(number == 1){return 1;}
       
       ArrayList<Integer> primeList = PrimeNumber.getSetOfPrimeNumbersPossibleDivisors(number);
       
        for(Integer prime: primeList){
            if((number % prime) == 0){
                return prime;
            }
        }
       
        return number;
       
    }
    
    public static boolean isPrimeNumber(Integer number){
        Integer divisor = PrimeNumber.getFirstDivisor(number);
       
        if(number==1 || number==-1) {return false;}
        if(divisor == number){return true;}
        return false;
       
    }
    
}