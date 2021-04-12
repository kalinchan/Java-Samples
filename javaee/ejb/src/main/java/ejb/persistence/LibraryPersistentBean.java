package ejb.persistence;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.jboss.logging.Logger;

@Stateless
public class LibraryPersistentBean implements LibraryPersistentBeanRemote {

	private static Logger LOGGER = Logger.getLogger(LibraryPersistentBean.class.getName());
	public LibraryPersistentBean() {
	}

	// pass persistence unit to entityManager.
	@PersistenceContext(unitName = "EJBComponentPU")
	private EntityManager entityManager;

	public void addBook(Book book) {
		entityManager.persist(book);
	}

	public List<Book> getBooks() {
		return entityManager.createQuery("From Book b", Book.class).getResultList();
	}

	/*-
	 * Callback annotations for stateless bean
	 * @PostConstruct 	Invoked when a bean is created for the first time.
	 * @PreDestroy 	Invoked when a bean is removed from the bean pool or is destroyed.
	 */
	@PostConstruct
	public void postConstruct() {
		LOGGER.info(
				"postConstruct:: LibraryPersistentBean session bean" + " created with entity Manager object: ");
	}

	@PreDestroy
	public void preDestroy() {
		LOGGER.info("preDestroy: LibraryPersistentBean session" + " bean is removed ");
	}
}
