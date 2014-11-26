/**
 * Player klassen, indeholder spillerens navn og Account klassen
 * @author 52
 *
 */
package entity;

public class Player extends Account {
	private String playerName;		//Spiller navn
	private boolean isDead = false; //Variable for if player has lost all money
	private int totalDiceSum;
	private int carField;
	private boolean hasWon = false;
	/** 
	 * @return Returnerer spillerens navn
	 */
	public String getName() {
		return playerName;
	}

	public boolean isWinner() {

		return false;
	}
	
	public void setHasWon(boolean condition) {
		hasWon = condition;
	}
	
	public boolean getHasWon() {
		return hasWon;
	}

	public void setName(String name) {
		playerName = name;		
	}

	public void setColor(int i) {		
	}

	public int getTotalDiceSum() {
		return totalDiceSum;
	}
	/**
	 * Sets the total dice sum for each player, used for moving them in circles around the board
	 * @param i current dice throw sum
	 */
	public void addTotalDiceSum(int i) {
		if((i + totalDiceSum) > 22) {
			totalDiceSum = ((totalDiceSum + i) % 22);
			if (totalDiceSum == 0) {
				totalDiceSum += 1;
			}
		} else {
		totalDiceSum += i;
		}
	}

	public void setCarField(int diceSum) {
		carField = diceSum;		
	}

	public int getCarField() {
		return carField;
	}

	public void setDeath(boolean i) {
		isDead = i;		
	}

	public boolean getDeath() {
		return isDead;
	}
	
	public String toString() {
		String name;
		String death;
		String totalDiceSumStr;
		String carFieldStr;
		String info;
		name = "Name :" + playerName + " ";
		death = "Dead: " + isDead + " ";
		totalDiceSumStr = "DiceSum :" + totalDiceSum + " ";
		carFieldStr = "Car field: " + carField + " ";
		info = name + death + totalDiceSumStr + carFieldStr;
		return info + super.toString();
	}



	



	
}


