package bz.sty.brra.xml.file.processors.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * The stupid ZipInputStream puts all files in one stream(instead of stream per file), but Jaxb closes after every file.
 * So now I have to create an "uncloaseable" stream, which does not close.
 *
 * @see UncloaseableInputStreamProxy#close()
 * @author Mihail Stoynov
 */
public class UncloaseableInputStreamProxy extends InputStream {
    private InputStream inner;

    public UncloaseableInputStreamProxy(InputStream inner) {
        this.inner = inner;
    }

    @Override
    public int read() throws IOException {
        return inner.read();
    }

    @Override
    public int read(byte[] b) throws IOException {
        return inner.read(b);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        return inner.read(b, off, len);
    }

    @Override
    public long skip(long n) throws IOException {
        return inner.skip(n);
    }

    @Override
    public int available() throws IOException {
        return inner.available();
    }

    @Override
    public synchronized void mark(int readlimit) {
        inner.mark(readlimit);
    }

    @Override
    public synchronized void reset() throws IOException {
        inner.reset();
    }

    @Override
    public boolean markSupported() {
        return inner.markSupported();
    }

    @Override
    public void close() throws IOException {
//        DO NOTHING
    }
}
