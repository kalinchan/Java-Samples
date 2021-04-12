package ejb.transactions;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class UserDetailBean implements UserDetailBeanRemote {

	/*Transaction Attributes
	 * 
	 * REQUIRED − Indicates that business method has to be executed within
	 * transaction, otherwise a new transaction will be started for that method.
	 * 
	 * REQUIRES_NEW − Indicates that a new transaction, is to be started for the
	 * business method.
	 * 
	 * SUPPORTS − Indicates that business method will execute as part of
	 * transaction.
	 * 
	 * NOT_SUPPORTED − Indicates that business method should not be executed as part
	 * of transaction.
	 * 
	 * MANDATORY − Indicates that business method will execute as part of
	 * transaction, otherwise exception will be thrown.
	 * 
	 * NEVER − Indicates if business method executes as part of transaction, then an
	 * exception will be thrown.
	 * 
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void createUserDetail() {

	}
}
