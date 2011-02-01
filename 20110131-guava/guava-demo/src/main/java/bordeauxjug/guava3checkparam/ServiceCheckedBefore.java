package bordeauxjug.guava3checkparam;

/**
 *
 * @author lfo
 */
public class ServiceCheckedBefore implements ServiceChecked {

    @Override
    public void doOperation(Object ob, int times) {
        if (ob == null) {
            throw new NullPointerException("ob ne peut être null");
        }
        if (times < 0) {
            throw new IllegalArgumentException(times + " times ne peut être négatif");
        }
    }

}
