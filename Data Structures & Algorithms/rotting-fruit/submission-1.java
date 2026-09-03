class Solution {
    int N, M;
    int[][] dist;
    int[][] map;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};
    Queue<int[]> q = new ArrayDeque<>();

    public int orangesRotting(int[][] grid) {
        N = grid.length;
        M = grid[0].length;
        map = grid;
        dist = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }
        
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 2){
                    q.offer(new int[]{i,j});
                    dist[i][j] = 0;
                }
            }
        }
        bfs();
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(dist[i][j] == -1 && map[i][j] == 1){
                    return -1;
                }
                max = Math.max(max, dist[i][j]);
            } 
        }
        return max;
    }

    public void bfs(){
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0 ; i < 4; i ++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M){
                    continue;
                }

                if(dist[newX][newY] != -1 || map[newX][newY] == 0){
                    continue;
                }

                q.offer(new int[]{newX, newY});
                dist[newX][newY] = dist[curX][curY] + 1;
            }
        }
    }
}

//모든 신선한 과일을 썩게 만드는 것이 불가능 -> -1 return