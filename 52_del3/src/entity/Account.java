
package entity;
/**
 * Account klassen indeholder beholdning, bliver brugt inde i Player klassen
 * @author 52
 *
 */

public class Account {
	int money = 30000;
	
	/**
	 * getBalance
	 * @return en moneybalance
	 */
	public int getBalance() {
		return money;
	}
	public void withdraw(int amount) {
		money -= amount;
	}
	
	public void deposit(int amount) {
		money = money + amount;
		
	}
	
	public void setBalance(int amount) {
		money = amount;
	}
	
	public void transfer(int amount, Player receiver) {
		money = money - amount;
		receiver.deposit(amount);
	}

}
