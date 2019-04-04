import java.util.*;
import java.io.*;

public class Tester {
  private static int trials;
  private static int size;
  private static Quick quick = new Quick();
  private static TextMergeQuick mquick = new TextMergeQuick();
  private static BufferedWriter writer;

  public static void main(String[] args) throws IOException{

    /*
    To-do
      -make excel sheet
      -submit

     */

    Scanner scan = new Scanner(System.in);
    System.out.println("Enter Array size: ");
    size = scan.nextInt();
    System.out.println("Enter number of trials: ");
    trials = scan.nextInt();

    Integer[] sorted= generateSortedArray(size);
    Integer[] reverse= generateReverseSortedArray(size);
    Integer[] random = generateRandomArray(size);
    long total=0;
    /*print(random);
    System.out.println();
    mquick.iterativeMsort(random);
    print(random);*/



  if(size<=20){
    for(int i=0;i<trials;i++){
      random = generateRandomArray(size);
      Integer[] qs1Random = new Integer[size];
      System.arraycopy(random,0,qs1Random,0,random.length);
      Integer[] qs2Random = new Integer[size];
      System.arraycopy(random,0,qs2Random,0,random.length);
      Integer[] qs3Random = new Integer[size];
      System.arraycopy(random,0,qs3Random,0,random.length);
      Integer[] qs4Random = new Integer[size];
      System.arraycopy(random,0,qs4Random,0,random.length);
      Integer[] qs5Random = new Integer[size];
      System.arraycopy(random,0,qs5Random,0,random.length);
      Integer[] qs6Random = new Integer[size];
      System.arraycopy(random,0,qs6Random,0,random.length);
      Integer[] qs7Random = new Integer[size];
      System.arraycopy(random,0,qs7Random,0,random.length);
      Integer[] qs8Random = new Integer[size];
      System.arraycopy(random,0,qs8Random,0,random.length);
      Integer[] qs9Random = new Integer[size];
      System.arraycopy(random,0,qs9Random,0,random.length);

      qs1TO(sorted, reverse,qs1Random);
      reverse= generateReverseSortedArray(size);

      qs2TO(sorted, reverse,qs2Random);
      reverse= generateReverseSortedArray(size);

      qs3TO(sorted, reverse,qs3Random);
      reverse= generateReverseSortedArray(size);

      qs4TO(sorted, reverse,qs4Random);
      reverse= generateReverseSortedArray(size);

      qs5TO(sorted, reverse,qs5Random);
      reverse= generateReverseSortedArray(size);

      qs6TO(sorted, reverse,qs6Random);
      reverse= generateReverseSortedArray(size);

      qs7TO(sorted, reverse,qs7Random);
      reverse= generateReverseSortedArray(size);

      qs8TO(sorted, reverse,qs8Random);
      reverse= generateReverseSortedArray(size);

      qs9TO(sorted, reverse,qs9Random);

    }
  }else{

    System.out.println("Enter file name: ");
    String filename = scan.next();
    writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));

    //commented to run large array runs
  /*for(int i=0;i<trials;i++){
    random = generateRandomArray(size);
    long start = System.nanoTime();
    quick.quickSort( random , random.length);
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs1R(total,random);total=0;*/


