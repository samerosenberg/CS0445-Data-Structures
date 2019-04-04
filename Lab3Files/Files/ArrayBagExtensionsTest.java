
/**
 * This class performs tests on the extensions to the ArrayBag class.
 * 
 * @author Charles Hoot
 * @version 4.0
 */
public class ArrayBagExtensionsTest {

    private static ArrayBag<String> testBag1 = new ArrayBag<String>();
    private static ArrayBag<String> testBag2 = new ArrayBag<String>();
    private static ArrayBag<String> testBag3 = new ArrayBag<String>();
    private static ArrayBag<String> testBag4 = new ArrayBag<String>();
    private static ArrayBag<String> testBag5 = new ArrayBag<String>();
    private static ArrayBag<String> testBag6 = new ArrayBag<String>();
    private static ArrayBag<String> testBag7 = new ArrayBag<String>();
    private static ArrayBag<String> testBag8 = new ArrayBag<String>();
    private static ArrayBag<String> testBag9 = new ArrayBag<String>();
    private static ArrayBag<String> testBag10 = new ArrayBag<String>();
    private static ArrayBag<String> testBag11 = new ArrayBag<String>(35);
    private static ArrayBag<String> testBag12 = new ArrayBag<String>(35);
    private static ArrayBag<String> testBag13 = new ArrayBag<String>();
    private static ArrayBag<String> testBag14 = new ArrayBag<String>();
    private static ArrayBag<String> testBag15 = new ArrayBag<String>();
    private static ArrayBag<String> testBag16 = new ArrayBag<String>();
    private static ArrayBag<String> testBag17 = new ArrayBag<String>();
    private static ArrayBag<String> testBag18 = new ArrayBag<String>();
    private static ArrayBag<String> testBag19 = new ArrayBag<String>();
    private static ArrayBag<String> testBag20 = new ArrayBag<String>();
    private static ArrayBag<String> testBag21 = new ArrayBag<String>();
    private static ArrayBag<String> testBag22 = new ArrayBag<String>();
    private static ArrayBag<String> testBag23 = new ArrayBag<String>();
    private static ArrayBag<String> testBag24 = new ArrayBag<String>();
    private static ArrayBag<String> testBag25 = new ArrayBag<String>(10);
    private static ArrayBag<String> testBag26 = new ArrayBag<String>(10);
    private static ArrayBag<String> testBag27 = new ArrayBag<String>(10);
    private static ArrayBag<String> testBag28 = new ArrayBag<String>(10);
    private static ArrayBag<String> testBag29 = new ArrayBag<String>(10);
    private static ArrayBag<String> testBag30 = new ArrayBag<String>(10);
    private static ArrayBag<String> testBag31 = new ArrayBag<String>();
    private static ArrayBag<String> testBag32 = new ArrayBag<String>();
    private static ArrayBag<String> testBag33 = new ArrayBag<String>();
    private static ArrayBag<String> testBag34 = new ArrayBag<String>();
    private static ArrayBag<String> testBag35 = new ArrayBag<String>(50);
    private static ArrayBag<String> testBag36 = new ArrayBag<String>();
    private static ArrayBag<String> testBag37 = new ArrayBag<String>(50);

    public static void main(String args[]) {        
        checkRemoveDuplicates();
    }

