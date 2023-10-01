package org.facchio.math;

import java.util.Arrays;

public class App 
{
    public static void main( String[] args )
    {
    	NaturalNumber n1 = new NaturalNumber(480);
    	    	
        System.out.println( String.format("Número: %d", n1.getNumber()));
        System.out.println( String.format("É um número primo: %s",n1.isPrimeNumber()));
        System.out.println( String.format("Lista de números primos antecessores: %s", PrimeNumber.getPrimeNumbersUpTo(n1.getNumber())));
        
        //FactorizationList list = new FactorizationList(n1);
        System.out.println(String.format("Fatoração: %s",n1.getFactorizationList()));
        System.out.println(String.format("Fatoração Condensada: %s",n1.getFactorizationList().getCondensedList()));
        System.out.println(n1.getFactorizationList().getList().size());
        
        ExponentiatedNumber n = new ExponentiatedNumber(2,10);
        
        System.out.println(n.getPower());
        n.subtractExponent();
        System.out.println(n.getPower());
        System.out.println(n);
        
        Integer[] values = {24,36,60,144};
        
        double LCM = org.facchio.math.NaturalNumbersUtil.getLeastCommonMultiple(values);
        System.out.println(String.format("O MMC dos números %s é %2f", Arrays.toString(values), LCM));
        
        
        double GCD = org.facchio.math.NaturalNumbersUtil.getGreatestCommonDivisor(values);
        System.out.println(String.format("O MDC dos números %s é %2f", Arrays.toString(values), GCD));
    }
}
