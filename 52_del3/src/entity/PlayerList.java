/**
 * PlayerList indeholder et array med 2-6 Players, som bliver brugt i spillet når Players tager tur
 * Er flittigt lånt fra 06_CDIO_del1_Full_2014_v2, med oversættelse til engelsk
 */
package entity;

public class PlayerList {
	private Player[] Players;
	
	public PlayerList (int numberOfPlayers ) {
		Players = new Player[numberOfPlayers];
		for (int i = 0;i < numberOfPlayers;i++)
			Players[i]=new Player();
	} 
	
	public void addPlayer(int numberOfPlayers){			//Det virker ikke efter hensigten denne funktion!!
		String[] PlayerNames = {"Peter ","Lene  ","Jan   ","Tobias","Jytte ","Lone  "};
		for (int i=0; i < numberOfPlayers; i++){
			Players[i].setName(PlayerNames[i]);
			Players[i].setColor(i);
		}	
	}	

	public Player[] getPlayers(){
		return Players;
	}

	public Player getPlayer(int index){
		return Players[index];
	}
	
	public boolean isWinner(){
		for (int i=0;i<Players.length;i++){
			if (Players[i].isWinner())
				return true;
		}		
		return false;
	}

	public int nextPlayer(int index){
		index = ++index % Players.length;
		return index;
	}
}