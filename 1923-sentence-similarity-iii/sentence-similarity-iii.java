class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] s1 = sentence1.split(" ");
        String[] s2 = sentence2.split(" ");
        if (s2.length < s1.length) {
            return areSentencesSimilar(sentence2, sentence1);
        }

        int i = 0, j = 0;
        while (i < s1.length && s1[i].equals(s2[i])) {
            i++;
        }
        while (j < s1.length && s1[s1.length - 1 - j].equals(s2[s2.length - 1 - j])) {
            j++;
        }

        return i + j >= s1.length;
    }
}
