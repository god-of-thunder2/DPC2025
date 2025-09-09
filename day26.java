// detect the cycle in undirected graph

import java.util.*;

public class day26 {

    static class Graph {
        int V;
        List<List<Integer>> adj;

        Graph(int V) {
            this.V = V;
            adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int u, int v) {
            adj.get(u).add(v);
            adj.get(v).add(u); // undirected
        }

        boolean isCyclic() {
            boolean[] visited = new boolean[V];
            for (int i = 0; i < V; i++) {
                if (!visited[i]) {
                    if (dfs(i, visited, -1)) {
                        return true;
                    }
                }
            }
            return false;
        }

        boolean dfs(int node, boolean[] visited, int parent) {
            visited[node] = true;

            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    if (dfs(neighbor, visited, node)) {
                        return true;
                    }
                } else if (neighbor != parent) {
                    return true; // cycle found
                }
            }
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter the no. vertices: ");
        int V = sc.nextInt();

        System.out.print("enter the no. of edges: ");
        int E = sc.nextInt();

        Graph g = new Graph(V);

        System.out.println("enter edges (u v): ");

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            g.addEdge(u, v);
        }

        System.out.println("does graph contain cycle:-" + g.isCyclic());
        sc.close();
    }
}
