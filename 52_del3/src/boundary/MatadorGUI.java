/**
 * MatadorGUI fra 06_CDIO_del1_Full_2014_v2
 * Håndterer kald til GUI.jar
 */

package boundary;

import desktop_resources.GUI;
import entity.Player;

public class MatadorGUI {

	public void spilstarter(){
		GUI.showMessage(String.format(Tekster.tekster[0]));
	}

	public void startInfo(Player [] p){
		for (int i=0; i<p.length;i++){	
			GUI.addPlayer(p[i].getName(),p[i].getBalance());
		}
	}

	public void venterPaaSlag(int pNr){
		GUI.showMessage(String.format(Tekster.tekster[2], pNr+1));
	}

	public void visSlag(int[] terninger){
		GUI.setDice(terninger[0], terninger[1]);
	}

	public void visSpilStatus (Player [] p){
		for(int j = 0; j < p.length; j++){		
			GUI.removeAllCars(p[j].getName());
			GUI.setCar(p[j].getBalance()+1, p[j].getName());
			GUI.setBalance(p[j].getName(), p[j].getBalance());
		}
	}

	public void visSlaaIgen(int pNr){
		GUI.showMessage(String.format(Tekster.tekster[6], pNr+1));
	}

	public void visSlutInfo(int pNr,Player [] p){
		GUI.setBalance(p[pNr].getName(), p[pNr].getBalance());
		GUI.showMessage(String.format(Tekster.tekster[7], p[pNr].getName()));
		for(int j = 0; j < p.length; j++){
			GUI.removeAllCars(p[j].getName());
			GUI.setCar(1, p[j].getName());

		}
	}	
}
