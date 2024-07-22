package Solution.P;

import java.util.*;

public class PathWithMaximumProbability {
}

class Solution1514Dijkstra {
    private record Pair(int key, double value) {}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double w = succProb[i];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        PriorityQueue<Pair> queue = new PriorityQueue<Pair>(Comparator.comparing(Pair::value).reversed());
        HashMap<Integer, Double> cost = new HashMap<>();
        queue.add(new Pair(start_node, 1));
        while (!queue.isEmpty()) {
            Pair u = queue.remove();
            if (cost.containsKey(u.key)) continue;
            cost.put(u.key, u.value);

            for (Pair v : adj.get(u.key)) {
                if (!cost.containsKey(v.key)) {
                    queue.add(new Pair(v.key, u.value * v.value));
                }
            }
        }

        return cost.containsKey(end_node) ? cost.get(end_node): 0;
    }
}

class Solution1514BellmanFord {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] maxProb = new double[n];
        maxProb[start] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            boolean hasUpdate = false;
            for (int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double w = succProb[j];

                if (maxProb[u] * w > maxProb[v]) {
                    hasUpdate = true;
                    maxProb[v] = maxProb[u] * w;
                }

                if (maxProb[v] * w > maxProb[u]) {
                    hasUpdate = true;
                    maxProb[u] = maxProb[v] * w;
                }
            }
            if (!hasUpdate) break;
        }

        return maxProb[end];
    }
}

class Solution1514SPFA {
    private record Pair(int key, double value) {}

    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double w = succProb[i];
            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        double[] cost = new double[n];
        cost[start] = 1;

        Deque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        while (!queue.isEmpty()) {
            int curNode = queue.removeFirst();
            for (Pair next : adj.get(curNode)) {
                int nextNode = next.key();
                double nextCost = next.value();
                if (cost[curNode] * nextCost > cost[nextNode]) {
                    cost[nextNode] = cost[curNode] * nextCost;
                    queue.addLast(nextNode);
                }
            }
        }
        return cost[end];
    }
}