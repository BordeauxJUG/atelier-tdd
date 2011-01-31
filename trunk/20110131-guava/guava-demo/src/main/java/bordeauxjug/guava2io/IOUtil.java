package bordeauxjug.guava2io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @since 1.0
 * @author lforet
 */
public interface IOUtil {

     void copy(InputStream input, OutputStream output) throws IOException;
}
