class Solution {
    public boolean isCircularSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return false;
        }
        
        if (sentence.charAt(0) != sentence.charAt(sentence.length() - 1)) {
            return false;
        }
        
        String[] words = sentence.split(" ");
        
        for (int i = 1; i < words.length; i++) {
            if (words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
                return false;
            }
        }
        
        return true;
    }
}
