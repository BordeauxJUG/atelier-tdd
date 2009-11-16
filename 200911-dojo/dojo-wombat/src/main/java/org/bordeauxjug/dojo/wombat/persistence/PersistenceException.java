package org.bordeauxjug.dojo.wombat.persistence;

import org.bordeauxjug.dojo.wombat.WombatException;

/**
 *
 * @author laurent.foret
 */
public class PersistenceException extends WombatException {

    public PersistenceException(Throwable cause) {
        super(cause);
    }

    public PersistenceException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistenceException(String message) {
        super(message);
    }

    public PersistenceException() {
    }



}
