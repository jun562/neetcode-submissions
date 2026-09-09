class Solution {
    int N, M;
    int[] dx = {0,0,1,-1};
    int[] dy = {1,-1,0,0};

    public void islandsAndTreasure(int[][] grid) {
        int N = grid.length;
        int M = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(grid[i][j] == 0){
                    q.offer(new int[]{i,j});
                }
            }
        }

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

                if(grid[newX][newY] == 2147483647){
                    q.offer(new int[]{newX, newY});
                    grid[newX][newY] = grid[curX][curY] + 1;
                }
            }
        }
    }
}

//-1 물 : 이동 X
//0 : 보물상자
//INF : 이동할수 있는 육지
//각 육지칸 -> 가장 가까운 보물 상자까지의 거리
//도달할수 없다면 -> INF 유지 
// 각 보물 상자에서 bfs