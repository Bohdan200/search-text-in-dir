package search.scanner;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RecursiveFileScanner implements FileScanner {
    @Override
    public Collection<File> scan(File base) {
        List<File> result = new ArrayList<>();

        recursiveScan(base, result);

        return result;
    }

    private void recursiveScan(File directory, Collection<File> storage) {
        for (File child : directory.listFiles()) {
            if (child.isDirectory()) {
                recursiveScan(child, storage);
            } else {
                storage.add(child);
            }
        }
    }
}
