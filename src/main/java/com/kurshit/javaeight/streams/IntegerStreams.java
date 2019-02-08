package com.kurshit.javaeight.streams;

import java.util.stream.IntStream;


public class IntegerStreams {

	public static void main(String[] args) {
		
		traditionalArrayTraversal();
		traverseUsingStreams();

	}
	
	
	public static void traditionalArrayTraversal() {
		
		int size = 10;
		System.out.println();
		for( int i=0; i< size; i++ ) {
			System.out.println(i);
		}
		
		System.out.println();
		for( int i=0; i<= size; i++ ) {
			System.out.println(i);
		}
		
		
	}
	
	public static void traverseUsingStreams() {
		int size = 10;
		System.out.println();
		IntStream.range(0, size)
					.forEach(e -> System.out.println(e));
		
		System.out.println();
		IntStream.rangeClosed(0, size)
					.forEach(e -> System.out.println(e));
		
		
	}
	
	public static void streamFunctions( ) {
		
	}

}
