class Solution {
    public int partitionString(String s) {
        Set<Character> ch = new HashSet<>();
        int r=0;
        int count = 0;
        while(r < s.length()){
          if(ch.contains(s.charAt(r))){
            count = count + 1;
            System.out.println(ch);
            ch.clear();
          }
          ch.add(s.charAt(r));
          r = r+1;
        }
        if(!ch.isEmpty()){
          count = count + 1;
        }
        return count;
    }
}