package bordeauxjug.guava2io;

import com.google.common.io.ByteStreams;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author lfo
 */
public class IOUtilGuava implements IOUtil {

    @Override
    public void copy(InputStream input, OutputStream output) throws IOException {
        ByteStreams.copy(input, output);
    }

}
