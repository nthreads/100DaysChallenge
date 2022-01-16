import java.util.ArrayList;
import java.util.List;

public class StringMatching {
    // https://leetcode.com/problems/string-matching-in-an-array/
    public List<String> stringMatching(String[] words) {
        List<String> results = new ArrayList<>();
        
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if(i != j && words[i].contains(words[j]) && !results.contains(words[j])) {
                    results.add(words[j]);
                }
            }
        }
        
        return results;
    }
}
