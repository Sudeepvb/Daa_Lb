class FloydWarshall {
    final static int INF = Integer.MAX_VALUE;

    public void FloydWarshall() {
    }
    int[][] floydWarshall(int A[][]) {
        int n = A.length;
        int D[][] = createDistanceMatrix(A, n);
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (D[i][k] < INF && D[k][j] < INF)
                        D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }
        return D;
    }
    int[][] createDistanceMatrix(int A[][], int n) {
        int D[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j)
                    D[i][j] = 0;
                else if (A[i][j] == 0)
                    D[i][j] = INF;
                else
                    D[i][j] = A[i][j];
            }
        }
        return D;
    }
    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall();
        int[][] adjMatrix = {
                {0, 3, INF, 5},
                {2, 0, INF, 4},
                {INF, 1, 0, INF},
                {INF, INF, 2, 0}
        };
        int[][] shortestPaths = fw.floydWarshall(adjMatrix);
        for (int i = 0; i < shortestPaths.length; i++) {
            for (int j = 0; j < shortestPaths.length; j++) {
                System.out.printf("%d ", shortestPaths[i][j]);

            }
            System.out.println();
        }
    }
}