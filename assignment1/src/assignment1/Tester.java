package assignment1;

import java.util.Random;

public class Tester {
	protected static final int[] SIZE = { 50, 10000, 10000000 };
	protected static final int MAX_VALUE = 100000000;
	protected static final int FIND_TRIES = 10000;
	protected static final int EXP_NUM_TRIALS = 100;

	public static void main(String[] args) {
		System.out.println("Binary search tree:");
		testBinarySearchTree();
		System.out.println();
		
		System.out.println("List:");
		testLinkedList();
		System.out.println();
	}
	
	static void testBinarySearchTree() {
		Random r = new Random();
		double startTime = 0;
		double endTime = 0;
		double totalInsertTime = 0;
		double totalFindTime = 0;
		
		for (int exp_num = 0; exp_num < SIZE.length; exp_num++) {
			int n = SIZE[exp_num];
			System.out.print("n=" + n + " ");

			for (int tries = 0; tries < EXP_NUM_TRIALS; tries++) {
				BinarySearchTree bTree = new BinarySearchTree();
				
				startTime = System.currentTimeMillis();
				for (int i = 0; i < n; i++) {
					bTree.insert(r.nextInt(MAX_VALUE));
				}
				endTime = System.currentTimeMillis();
				totalInsertTime = totalInsertTime + (endTime - startTime);

				startTime = System.currentTimeMillis();
				for (int i = 0; i < FIND_TRIES; i++) {
					bTree.find(r.nextInt(MAX_VALUE));
				}
				endTime = System.currentTimeMillis();
				totalFindTime = totalFindTime + (endTime - startTime);
			}

			System.out.printf("insert: %.3f ms; find: %.3f ms\n",
					totalInsertTime / EXP_NUM_TRIALS, totalFindTime
							/ EXP_NUM_TRIALS);
		}
	}

	static void testLinkedList() {
		Random r = new Random();
		double startTime = 0;
		double endTime = 0;
		double totalInsertTime = 0;
		double totalFindTime = 0;
		
		for (int exp_num = 0; exp_num < SIZE.length; exp_num++) {
			int n = SIZE[exp_num];
			System.out.print("n=" + n + " ");

			for (int tries = 0; tries < EXP_NUM_TRIALS; tries++) {
				LinkedList ll = new LinkedList();
				
				startTime = System.currentTimeMillis();
				for (int i = 0; i < n; i++) {
					ll.insert(r.nextInt(MAX_VALUE));
				}
				endTime = System.currentTimeMillis();
				totalInsertTime = totalInsertTime + (endTime - startTime);

				startTime = System.currentTimeMillis();
				for (int i = 0; i < FIND_TRIES; i++) {
					ll.find(r.nextInt(MAX_VALUE));
				}
				endTime = System.currentTimeMillis();
				totalFindTime = totalFindTime + (endTime - startTime);
			}

			System.out.printf("insert: %.3f ms; find: %.3f ms\n",
					totalInsertTime / EXP_NUM_TRIALS, totalFindTime
							/ EXP_NUM_TRIALS);
		}
	}
	
}
