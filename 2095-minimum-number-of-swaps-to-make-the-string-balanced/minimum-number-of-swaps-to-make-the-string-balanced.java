class Solution {
    public int minSwaps(String s) {
      List<Character> al = new ArrayList<>();
      for(int i=0; i< s.length(); i++){
        if(s.charAt(i) == ']' && !al.isEmpty() &&  al.get(al.size()-1) == '['){
          al.remove(al.size()-1);
        }
        else{
          al.add(s.charAt(i));
        }
      }
      return ((al.size()/2)+1) / 2;
      
    }
}