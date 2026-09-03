class Solution {
    boolean[][] visited;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    char[][] map;
    int N, M;
    int count = 0;

    public int numIslands(char[][] grid) {
        N = grid.length;
        M = grid[0].length;
        map = grid;
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == '1'){
                    bfs(i,j);
                    count++;
                }
            }
        }

        return count;
    }

    public void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        visited[x][y] = true;
        q.offer(new int[] {x,y});

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cX = cur[0];
            int cY = cur[1];

            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];

                if(nX < 0 || nY < 0 || nX >= N || nY >= M){
                    continue;
                }

                if(visited[nX][nY] || map[nX][nY] == '0'){
                    continue;
                }

                q.offer(new int[] {nX,nY});
                visited[nX][nY] = true;
            }
        }
    }
}

// 1은 땅, 0은 물 , 섬 개수 반환