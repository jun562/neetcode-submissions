class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> dq = new ArrayDeque<>();

        for(int i = 0; i < temperatures.length; i++){            
            while(!dq.isEmpty()){
                int index = dq.peek();
                if(temperatures[index] < temperatures[i]){
                    dq.pop();
                    answer[index] = i - index;
                } else{
                    break;
                }
            }
            dq.push(i);
        }
        return answer;
    }        
}

// t[i] - > i 번째 날 온도
// result[i] - > i 번째 날 이후 더 따뜻한 날 까지의 일수
// 없으면 0
