package com.kurshit.javaeight.streams;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class IntegerStreamsOperations {

	public static void main(String[] args) {
		
		traditionalArrayTraversal();
		traverseUsingStreams();
		System.out.println();
		streamFunctions();
	}
	
	
	public static void traditionalArrayTraversal() {
		
		int size = 10;
		System.out.println();
		
		// 10 excluded
		for( int i=0; i< size; i++ ) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		// 10 included
		
		for( int i=0; i<= size; i++ ) {
			System.out.print(i + " ");
		}
		
		
	}
	
	public static void traverseUsingStreams() {
		int size = 10;
		System.out.println();
		
		//10 excluded		
		IntStream.range(0, size)
					.forEach(e -> System.out.print(e + " "));
		
		//10 included
		System.out.println();
		IntStream.rangeClosed(0, size)
					.forEach(e -> System.out.print(e + " "));
		
		
	}
	
	public static void streamFunctions( ) {
		int size = 10;
		System.out.print("\nCheck if all elements of streams are less than 10 :");
		System.out.print(IntStream.range(0, size)
					.allMatch(e -> e < 9 ));
		
		System.out.print("\nCheck if there is any element divisible by 5 :");
		System.out.print(IntStream.range(0, 10).anyMatch(e -> e %5 ==0));
		
		
		System.out.print("\nConvert Integer Stream to Double Stream :");
		IntStream.range(0, 10)
				.asDoubleStream()
				.forEach(e -> System.out.print(e +" "));
		
		System.out.print("\nConvert Integer Stream to Long Stream :");
		IntStream.range(0, 10)
				.asLongStream()
				.forEach(e -> System.out.print(e +" "));
		
		System.out.print("\nAverage of all elements in stream :");
		OptionalDouble result = IntStream.range(0, 10)
				.average();
		System.out.print(result.getAsDouble());
		
		System.out.print("\nBox IntStream into Stream of Integers :");
		Stream<Integer> stream = IntStream.range(0, 10)
				.boxed();
		stream.forEach(e -> System.out.print(e + " "));
		
		//collect function remains
		
		System.out.print("\nCount of elements in stream :");
		System.out.print(IntStream.range(0, 15)
				.count());
		
		System.out.print("\nPrint distinct elements of stream avoiding duplicates : ");
		Stream.of(1,2,3,4,5,5,5,6,6,7,7)
				.distinct()
				.forEach(e -> System.out.print(e + " "));
		//filter remains
		
		
		System.out.print("\nReturns the any random element of streams : ");
		/*
		 * Behavior of this undeterministic. Mostly will return first element. If Empty, will return Op
		 */
		
		System.out.print(IntStream.range(20, 30)
				.findAny().getAsInt());
		
		System.out.print("\nReturns the first elements of streams. Simillar to findFirst() : ");
		System.out.print(IntStream.range(20, 30)
				.findFirst());
		
		
		List<Integer> listA = Arrays.asList(10,20,30,40);
		List<Integer> listB = Arrays.asList(50,60,70,80,40);
		List<Integer> listC = Arrays.asList(80,90,100,110);
		
		List<List<Integer>> combinedList = Arrays.asList(listA,listB,listC);
		
		System.out.print("\nCombining three lists into one lists using flatMap() : ");
		combinedList.stream()
				.flatMap(e -> e.stream())
				.forEach(e -> System.out.print(e + " "));
		
		System.out.print("\nIs Stream Parallel : " + IntStream.range(0, 10)
				.isParallel());
		
		
		System.out.print("\nIterating using OfInt Iterator - Primitive Iterator : " );
		OfInt iterator = IntStream.range(0, 10)
				.iterator();
		
		while(iterator.hasNext()) {
			System.out.print(iterator.nextInt() +" ");
		}
		
		
		System.out.print("\nLimiting the stream elements: ");
															
		IntStream.range(0, 10)
				.limit(4)
				.forEach(e -> System.out.print(e + " "));
		
		System.out.println("\nUsing of map function - double stream values : ");
		
		IntStream.range(0,10)
				.map( e-> e * 2)
				.forEach(e -> System.out.print(e +" "));
		
		System.out.print("\nMax element of stream : "+ IntStream.range(0, 10).max()+ " and min is : " +IntStream.range(0, 10).min() );
		
		System.out.print("\nnoneMatch() - Stream does NOT have any element that is modulas of 2 : " +IntStream.range(0, 10)
				.noneMatch(e -> e %2 == 0));
		
		System.out.print("\nnoneMatch() - Stream does NOT have any element that is greater than 9 : " +IntStream.range(0, 10)
		.noneMatch(e -> e > 9));
		
		IntStream streamClosable = IntStream.range(0, 10)
				.onClose(() -> System.out.println("This is closable task"));
		System.out.print("\nClosable task has been written, which would only get called"
				+ "on calling close() on Streams explicitely. :");
		System.out.print("\nIterating before closing the stream \n");
		streamClosable.forEach(e -> System.out.print(e + " "));
		
		/*
		 * Following commented line would cause an exception as String is already closed
		 * But, the Closablle Task would not get called until and unless close() is
		 * not called up
		 *  
		 */
		
		//System.out.println(streamClosable.average());
		
		streamClosable.close();					
				
	}

}
