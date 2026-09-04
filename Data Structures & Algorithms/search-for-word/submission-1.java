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
                dfs(0,i,j,word);
            }
        }
        return answer;
    }

    public void dfs(int depth, int x, int y, String word){
        if(map[x][y] != word.charAt(depth)){
            return;
        }
        
        if(depth == word.length()-1){
           answer = true;
           return;
        }

        visited[x][y] = true;
        
        for(int i = 0; i < 4; i++){
            int curX = x + dx[i];
            int curY = y + dy[i];

            if(curX < 0 || curY < 0 || curX >= N || curY >= M){
                continue;
            }

            if(visited[curX][curY]){
                continue;
            }

            dfs(depth+1, curX, curY, word);
        }

        visited[x][y] = false;
    }
}
