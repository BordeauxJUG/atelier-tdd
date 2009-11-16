package org.bordeauxjug.dojo.wombat;

/**
 *
 * @author laurent.foret
 */
public class WombatException extends Exception {

    public WombatException(Throwable cause) {
        super(cause);
    }

    public WombatException(String message, Throwable cause) {
        super(message, cause);
    }

    public WombatException(String message) {
        super(message);
    }

    public WombatException() {
    }

}
