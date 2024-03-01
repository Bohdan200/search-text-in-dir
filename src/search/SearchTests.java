package search;

import java.io.File;

public class SearchTests {
    public static void main(String[] args) {
        File foundDir = new File("./src/files");
        new SearchEngine().searchAndPrintResults(
                foundDir,
                "in file root"
        );
    }
}
