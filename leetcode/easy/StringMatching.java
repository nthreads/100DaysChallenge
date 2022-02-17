import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringMatching {
    // https://leetcode.com/problems/string-matching-in-an-array/

    // O(mn2), m: max length of a word, n: input array length
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

    public List<String> stringMatchingWithMemo(String[] words) {
        HashSet answerSet = new HashSet();
        for(int i = 0; i < words.length - 1; i++) {
            for(int j = i + 1; j < words.length; j++) {
                if(words[i].contains(words[j])) {
                    answerSet.add(words[j]);
                } else if(words[j].contains(words[i])) {
                    answerSet.add(words[i]);
                }
            }
        }
        List<String> answerList = new ArrayList<String>(answerSet);
        return answerList;
    }
}
