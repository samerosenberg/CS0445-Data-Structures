
/**
 * This class performs tests on the Quiz 1 extensions
 * to the ArrayBag class.
 *
 * @author Sherif Khattab
 */
public class Quiz1Test {

	private static ArrayBag<String> testBag1 = new ArrayBag<String>();
	private static ArrayBag<String> testBag2 = new ArrayBag<String>(10);
	private static ArrayBag<String> testBag3 = new ArrayBag<String>(10);

	public static void main(String args[]) {
		checkSplitAndAddAll();
	}

	public static void checkSplitAndAddAll() {
		System.out.println("TESTING Splitting and Adding");

		// Check that it works on an empty bag
		System.out.println("Checking to see that we can split an empty bag and "
				+ "still have an empty bag");
		testBag1.clear();
		check();
		/*System.out.println(testBag1.toString());
		System.out.println(testBag1.toString());*/



		// Check that it works on a bag with a single item
		System.out.println("Checking to see that we can split "
				+ "a singleton bag");
		testBag1.add("Singleton");
		check();

		testBag1.clear();
		testBag2.clear();
		testBag3.clear();

		// Check that it works on a bag with two copies of the same item
		System.out.println("Checking to see we can split a bag of two duplicates sucessfully");
		testBag1.add("A");
		testBag1.add("A");
		check();

		testBag1.clear();
		testBag2.clear();
		testBag3.clear();

		// Check that it works on a bag with three copies of the same item
		System.out.println("Checking to see we can split a bag of three duplicates sucessfully");
		testBag1.add("A");
		testBag1.add("A");
		testBag1.add("A");
		check();
		testBag1.clear();
		testBag2.clear();
		testBag3.clear();

		// Check that it works on a bag with 10 items
		System.out.println("Checking to see we can split a bag with 10 items");
		for(int i=0; i<10; i++)
			testBag1.add("A");

		check();


		// Check that it doesn't works with 20 items
		System.out.println("Checking to see we cannot split a bag with 20 items");
		for(int i=0; i<20; i++)
			testBag1.add("A");
		if(!testBag1.splitInto(testBag2, testBag3)){
			System.out.println("    Passed test");
		} else {
			System.out.println("*** Failed test");
		}
		System.out.println();
	}
	static private void check() {
		testBag1.splitInto(testBag2, testBag3);
		testBag2.addAll(testBag3);
		if (testBag2.equals(testBag1)) {
			System.out.println("    Passed test");
		} else {
			System.out.println("*** Failed test");
		}
		System.out.println();
	}
}
