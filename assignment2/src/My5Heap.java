
public class My5Heap {
	private double[] priorityArray;
	private String[] valueArray;
	private int next;
	
	public My5Heap(int size) {
		priorityArray = new double[size];
		valueArray = new String[size];
		next = 0;
	}

	public void insert(double priority, String value) {
		priorityArray[next] = priority;
		valueArray[next] = value;
		int pos = next;
		while(pos > 0) {
			int parent = (pos-1)/5;
			if(priorityArray[pos] > priorityArray[parent]) {
				swap(pos, parent);
			} else {
				break;
			}
			pos = parent;
		}
		next = next + 1;
	}
	
	public void swap(int pos1, int pos2) {
		double tempPriority = priorityArray[pos1];
		String tempValue = valueArray[pos1];
		priorityArray[pos1] = priorityArray[pos2];
		valueArray[pos1] = valueArray[pos2];
		priorityArray[pos2] = tempPriority;
		valueArray[pos2] = tempValue;
	}
	
	public boolean isFull() {
		return (next >= priorityArray.length-1);
	}
	
	public String deleteMax() {
		return null;
	}
}
