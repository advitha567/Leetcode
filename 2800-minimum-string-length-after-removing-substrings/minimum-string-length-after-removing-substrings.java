class Solution {
    public int minLength(String s) {
        char arr[] = s.toCharArray();
        int n = arr.length;
        int index = -1;
        for(int i = 0; i < n; i++) {
            char ch = arr[i];
            if(index == -1) {
                index++;
                arr[index] = ch;
            }
            else if(ch == 'B' && arr[index] == 'A') index--;
            else if(ch == 'D' && arr[index] == 'C') index--;
            else {
                index++;
                arr[index] = ch;
            }
        }
        return index + 1;
    }
}