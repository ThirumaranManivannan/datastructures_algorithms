package ds.datastructures.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {

    List<List<Integer>> graph;
    // Graph representation Adjacency list

    public Graph(int size){
        graph = new ArrayList<>();
        for(int i = 0; i < size; i++){
            graph.add(new ArrayList<>());
        }
    }

    public void addEdge(int u, int v){

        graph.get(u).add(v);
        graph.get(v).add(u);

    }

    public void bfs(int s, boolean[] visited){

        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        System.out.print(s + " ");
        while(!q.isEmpty()){
            List<Integer> adjacents = graph.get(q.poll());
            for(Integer v : adjacents){
                if(!visited[v]){
                    q.add(v);
                    System.out.print(v + " ");
                    visited[v] = true;
                }
            }
        }
    }

    public void bfs(){
        int size = graph.size();
        boolean[] visited = new boolean[graph.size()];
        for(int i = 0; i < size; i++){

            if(!visited[i]){
                bfs(i, visited);
            }

        }
    }

    private void dfs(int s, boolean[] visited){
        if(visited[s])
            return;
        System.out.print(s + " ");
        visited[s] = true;
        for(int v : graph.get(s)){
            if(!visited[v])
                dfs(v, visited);
        }
    }

    public void dfs(){

        boolean[] visited = new boolean[graph.size()];
        int count = 0;
        for(int i = 0; i < graph.size(); i++){
            if(!visited[i]) {
                count++;
                dfs(i, visited);
            }
        }

        System.out.println();
        System.out.println(count);
    }

    public static void main(String[] args){

        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(3, 2);
        graph.addEdge(4, 5);
        graph.addEdge(6, 7);

        graph.dfs();
    }
}