    public static void initializeBags() {
        testBag1.clear();
        testBag1.add("Jack");
        testBag1.add("Jill");
        testBag1.add("John");
        testBag1.add("Jack");

        // Same as testBag1
        testBag2.clear();
        testBag2.add("Jack");
        testBag2.add("Jill");
        testBag2.add("John");
        testBag2.add("Jack");

        // Same as testBag1 different add order
        testBag3.clear();
        testBag3.add("Jill");
        testBag3.add("John");
        testBag3.add("Jack");
        testBag3.add("Jack");


        // Same as testBag1 but missing an item
        testBag4.clear();
        testBag4.add("Jack");
        testBag4.add("Jill");
        testBag4.add("Jack");

        // Same as testBag1 but missing a duplicate
        testBag5.clear();
        testBag5.add("Jack");
        testBag5.add("John");
        testBag5.add("Jill");

        // Same as testBag1 but has an extra duplicate
        testBag6.clear();
        testBag6.add("John");
        testBag6.add("Jack");
        testBag6.add("Jill");
        testBag6.add("Jack");
        testBag6.add("Jill");

        // Same as testBag1 but has mismatched frequencies, size is the same
        testBag7.clear();
        testBag7.add("John");
        testBag7.add("Jack");
        testBag7.add("Jill");
        testBag7.add("Jill");


        // A bag with one item
        testBag8.clear();
        testBag8.add("check");

        // A bag with unique values
        testBag9.clear();
        testBag9.add("A");
        testBag9.add("B");
        testBag9.add("C");
        testBag9.add("D");
        testBag9.add("E");
        testBag9.add("F");
        testBag9.add("G");
        testBag9.add("H");
        testBag9.add("I");
        testBag9.add("J");
        testBag9.add("K");

        // Same as the previous bag
        testBag10.clear();
        testBag10.add("A");
        testBag10.add("B");
        testBag10.add("C");
        testBag10.add("D");
        testBag10.add("E");
        testBag10.add("F");
        testBag10.add("G");
        testBag10.add("H");
        testBag10.add("I");
        testBag10.add("J");
        testBag10.add("K");

        // A bag with 5 duplicates of each item
        testBag11.clear();
        testBag11.add("U");
        testBag11.add("U");
        testBag11.add("V");
        testBag11.add("W");
        testBag11.add("X");
        testBag11.add("Y");
        testBag11.add("Z");
        testBag11.add("X");
        testBag11.add("Y");
        testBag11.add("Z");
        testBag11.add("U");
        testBag11.add("V");
        testBag11.add("W");
        testBag11.add("U");
        testBag11.add("V");
        testBag11.add("V");
        testBag11.add("W");
        testBag11.add("W");
        testBag11.add("X");
        testBag11.add("X");
        testBag11.add("Y");
        testBag11.add("Y");
        testBag11.add("Z");
        testBag11.add("Z");
        testBag11.add("U");
        testBag11.add("V");
        testBag11.add("W");
        testBag11.add("X");
        testBag11.add("Y");
        testBag11.add("Z");

        // An empty bag to use to place items
        testBag12.clear();

        // A bag of items
        testBag13.clear();
        testBag13.add("A");
        testBag13.add("B");
        testBag13.add("C");
        testBag13.add("X");
        testBag13.add("Y");
        testBag13.add("Z");
        testBag13.add("X");
        testBag13.add("Y");
        testBag13.add("Z");

        // Same as the previous bag
        testBag14.clear();
        testBag14.add("A");
        testBag14.add("B");
        testBag14.add("C");
        testBag14.add("X");
        testBag14.add("Y");
        testBag14.add("Z");
        testBag14.add("X");
        testBag14.add("Y");
        testBag14.add("Z");




        // A couple empty bags
        testBag15.clear();
        testBag16.clear();

        // Bag of values
        testBag17.clear();
        testBag17.add("L");
        testBag17.add("M");
        testBag17.add("N");
        testBag17.add("O");
        testBag17.add("P");
        testBag17.add("Q");
        testBag17.add("R");
        testBag17.add("S");
        testBag17.add("T");

        // Same as the previous bag
        testBag18.clear();
        testBag18.add("L");
        testBag18.add("M");
        testBag18.add("N");
        testBag18.add("O");
        testBag18.add("P");
        testBag18.add("Q");
        testBag18.add("R");
        testBag18.add("S");
        testBag18.add("T");


        // Bag with one item
        testBag19.clear();
        testBag19.add("Jack");

        // Duplicate of the previous bag
        testBag20.clear();
        testBag20.add("Jack");
        testBag20.add("Jack");

        // Bag with one item
        testBag21.clear();
        testBag21.add("Jack");
        testBag21.add("Jill");

        // Duplicate of the previous bag
        testBag22.clear();
        testBag22.add("Jack");
        testBag22.add("Jill");
        testBag22.add("Jack");
        testBag22.add("Jill");

        // General bag
        testBag23.clear();
        testBag23.add("A");
        testBag23.add("B");
        testBag23.add("A");
        testBag23.add("B");
        testBag23.add("C");
        testBag23.add("D");
        testBag23.add("D");
        testBag23.add("A");
        testBag23.add("B");

        // duplicate of the previous bag
        testBag24.clear();
        testBag24.add("A");
        testBag24.add("B");
        testBag24.add("A");
        testBag24.add("B");
        testBag24.add("C");
        testBag24.add("D");
        testBag24.add("D");
        testBag24.add("A");
        testBag24.add("B");
        testBag24.add("A");
        testBag24.add("B");
        testBag24.add("C");
        testBag24.add("D");
        testBag24.add("D");
        testBag24.add("A");
        testBag24.add("B");
        testBag24.add("A");
        testBag24.add("B");

        // A bag that is just under half capacity
        testBag25.clear();
        testBag25.add("A");
        testBag25.add("B");
        testBag25.add("A");
        testBag25.add("B");

        // Duplicate all result for previous
        testBag26.clear();
        testBag26.add("A");
        testBag26.add("B");
        testBag26.add("A");
        testBag26.add("B");
        testBag26.add("A");
        testBag26.add("B");
        testBag26.add("A");
        testBag26.add("B");

        // A bag that is exactly at half capacity
        testBag27.clear();
        testBag27.add("A");
        testBag27.add("B");
        testBag27.add("A");
        testBag27.add("B");
        testBag27.add("C");

        // Duplicate all result for previous
        testBag28.clear();
        testBag28.add("A");
        testBag28.add("B");
        testBag28.add("A");
        testBag28.add("B");
        testBag28.add("A");
        testBag28.add("B");
        testBag28.add("A");
        testBag28.add("B");
        testBag28.add("C");
        testBag28.add("C");

        // A bag that is just over half capacity
        testBag29.clear();
        testBag29.add("A");
        testBag29.add("B");
        testBag29.add("A");
        testBag29.add("B");
        testBag29.add("C");
        testBag29.add("C");

        // Duplicate all result for previous
        testBag30.clear();
        testBag30.add("A");
        testBag30.add("B");
        testBag30.add("A");
        testBag30.add("B");
        testBag30.add("C");
        testBag30.add("C");

        // A bag with a single item
        testBag31.clear();
        testBag31.add("A");

        // Same bag as before to check against
        testBag32.clear();
        testBag32.add("A");

// A bag with two duplicates
        testBag33.clear();
        testBag33.add("A");
        testBag33.add("A");

        // A bag with three duplicate
        testBag34.clear();
        testBag34.add("A");
        testBag34.add("A");
        testBag34.add("A");

        // A bag with some items duplicated
        testBag35.clear();
        testBag35.add("G");
        testBag35.add("H");
        testBag35.add("G");
        testBag35.add("H");
        testBag35.add("A");
        testBag35.add("B");
        testBag35.add("C");
        testBag35.add("D");
        testBag35.add("G");
        testBag35.add("A");
        testBag35.add("B");
        testBag35.add("C");
        testBag35.add("D");
        testBag35.add("G");
        testBag35.add("H");
        testBag35.add("A");
        testBag35.add("B");
        testBag35.add("C");
        testBag35.add("I");
        testBag35.add("D");
        testBag35.add("G");
        testBag35.add("H");
        testBag35.add("A");
        testBag35.add("B");
        testBag35.add("C");
        testBag35.add("D");
        testBag35.add("E");
        testBag35.add("F");
        testBag35.add("G");
        testBag35.add("H");


        // The previous bag with duplicates removed
        testBag36.clear();
        testBag36.add("A");
        testBag36.add("B");
        testBag36.add("C");
        testBag36.add("D");
        testBag36.add("E");
        testBag36.add("G");
        testBag36.add("F");
        testBag36.add("H");
        testBag36.add("I");

        // The previous bag with every item duplicated
        testBag37.clear();
        testBag37.add("A");
        testBag37.add("A");
        testBag37.add("A");
        testBag37.add("A");
        testBag37.add("A");
        testBag37.add("B");
        testBag37.add("C");
        testBag37.add("D");
        testBag37.add("E");
        testBag37.add("G");
        testBag37.add("F");
        testBag37.add("H");
        testBag37.add("B");
        testBag37.add("C");
        testBag37.add("D");
        testBag37.add("E");
        testBag37.add("G");
        testBag37.add("F");
        testBag37.add("D");
        testBag37.add("E");
        testBag37.add("G");
        testBag37.add("F");
        testBag37.add("F");
        testBag37.add("D");
        testBag37.add("E");
        testBag37.add("G");
        testBag37.add("F");
        testBag37.add("F");
        testBag37.add("D");
        testBag37.add("E");
        testBag37.add("G");
        testBag37.add("F");
        testBag37.add("D");
        testBag37.add("E");
        testBag37.add("G");
        testBag37.add("F");
        testBag37.add("H");
        testBag37.add("I");
        testBag37.add("I");
        testBag37.add("I");
        testBag37.add("I");


        System.out.println();
    }

    

