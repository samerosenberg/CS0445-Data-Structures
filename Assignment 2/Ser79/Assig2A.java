/** CS 0445 Spring 2018 (Adapted  from Dr. John Ramirez's assignment code)

 Test program for your LinkedDS class -- for full credit you CANNOT MODIFY
 this code in ANY WAY.

 This program should execute without error and produce output identical to
 the output shown in the file A2Out.txt.  If your output does not match mine,
 think carefully about what your operations are doing and trace them to find the
 problem.

 If your output does not match mine, or if you must change this file to get
 your code to work, you will lose credit, but you can still get PARTIAL
 credit for your work, so be sure to turn something in no matter what!
*/

public class Assig2A
{
	static final String [] data = {"Tori", "Sarah", "Kate", "Aimee", "Shirley",
							"Chrissy", "Debbie", "Alanis", "Courtney", "Sinead"};

	public static void main (String [] args)
	{
		// Testing constructor
		LinkedDS<Integer> L1 = new LinkedDS<>();
		for (int i = 0; i < 10; i++)
		{
			L1.addItem(i);
		}
		System.out.println("L1: " + L1.toString());

		// Testing copy constructor
		LinkedDS<Integer> L2 = new LinkedDS<>(L1);
		System.out.println("L2: " + L2.toString());


		// Testing shift and rotate methods
		System.out.println("L1.leftShift(2)");
		L1.leftShift(2);
		System.out.println("\tL1: " + L1.toString());

		System.out.println("L2.rightShift(3)");
		L2.rightShift(3);
		System.out.println("\tL2: " + L2.toString());

		System.out.println("L1.leftRotate(4)");
		L1.leftRotate(4);
		System.out.println("\tL1: " + L1.toString());
		System.out.println("L2.rightRotate(2)");
		L2.rightRotate(2);
		System.out.println("\tL2: " + L2.toString());

		System.out.println("Reversing L1");
		L1.reverse();
		System.out.println("\tL1: " + L1.toString());
		System.out.println("Reversing L1 again");
		L1.reverse();
		System.out.println("\tL1: " + L1.toString());
		System.out.println();

		// Testing removeItem
		while (!(L2.empty()))
		{
			Integer oldItem = L2.removeItem();
			System.out.println(oldItem + " retrieved from Q");
		}
		Integer noItem = L2.removeItem();
		if (noItem == null)
			System.out.println("Nothing in the Q");



		// Note that rotating is not limited to the length of the list.  If the
		// rotation is greater than the length of the list it should "wrap" as many
		// times as necessary.  However,  do not rotate unnecessarily -- think about
		// how you can do this very efficiently.  Also note that negative rotations
		// work as expected!
		LinkedDS<String> L3 = new LinkedDS<>();
		LinkedDS<String> L4 = new LinkedDS<>();
		LinkedDS<String> L5 = new LinkedDS<>();
		for (int i = 0; i < data.length; i++)
		{
			L3.addItem(data[i]);
			L4.addItem(data[i]);
			L5.addItem(data[i]);
		}
		System.out.println("L3: " + L3.toString());
		System.out.println("L3.leftRotate(9)");
		L3.leftRotate(9);
		System.out.println("\tL3: " + L3.toString());

		System.out.println("L4: " + L4.toString());
		System.out.println("L4.leftRotate(10)");
		L4.leftRotate(10);
		System.out.println("\tL4: " + L4.toString());

		System.out.println("L5: " + L5.toString());
		System.out.println("L5.leftRotate(11)");
		L5.leftRotate(11);
		System.out.println("\tL5: " + L5.toString());

		System.out.println("L4.rightRotate(22)");
		L4.rightRotate(22);
		System.out.println("\tL4: " + L4.toString());
		System.out.println("L4.rightRotate(-3)");
		L4.rightRotate(-3);
		System.out.println("\tL4: " + L4.toString());
		System.out.println("L4.leftRotate(-4)");
		L4.leftRotate(-4);
		System.out.println("\tL4: " + L4.toString());


	}
}
