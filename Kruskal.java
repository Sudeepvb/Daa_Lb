import java.util.Scanner;

public class Kruskal {
    int[] parent = new int[10];

    // Function to find the root or parent of a vertex
    int find(int m) {
        while (parent[m] != 0) {
            m = parent[m];
        }
        return m;
    }

    // Function to perform union operation
    void union(int i, int j) {
        if (i < j) {
            parent[i] = j;
        } else {
            parent[j] = i;
        }
    }

    // Function implementing Kruskal's algorithm
    void krkl(int[][] a, int n) {
        int u = 0, v = 0, min, sum = 0, k = 0;
        while (k < n - 1) { // Spanning tree will have n-1 edges
            min = 99; // Initialize the minimum weight to a high value

            // Find the smallest edge in the graph
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (a[i][j] < min && i != j) {
                        min = a[i][j];
                        u = i;
                        v = j;
                    }
                }
            }

            // Find the roots of the vertices
            int i = find(u);
            int j = find(v);

            // If the vertices are not part of the same tree, include the edge
            if (i != j) {
                union(i, j);
                System.out.println("(" + u + "," + v + ") = " + a[u][v]);
                sum += a[u][v];
                k++;
            }

            // Mark the edge as used
            a[u][v] = a[v][u] = 99;
        }

        System.out.println("The cost of minimum spanning tree = " + sum);
    }

    public static void main(String[] args) {
        int[][] a = new int[10][10];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of vertices of the graph:");
        int n = sc.nextInt();

        System.out.println("Enter the weighted matrix:");
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        Kruskal k = new Kruskal();
        k.krkl(a, n);

        sc.close();
    }
}
