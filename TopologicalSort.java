import java.util.*;
import java.lang.Integer;
import java.lang.Object;
public class TopologicalSort { 
private int V; // Number of vertices 
private List adjList[];
public TopologicalSort(int v) {
V = v; adjList = new LinkedList[v]; 
for (int i = 0; i < v; ++i) 
adjList[i] = new LinkedList<>();
}
private void addEdge(int v, int w) {
adjList[v].add(w);
}
private void topologicalSortUtil(int v, boolean visited[], 
Stack stack) { 
visited[v] = true;
for (Object neighbor : adjList[v])
 {
if (!visited[(int) neighbor])
topologicalSortUtil((Integer) neighbor, visited, stack);
}
stack.push(v);
}
private void topologicalSort() { 
Stack stack = new Stack<>();
boolean visited[] = new boolean[V];
Arrays.fill(visited, false); 
for (int i = 0; i < V; ++i) { 
if (!visited[i]) topologicalSortUtil(i, visited, stack); 
}
System.out.println("Topological Sort:");
while (!stack.isEmpty()) 
System.out.print(stack.pop() + " "); 
}
public static void main(String args[]) { 
Scanner scanner = new Scanner(System.in); 
System.out.print("Enter the number of vertices: ");
int V = scanner.nextInt();
TopologicalSort g = new TopologicalSort(V);
System.out.println("Enter the adjacency matrix:"); 
for (int i = 0; i < V; i++) { for (int j = 0; j < V; j++) {
if (scanner.nextInt() == 1) { 
g.addEdge(i, j);
}
}
}
g.topologicalSort(); 
scanner.close();
}
}