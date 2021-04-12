package ejb.stateful;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateful;

import org.jboss.logging.Logger;

@Stateful
public class LibraryStatefulSessionBean implements LibraryStatefulSessionBeanRemote {

	private static Logger LOGGER = Logger.getLogger(LibraryStatefulSessionBean.class.getName());

	List<String> bookShelf;

	public LibraryStatefulSessionBean() {
		bookShelf = new ArrayList<String>();
	}

	public void addBook(String bookName) {
		bookShelf.add(bookName);
	}

	public List<String> getBooks() {
		return bookShelf;
	}

	/*-
	 * Callback annotations for Stateful bean
	 * @PostConstruct 	Invoked when a bean is created for the first time.
	 * @PreDestroy 	Invoked when a bean is removed from the bean pool or is destroyed.
	 * @PostActivate 	Invoked when a bean is loaded to be used.
	 * @PrePassivate 	Invoked when a bean is put back to bean pool.
	 */

	@PostConstruct
	public void postConstruct() {
		LOGGER.info("LibraryStatefulSessionBean.postConstruct::" + " bean created.");
	}

	@PreDestroy
	public void preDestroy() {
		LOGGER.info("LibraryStatefulSessionBean.preDestroy:" + " bean removed.");
	}

	@PostActivate
	public void postActivate() {
		LOGGER.info("LibraryStatefulSessionBean.postActivate:" + " bean activated.");
	}

	@PrePassivate
	public void prePassivate() {
		LOGGER.info("LibraryStatefulSessionBean.prePassivate:" + " bean passivated.");
	}
}
