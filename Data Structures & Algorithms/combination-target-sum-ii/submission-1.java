class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    int N;
    int[] arr;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        N = target;
        arr = candidates;
        dfs(0,0,new ArrayList<>());
        return answer;
    }

    public void dfs(int start, int sum, List<Integer> cur){
        if(sum == N){
            answer.add(new ArrayList<>(cur));
            return;
        }

        for(int i = start; i < arr.length; i++){
            if(sum > N){
                break;
            }
            if(i > start && arr[i] == arr[i-1]){
                continue;
            } //같은 depth의 같은 숫자는 한 번만 선택
            cur.add(arr[i]);
            dfs(i+1, sum+arr[i], cur);
            cur.remove(cur.size()-1);
        }
    }
}

//candiateds : 정수 배열 (중복 정수 포함)
//target : 정수
//canidates에서 선택 -> 합이 target 되는 모든 고유한 조합
//각 원소는 최대 한번만 사용 가능(사용안하거나 사용하거나)
//중복된 조합 포함 X 