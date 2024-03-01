package search;

import search.read.FileContentReader;
import search.read.ScannerContentReader;
import search.scanner.FileScanner;
import search.scanner.RecursiveFileScanner;
import search.search.ContentSearcher;
import search.search.PrimitiveContentSearcher;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SearchEngine {
    public void searchAndPrintResults(File input, String search) {
        Collection<File> result = search(input, search);

        if (result.isEmpty()) {
            System.out.println("No files found");
        } else {
            System.out.println("Files found: " + result.size());

            for (File file : result) {
                try {
                    System.out.println("file.getCanonicalPath() = " + file.getCanonicalPath());
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }

    public Collection<File> search(File input, String search) {
        List<File> result = new ArrayList<>();

        FileScanner fileScanner = new RecursiveFileScanner();
        FileContentReader fileContentReader = new ScannerContentReader();
        ContentSearcher contentSearcher = new PrimitiveContentSearcher();

        Collection<File> files = fileScanner.scan(input);
        for (File file : files) {
            String content = fileContentReader.read(file);

            if (contentSearcher.search(content, search)) {
                result.add(file);
            }
        }

        return result;
    }
}
