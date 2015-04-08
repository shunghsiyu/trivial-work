package assignment3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DegreeOfSeperation {
	private static final int inf = Integer.MAX_VALUE;
	private char[] vertexs;
	private int[][] matrix;

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("Input ERROR");
			System.out
					.println("Usage: java DegreeOfSeperation startVertex endVertex");
		} else {
			int startVertex = Integer.parseInt(args[0]);
			int endVertex = Integer.parseInt(args[1]);
			double cost = dijkstra(startVertex, endVertex);
			System.out.printf("The degree of users %d and %d is %d",
					startVertex, endVertex, (int) cost);
		}
	}

	/*
	 * public void dijkstra(int vs, int vn) { boolean[] route = new
	 * boolean[vertexs.length];// find the shortest route
	 * 
	 * for (int i = 0; i < vertexs.length; i++) { route[i] = false; prev[i] = 0;
	 * cost[i] = matrix[vs][i]; } Vertex s = Vertex.getVertex(vs);
	 * s.getNeighbors();
	 * 
	 * route[vs] = true;// inialize the vetex cost[vs] = 0; int n = 0; // find
	 * every vertex shortest route for (int i = 1; i < vertexs.length; i++) {
	 * int min = inf; for (int j = 0; j < vertexs.length; j++) { if (route[j] =
	 * false && cost[j] < min) { min = cost[j]; n = j; } } route[n] = true;//
	 * tag the route // update the route and update previous vertex for (int j =
	 * 0; j < vertexs.length; j++) { int tmp = (matrix[n][j] == inf ? inf : (min
	 * + matrix[n][j])); if (route[j] = false && (tmp < cost[j])) { cost[j] =
	 * tmp; prev[j] = n; } }
	 * 
	 * } }
	 */

	public static double dijkstra(int start, int end) {
		boolean costFound = false;
		Vertex vStart = Vertex.getVertex(start);
		vStart.setCostFromStartIfSmaller(0);
		Vertex vEnd = Vertex.getVertex(end);
		PriorityQueue<Vertex> toExplore = new PriorityQueue<Vertex>();
		toExplore.add(vStart);

		double costStartToEnd = Double.POSITIVE_INFINITY;
		while (!toExplore.isEmpty() && !costFound) {
			Vertex v = toExplore.poll();
			v.setVisited(true);
			double costToV = v.getCostFromStart();
			List<Vertex> neighbors = v.getNeighbors();

			for (Vertex neighbor : neighbors) {
				double costVtoNeighbor = 1;
				neighbor.setCostFromStartIfSmaller(costToV + costVtoNeighbor);

				if (neighbor == vEnd) {
					costStartToEnd = neighbor.getCostFromStart();
					costFound = true;
					break;
				}

				if (!neighbor.isVisited() && !toExplore.contains(neighbor)) {
					toExplore.add(neighbor);
				}
			}

		}

		return costStartToEnd;
	}
}

class Vertex implements Comparable<Vertex> {
	public static final String INPUT_FILENAME = "facebook_combined.txt";
	public static final double LINK_COST = 1;
	public static String input;
	static Map<Integer, Vertex> verticesMap = new HashMap<>();
	int id;
	boolean visited;
	double costFromStart;
	List<Vertex> neighbors;

	public static Vertex getVertex(int id) {
		Vertex toGet = verticesMap.get(id);
		if (toGet == null) {
			toGet = new Vertex(id);
			verticesMap.put(id, toGet);
		}
		return toGet;
	}

	private Vertex(int id) {
		this.id = id;
		this.visited = false;
		this.costFromStart = Double.POSITIVE_INFINITY;
	}

	public double getCostFromStart() {
		return costFromStart;
	}

	public boolean setCostFromStartIfSmaller(double newCost) {
		boolean setSuccess = false;
		if (newCost < costFromStart) {
			costFromStart = newCost;
		}
		return setSuccess;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean newValue) {
		this.visited = newValue;
	}

	public List<Vertex> getNeighbors() {
		if (neighbors == null) {
			populateNeighbors();
		}
		return new ArrayList<Vertex>(neighbors);
	}

	private void populateNeighbors() {
		List<Integer> neightborIDs = getNeighborIDFromFile();
		List<Vertex> newNeighborList = new ArrayList<Vertex>(
				neightborIDs.size());
		for (int i = 0; i < neightborIDs.size(); i++) {
			Vertex newVertex = Vertex.getVertex(neightborIDs.get(i));
			newNeighborList.add(newVertex);
		}

		this.neighbors = newNeighborList;
	}

	private List<Integer> getNeighborIDFromFile() {
		if (input == null) {
			input = readInputFile();
		}

		List<Integer> neighbors = new ArrayList<>();
		List<Integer> list1 = resultToList(findIDAtEnd());
		List<Integer> list2 = resultToList(findIDAtStart());
		neighbors.addAll(list1);
		neighbors.addAll(list2);

		return neighbors;
	}

	private static String readInputFile() {
		String toReturn = "";
		try {
			Scanner in = new Scanner(new File(INPUT_FILENAME));
			in.useDelimiter("\\Z");
			toReturn = in.next();
			in.close();
		} catch (FileNotFoundException e) {
			System.out.println("Can't find " + INPUT_FILENAME);
			System.exit(-1);
		}
		return toReturn;
	}

	private Matcher findIDAtEnd() {
		String patternString = "^(\\d+)\\s" + this.id + "$";
		return Pattern.compile(patternString, Pattern.MULTILINE).matcher(input);
	}

	private Matcher findIDAtStart() {
		String patternString = "^" + this.id + "\\s(\\d+)$";
		return Pattern.compile(patternString, Pattern.MULTILINE).matcher(input);
	}

	private List<Integer> resultToList(Matcher m) {
		int group = 1;
		List<Integer> list = new ArrayList<Integer>();
		while (m.find()) {
			list.add(Integer.parseInt(m.group(group)));
		}
		return list;
	}

	@Override
	public String toString() {
		return "vertex#" + id;
	}

	@Override
	public int compareTo(Vertex o) {
		double costOfThis = this.getCostFromStart();
		double costOfTarget = o.getCostFromStart();
		if (costOfThis < costOfTarget) {
			return -1;
		} else if (costOfThis == costOfTarget) {
			return 0;
		} else {
			return 1;
		}
	}
}
