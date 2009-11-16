package org.bordeauxjug.dojo.wombat.persistence;

import java.util.Collection;

/**
 *
 * @author laurent.foret
 */
public interface GenericDAO<P extends PersistentObject> {

    public void add(P po) throws PersistenceException;

    public void update(P po) throws PersistenceException;

    public void delete(P po) throws PersistenceException;

    public Collection<P> findBy(String query, String ... params);
}
