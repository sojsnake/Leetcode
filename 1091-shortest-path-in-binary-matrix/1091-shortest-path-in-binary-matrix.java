class Solution {
    static int[] dr = {-1,-1,-1,0,0,1,1,1};
    static int[] dc = {1,-1,0,-1,1,1,-1,0};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int rowLen = grid.length;
        int colLen = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rowLen][colLen];

        int[] start = {0, 0};
        int[] end = {rowLen-1, colLen-1};

        int startR = start[0], startC = start[1];
        int endR = end[0], endC = end[1];


        if(!(grid[0][0]==0 && grid[rowLen-1][colLen-1]==0))
            return -1;
        
        queue.add(new int[]{startR, startC, 1});
        visited[startR][startC] = true;

        while(!queue.isEmpty()){
            int[] node = queue.remove();
            int r = node[0], c = node[1], dist = node[2];

            if(r == endR && c==endC)
                return dist;
            
            for(int i=0; i<8; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nr<rowLen && nc>=0 && nc<colLen && grid[nr][nc] == 0){
                    if(!visited[nr][nc]){
                        visited[nr][nc] = true;
                        queue.add(new int[]{nr, nc, dist + 1});
                    }
                }
            }
        }
        return -1;
    }
}