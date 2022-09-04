//(c) A+ Computer Science
// www.apluscompsci.com
//Name -  

import java.util.Objects;
import java.util.Scanner;
import static java.lang.System.*;
import java.util.Random;

public class RockPaperScissors
{
	private String playChoice;
	private String compChoice;
	private String Winner;

	public RockPaperScissors()
	{
		playChoice = "";
		compChoice = "";
	}

	public RockPaperScissors(String player)
	{
		setPlayers(player);
	}

	public void setPlayers(String player)
	{
		playChoice = player;
	}

	public String determineWinner()
	{
		Random rand = new Random();
		int number = rand.nextInt(3);
		String winner= " ";
		switch (number) {
			case 0 -> compChoice = "R";
			case 1 -> compChoice = "P";
			case 2 -> compChoice = "S";
		}
		if (compChoice.equals("R")){
			if(playChoice.equals("R")){
				winner = "Draw";
			}
			else if(playChoice.equals("S")){
				winner = "Computer";
			}
			else{
				winner = "Player";
			}
		}
		if (compChoice.equals("P")){
			if(playChoice.equals("P")){
				winner = "Draw";
			}
			else if(playChoice.equals("R")){
				winner = "Computer";
			}
			else{
				winner = "Player";
			}
		}
		if (compChoice.equals("S")){
			if(playChoice.equals("S")){
				winner = "Draw";
			}
			else if(playChoice.equals("P")){
				winner = "Computer";
			}
			else{
				winner = "Player";
			}
		}
		Winner = winner;
		return winner;
	}

	public String toString()
	{
		String output=" ";
		if (compChoice.equals("R")){
			compChoice = "Rock";
		}
		else if (compChoice.equals("P")){
			compChoice = "Paper";
		}
		else{
			compChoice = "Scissors";
		}

		if (playChoice.equals("R")){
			playChoice = "Rock";
		}
		else if (playChoice.equals("P")){
			playChoice = "Paper";
		}
		else{
			playChoice = "Scissors";
		}

		if (Winner.equals("Player")){
			output = "!Player wins <<" + playChoice + " Covers " + compChoice + ">>";
		}
		else if (Winner.equals("Computer")){
			output =  "!Computer wins <<" + compChoice + " Covers " + playChoice + ">>";
		}
		else{
			output = "!Draw Game!";
		}
		return output;
	}
}