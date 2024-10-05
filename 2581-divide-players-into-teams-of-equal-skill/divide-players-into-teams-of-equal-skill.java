class Solution {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum =0;
        long x=0;
        // x tho compare chestunnav. x tho kad ga chesedi
        for(int i =0; i< skill.length; i++){
          x = x + skill[i];
        }
        x = (x * 2) / skill.length;
        for(int i =0; i< skill.length/2; i++){
          if(x != skill[i] + skill[skill.length-i-1]){
            System.out.println(skill[i] * skill[skill.length-i-1]);
            return -1;
          }
          sum = sum + (skill[i] * skill[skill.length-i-1]);
        }
        return sum;
    }
}