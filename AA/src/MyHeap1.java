
public class MyHeap1 {
	double[] priorityArray;
	String[] valueArray;
	int next;
	int size;
	
	public MyHeap1(int size){
		this.size=size;
		priorityArray=new double[size];
		valueArray=new String[size];
		next=0;
	}
	public void insert(int val,String value){
		priorityArray[next]=val;
		valueArray[next]=value;
		int pos=next;
		while(pos>0){
			int parent=(pos-1)/5;
			if(priorityArray[pos]>priorityArray[parent]){
					swap(pos,parent);
			}
			else{
				break;
			}
			pos=parent;
		}
		next=next+1;
	}
	
	public void swap(int pos1,int pos2){
		double temp=priorityArray[pos1];
		priorityArray[pos1]=priorityArray[pos2];
		priorityArray[pos2]=temp;
		String tempValue=valueArray[pos1];
		valueArray[pos1]=valueArray[pos2];
		valueArray[pos2]=tempValue;
	}
	
	public String deletetMax(){
		double max=0;//the root value
		String str="";
		//the last hole
		size--;
		double lastVal=priorityArray[size];
		String lastStr=valueArray[size];
		
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
			int lastChildren=hole*5+5>size-1?size-1:child+4;
				for(int j=child;j<lastChildren;j++){
					if(priorityArray[j]<priorityArray[j+1]){
						cmax=cmax>priorityArray[j+1]?cmax:priorityArray[j+1];
							if(cmax==priorityArray[j+1])
								cindex=j+1;
					}
					else if(priorityArray[j]>priorityArray[j+1]){
						cmax=cmax>priorityArray[j]?cmax:priorityArray[j];
							if(cmax==priorityArray[j])
								cindex=j;
					}
				}
			 
			//swap nodes
			if(priorityArray[cindex]>priorityArray[hole]){
				swap(cindex,hole);			}
			else break;
			hole=cindex;
		}
	}

	

	public void getArr(){
		for(int i=0;i<size;i++){
			System.out.println(priorityArray[i]+"\t"+valueArray[i]);
		}
	}


}
