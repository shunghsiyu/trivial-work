package assignment3;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DegreeOfSeperation {

	public static void main(String[] args) {
		// TODO Implement
	}

	public static class Vertex {
		public static final String INPUT_FILENAME = "facebook_combined.txt";
		public static final double LINK_COST = 1;
		public static String input;
		static Map<Integer, Vertex> verticesMap = new HashMap<>();
		int id;
		boolean visited;
		double costFromStart;
		List<Entry<Vertex, Double>> neighbors;

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

		public List<Entry<Vertex, Double>> getNeighbors() {
			if (neighbors == null) {
				populateNeighbors();
			}
			return new ArrayList<Entry<Vertex, Double>>(neighbors);
		}

		void populateNeighbors() {
			List<Integer> neightborIDs = getNeighborIDFromFile();
			List<Entry<Vertex, Double>> newNeighborList = new ArrayList<Entry<Vertex, Double>>(
					neightborIDs.size());
			for (int i = 0; i < neightborIDs.size(); i++) {
				Vertex newVertex = Vertex.getVertex(neightborIDs.get(i));
				double cost = LINK_COST;
				Entry<Vertex, Double> vertexCostEntry = new SimpleEntry<Vertex, Double>(
						newVertex, cost);
				newNeighborList.add(vertexCostEntry);
			}
			
			this.neighbors = newNeighborList;
		}

		List<Integer> getNeighborIDFromFile() {
			if(input == null) {
				input = readInputFile();
			}
			
			List<Integer> neighbors = new ArrayList<>();
			List<Integer> list1 = resultToList(findIDAtEnd());
			List<Integer> list2 = resultToList(findIDAtStart());
			neighbors.addAll(list1);
			neighbors.addAll(list2);
			
			return neighbors;
		}
		
		static String readInputFile() {
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
		
		Matcher findIDAtEnd() {
			String patternString = "^(\\d+)\\s" + this.id + "$";
			return Pattern.compile(patternString, Pattern.MULTILINE).matcher(input);
		}
		
		Matcher findIDAtStart() {
			String patternString = "^" + this.id + "\\s(\\d+)$";
			return Pattern.compile(patternString, Pattern.MULTILINE).matcher(input);
		}
		
		List<Integer> resultToList(Matcher m) {
			int group = 1;
			List<Integer> list = new ArrayList<Integer>();
			while(m.find()) {
				list.add(Integer.parseInt(m.group(group)));
			}
			return list;
		}
	}
}
