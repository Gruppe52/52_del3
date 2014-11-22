
package entity;
/**
 * Account klassen indeholder pengebeholdning, bliver brugt inde i Player klassen
 * @author 52
 *
 */

public class Account {
	int penge = 30000;
	
	/**
	 * getBalance
	 * @return en pengebalance
	 */
	public int getBalance() {
		return penge;
	}

}
