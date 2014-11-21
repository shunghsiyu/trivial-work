package assignment3;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Matcher;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import assignment3.DegreeOfSeperation.Vertex;

public class VertexTest {
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetVertex() {
		int id = 10;
		Vertex vertex = Vertex.getVertex(id);
		assertTrue(vertex.id == 10);
	}

	@Test
	public void testGetCostFromStart() {
		int id = 11;
		Vertex vertex = Vertex.getVertex(id);
		assertTrue(vertex.getCostFromStart() > Double.MAX_VALUE);
	}

	@Test
	public void testSetCostFromStartIfSmaller() {
		int id = 12;
		Vertex vertex = Vertex.getVertex(id);
		double newCost = 5;
		vertex.setCostFromStartIfSmaller(newCost);
		assertEquals(newCost, vertex.getCostFromStart(), 0.001);
		;
	}

	@Test
	public void testIsVisited() {
		int id = 13;
		Vertex vertex = Vertex.getVertex(id);
		assertFalse(vertex.isVisited());
	}

	@Test
	public void testSetVisited() {
		int id = 14;
		Vertex vertex = Vertex.getVertex(id);
		vertex.setVisited(true);
		assertTrue(vertex.isVisited());
	}

	@Test
	public void testGetNeighbors() {
		int id = 16;
		Vertex vertex = Vertex.getVertex(id);
		List<Entry<Vertex, Double>> list = vertex.getNeighbors();
		int[] neighbors = new int[] {0, 29, 82, 118, 172, 261, 329, 331, 332};
		assertTrue(list.size() == neighbors.length);
		for(int i = 0; i < list.size(); i++) {
			assertTrue(list.get(i).getKey().id == neighbors[i]);
			assertEquals(1.0, list.get(i).getValue(), 0.001);;
		}
	}

	@Test
	public void testPopulateNeighbors() {
		int id = 17;
		Vertex vertex = Vertex.getVertex(id);
		vertex.populateNeighbors();
		assertTrue(vertex.neighbors != null);
	}

	@Test
	public void testGetNeighborIDFromFile() {
		int id = 2;
		Vertex vertex = Vertex.getVertex(id);
		Integer[] neighborsArray = new Integer[] {0, 20, 115, 116, 149, 226, 312, 326, 333, 343};
		List<Integer> actualList = vertex.getNeighborIDFromFile();
		assertArrayEquals(neighborsArray, actualList.toArray(new Integer[actualList.size()]));
	}

	@Test
	public void testReadInputFile() {
		assertTrue(Vertex.readInputFile().length() == 854361);
	}

	@Test
	public void testSameVertex() {
		Vertex vertex0 = Vertex.getVertex(0);
		Vertex vertex1 = Vertex.getVertex(1);
		Vertex vertex0From1 = vertex1.getNeighbors().get(0).getKey();
		assertEquals(vertex0.getCostFromStart(), vertex0From1.getCostFromStart(), 0.001);
		vertex0From1.setCostFromStartIfSmaller(0);
		assertEquals(vertex0.getCostFromStart(), vertex0From1.getCostFromStart(), 0.001);
	}

	@Test
	public void testFindIDAtEnd() {
		int id = 321;
		Vertex vertex = Vertex.getVertex(id);
		int[] neighborsAsSource = new int[] {0, 143, 175};
		Matcher m = vertex.findIDAtEnd();
		for(int i = 0; i < neighborsAsSource.length; i++) {
			m.find();
			assertEquals(String.valueOf(neighborsAsSource[i]), m.group(1));
		}
	}
	
	@Test
	public void testFindIDAtStart() {
		int id = 84;
		Vertex vertex = Vertex.getVertex(id);
		int[] neighborsAsTarget = new int[] {224, 236, 237, 265, 276, 304, 313};
		Matcher m = vertex.findIDAtStart();
		for(int i = 0; i < neighborsAsTarget.length; i++) {
			m.find();
			assertEquals(String.valueOf(neighborsAsTarget[i]), m.group(1));
		}
	}
}
