package bordeauxjug.guava3checkparam;

import com.google.common.base.Preconditions;

/**
 *
 * @since 1.0
 * @author lforet
 */
public class ServiceCheckedByGuava implements ServiceChecked{

    @Override
    public void doOperation(Object ob, int times) {
        Preconditions.checkNotNull(ob, "ob ne peut être null");
        Preconditions.checkArgument((times < 0), "%s times ne peut être négatif", times);
    }

}
