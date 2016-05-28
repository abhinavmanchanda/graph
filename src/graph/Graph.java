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
  }

  public boolean isConnectedTo(Graph other) {
    return numberOfHopsTo(other) >= 0;
  }

  public int numberOfHopsTo(Graph other) {
    if(other.name.equals(this.name)) return 0;

    for (Graph neighbour : neighbours) {
      int numerOfHopsTo = neighbour.numberOfHopsTo(other);
      if(numerOfHopsTo != -1){
        return numerOfHopsTo + 1;
      };
    }
    return -1;
  }
}
