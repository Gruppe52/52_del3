/**
 * Player klassen, indeholder spillerens navn og Account klassen
 * @author 52
 *
 */
package entity;

public class Player extends Account {
	String playerName;		//Spiller navn
	boolean isDead = false; //Variable for if player has lost all money
	
	/** 
	 * @return Returnerer spillerens navn
	 */
	public String getName() {
		return playerName;
	}

	public boolean isWinner() {

		return false;
	}

	public void setName(String name) {
		playerName = name;		
	}

	public void setColor(int i) {		
	}
	
}


