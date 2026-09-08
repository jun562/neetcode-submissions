class Solution {
    int [][] map;
    boolean [][] visited;
    int N,M;
    int max = 0;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public int maxAreaOfIsland(int[][] grid) {
        map = grid;
        N = map.length;
        M = map[0].length;
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(!visited[i][j] && map[i][j] == 1){
                    bfs(i,j);
                }
            }
        }

        return max;
    }

    public void bfs(int x, int y){
        Queue<int[]> q = new ArrayDeque<>();
        int count = 0;
        q.offer(new int[]{x,y});
        visited[x][y] = true;
        count++;

        while(!q.isEmpty()){
            int[] cur = q.poll();

            int curX = cur[0];
            int curY = cur[1];

            for(int i = 0; i < 4; i++){
                int newX = curX + dx[i];
                int newY = curY + dy[i];

                if(newX < 0 || newY < 0 || newX >= N || newY >= M){
                    continue;
                }

                if(visited[newX][newY] || map[newX][newY] == 0){
                    continue;
                }

                q.offer(new int[] {newX, newY});
                visited[newX][newY] = true;
                count++;
            }
        }

        max = Math.max(max, count);
    }
}
