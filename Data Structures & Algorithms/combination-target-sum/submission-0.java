class Solution {
    int N;
    int[] M;
    List<List<Integer>> answer;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        N = target;
        M = nums;
        answer = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0,0,new ArrayList<>());
        return answer;
    }

    public void dfs(int sum, int start, List<Integer> cur){
        if(sum == N){
            answer.add(new ArrayList<>(cur)); // 새로 생성
            return;
        }

        for(int i = start; i < M.length; i++){
            if (sum > N) {
                return;
            }
            cur.add(M[i]);
            dfs(sum + M[i], i, cur);
            cur.remove(cur.size() - 1);
        }

    }
}

// 중복 사용 가능
// nums -> 중복되지 않은 정수 모음
// 1+1+1
// 1+2
// 조합이 안되면 빈리스트 반환
// nums를 sort
// 작은 인덱스 부터 중복되게 더함