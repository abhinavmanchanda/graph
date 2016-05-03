package graph;

import java.util.*;

public class Graph {
  private String name;
  private List<Graph> neighbours;

  public Graph(String name) {
    this.name = name;
    neighbours = new ArrayList<Graph>();
  }

  public void addNeighbour(Graph neighbour) {
    this.neighbours.add(neighbour);
    neighbour.neighbours.add(this);
  }

  public boolean isConnectedTo(Graph other) {
    Set<Graph> visited = new HashSet<Graph>();
    LinkedList<Graph> pending = new LinkedList<Graph>();
    if(this == other) return true;
    pending.addAll(neighbours);
    visited.add(this);
    while(pending.peek() != null){
      Graph element = pending.poll();
      if(element.equals(other)) return true;
      visited.add(element);
      for (Graph neighbour : element.neighbours) {
        if(!visited.contains(neighbour)) pending.add(neighbour);
      }
    }
    return false;
  }
}
