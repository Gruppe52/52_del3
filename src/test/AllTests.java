package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestIfGameStopsWhenPlayerWon.class, TestIfPlayerCanDie.class,
		TestIfPlayerCanOwnTerritory.class, TestIfPlayerCanWin.class,
		TestIfPlayerLosesPropertyWhenDead.class,
		TestIfPlayerLosesTurnWhenDead.class, TestPlayersCanTransferMoney.class,
		TestPlayerWithdraw.class })
public class AllTests {

}
