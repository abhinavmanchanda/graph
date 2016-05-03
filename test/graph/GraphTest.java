package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {

  private Graph graph;
  private Graph second;

  @Before
  public void setup(){
    graph = new Graph("first");
    second = new Graph("second");
    graph.addNeighbour(second);
  }

  @Test
  public void shouldFindNeighbour(){
    assertTrue(graph.isConnectedTo(second));
  }

  @Test
  public void shouldNotFindDisconnectedNode(){
    Graph third = new Graph("third");
    assertFalse(graph.isConnectedTo(third));
  }

  @Test
  public void shouldFindMultipleNeighbours(){
    Graph third = new Graph("third");
    graph.addNeighbour(third);
    assertTrue(graph.isConnectedTo(second));
    assertTrue(graph.isConnectedTo(third));
  }

  @Test
  public void shouldFindIndirectConnections(){
    Graph third = new Graph("third");
    Graph fourth = new Graph("fourth");
    Graph fifth = new Graph("fifth");
    graph.addNeighbour(third);
    second.addNeighbour(fourth);
    third.addNeighbour(fifth);
    assertTrue(graph.isConnectedTo(fourth));
    assertTrue(graph.isConnectedTo(fifth));
  }

  @Test
  public void shouldBeBidirectional(){
    assertTrue(second.isConnectedTo(graph));
  }
}
