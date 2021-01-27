package com.kurshit.javaeight.lambdaexpression;


/**
 * @author Kurshit Kukreja - kukreja.kurshit@gmail.com
 * 
 * 
 * This class shows the very basic syntax to write a lambda expressions.
 * The lamda's uses the Single Abstract Method Interface - an Intefrace with only one method in it.
 * 
 *  
 * 
 */

public class SampleLambda {
	
	public static void main(String[] args) {
		
		
		/*
		 * This is a traditional approach to provide implementation of an interface's method using
		 * an anonymous class. This traditional approach would create a .class file on compilation
		 * with name - SampleLambda$1.class. Also, the following method is quite verbose and noisy.		 *  
		 * Lambda expression has given this approach an entirely new dimension.
		 */
		
		SampleSAM sampleSAMTraditionalRef = new SampleSAM() {

			@Override
			public int operation(int a, int b) {
				return a + b;
			}
				
		};
		
		System.out.println(sampleSAMTraditionalRef.operation(50, 50));
		
		
		/*
		 * Following is a way to overcome traditional approach and create implementation of a method at run time.
		 * The following approach would never create a .class file on compilation. Please mind this. The call to 
		 * implemented method gets binded using "invokeDynamic" concept. InvokeDynamic is basically an JVM instruction 
		 * that was initially introduced in Java 7 to make Java a dynamically typed language. However, this concept took
		 * an altogether different form in Java8. This approach gets rid of creating .class files as in case of above 
		 * traditional approach and does not make an app a fat jar.  
		 * 
		 */
		
		SampleSAM sampleSAMRef = (int a, int  b) -> { return a + b;};
		
		System.out.println(sampleSAMRef.operation(10, 20));
		
		
		// The return keyword and braces are optional for an inline statement
		SampleSAM sampleSAMRefOne = (int a, int  b) -> a + b; 
		
		System.out.println(sampleSAMRefOne.operation(20, 20));
		
		
		// Providing argument type is optional. Java finally seems to have type inference in Java8.
		SampleSAM sampleSAMRefTwo = (a,b) -> a + b;
		
		System.out.println(sampleSAMRefTwo.operation(30, 20));
		
		

	}

}

/*
 *  Single Abstract Method interface to be used in Lambda expression.
 */

interface SampleSAM {
	public int  operation(int a, int b);
}
