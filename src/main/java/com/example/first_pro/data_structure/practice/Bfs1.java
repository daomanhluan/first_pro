package com.example.first_pro.data_structure.practice;

import com.example.first_pro.data_structure.MyGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Bfs1 {

  private LinkedList<Integer> adj[];
  private static int V;

  Bfs1(int v) {
    this.V = v;
    adj = new LinkedList[V+1];
    for (int i = 1; i <= v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public static Bfs1 initGraph(int v) {
    Bfs1 g = new Bfs1(v + 1);
    g.addEdge(1, 2);
    g.addEdge(1, 3);
    g.addEdge(1, 4);
    g.addEdge(2, 5);
    g.addEdge(2, 6);
    g.addEdge(4, 7);
    g.addEdge(4, 8);
    g.addEdge(4, 9);
    g.addEdge(6, 10);
    g.addEdge(6, 11);
    g.addEdge(7, 11);

    g.addEdge(8, 12);
    g.addEdge(8, 13);
    g.addEdge(9, 13);
    g.addEdge(9, 14);
    return g;
  }

  int bfs(int s, int key) {
    Map<Integer, Integer> mapNode = new HashMap<>();
    boolean visited[] = new boolean[V + 1];
    visited[s] = true;
    Queue<Integer> queue = new LinkedList<>();
    queue.add(s);
    mapNode.put(s, 0);
    while ((!queue.isEmpty())) {
      s = queue.poll();
      int count = mapNode.get(s);
      for (int i : adj[s]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
          mapNode.put(i, count + 1);
        }
      }
    }
    mapNode.forEach(
        (k, v) -> {
          System.out.println("k = "+k+", v = "+v);
        });

    return mapNode.getOrDefault(key, -1);
  }

  public static void main(String[] args) {
    //
      Bfs1 b1 = initGraph(14);
    b1.bfs(1,1);
  }
}
