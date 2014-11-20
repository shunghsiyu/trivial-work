import java.util.Map.Entry;


public class DegreeOfSeperation {

	public static void main(String[] args) {
		// TODO Implement
	}

}

class Vertex {
	public static String INPUT_FILENAME = "facebook_combined.txt";
	private int id;
	private boolean initialized;
	private boolean visited;
	private double costFromStart;
	private Entry<Vertex, Integer>[] neighbors;
	
	public Vertex(int id) {
		this.id = id;
		this.initialized = false;
		this.visited = false;
		this.costFromStart = Double.POSITIVE_INFINITY;
	}
	
	public double getCostFromStart() {
		return costFromStart;
	}
	
	public boolean setCostFromStartIfSmaller(double newCost) {
		boolean setSuccess = false;
		if(newCost < costFromStart) {
			costFromStart = newCost;
		}
		return setSuccess;
	}
	
	public Entry<Vertex, Integer>[] getNeighbors() {
		// TODO Implement
		return null;
	}
	
	
}