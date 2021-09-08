class Solution {
    public static int[][] turn90Degree(int[][] map){
        int n = map.length;
        int m = map[0].length;
        
        int[][] newMap = new int[n][m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                newMap[j][n-i-1] = map[i][j];
            }
        }
        return newMap;
    }
    public static boolean check(int[][] lock){
        int n = lock.length / 3;
        
        for(int i=n; i<2*n; i++){
            for(int j=n; j<2*n; j++){
                if(lock[i][j] != 1)
                    return false;
            }
        }
        return true;
    }
    
    public boolean solution(int[][] key, int[][] lock) {
        int n = key.length;
        int m = lock.length;
        
        int[][] newLock = new int[3*m][3*m];
        
        for(int i=0; i<m; i++){
            for(int j=0; j<m; j++){
                newLock[m+i][m+j] = lock[i][j]; 
            }
        }
        
        for(int t=0; t<4; t++){
            key = turn90Degree(key);
            for(int i=0; i<2*m; i++){
                for(int j=0; j<2*m; j++){
                    for(int k=0; k<n; k++){
                        for(int l=0; l<n; l++){
                            newLock[i+k][j+l] += key[k][l];
                        }
                    }
                    if(check(newLock)){
                        return true;
                    }
                    for(int k=0; k<n; k++){
                        for(int l=0; l<n; l++){
                            newLock[i+k][j+l] -= key[k][l];
                        }
                    }
                }
            }
        }
        return false;
    }
}
