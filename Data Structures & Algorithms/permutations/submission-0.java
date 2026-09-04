class Solution {
    int[] M;
    int N;
    List<List<Integer>> answer;
    boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        N = nums.length;
        M = nums;
        visited = new boolean[N];
        answer = new ArrayList<>();
        dfs(0, new ArrayList<>());
        return answer;
    }

    public void dfs(int depth, List<Integer> cur){
        if(depth == N){
            answer.add(new ArrayList<>(cur));
        }

        for(int i = 0; i < N; i++){
            if(visited[i]){
                continue;
            }

            visited[i] = true;
            cur.add(M[i]);

            dfs(depth + 1, cur);

            visited[i] = false;
            cur.remove(cur.size()-1);
        }
    }
}
