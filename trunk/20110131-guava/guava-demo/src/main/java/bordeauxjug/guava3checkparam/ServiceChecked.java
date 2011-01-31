package bordeauxjug.guava3checkparam;

/**
 *
 * @since 1.0
 * @author lforet
 */
public interface ServiceChecked {

    /**
     * 
     * @param ob NE DOIT PAS ETRE NUL, lance une NPE sinon
     * @param times NE DOIT PAS être négatif
     */
    public void doOperation(Object ob, int times);

}
