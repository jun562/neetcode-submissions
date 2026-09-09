class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            List<Character> list = new ArrayList<>();
            Set<Character> set;
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    list.add(board[i][j]);
                }
            }

            set = new HashSet<>(list);
            if(list.size() != set.size()){
                return false;
            }
        }

        for(int i = 0; i < 9; i++){
            List<Character> list = new ArrayList<>();
            Set<Character> set;
            for(int j = 0; j < 9; j++){
                if(board[j][i] != '.'){
                    list.add(board[j][i]);
                }
            }

            set = new HashSet<>(list);
            if(list.size() != set.size()){
                return false;
            }
        }

        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                List<Character> list = new ArrayList<>();
                Set<Character> set;

                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.') {
                            list.add(board[i][j]);
                        }
                    }
                }
                set = new HashSet<>(list);
                if(list.size() != set.size()){
                    return false;
                }
            }
        }  
        return true;  
    }
}

//스도쿠 유효 true
//그렇지 않으면 false

// 보드가 모든 칸 안 채워져도 됌
// 현재 채워진 숫자들 한해 규칙 위반 X -> 유효로 간주