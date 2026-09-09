class Solution {
    int N;
    List<String> list;
    
    public String longestPalindrome(String s) {
        N = s.length();
        list = new ArrayList<>();
        calc1(s);
        calc2(s);

        Collections.sort(list,(a,b) -> b.length() - a.length());
        return list.get(0);
    }

    public void calc1(String s){
        for(int i = 0; i < N; i++){
            int left = i;
            int right = i;

            while(left >= 0 && right < N){
                
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }

                list.add(s.substring(left,right+1));
                
                left--;
                right++;   
            }
        }
    }

    public void calc2(String s){
        for(int i = 0; i < N; i++){
            int left = i;
            int right = i + 1;
            
            while(left >= 0 && right < N){
                if(s.charAt(left) != s.charAt(right)){
                    break;
                }

                list.add(s.substring(left,right+1));
                
                left--;
                right++;   
            }
        }
    }
}