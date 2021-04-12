package ejb.persistence;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface LibraryPersistentBeanRemote {
	
	void addBook(Book book);

	List<Book> getBooks();
}
