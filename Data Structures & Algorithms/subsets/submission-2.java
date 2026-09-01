class Solution {
    int[] num;
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        num = nums;
        dfs(0, new ArrayList<>());
        return answer;
    }

    public void dfs(int depth, List<Integer> cur){
        if(depth == num.length){
            answer.add(new ArrayList<>(cur));
            return;
        }

        cur.add(num[depth]);
        dfs(depth + 1, cur);

        cur.remove(cur.size()-1);
        dfs(depth + 1, cur);

    }
}
