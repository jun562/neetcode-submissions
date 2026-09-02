class Solution {
    public boolean isValid(String s) {
        Deque<Character> dq = new ArrayDeque<>();
        char[] cs = s.toCharArray();
        boolean answer = true;

        for(char c : cs){
            if(c=='(' || c =='{' || c=='['){
                dq.push(c);
            } else {
                if (dq.isEmpty()) {
                    return false;
                }
                if(c==')' && dq.peek() == '('){
                    dq.pop();
                } else if (c=='}' && dq.peek() == '{'){
                    dq.pop();
                } else if (c==']' && dq.peek() == '['){
                    dq.pop();
                } else {
                    return false;
                }
            }
        }

        if(!dq.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
