class Solution {
    public String compressedString(String word) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        int n = word.length();
        for(int i = 1; i < n; i ++){
          if(word.charAt(i) != word.charAt(i-1)){
            while(count>9){
              sb.append('9');
              sb.append(word.charAt(i-1));
              count = count - 9;
            }
            if(count != 0){
              sb.append(Integer.toString(count));
            }
            sb.append(word.charAt(i-1));
            count = 1;
          }
          else{
            count = count + 1;
          }
        }
        while(count>9){
          sb.append('9');
          sb.append(word.charAt(n-1));
          count = count - 9;
        }
        if(count != 0){
          sb.append(Integer.toString(count));
          sb.append(word.charAt(n-1));
        }
        // sb.append(Integer.toString(count));
        // sb.append(word.charAt(word.length()-1));
        return sb.toString();
    }
}