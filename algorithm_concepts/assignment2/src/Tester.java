import java.util.Random;

public class Tester {
	static final int SIZE = 1000;
	static final int MAX_NUMBER = 100000;

	public static void main(String[] args) {
		My5Heap test = new My5Heap(SIZE);
		Random x = new Random();
		for (int i = 0; i < 1000; i++) {
			int randomNumber = x.nextInt(MAX_NUMBER);
			// insert 1000 random number into heap
			test.insert(randomNumber, String.valueOf(randomNumber));
		}
		for (int q = 0; q < 1000; q++) {
			System.out.printf("%s\telement %d\n", test.deleteMax(), q+1);
		}
	}
}
