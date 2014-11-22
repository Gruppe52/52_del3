/**
 * KeyboardMatadorGUI håndterer keyboard input til GUI.jar
 */
package boundary;

import boundaryToMatador.GUI;

public class KeyboardMatadorGUI {

	public void waitForInt(int ind){
		int temp;
		do {
			temp = GUI.getUserInteger("");
		}while (!(ind==temp)); 	
	}

	public void waitForEnter(){
		GUI.getUserButtonPressed("", "ENTER");
	}
}
