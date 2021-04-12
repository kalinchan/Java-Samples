package ejb.callback;

import javax.persistence.PostLoad;
import javax.persistence.PostPersist;
import javax.persistence.PostRemove;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import javax.persistence.PreRemove;
import javax.persistence.PreUpdate;

import org.jboss.logging.Logger;

import ejb.persistence.Book;

public class BookCallbackListener {
	
	private static Logger LOGGER = Logger.getLogger(BookCallbackListener.class.getName());

	/*-
	 * Annotations for entity bean
	 * @PrePersist 	Invoked when an entity is created in database.
	 * @PostPersist 	Invoked after an entity is created in database.
	 * @PreRemove 	Invoked when an entity is deleted from the database.
	 * @PostRemove 	Invoked after an entity is deleted from the database.
	 * @PreUpdate 	Invoked before an entity is to be updated in the database.
	 * @PostLoad 	Invoked when a record is fetched from database and loaded into the entity.
	 */
	@PrePersist
	public void prePersist(Book book) {
		LOGGER.info("BookCallbackListener.prePersist:" + "Book to be created with book id: " + book.getId());
	}

	@PostPersist
	public void postPersist(Object book) {
		System.out
				.println("BookCallbackListener.postPersist::" + "Book created with book id: " + ((Book) book).getId());
	}

	@PreRemove
	public void preRemove(Book book) {
		LOGGER.info("BookCallbackListener.preRemove:" + " About to delete Book: " + book.getId());
	}

	@PostRemove
	public void postRemove(Book book) {
		LOGGER.info("BookCallbackListener.postRemove::" + " Deleted Book: " + book.getId());
	}

	@PreUpdate
	public void preUpdate(Book book) {
		LOGGER.info("BookCallbackListener.preUpdate::" + " About to update Book: " + book.getId());
	}

	@PostUpdate
	public void postUpdate(Book book) {
		LOGGER.info("BookCallbackListener.postUpdate::" + " Updated Book: " + book.getId());
	}

	@PostLoad
	public void postLoad(Book book) {
		LOGGER.info("BookCallbackListener.postLoad::" + " Loaded Book: " + book.getId());
	}
}
