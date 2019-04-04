import java.util.Arrays;
import java.util.Random;

public class Quiz2Test {
	private final static int SIZE_LARGE = 10000;
	private final static int SIZE_SMALL = 100;
	private static final long SEED = 10;
	private static final int PAIRS_LARGE = 200000;
	private static final int PAIRS_SMALL = 2000;
	private static final int TEST1 = 49995000;
	private static final int TEST1_SMALL = 4950;
	private static final int TEST2 = 0;
	private static final int TEST3 = 24852077;
	private static final int TEST3_SMALL = 2826;
	private static final int TEST4 = 1654978;
	private static final int TEST4_SMALL = 83;

	static public void main(String[] args) {
		System.out.println("=== Array List ===");
		ListInterface<Integer> array = new AList<>();
		test(array, true);
		System.out.println("=== Linked List ===");
		ListInterface<Integer> chain = new LList<>();
		test(chain, false);
	}

	private static void test(ListInterface<Integer> list, boolean large) {
		int size = large? SIZE_LARGE : SIZE_SMALL;
		int nPairs = large? PAIRS_LARGE : PAIRS_SMALL;

		for(int i=0; i<size; i++) {
			list.add(size-i-1);
		}
		if(Quiz2.countInversions(list) == (large? TEST1 : TEST1_SMALL)) {
			System.out.println("Test1 Reverse Sorted: PASS");
		} else {
			System.out.println("Test1 Reverse Sorted: FAIL");
		}
		list.clear();
		for(int i=0; i<size; i++) {
			list.add(i);
		}
		if(Quiz2.countInversions(list) == TEST2) {
			System.out.println("Test2 Sorted: PASS");
		} else {
			System.out.println("Test2 Sorted: FAIL");
		}
		Random rand = new Random(SEED);
		list.clear();
		for(int i=0; i<size; i++) {
			list.add(rand.nextInt(size));
		}
		if(Quiz2.countInversions(list) == (large? TEST3 : TEST3_SMALL)) {
			System.out.println("Test3 Random: PASS");
		} else {
			System.out.println("Test3 Random: FAIL");
		}

		ListInterface<Integer> pairs = new AList<>();
		for(int i=1; i<2*nPairs; i+=2) {
			pairs.add(rand.nextInt(size)+1);
			pairs.add(rand.nextInt(size)+1);
		}
		int inversions = Quiz2.shuffle(list, pairs);
		for(int i=1; i<2*nPairs; i+=2) {
			int pos1 = pairs.getEntry(i);
			int pos2 = pairs.getEntry(i+1);
			if (!(((pos1 < pos2)||(list.getEntry(pos1) <= list.getEntry(pos2))) ||
					((pos2 < pos1)||(list.getEntry(pos2) <= list.getEntry(pos1))))) {
				System.out.println("Test4 Shuffle: FAIL");
			}
		}
		if(inversions == (large? TEST4 : TEST4_SMALL)) {
			System.out.println("Test4 Shuffle: PASS");
		} else {
			System.out.println("Test4 Shuffle: FAIL");
		}
	}

}