  for(int i=0;i<trials;i++){
    mquick.changeMinSize(5);
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.quickSort( random , random.length);
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs2R(total,random);total=0;

  for(int i=0;i<trials;i++){
    mquick.changeMinSize(20);
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.quickSort( random , random.length);
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs3R(total,random);total=0;

  for(int i=0;i<trials;i++){
    mquick.changeMinSize(100);
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.quickSort( random , random.length);
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs4R(total,random);total=0;

  for(int i=0;i<trials;i++){
    mquick.changeMinSize(5);
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.randomquickSort( random , random.length);
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs5R(total,random);total=0;

  for(int i=0;i<trials;i++){
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.iterativeQsort( random );
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs6R(total,random);total=0;

  for(int i=0;i<trials;i++){
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.mergeSort( random , random.length);
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs7R(total,random);total=0;

  for(int i=0;i<trials;i++){
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.iterativeMergeSort( random , random.length);
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs8R(total,random);total=0;

  for(int i=0;i<trials;i++){
    random = generateRandomArray(size);
    long start = System.nanoTime();
    mquick.iterativeMsort( random );
    long finish = System.nanoTime();
    long delta = finish-start;
    total+=delta;
  }qs9R(total,random);total=0;

    //qs1(sorted,"Sorted");
    qs2(sorted,"Sorted");
    qs3(sorted,"Sorted");
    qs4(sorted,"Sorted");
    qs5(sorted,"Sorted");
    qs6(sorted,"Sorted");
    qs7(sorted,"Sorted");
    qs8(sorted,"Sorted");
    qs9(sorted,"Sorted");

    //qs1(reverse,"Reverse");
    qs2(reverse,"Reverse");
    qs3(reverse,"Reverse");
    qs4(reverse,"Reverse");
    qs5(reverse,"Reverse");
    qs6(reverse,"Reverse");
    qs7(reverse,"Reverse");
    qs8(reverse,"Reverse");
    qs9(reverse,"Reverse");

    writer.close();
  }


  }
  private static Integer[] generateRandomArray(int size){
    ArrayList<Integer> stuffs = new ArrayList<Integer>(size);
    for(int i=0;i<size;i++){
      stuffs.add(i+1);
    }
    Integer arr[] = new Integer[size];
    int pointer=0;
    while(stuffs.size()>0 && pointer<arr.length){
      Random rand  = new Random();
      int i = rand.nextInt(stuffs.size());
      arr[pointer]= stuffs.get(i);
      stuffs.remove(i);
      pointer++;
    }
    return arr;
  }
  private static Integer[] generateSortedArray(int size){
    Integer a[] = new Integer[size];
    for(int i=0;i<a.length;i++){
      a[i] =i+1;
    }
    return a;
  }
  private static Integer[] generateReverseSortedArray(int size){
    Integer a[] = new Integer[size];
    int count =size;
    for(int i=0;i<a.length;i++){
      a[i] = count;
      count--;
    }
    return a;
  }
  private static void print(Integer[] a){
    for(int i=0;i<a.length;i++){
      System.out.print(a[i] +" ");
    }
  }
  private static void qs1(Integer[] a,String order)throws IOException{
    writer.write("Algorithm: Quick Sort\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      quick.quickSort( a , a.length);
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ quick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ quick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    quick.reset();
  }
  private static void qs1R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Quick Sort\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ quick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ quick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs1TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      System.out.println();
      System.out.println("Algorithm: Quick Sort");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      quick.quickSort( sorted , sorted.length);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      quick.quickSort( reverse , reverse.length);
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      quick.quickSort( random , random.length);
      print(random);
        System.out.println();
    }
  private static void qs2(Integer[] a, String order)throws IOException{
    mquick.changeMinSize(5);
    writer.write("Algorithm: Median of 3 Quick Sort(5)"+"\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      mquick.quickSort( a , a.length);
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    mquick.reset();
  }
  private static void qs2R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Median of 3 Quick Sort(5)\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs2TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      mquick.changeMinSize(5);
      System.out.println();
      System.out.println("Algorithm: Median of 3 Quick Sort(5)");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      mquick.quickSort( sorted , sorted.length);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      mquick.quickSort( reverse , reverse.length);
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      mquick.quickSort( random , random.length);
      print(random);
        System.out.println();
    }
  private static void qs3(Integer[] a, String order)throws IOException{
    mquick.changeMinSize(20);
    writer.write("Algorithm: Median of 3 Quick Sort(20)"+"\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      mquick.quickSort( a , a.length);
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    mquick.reset();
  }
  private static void qs3R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Median of 3 Quick Sort(20)\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs3TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      mquick.changeMinSize(20);
      System.out.println();
      System.out.println("Algorithm: Median of 3 Quick Sort(20)");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      mquick.quickSort( sorted , sorted.length);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      mquick.quickSort( reverse , reverse.length);
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      mquick.quickSort( random , random.length);
      print(random);
        System.out.println();
    }
  private static void qs4(Integer[] a, String order)throws IOException{
    mquick.changeMinSize(100);
    writer.write("Algorithm: Median of 3 Quick Sort(100)"+"\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      mquick.quickSort( a , a.length);
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    mquick.reset();
  }
  private static void qs4R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Median of 3 Quick Sort(100)\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs4TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      mquick.changeMinSize(100);
      System.out.println();
      System.out.println("Algorithm: Median of 3 Quick Sort(100)");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      mquick.quickSort( sorted , sorted.length);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      mquick.quickSort( reverse , reverse.length);
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      mquick.quickSort( random , random.length);
      print(random);
      System.out.println();
    }
  private static void qs5(Integer[] a, String order)throws IOException{
    mquick.changeMinSize(5);
    writer.write("Algorithm: Random Pivot Quick Sort"+"\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      mquick.randomquickSort( a , a.length);
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    mquick.reset();
  }
  private static void qs5R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Random Pivot Quick Sort\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs5TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      System.out.println();
      System.out.println("Algorithm: Random Pivot Quick Sort");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      mquick.randomquickSort( sorted , sorted.length);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      mquick.randomquickSort( reverse , reverse.length);
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      mquick.randomquickSort( random , random.length);
      print(random);
        System.out.println();
    }
  private static void qs6(Integer[] a, String order)throws IOException{
    writer.write("Algorithm: Iterative Quick Sort"+"\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      mquick.iterativeQsort( a );
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    mquick.reset();
  }
  private static void qs6R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Iterative Quick Sort\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs6TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      System.out.println();
      System.out.println("Algorithm: Iterative Quick Sort");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      mquick.iterativeQsort( sorted);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      mquick.iterativeQsort( reverse );
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      mquick.iterativeQsort( random );
      print(random);
        System.out.println();
    }
  private static void qs7(Integer[] a, String order)throws IOException{
    writer.write("Algorithm: Merge Sort"+"\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      mquick.mergeSort( a , a.length);
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    mquick.reset();
  }
  private static void qs7R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Merge Sort\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs7TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      System.out.println();
      System.out.println("Algorithm: Merge Sort");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      mquick.mergeSort( sorted , sorted.length);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      mquick.mergeSort( reverse , reverse.length);
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      mquick.mergeSort( random , random.length);
      print(random);
        System.out.println();
    }
  private static void qs8(Integer[] a, String order)throws IOException{
    writer.write("Algorithm: Iterative Merge Sort"+"\n");
    writer.write("Array size: "+a.length+"\n");
    writer.write("Order: "+order+"\n");
    writer.write("Number of trials: "+trials+"\n");
    long total =0;
    for(int i=0;i<trials;i++){
      if(order.equals("Reverse"))
        a = generateReverseSortedArray(a.length);
      long start = System.nanoTime();
      mquick.iterativeMergeSort( a , a.length);
      long finish = System.nanoTime();
      long delta = finish-start;
      total+=delta;
    }
    writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
    writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
    writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
    writer.write('\n');
    mquick.reset();
  }
  private static void qs8R(long time, Integer[] a)throws IOException{
      writer.write("Algorithm: Iterative Merge Sort\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: Random\n");
      writer.write("Number of trials: "+trials+"\n");
      writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      quick.reset();
    }
    private static void qs8TO(Integer[] sorted,Integer[] reverse, Integer[] random){
      System.out.println();
      System.out.println("Algorithm: Iterative Merge Sort");
      System.out.println("Array size: "+sorted.length);
      System.out.println("Sorted Run:");
      print(sorted);
      System.out.println();
      mquick.iterativeMergeSort( sorted , sorted.length);
      print(sorted);
      System.out.println("\nReverse Run:");
      print(reverse);
      System.out.println();
      mquick.iterativeMergeSort( reverse , reverse.length);
      print(reverse);
      System.out.println("\nRandom Run:");
      print(random);
      System.out.println();
      mquick.iterativeMergeSort( random , random.length);
      print(random);
        System.out.println();
    }
    private static void qs9(Integer[] a, String order)throws IOException{
      writer.write("Algorithm: My Iterative Merge Sort"+"\n");
      writer.write("Array size: "+a.length+"\n");
      writer.write("Order: "+order+"\n");
      writer.write("Number of trials: "+trials+"\n");
      long total =0;
      for(int i=0;i<trials;i++){
        if(order.equals("Reverse"))
          a = generateReverseSortedArray(a.length);
        long start = System.nanoTime();
        mquick.iterativeMsort( a );
        long finish = System.nanoTime();
        long delta = finish-start;
        total+=delta;
      }
      writer.write("Average Time: "+ (total/trials)/1000000000.0 +" seconds"+"\n");
      writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
      writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
      writer.write('\n');
      mquick.reset();
    }
    private static void qs9R(long time, Integer[] a)throws IOException{
        writer.write("Algorithm: My Iterative Merge Sort\n");
        writer.write("Array size: "+a.length+"\n");
        writer.write("Order: Random\n");
        writer.write("Number of trials: "+trials+"\n");
        writer.write("Average Time: "+ (time/trials)/1000000000.0 +" seconds"+"\n");
        writer.write("Average number of comparisons: "+ mquick.getComparisons()+" comparisons"+"\n");
        writer.write("Average number of data moves: "+ mquick.getMoves()/trials+" moves"+"\n");
        writer.write('\n');
        quick.reset();
      }
      private static void qs9TO(Integer[] sorted,Integer[] reverse, Integer[] random){
        System.out.println();
        System.out.println("Algorithm: My Iterative Merge Sort");
        System.out.println("Array size: "+sorted.length);
        System.out.println("Sorted Run:");
        print(sorted);
        System.out.println();
        mquick.iterativeMsort( sorted );
        print(sorted);
        System.out.println("\nReverse Run:");
        print(reverse);
        System.out.println();
        mquick.iterativeMsort( reverse);
        print(reverse);
        System.out.println("\nRandom Run:");
        print(random);
        System.out.println();
        mquick.iterativeMsort( random);
        print(random);
      }
  }
