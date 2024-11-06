class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(res,path,candidates, target, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> path, int[] candidates, int target, int start){
      if(target < 0){
        return;
      }
      else if(target == 0){
        res.add(new ArrayList<>(path));
        return;
      }
      else{
        for(int i =start; i< candidates.length; i++){
          path.add(candidates[i]);
          dfs(res, path, candidates, target-candidates[i], i);
          path.remove(path.size()-1);
        }
      }
    }
}