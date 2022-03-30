package com.example.demo;

public class game {

	computerChoice computerchoice = new computerChoice();

	whoWon whowon = new whoWon();

	public String Game(String move) {
		String computer = computerchoice.computerchoice();
		String result = whowon.checkWhoWon(move, computer);
		return "Ditt val = " + move + ", datorns val = " + computer + ". " + result;
	}

}
