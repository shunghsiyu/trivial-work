import java.util.Random;

public class Tester {

	public static void main(String[] args) {
	  static final int SIZE=1000;
          static final int MAX_NUMBER=100000;
   
    public static void main(String[]args){
         My5Heap test=new My5Heap(SIZE);
         Random x=new Random();
        double randomNumber=x.nextInt(MAX_NUMBER);
        for(int i=0;i<1000;i++){
            test.insert(randomNumber,Double.toString(randomNumber));     //insert 1000 random number into heap   
        }
        for(int q=0;q<1000;q++){
           System.out.println(test.deleteMax()+"No"+q+"Element");
       }
    }
	}

}
