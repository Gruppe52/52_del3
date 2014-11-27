package test;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;

import entity.PlayerList;

public class DoAllPlayersGetTurn {
	private int numberOfPlayers = 6;
	private PlayerList playerList = new PlayerList(numberOfPlayers);
	private Random random = new Random();
	private int alivePlayers = 2;
	
	@Test
	public void test() {
		//Preconditions
		
		//Make sure we have an array of mixed dead and alive players
		
		//Makes all players dead
		for (int i = 0; i < (playerList.getPlayers().length); i++) {
			playerList.getPlayer(i).setDeath(true);
		}
		
		

		//Give designated players life
		int x = 0;
		while(x <= alivePlayers) {
			playerList.getPlayer(random.nextInt(playerList.getPlayers().length+1)).setDeath(false);
			x = x + 1;
			System.out.println(x);
		}
		System.out.println(x);
		
		//Make sure players are alive		
		int y = 0;
		for (int i = 0; i < playerList.getPlayers().length; i++) {
			if(playerList.getPlayer(i).getDeath() == false) {
				y++;
			}
		}
		assertEquals(alivePlayers,y);
		
		
		
		
		
		
	}

}
