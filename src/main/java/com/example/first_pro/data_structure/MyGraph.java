package com.example.first_pro.data_structure;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MyGraph {

  private int V;
  private LinkedList<Integer> adj[];

  public MyGraph(int v) {
    this.V = v;
    adj = new LinkedList[v + 1];
    for (int i = 1; i <= v; i++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int v, int w) {
    adj[v].add(w);
  }

  public void bfs(int s) {
    boolean visited[] = new boolean[V + 1];
    Queue<Integer> queue = new LinkedList<>();
    visited[s] = true;
    queue.add(s);

    while (!queue.isEmpty()) {
      s = queue.poll();

      for (Integer i : adj[s]) {
        if (!visited[i]) {
          visited[i] = true;
          queue.add(i);
        }
      }
      System.out.println("S -> " + s + ", v[] = " + queue);
    }
  }

  public void bfs1(int s){
    int result = -1;
  }

  public void dfs(int s){
    boolean visited[] = new boolean[V+1];
    Stack<Integer> stack = new Stack<>();
    visited[s]=true;
    stack.push(s);

    while(!stack.isEmpty()){
      int v = stack.pop();
      System.out.println("s: "+v);
      for(Integer i : adj[v]){
        if(!visited[i]){
          visited[i]=true;
          stack.push(i);
        }
      }
    }
  }

  public void dfs_v2(int s, boolean visited[]){
    if(visited[s]) return;
    visited[s] = true;
    System.out.println("s: "+s);
    for(int i:adj[s]){
      dfs_v2(i,visited);
    }
  }

  public static MyGraph initGraph() {
    MyGraph g = new MyGraph(14);
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

  public static void main(String args[]) {
    MyGraph myGraph = initGraph();
    System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

//    myGraph.bfs(1);
//    myGraph.dfs(1);
    System.out.println("==================================");
    myGraph.dfs_v2(1,new boolean[20]);
  }
}
