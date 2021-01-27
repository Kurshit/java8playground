package com.kurshit.javaeight.streams.collectors;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsOperations {

	public static void main(String[] args) {
		
		joinTheStringsUsingJoining();

	}
	
	public static void joinTheStringsUsingJoining() {
		
		String[] namesString = {"Magnus Carlsen", "Anish Giri", "Vishy Anand", "Vidit Gujrathi"};
		
		
		
		/* 
		 * 1. This will concat all strings in namesString array together.
		 * 
		 */
		Stream<String> namesStream1 = Stream.of(namesString);
		String collect1 = namesStream1
			.collect(Collectors.joining());
		System.out.println("1. Joining the strings :");
		System.out.println(collect1);
		
		System.out.println();
		
		/*
		 * 2. This will join all names with , as delimeter
		 */
		
		Stream<String> namesStream2 = Stream.of(namesString);
		String collect2 = namesStream2
			.collect(Collectors.joining(","));
		System.out.println("2. Joining the strings with , delimeter:");
		System.out.println(collect2);
		
		/*
		 * This will join string separated by , as delimeter and with Prefix (Start of String) as |
		 * and Suffix #
		 * 
		 */
		
		Stream<String> namesStream3 = Stream.of(namesString);
		String collect3 = namesStream3
			.collect(Collectors.joining(",","|"," #"));
		System.out.println("3. Joining the strings with , delimeter:");
		System.out.println(collect3);
		
		
	}

}
