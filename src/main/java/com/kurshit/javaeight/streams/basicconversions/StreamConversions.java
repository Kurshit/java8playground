package com.kurshit.javaeight.streams.basicconversions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamConversions {

	public static void main(String[] args) {

		System.out.println("1. String array to Streams :\n");
		stringArrayToStreamConversion();

		System.out.println();

		System.out.println("2. Difference between Stream.of() and Arrays.stream() :\n");
		differenceBetweenStreamOfAndArraysToStream();

		System.out.println();
		System.out.println("\n3. ArrayList to Streams\n");
		listToStreamConversion();

		System.out.println();
		System.out.println("\n4. HashMap to Streams\n");
		mapToStreamConversion();
	}


	public static void stringArrayToStreamConversion() {

		//1. Converting String array to Stream<String>

		String[] arrayOfNamesStrings = {"Magnus Carlsen", "Anish Giri", "Vishy Anand", "Vidit Gujrathi"};

		/*
		 * FOllowing are two ways to do so. 
		 * 
		 * Stream.of() internally uses Arrays.stream() only to convert into Stream.
		 * 
		 * But there is a difference between them as we will see further.
		 * 
		 */

		Stream<String> streamOfStrings1 = Stream.of(arrayOfNamesStrings);


		Stream<String> streamOfStrings2 = Arrays.stream(arrayOfNamesStrings);

		System.out.println("First Stream :\n");
		streamOfStrings1.forEach(e -> System.out.print(e + " "));
		System.out.println("\n");
		System.out.println("Second Stream :\n");
		streamOfStrings2.forEach(e -> System.out.print(e + " "));		

	}

	/*
	 *  2. Difference of Arrays.stream() and Stream.of().
	 *  The Stream.of() simply calls Arrays.stream() method for "Non-Primitive" types internally.
	 *  
	 *  Ques: When Stream.of() seems to be just a wrapper on Arrays.stream(), then why is it included in Java ?
	 *  Ans:
	 *  	1. For Primitive arrays, Arrays.stream() and Stream.of() have different return types.
	 *  
	 *   	For example - if we pass an int[], Stream.of() will return Stream<int[]> while Arrays.stream() returns
	 *   	an IntStream. 
	 *   
	 *      2. Since, Stream.of() returns Stream<int[]>, we need to convert it to IntStream explicitely to be able to 
	 *      perform other intermidiate operation on Stream. Example is shown as below
	 *      
	 *      3. Arrays.stream() is overloaded for primitive arrays of int, long and double type. For other types, 
	 *      Arrays.stream() won't work. It returns IntStream for an int[], LongStream for long[] and DoubleStream
	 *      for double[]. On the other hand, Stream.of() has no overloaded method for primitive arrays. Instead it has only
	 *      for T generic object
	 *  
	 * 
	 */

	public static void differenceBetweenStreamOfAndArraysToStream() {		

		int[] primitiveIntArray = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

		Stream<int[]> primitiveIntStream1 =  Stream.of(primitiveIntArray);

		IntStream primitiveIntStream2 = Arrays.stream(primitiveIntArray);


		primitiveIntStream1
		.forEach(e -> System.out.print(e + " ")); // this will output - [I@3e3abc88 

		System.out.println();

		primitiveIntStream2.forEach(e -> System.out.print(e + " ")); // output - 10 20 30 40 50 60 70 80 90 100 

		// For first Stream<int> we need to convert it to IntStream explicitely - 

		System.out.println("\nConverting Stream<int> to IntStream Explicitely");

		Stream<int[]> primitiveIntStream3 =  Stream.of(primitiveIntArray);

		primitiveIntStream3
		.flatMapToInt(e -> Arrays.stream(e))
		.forEach(e -> System.out.print(e + " "));

	}


	public static void listToStreamConversion() {

		//3. Converting ArrayList of Int to Stream<Integer>

		List<String> arraylistOfNames = Arrays.asList("Magnus Carlsen", "Anish Giri", "Vishy Anand", "Vidit Gujrathi");

		/*
		 *  Now instead of an array, we have a collection. The collection API provided an inbuilt method to convert a 
		 *  collection into an sequential (or parallel) stream by invoking .stream() on it.
		 *  
		 *  Also, in this case, Arrays.stream() will not work as it acceptso array of different types - T[]
		 *  
		 *  Calling Stream.of() for collection would return Stream<Type> 
		 *  
		 */

		Stream<List<String>> streamOfStrings1 = Stream.of(arraylistOfNames);

		Stream<String> streamOfStrings2 = arraylistOfNames.stream();

		System.out.println("First Stream :\n");
		streamOfStrings1.forEach(e -> System.out.print(e + " ")); // This would print an object - which in turns prints all elements

		System.out.println("");

		System.out.println("Second Stream :\n");
		streamOfStrings2.forEach(e -> System.out.print(e + " "));

		System.out.println();

		System.out.println("\nExplicitely converting the Stream<List<String>> to Stream<String>\n");
		Stream<List<String>> streamOfStrings3 = Stream.of(arraylistOfNames);
		streamOfStrings3
		.flatMap(e -> e.stream())		
		.forEach(e -> System.out.print(e + " "));


		/*
		 * We will see conversion for List<Integer> now. The difference lies in using flatMapToInt in this case instead of
		 * flatMap() only.
		 */

		System.out.println();

		List<Integer> arraylistOfNumbers = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90, 100);

		Stream<Integer> streamOfIntegers1 = arraylistOfNumbers.stream();

		Stream<List<Integer>> streamOfIntegers2 = Stream.of(arraylistOfNumbers);

		System.out.println("First Integer numbers : \n");

		streamOfIntegers1
		.forEach(e -> System.out.print(e + " "));

		System.out.println();

		System.out.println("Second Integer numbers with explicit conversion: \n");

		streamOfIntegers2
		.flatMap(e -> e.stream())
		.forEach(e -> System.out.print(e + " "));
	}

	public static void mapToStreamConversion() {

		//4. Converting HashMap of Int,String to Stream
		
		Map<Integer, String> map = new HashMap<Integer,String>(){{
			put(1, "Magnus Carlsen");
			put(2, "Vishy Anand");
			put(3, "Vidit Gujrati");
			put(4, "P Harikrishna");
			put(5, "Anish Giri");
			
		}};
		
		
		Stream<Map.Entry<Integer, String>> mapStreams = map.entrySet()
			.stream();
		
		mapStreams.forEach(e -> System.out.println("Rank is : " + e.getKey() + " Name is : " +e.getValue()));
		

	}


}
