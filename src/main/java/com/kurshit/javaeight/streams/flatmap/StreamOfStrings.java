package com.kurshit.javaeight.streams.flatmap;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamOfStrings {

	public static void main(String[] args) {
		
		retriveFirstNameAndJoinWithCommas();

	}
	
	public static void retriveFirstNameAndJoinWithCommas() {
		
		String[] namesString = {"Magnus Carlsen", "Anish Giri", "Vishy Anand", "Vidit Gujrathi"};
		
		Stream<String> namesStream = Stream.of(namesString);
		
		String collect = namesStream
			.collect(Collectors.joining());
		
		System.out.println(collect);
		
		
	}

}
