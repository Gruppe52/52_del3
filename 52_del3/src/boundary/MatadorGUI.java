
/**
 * MatadorGUI fra 06_CDIO_del1_Full_2014_v2
 * Håndterer kald til GUI.jar
 */

package boundary;

import desktop_resources.GUI;
import entity.PlayerList;
import entity.Player;

public class MatadorGUI {

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

}