    public static void checkRemoveDuplicates() {
        initializeBags();

        System.out.println("TESTING REMOVE DUPLICATES");

        // Check that it works on an empty bag
        System.out.println("Checking to see that we can remove duplicates on an empty bag and still have an empty bag");
        testBag15.removeDuplicates();
        if (testBag15.equals(testBag16)) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");

        }
       System.out.println();
 

        // Check that it works on a bag with a single item
        System.out.println("Checking to see that we can remove duplicates on a singleton bag and still have the same singleton bag");
        testBag31.removeDuplicates();
        if (testBag31.equals(testBag32)) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");

        }
       System.out.println();
 
        // Check that it works on a bag with two copies of the same item
        System.out.println("Checking to see a bag of two duplicates sucessfully becomes the correct singleton bag");
        testBag33.removeDuplicates();
        if (testBag33.equals(testBag32)) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");

        }
       System.out.println();
 
        // Check that it works on a bag with three copies of the same item
        System.out.println("Checking to see a bag of three duplicates sucessfully becomes the correct singleton bag");
        testBag34.removeDuplicates();
        if (testBag34.equals(testBag32)) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");

        }
       System.out.println();
 
        // Check that it works on a bag with multiple items, but no duplicates
        System.out.println("Checking to see a bag with no duplicates remains the same");
        testBag9.removeDuplicates();
        if (testBag9.equals(testBag10)) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");

        }
       System.out.println();
 

        // Check that it works on a bag where some itmes are duplicated
        System.out.println("Checking a bag with some items duplicated to see that duplicates are removed");
        testBag35.removeDuplicates();
        if (testBag35.equals(testBag36)) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");

        }
       System.out.println();
 

        // Check that it works on a bag where every itme is duplicated
        System.out.println("Checking a bag with all items duplicated to see that duplicates are removed");
        testBag37.removeDuplicates();
        if (testBag37.equals(testBag36)) {
            System.out.println("    Passed test");
        } else {
            System.out.println("*** Failed test");

        }





        System.out.println();
    }
}
