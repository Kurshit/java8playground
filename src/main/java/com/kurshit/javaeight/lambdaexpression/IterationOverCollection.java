package com.kurshit.javaeight.lambdaexpression;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * The class IterationOverCollection shows various ways to iterate over a collection using Java8 lambda expressions.
 */

	
public class IterationOverCollection {
	
	public static void main(String[] args) {
		
		List<Integer> numbers = Arrays.asList(10,20,30,40,50);
		
		/*
		 * Traditional approach - basic index based for loop. (Declarative programming)
		 */
		
		System.out.println("Basic traditional index based for loop");
		for(int i=0; i<numbers.size(); i++) {
			System.out.println(i);
		}
		
		System.out.println("External for loop");
		
		for(Integer no : numbers) {
			System.out.println(no);
		}
		
		/*
		 * Using lambda's and forEach loop. ( Iterative Programming)
		 * 
		 * forEach loop - this takes in the Consumer instance. Consumer is basicallt a SAM interface
		 * with a signle method - accept().
		 */
		
		/*
		 * Creating the consumer's annonymous class and passing it to for each - naive approach
		 */
		
		System.out.println("Using for each and Consumer's anonymous class");
		numbers.forEach(new Consumer<Integer> () {

			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}
			
		});
		
		/*
		 * This above code is quite verbose. This can be enhanced using lambdas, since Consumer is a SAM interface, as follow :
		 */
		
		System.out.println("Enhancing for each using lambda's");
		
		numbers.forEach(element -> System.out.println(element));
		
		/*
		 * This above for each is a perfect example of Abstraction. Look at the quiteness in this approach of iterating a collection.
		 * 
		 */
		
		System.out.println("Enhacnging forEach using method ref :");
		
		numbers.forEach(System.out :: println);
		


	}

}
