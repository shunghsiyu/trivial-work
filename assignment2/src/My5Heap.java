public class My5Heap {
	private double[] priorityArray;
	private String[] valueArray;
	private int next;
	int size;

	public My5Heap(int size) {
		this.size = size;
		priorityArray = new double[size];
		valueArray = new String[size];
		next = 0;
	}

	public void insert(double priority, String value) {
		priorityArray[next] = priority;
		valueArray[next] = value;
		int pos = next;
		while (pos > 0) {
			int parent = (pos - 1) / 5;
			if (priorityArray[pos] > priorityArray[parent]) {
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
		return (next >= priorityArray.length - 1);
	}

	public String deleteMax() {
		double max = priorityArray[0];// the root value
		String str = valueArray[0];

		swap(0, next - 1);

		// delete the max
		priorityArray[next - 1] = 0.0;
		valueArray[next - 1] = null;

		percolateDown(0);
		next = next - 1;

		return max + "\t" + str;
	}

	public void percolateDown(int hole) {
		while (hole * 5 + 1 < next) {
			int maxChildIndex = maxChildrenOf(hole);
			// swap nodes
			if (priorityArray[maxChildIndex] > priorityArray[hole]) {
				swap(maxChildIndex, hole);
			} else
				break;
			hole = maxChildIndex;
		}
	}

	private int maxChildrenOf(int parent) {
		int firstChild = parent * 5 + 1;
		// find the max in the children
		int maxChildIndex = parent * 5 + 1;
		// if the last onde's children number less than 5
		int lastChild = (firstChild + 4 > next - 1) ? next - 1
				: firstChild + 4;
		
		for (int i = firstChild + 1; i <= lastChild; i++) {
			if (priorityArray[i] > priorityArray[maxChildIndex]) {
				maxChildIndex = i;
			}
		}
		return maxChildIndex;
	}
}
