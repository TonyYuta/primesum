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
	public static BigInteger[] ams = new BigInteger[45]; // Arithmetic Means sum digits
	public static int[] primeNumbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107, 109,	 113, 127, 131,	137, 139, 149, 151, 157, 163, 167, 173, 179, 181};

	
	public static void main(String... args) throws Throwable {
		dataBI();
		allArithmeticMeans();
        System.out.println("1===================================");
		printOutArray(bidata);
        System.out.println("2===================================");
        printOutArray(am);		
        allArithmeticMeansSum(am);
        System.out.println("3===================================");
        printOutArray(ams);		
		
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
    
    public static void allArithmeticMeans() {
    	   int n = 0;
    	   for(int i = 0; i < 9; i++) {
    		   for(int j = i+1; j < 10; j++) {
    			   am[n] = arithmeticMean(bidata[i], bidata[j]);
    			   System.out.println("bidata[" + i + "] : bidata[" + j + "] : am[" + n + "] | " +  bidata[i] + ":" + bidata[j] + ":" + am[n]);
    			   n++;
    		   }
    	   }
    }
    
    public static void printOutArray(BigInteger[] arr) {
    	   for (int i = 0; i < arr.length; i++) {
    		   System.out.println(arr[i]);
    	   }
    }
    
    public static void allArithmeticMeansSum(BigInteger[] arr) {
    		for(int i = 0; i < arr.length; i++) {
    			String digits = arr[i].toString();
    			int sum = 0;

	    		for(int j = 0; j < digits.length(); j++) {
	    			int digit = digits.charAt(j) - '0';
	    			sum = sum + digit;
	    		}
    		ams[i] = BigInteger.valueOf(sum);
    		//System.out.println(sum);
    		}     
    }
  

}