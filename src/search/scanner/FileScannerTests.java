package search.scanner;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class FileScannerTests {
    public static void main(String[] args) throws IOException {
        FileScanner fileScanner = new RecursiveFileScanner();

        Collection<File> files = fileScanner.scan(new File("./src/files"));

        for (File file : files) {
            System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
        }
    }
}
