import java.util.Scanner;

public class Dijkstra {
    int[] d = new int[10]; // Distance array
    int[] p = new int[10]; // Parent array to track the shortest path
    int[] visited = new int[10]; // Visited array

    // Dijkstra's algorithm
    public void dijk(int[][] a, int s, int n) {
        int u = -1, v, i, j, min;

        // Initialize distances and visited arrays
        for (i = 0; i < n; i++) {
            d[i] = Integer.MAX_VALUE; // Initially, set all distances to infinity
            visited[i] = 0;           // Mark all vertices as unvisited
            p[i] = -1;                // No parent for any vertex at the start
        }
        d[s] = 0; // Distance to the source vertex is zero

        for (i = 0; i < n; i++) {
            min = Integer.MAX_VALUE;

            // Find the vertex with the smallest distance that is unvisited
            for (j = 0; j < n; j++) {
                if (d[j] < min && visited[j] == 0) {
                    min = d[j];
                    u = j;
                }
            }

            visited[u] = 1; // Mark the vertex as visited

            // Update the distances of adjacent vertices
            for (v = 0; v < n; v++) {
                if (a[u][v] > 0 && visited[v] == 0 && d[u] + a[u][v] < d[v]) {
                    d[v] = d[u] + a[u][v]; // Update distance
                    p[v] = u; // Update parent of vertex v to u
                }
            }
        }
    }

    // Recursive function to print the path from source to vertex v
    void path(int v, int s) {
        if (p[v] != -1) {
            path(p[v], s);
        }
        if (v != s) {
            System.out.print("->" + v + " ");
        }
    }

    // Display the shortest paths and their distances
    void display(int s, int n) {
        for (int i = 0; i < n; i++) {
            if (i != s) {
                System.out.print(s);
                path(i, s);
                System.out.print(" = " + d[i]);
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[10][10];
        int i, j, n, s;

        System.out.println("Enter the number of vertices:");
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        System.out.println("Enter the weighted matrix:");
        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the source vertex:");
        s = sc.nextInt();

        Dijkstra tr = new Dijkstra();
        tr.dijk(a, s, n);

        System.out.println("The shortest path from source " + s + " to remaining vertices are:");
        tr.display(s, n);

        sc.close();
    }
}
