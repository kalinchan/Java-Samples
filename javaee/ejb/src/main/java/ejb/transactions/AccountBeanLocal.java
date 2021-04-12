package ejb.transactions;

import javax.ejb.Local;

@Local
public interface AccountBeanLocal {
	
	void transferFund(String account, double fund, String toAccount) throws Exception;
	
}
