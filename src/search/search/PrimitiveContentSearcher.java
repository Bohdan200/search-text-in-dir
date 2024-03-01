package search.search;

public class PrimitiveContentSearcher implements ContentSearcher {
    @Override
    public boolean search(String content, String search) {
        String[] words = search.toLowerCase().split(" ");

        for (String word : words) {
            if (!content.contains(word)) {
                return false;
            }
        }

        return true;
    }
}
