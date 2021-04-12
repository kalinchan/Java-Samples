package ejb.transactions;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.naming.directory.InvalidAttributesException;
import javax.transaction.UserTransaction;

@Stateless
@TransactionManagement(value = TransactionManagementType.BEAN)
public class AccountBean implements AccountBeanLocal {

	// Bean Managed Transaction - In this type, the developer manages the life cycle
	// of transaction states.

	@Resource
	private UserTransaction userTransaction;

	@Override
	public void transferFund(String account, double fund, String toAccount) throws Exception {
		try {

			userTransaction.begin();
			confirmAccountDetail(account);
			withdrawAmount();
			confirmAccountDetail(toAccount);
			depositAmount();
			userTransaction.commit();
		} catch (InvalidAttributesException e) {
			userTransaction.rollback();
		} catch (NumberFormatException e) {
			userTransaction.rollback();
		} catch (Exception e) {
			userTransaction.rollback();
		}

	}

	private void confirmAccountDetail(String account) throws InvalidAttributesException {
	}

	private void withdrawAmount() throws NumberFormatException {
	}

	private void depositAmount() throws Exception {
	}
}
