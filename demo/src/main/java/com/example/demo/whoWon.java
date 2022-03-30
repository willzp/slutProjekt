package com.example.demo;

public class whoWon {

	gameBean gameBean = new gameBean();
	
	public String checkWhoWon(String userchoice, String computerchoice) {

		gameBean.setDraws(gameBean.getDraws()+1);

		if (computerchoice.equals("sten") && userchoice.equals("påse")) {
			gameBean.setWins(gameBean.getWins()+1);
			// gameBean.wins++;
			return "Du vann";
		}
		if (computerchoice.equals("sten") && userchoice.equals("sax")) {
			gameBean.setLosses(gameBean.getLosses()+1);
			return "Datorn vann";
		}
		if (computerchoice.equals("påse") && userchoice.equals("sax")) {
			gameBean.setWins(gameBean.getWins()+1);
			// gameBean.wins++;
			return "Du vann";
		}
		if (computerchoice.equals("påse") && userchoice.equals("sten")) {
			gameBean.setLosses(gameBean.getLosses()+1);
			return "Datorn vann";
		}
		if (computerchoice.equals("sax") && userchoice.equals("sten")) {
			gameBean.setWins(gameBean.getWins()+1);
			// gameBean.wins++;
			return "Du vann";
		}
		if (computerchoice.equals("sax") && userchoice.equals("påse")) {
			gameBean.setLosses(gameBean.getLosses()+1);
			return "Datorn vann";
		}

		gameBean.setDraws(gameBean.getDraws()+1);
		return "Det blev lika, testa igen";
	}

}
