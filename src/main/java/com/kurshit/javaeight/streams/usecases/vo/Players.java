package com.kurshit.javaeight.streams.usecases.vo;

import java.util.List;

public class Players {
	
	String name;
	int age, rating;
	
	List<String> titles;
	
	public Players(String name, int age, int rating, List<String> titles) {
		this.name = name;
		this.age = age;
		this.rating = rating;
		this.titles = titles;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<String> getTitles() {
		return titles;
	}

	public void setTitles(List<String> titles) {
		this.titles = titles;
	}	
}