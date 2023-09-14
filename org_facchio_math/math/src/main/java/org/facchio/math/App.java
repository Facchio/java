package org.facchio.math;

public class App 
{
    public static void main( String[] args )
    {
    	NaturalNumber n1 = new NaturalNumber(97);
    	    	
        System.out.println( n1.getNumber());
        System.out.println( n1.isPrimeNumber());
        System.out.println( PrimeNumber.getPrimeNumbersUpTo(n1.getNumber()));
        
        FactorizationList list = new FactorizationList(n1);
        System.out.println(list);
        System.out.println(list.getList().size());
        
        
    }
}
