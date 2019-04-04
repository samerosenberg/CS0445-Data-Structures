/** CS 0445 Spring 2018 (Adapted  from Dr. John Ramirez's assignment code)
 Test program for your ReallyLongHex class -- for full credit you CANNOT MODIFY
 this code in ANY WAY.

 This program should execute without error and produce output identical to
 the output in the file RLITest.txt.  If your output does not match mine, think
 carefully about what your operations are doing and trace them to find the
 problem.

 If your output does not match mine, or if you must change this file to get
 your code to work, you will lose credit, but you can still get PARTIAL
 credit for your work, so be sure to turn something in no matter what!
*/

import java.util.*;

public class RLHTest
{
	public static void main (String [] args)
	{
		ReallyLongHex R1 = new ReallyLongHex("123456789ABCDEF");
		ReallyLongHex R2 = new ReallyLongHex("FEDCBA987654321");
		System.out.println("R1 = " + R1.toString());
		System.out.println("R2 = " + R2.toString());
		System.out.println();
		
		// Testing add method
		ReallyLongHex R3 = R1.add(R2);
		System.out.println(R1 + " + " + R2 + " = " + R3);
		R1 = new ReallyLongHex("1");
		R2 = new ReallyLongHex("FFFFFFFFFFFFFFF");
		R3 = R1.add(R2);
		ReallyLongHex R4 = R2.add(R1);
		System.out.println(R1 + " + " + R2 + " = " + R3);
		System.out.println(R2 + " + " + R1 + " = " + R4);
		System.out.println();
		
		// Testing subtract method
		R1 = new ReallyLongHex("23456");
		R2 = new ReallyLongHex("4567");
		R3 = R1.subtract(R2);
		System.out.println(R1 + " - " + R2 + " = " + R3);
		R1 = new ReallyLongHex("1000000");
		R2 = new ReallyLongHex("1");
		R3 = R1.subtract(R2);
		System.out.println(R1 + " - " + R2 + " = " + R3);
		R1 = new ReallyLongHex("123456");
		R2 = new ReallyLongHex("123455");
		R3 = R1.subtract(R2);
		System.out.println(R1 + " - " + R2 + " = " + R3);
		R1 = new ReallyLongHex("1000");
		R2 = new ReallyLongHex("1001");
		try
		{
			R3 = R1.subtract(R2);
		}
		catch (ArithmeticException e)
		{
			System.out.println(e);
		}
		System.out.println();

		// Testing copy constructor
		ReallyLongHex R5 = new ReallyLongHex(R4);
		System.out.println("Copy of " + R4.toString() + " = " + R5.toString());
		System.out.println();
		
		// Testing compareTo
		ReallyLongHex [] C = new ReallyLongHex[4];
		C[0] = new ReallyLongHex("844444444444444");
		C[1] = new ReallyLongHex("744444444444444");
		C[2] = new ReallyLongHex("844444445444444");
		C[3] = new ReallyLongHex("4444");
		for (int i = 0; i < C.length; i++)
		{
			for (int j = 0; j < C.length; j++)
			{
				int ans = C[i].compareTo(C[j]);
				if (ans < 0)
					System.out.println(C[i] + " < " + C[j]);
				else if (ans > 0)
					System.out.println(C[i] + " > " + C[j]);
				else
					System.out.println(C[i] + " == " + C[j]);
			}
		}
		System.out.println();
		Arrays.sort(C);
		System.out.println("Here is the sorted array: ");
		for (ReallyLongHex R: C)
			System.out.println(R);
		System.out.println();

		// Testing equals
		R1 = new ReallyLongHex("12345678987654321");
		R2 = new ReallyLongHex("12345678987654321");
		R3 = new ReallyLongHex("12345678907654321");
		if (R1.equals(R2))
			System.out.println(R1 + " equals " + R2);
		if (!R1.equals(R3))
			System.out.println(R1 + " does not equal " + R3);
		System.out.println();

		// Testing shift operations
		R1 = new ReallyLongHex("1234567");
		System.out.println(R1);
		R1.mult16ToThe(6);
		System.out.println(R1);
		R1.div16ToThe(8);
		System.out.println(R1);
		System.out.println();
		
	}
}
