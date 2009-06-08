package org.bordeauxjug.business;

import org.bordeauxjug.persistence.PersistenceManager;

public class BookStore {

    private PersistenceManager<Book> persistenceManager = new PersistenceManager<Book>();

    public void store(Book book) {
        persistenceManager.makePersistent(book);
    }

}
