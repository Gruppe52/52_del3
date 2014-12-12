
/**
 * MatadorGUI fra 06_CDIO_del1_Full_2014_v2
 * Håndterer kald til GUI.jar
 */

package boundary;


import entity.PlayerList;
import entity.Player;
import boundaryToMatador.GUI;

public class MatadorGUI {
	
	/** fields FILE */
	public void gameStarter(){
		GUI.showMessage(String.format(Texts.texts[0]));
	}

	public void startInfo(Player [] p){
		for (int i=0; i<p.length;i++){	
			GUI.addPlayer(p[i].getName(),p[i].getBalance());
		}
	}

	public void waitingForPlayer(int pNr){
		GUI.showMessage(String.format(Texts.texts[2], pNr+1));
	}

	public void showDice(int[] terninger){
		GUI.setDice(terninger[0], terninger[1]);
	}

	public void showGameStatus (Player [] p){
		for(int j = 0; j < p.length; j++){		
			GUI.removeAllCars(p[j].getName());
			GUI.setCar(p[j].getBalance()+1, p[j].getName());
			GUI.setBalance(p[j].getName(), p[j].getBalance());
		}
	}

	public void showExtraTurn(int pNr){
		GUI.showMessage(String.format(Texts.texts[6], pNr+1));
	}

	public void showEndGameInfo(int pNr,Player [] p){
		GUI.setBalance(p[pNr].getName(), p[pNr].getBalance());
		GUI.showMessage(String.format(Texts.texts[7], p[pNr].getName()));
		for(int j = 0; j < p.length; j++){
			GUI.removeAllCars(p[j].getName());
			GUI.setCar(1, p[j].getName());

		}
	}	
	public void addPlayers(int pNr, PlayerList p) {
		for (int i = 0; i < p.getPlayers().length; i++) {
			GUI.addPlayer(p.getPlayer(i).getName(), p.getPlayer(i).getBalance());
		}

	}
	public void askForNumberOfPlayers() {
		GUI.showMessage(Texts.texts[7]);
	}

	public void createBoard() {
		GUI.create("fields.txt");
	}

	public int getNumberOfPlayers() {
		int numberOfPlayers;
		numberOfPlayers = GUI.getUserInteger(Texts.texts[8]);
		return numberOfPlayers;
	}

	public void askForPlayerNames(PlayerList playerList) {
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			String name = GUI.getUserString(Texts.texts[9] + (i + 1)); //Receives playerName from GUI
			playerList.getPlayer(i).setName(name); //Sets playerName received from GUI
			}		
	}
	public void awaitDiceThrow(Player player) {
		GUI.getUserButtonPressed(player.getName() + Texts.texts[11], "ROLLING");
	}
	public void setDices(int[] faceValues) {
		GUI.setDice(faceValues[0], faceValues[1]);		
	}

	public void setCars(PlayerList playerList) {
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			GUI.setCar(1, playerList.getPlayer(i).getName());	
		}
			
	}
	/**
	 * This function moves the car around the board
	 * Uses players totalDiceSum attribute to keep track of movement
	 * @param player player entity to move car, and set diceTotalSum so he moves in circles on board
	 */
	public void moveCar(Player player) {
		GUI.removeAllCars(player.getName()); 	//Removing cars from this specific player, or we are going to have multiple cars on the board
		GUI.setCar(player.getCarField(), player.getName());	//Sets the new car based on the throw		
	}
	public boolean askIfPlayerWantsToBuyTerritory() {
		boolean x = GUI.getUserLeftButtonPressed(Texts.texts[12], "Ja", "Nej");
		return x;
	}

	public void playerCantAfford() {
		GUI.showMessage(Texts.texts[13]);
		
	}

	public void updateMoney(PlayerList playerList) {
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			GUI.setBalance(playerList.getPlayer(i).getName(), playerList.getPlayer(i).getBalance());
		}		
	}

	public void landedOnTaxField(Player player, int taxAmount) {
		GUI.showMessage(Texts.texts[14] + taxAmount);
		
	}

	public void playerPaysRent(Player player, Player owner, int rent) {
		GUI.showMessage(player.getName() + Texts.texts[15] + owner.getName() + Texts.texts[16] + rent );
		
	}

	public void playerDied(Player deadPlayer) {
		GUI.showMessage(deadPlayer.getName() + Texts.texts[17]);
		
	}

	public void playerWon(Player winningPlayer) {
		GUI.showMessage(winningPlayer.getName() + Texts.texts[18]);
	}
	
}
