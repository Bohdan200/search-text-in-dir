package search.read;

import java.io.File;

public class FileContentReaderTests {
    public static void main(String[] args) {
        FileContentReader contentReader = new ScannerContentReader();

        String content = contentReader.read(new File("./src/files/root.txt"));

        System.out.println("content = " + content);
    }
}
