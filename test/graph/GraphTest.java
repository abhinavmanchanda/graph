package graph;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphTest {

  private Graph first;
  private Graph second;

  @Before
  public void setup(){
    first = new Graph("first");
    second = new Graph("second");
    first.addNeighbour(second);
  }

  @Test
  public void shouldFindNeighbour(){
    assertTrue(first.isConnectedTo(second));
  }

  @Test
  public void shouldNotFindDisconnectedNode(){
    Graph third = new Graph("third");
    assertFalse(first.isConnectedTo(third));
  }

  @Test
  public void shouldFindMultipleNeighbours(){
    Graph third = new Graph("third");
    first.addNeighbour(third);
    assertTrue(first.isConnectedTo(second));
    assertTrue(first.isConnectedTo(third));
  }

  @Test
  public void shouldFindIndirectConnections(){
    Graph third = new Graph("third");
    Graph fourth = new Graph("fourth");
    Graph fifth = new Graph("fifth");
    first.addNeighbour(third);
    second.addNeighbour(fourth);
    third.addNeighbour(fifth);
    assertTrue(first.isConnectedTo(fourth));
    assertTrue(first.isConnectedTo(fifth));
  }

  @Test
  public void numberOfHopsToSelfShouldBeZero(){
    assertEquals(0, first.numberOfHopsTo(first));
  }

  @Test
  public void numberOfHopsToDirectNeighbourShouldBeOne(){
    assertEquals(1, first.numberOfHopsTo(second));
  }

  @Test
  public void shouldFindNumberOfHops(){
    Graph third = new Graph("third");
    Graph fourth = new Graph("fourth");
    Graph fifth = new Graph("fifth");
    first.addNeighbour(third);
    second.addNeighbour(fourth);
    third.addNeighbour(fifth);
    assertEquals(2, first.numberOfHopsTo(fifth));
  }

  @Test
  public void numberOfHopsToDisconnectedNodeShouldBeMinusOne(){
    assertEquals(-1, first.numberOfHopsTo(new Graph("sixth")));
  }

}
