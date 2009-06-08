package org.bordeauxjug.persistence;


public class PersistenceManager<E> {

    public E findByPrimaryKey(long id) {
        return null;
    }

    public void makePersistent(E entity) {
        System.out.println(String.format("%s has been stored.", entity));
    }

    public void delete(E entity) {
        System.out.println(String.format("%s has been deleted.", entity));
    }
}
