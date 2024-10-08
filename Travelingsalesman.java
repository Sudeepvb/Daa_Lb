public class Travelingsalesman {
    static int n = 4; // Number of vertices
    static int MAX = 1000000; // Large number representing infinity
    static int[][] dist = {
            {0, 0, 0, 0, 0},
            {0, 0, 10, 15, 20},
            {0, 10, 0, 25, 25},
            {0, 15, 25, 0, 30},
            {0, 20, 25, 30, 0}
    }; // Distance matrix

    static int[][] memo = new int[n + 1][1 << (n + 1)]; // DP memoization table

    static int fun(int i, int mask) {
        if (mask == ((1 << i) | 3)) {
            return dist[1][i]; // Base case
        }

        if (memo[i][mask] != 0) {
            return memo[i][mask]; // Return precomputed result if available
        }

        int res = MAX; // Result for this sub-problem

        // Explore all cities
        for (int j = 1; j <= n; j++) {
            if ((mask & (1 << j)) != 0 && j != i && j != 1) {
                res = Math.min(res, fun(j, mask & (~(1 << i))) + dist[j][i]);
            }
        }

        return memo[i][mask] = res; // Store result in memo table
    }

    public static void main(String[] args) {
        int ans = MAX;

        // Try to find the minimum tour starting from any city
        for (int i = 1; i <= n; i++) {
            ans = Math.min(ans, fun(i, (1 << (n + 1)) - 1) + dist[i][1]);
        }

        System.out.println("The cost of the most efficient tour = " + ans);
    }
}
