public class ReorderSpaces {
    // https://leetcode.com/problems/rearrange-spaces-between-words/
    // 1592. Rearrange Spaces Between Words

    /*
    Example 1:
        Input: text = "  this   is  a sentence "
        Output: "this   is   a   sentence"
        Explanation: There are a total of 9 spaces and 4 words.
        We can evenly divide the 9 spaces between the words: 9 / (4-1) = 3 spaces.
     */

    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int wCount = words.length;
        
        int totalSpaces = (int) text.chars().filter(c -> c == ' ').count();
        int spacesDist = wCount <= 1 ? 0 : totalSpaces / (wCount - 1);     
        int trailingSpaces = totalSpaces - spacesDist * (wCount - 1);

        StringBuilder sb = new StringBuilder();
        for(int w = 0; w < wCount; w++) {
            sb.append(words[w]);
            if(w < wCount-1) {
                appendSpaces(sb, spacesDist);
            } else if (trailingSpaces > 0) {
                appendSpaces(sb, trailingSpaces);
            }
        }
        
        return sb.toString();
    }
    
    private void appendSpaces(StringBuilder sb, int count) {
        for(int i = 0; i < count; i++) {
            sb.append(" "); 
        }
    }
}
