// find the shortest path among two vertices in unweighted graph

import java.util.*;

public class day27 {

    // methodd to compute shortest path in an unweighted graph
    public static int findShortestPath(int vertices, int[][] edges, int src, int dest) {
        // building adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]); // undirected graph
        }

        // using bfs
        Queue<Integer> q = new LinkedList<>();
        boolean[] seen = new boolean[vertices];
        int[] distance = new int[vertices];
        Arrays.fill(distance, -1);

        q.add(src);
        seen[src] = true;
        distance[src] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int nei : adj.get(node)) {
                if (!seen[nei]) {
                    seen[nei] = true;
                    distance[nei] = distance[node] + 1;
                    q.add(nei);

                    if (nei == dest) {
                        return distance[nei];
                    }
                }
            }
        }
        return -1; // no path
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("enter no. of vertices: ");
        int V = sc.nextInt();

        System.out.print("enter no. of edges: ");
        int E = sc.nextInt();

        int[][] edges = new int[E][2];
        System.out.println("enter edges (u v): ");
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }

        System.out.print("enter  start node: ");
        int start = sc.nextInt();

        System.out.print("enter end node: ");
        int end = sc.nextInt();

        int ans = findShortestPath(V, edges, start, end);
        System.out.println("shortest path length: " + ans);
        sc.close();
    }
}
