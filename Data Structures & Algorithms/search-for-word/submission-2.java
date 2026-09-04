class Solution {
    boolean[][] visited;
    char[][] map;
    int N;
    int M;
    boolean answer;

    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public boolean exist(char[][] board, String word) {
        N = board.length;
        M = board[0].length;
        visited = new boolean[N][M];
        map = board;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if (map[i][j] == word.charAt(0)) {
                    visited[i][j] = true;

                    dfs(1, i, j, word);

                    visited[i][j] = false;
                }
            }
        }
        return answer;
    }

    public void dfs(int depth, int x, int y, String word){
        
        if(depth == word.length()){
           answer = true;
           return;
        }
        
        for(int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if(curX < 0 || curY < 0 || curX >= N || curY >= M){
                continue;
            }

            if(visited[curX][curY]){
                continue;
            }

            if(map[curX][curY] != word.charAt(depth)){
                continue;
            }   

            visited[curX][curY] = true;
            dfs(depth+1, curX, curY, word);
            visited[curX][curY] = false;
        }

    }
}
