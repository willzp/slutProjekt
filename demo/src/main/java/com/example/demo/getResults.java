package com.example.demo;

public class getResults {
	gameBean gameBean = new gameBean();
	public String GetResults() {
		String pattern = "{ \"games\":\"%s\", \"wins\":\"%s\", \"losses\":\"%s\", \"ties\": \"%s\"}";
		return String.format(pattern, gameBean.getGameCount(), gameBean.getWins(), gameBean.getLosses(), gameBean.getDraws());
	}

}
