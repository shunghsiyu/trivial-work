
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
			double lastVal=priorityArray[--size];
			String lastStr=valueArray[--size];
		
			//the max node 
			max=priorityArray[0];
			str=valueArray[0];
			
			//delete the max
			priorityArray[0]=lastVal;
			valueArray[0]=lastStr;

			per_Down(0);
		
		return max+"\t"+str;
	}
	
	public void per_Down(int hole){
		int child;		
		int cindex=0;
		double cmax=0;
		
		for(;hole*5+1<size;){
			child=hole*5+1;
			//find the max in the children
			//if the last onde's children number less than 5
			if(hole*5+5>size-1){
				for(int j=child;j<size-1;j++){
					if(priorityArray[j]<priorityArray[j+1]){
						cmax= (cmax>priorityArray[j+1]?cmax:priorityArray[j+1]);
							if(cmax==priorityArray[j+1])
								cindex=j+1;
					}
					else if(priorityArray[j]>priorityArray[j+1]){
						cmax=cmax>priorityArray[j]?cmax:priorityArray[j];
							if(cmax==priorityArray[j])
								cindex=j;
					}
				}
			}
			else{
				//find max between child, and its index
				for(int i=child;i<child+4;i++){
					if(priorityArray[i]<priorityArray[i+1]){
						cmax=cmax>priorityArray[i+1]?cmax:priorityArray[i+1];
							if(cmax==priorityArray[i+1])
								cindex=i+1;
					}
					else if(priorityArray[i]>priorityArray[i+1]){
						cmax=cmax>priorityArray[i]?cmax:priorityArray[i];
							if(cmax==priorityArray[i])
								cindex=i;
					}
				}
			} 
			//swap nodes
			if(priorityArray[cindex]>priorityArray[hole]){
				double temp=priorityArray[cindex];
				priorityArray[cindex]=priorityArray[hole];
				priorityArray[hole]=temp;
				String tempValue=valueArray[cindex];
				valueArray[cindex]=valueArray[hole];
				valueArray[hole]=tempValue;
			}
			else break;
			hole=cindex;
		}
	}

}
