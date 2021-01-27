package com.kurshit.javaeight.streams.usecases;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kurshit.javaeight.streams.usecases.vo.Players;

public class ChessTournamentsUtil {
	
public static List<Players> samplePlayers() {
		
		List<Players> result = new ArrayList<>();
		
		Players player1 = new Players("Vishy Anand", 56, 2778 , Arrays.asList("GM","IM","FM"));
		Players player2 = new Players("Magnus Carlsen", 26, 2832 , Arrays.asList("GM","IM","FM"));
		Players player3 = new Players("Vidit Gujrathi", 25, 2706 , Arrays.asList("GM","IM","FM"));
		Players player4 = new Players("Sagar Shah", 28, 2415 , Arrays.asList("IM"));
		Players player5 = new Players("Samay Raina", 22, 0 , Arrays.asList());
		Players player6 = new Players("Tania Sachdev", 23, 2515 , Arrays.asList("WGM","IM","FM"));
		Players player7 = new Players("Anish Giri", 26, 2726 , Arrays.asList("GM","IM","FM"));
		Players player8 = new Players("Biswakalyan Rath", 30, 0 , Arrays.asList());
		Players player9 = new Players("Amruta Mokal", 26, 1998 , Arrays.asList("IM"));
		Players player10 = new Players("Soumya Swaminathan", 26, 2478 , Arrays.asList("WGM","IM","FM"));
		Players player11 = new Players("Kurshit Kukreja", 27, 2314 , Arrays.asList());
		
		result.add(player1);
		result.add(player2);
		result.add(player3);
		result.add(player4);
		result.add(player5);
		result.add(player6);
		result.add(player7);
		result.add(player8);
		result.add(player9);
		result.add(player10);
		result.add(player11);
		
		return result;
		
	}
	

}
