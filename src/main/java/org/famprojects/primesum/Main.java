package org.famprojects.primesum;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Main class with input & analysis methods
 * range sum 1 to 189
 *
 */
public class Main {
	
	public static boolean inputOk = true;
	public static BigInteger bi;
	public static String inpString = "";
	public static BigInteger[] bidata = new BigInteger[10]; // Big Integer data
	public static BigInteger[] am = new BigInteger[45]; // Arithmetic Means
	
	public static void main(String... args) throws Throwable {
		dataBI();
		allArithmeticMeansSum();
      }
       
    public static void verifyInputLength(String inp) {
    	   boolean result;
    	   bi = new BigInteger(inp);
    	   if(inp.length() != 22) {
    		   inputOk = false;
    	   } else inputOk = true;
    }
    
    public static String inputStr(int n) {
        Scanner kb = new Scanner(System.in);
        String str1 = "";
        System.out.print("Enter number " + (n+1) + ": ");
 	    inputOk = false;
        while (!inputOk) {
           str1 = kb.nextLine();
           verifyInputLength(str1);
           System.out.println(inputOk?"":"Try again. Enter number 22 digits, first is not 0");
        } 
        return str1;
    }
    
    public BigInteger stringToBigInteger(String str) {
    	   bi = new BigInteger(str);
    	   return bi;
    }
    
    public static void dataBI() {
		for (int i = 0; i < 10; i++) {
		    inpString = inputStr(i);
		    bidata[i] = new BigInteger(inpString);		
		}
    }
        
    public static BigInteger arithmeticMean(BigInteger a, BigInteger b) {
 	   BigInteger sum = new BigInteger("0");
 	   sum = sum.add(a);
 	   sum = sum.add(b);
 	   BigInteger am = new BigInteger("0");
 	   am = sum.divide(BigInteger.valueOf(2));
 	   return am;
    }
    
    public static void allArithmeticMeansSum() {
    	   int n = 0;
    	   boolean found = false;;
    	   for(int i = 0; i < 9; i++) {
    		   for(int j = i+1; j < 10; j++) {
    			   am[n] = arithmeticMean(bidata[i], bidata[j]);
    			   if(isPrimeNumber(sumDigits(am[n]))) {
    				   found = true;
    				   System.out.println( (i+1) + ":" + (j+1) + ":" + sumDigits(am[n]));
    			   }    			   
    			   n++;
    		   }
    	   }
    	   if(!found) System.out.println("not found");
    }
    
    public static void printOutArray(BigInteger[] arr) {
    	   for (int i = 0; i < arr.length; i++) {
    		   System.out.println(arr[i]);
    	   }
    }
    
    public static int sumDigits(BigInteger num) {
    	int result = 0;
		int sum = 0;
		String digits = num.toString();

    		for(int i = 0; i < digits.length(); i++) {
    			int digit = digits.charAt(i) - '0';
    			sum = sum + digit;
    		}
		result = sum;
		return result;
	}     
    
    /**
     * checks whether an int is prime or not.
     * @param num
     * @return boolean
     * 
     */
    public static boolean isPrimeNumber(int num) {
    		if(num == 1) return false;
    	    if(num % 2 == 0) return false;
    	    for(int i = 3; i*i <= num; i += 2) {
    	        if(num % i == 0)
    	            return false;
    	    }
    	    return true;
    	}
}