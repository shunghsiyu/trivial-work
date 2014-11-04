
public class My5Heap {
	private double[] priorityArray;
	private String[] valueArray;
	private int next;
	int size;

	public My5Heap(int size) {
		this.size=size;
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
		double max=0;//the root value
		String str="";
		
			//the last hole
			double lastVal=priorityArray[next - 1];
			String lastStr=valueArray[next - 1];
		
			//the max node 
			max=priorityArray[0];
			str=valueArray[0];
			
			//delete the max
			priorityArray[0]=lastVal;
			valueArray[0]=lastStr;

			per_Down(0);
		
			next = next - 1;
			
		return max+"\t"+str;
	}
	
	public void per_Down(int hole){
		int child;		
		int cindex=0;
		double cmax=0;
		
		while(hole*5+1<next){
			child=hole*5+1;
			//find the max in the children
			//if the last onde's children number less than 5
			if(hole*5+5>next-1){
				cindex = child;
				cmax = priorityArray[cindex];
				for(int i=child+1;i<=next-1;i++){
					if(priorityArray[i]>cmax){
						cindex = i;
					}
				}
			}
			else{
				//find max between child, and its index
				cindex = child;
				cmax = priorityArray[child];
				for(int i=child+1;i<=child+4;i++){
					if(priorityArray[i]>cmax){
						cindex = i;
					}
				}
			} 
			//swap nodes
			if(priorityArray[cindex]>priorityArray[hole]){
				swap(cindex, hole);
			}
			else break;
			hole=cindex;
		}
	}

}
