class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int[] M;
    int N;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        N = nums.length;
        M = nums;
        dfs(0, new ArrayList<>());

        return answer;
    }

    public void dfs(int depth, List<Integer> cur){
        if (depth == N){
            answer.add(new ArrayList<>(cur));
            return;
        }

        cur.add(M[depth]);
        dfs(depth+1, cur);
        cur.remove(cur.size()-1);

        int next = depth + 1;
        while(next < N && M[next] == M[depth]){
            next++;
        }

        dfs(next, cur);
    }
}
