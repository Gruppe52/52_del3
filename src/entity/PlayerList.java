/**
 * PlayerList indeholder et array med 2-6 players, som bliver brugt i spillet når players tager tur
 * Er flittigt lånt fra 06_CDIO_del1_Full_2014_v2, med oversættelse til engelsk
 */
package entity;

import boundary.MatadorGUI;

public class PlayerList {
	private Player[] players;
	
	public PlayerList (int numberOfplayers ) {
		players = new Player[numberOfplayers];
		for (int i = 0;i < numberOfplayers;i++)
			players[i]=new Player();
	} 
	
//	public void addPlayer(int numberOfplayers){			//Det virker ikke efter hensigten denne funktion!!
//		String[] PlayerNames = {"Peter ","Lene  ","Jan   ","Tobias","Jytte ","Lone  "};
//		for (int i=0; i < numberOfplayers; i++){
//			players[i].setName(PlayerNames[i]);
//			players[i].setColor(i);
//		}	
//	}	

	public Player[] getPlayers(){
		return players;
	}

	public Player getPlayer(int index){
		return players[index];
	}
	
	public void setWinningPlayer() {
		int x = 0;
		for (int i = 0; i < players.length; i++) {
			if (players[i].getDeath()) {
				x++;
			}
		}
		if ((players.length - x) == 1) {
			for (int i = 0; i < players.length; i++) {
				if(!players[i].getDeath()) {
					players[i].setHasWon(true);
				}
			}
		}
	}
	/**
	 * Finds the player object that has won in the playerList.
	 * @return
	 */
	public Player getWinningPlayer() {
		Player winningPlayer = new Player();
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].getName());
			if(players[i].getHasWon()) {
				winningPlayer = players[i];
			}
		}
		return winningPlayer;
	}
	
	public boolean isWinner(){
		for (int i=0;i<players.length;i++){
			if (players[i].isWinner())
				return true;
		}		
		return false;
	}

	public int nextPlayer(int index){
		index = ++index % players.length;
		return index;
	}
	
	public String toString() {
		String playersInfo = "";
		for (int i = 0; i < players.length; i++) {
			playersInfo = getPlayer(i).toString();
		}
		return playersInfo;
	}
	/**
	 * Checks if a player is dead according to game rules
	 * @param matadorGUI
	 */
	public void checkIfPlayerIsDead(MatadorGUI matadorGUI) {
		for (int i = 0; i < players.length; i++) {
			if(players[i].getBalance() <= 0) {
				players[i].setDeath(true);
				matadorGUI.playerDied(players[i]);
			}
		}		
	}
}