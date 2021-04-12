package ejb.transactions;

import javax.ejb.Remote;

@Remote
public interface UserDetailBeanRemote {
	void createUserDetail();
}
