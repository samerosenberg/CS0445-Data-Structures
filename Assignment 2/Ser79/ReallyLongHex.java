/** CS 0445 Spring 2018 (Adapted  from Dr. John Ramirez's assignment code)
 This is a partial implementation of the ReallyLongHex class.  You need to
 complete the implementations of the remaining methods.  Also, for this class
 to work, you must complete the implementation of the LinkedDS class.
 See additional comments below.
*/
public class ReallyLongHex 	extends LinkedDS<Character>
							implements Comparable<ReallyLongHex>
{
	// Instance variables are inherited.  You may not add any new instance variables

	// Default constructor
	private ReallyLongHex()
	{
		super();
	}

	// Note that we are adding the digits here in the END. This results in the
    // MOST significant digit first in the chain.
    // It is assumed that String s is a valid representation of an
	// unsigned integer with no leading zeros.
	public ReallyLongHex(String s)
	{
		super();
		char c;
		// Iterate through the String, getting each character and adding it
        // at the end of the list.
		for (int i = 0; i < s.length(); i++)
		{
			c = s.charAt(i);
			if ((('0' <= c) && (c <= '9')) || (('A' <= c) && (c <= 'F')))
			{
				this.addItem(c);
			}
			else throw new NumberFormatException("Illegal digit " + c);
		}
	}

	// Simple call to super to copy the nodes from the argument ReallyLongHex
	// into a new one.
	public ReallyLongHex(ReallyLongHex rightOp)
	{
		super(rightOp);
	}

	// Method to put digits of number into a String.  We traverse the chain
    // to add the digits to a StringBuilder.
	public String toString()
	{
		StringBuilder sb = new StringBuilder();
		if (numOfEntries > 0)
		{
			sb.append("0x");
			for (Node curr = firstNode; curr != null; curr = curr.getNextNode())
			{
				sb.append(curr.getData());
			}
		}
		return sb.toString();
	}

	// You must implement the methods below.  See the descriptions in the
	// assignment sheet


	/**
	 * Add hexadecimal numbers of this and rightOp
	 * @param  ReallyLongHex rightOp       hexadecimal number to be added to this number
	 * @return               sum of two hexadecimal numbers
	 */
	public ReallyLongHex add(ReallyLongHex rightOp)
	{
		this.reverse();
		rightOp.reverse();
		ReallyLongHex answer = new ReallyLongHex();
		Node thisCN = this.firstNode;
		Node otherCN = rightOp.firstNode;
		int num1 =0;
		int num2 =0;
		int extra =0;
		int num3 =0;
		while((thisCN!=null && otherCN !=null) || extra>0){ // starts off process of going through each node
			 num1 =0;
			 num2 =0;
			//Check if values are chars, then set values to num1 and num2
			if(thisCN!=null && (('A' <= thisCN.getData()) && (thisCN.getData() <= 'F'))){ //checks if value in thisCN is a char
				num1 = convCharToNum(thisCN.getData());
			}else if(thisCN!=null) {//end if
				num1 =  thisCN.getData() -48;
			}//end else
			if(otherCN!=null && (('A' <= otherCN.getData()) && (otherCN.getData() <= 'F'))){// check is value of otherCN is a char
				num2 = convCharToNum(otherCN.getData());
			}//end if
			else if(otherCN!=null){
				num2 = otherCN.getData() -48;
			}//end else

			//get sum of two values and and carry over
			num3 = num1 + num2 + extra;
			extra=0;
			if(num3<=9){ // add num to answer linked list
				String s = ""+num3;
				char temp = s.charAt(0);
				answer.addItem(temp);
			}
			else if(num3>9 && num3<=15){// if num should be character convert and add to ReallyLongHex
				char temp = convNumToChar(num3);
				answer.addItem(temp);
			}
			else{//else set carry over to extra and add remainder to answer
				extra = num3/16;
				num3=num3%16;
				if(num3>9 && num3<=15){
					char temp = convNumToChar(num3);
					answer.addItem(temp);
				}
				else{
					String s = ""+num3;
					char temp = s.charAt(0);
					answer.addItem(temp);
				}
			}
				//Set currentnode to next node in sequence
				if(thisCN!=null)
				thisCN = thisCN.getNextNode();
				if(otherCN!=null)
				otherCN = otherCN.getNextNode();
		}//end while
		if(extra<=9&& extra>0){ // add overflow values from last computation to ll
			String s = ""+extra;
			char temp = s.charAt(0);
			answer.addItem(temp);
		}
		else if(extra>9 && extra<=15){
			char temp = convNumToChar(extra);
			answer.addItem(temp);
		}
		this.reverse();
		rightOp.reverse();
		answer.reverse();
		return answer;
	}
	/**
	 * Subtract hexadecimal number rightOp from this number
	 * @param  ReallyLongHex rightOp       hexadecimal number to be subtracted from this number
	 * @return               difference of hexadecimal numbers
	 */
	public ReallyLongHex subtract(ReallyLongHex rightOp)
	{
		ReallyLongHex answer = new ReallyLongHex();
		if(this.compareTo(rightOp)<0){
			throw new ArithmeticException("Can not be negative");
		}
		this.reverse();
		rightOp.reverse();
		Node thisCN = this.firstNode;
		Node otherCN = rightOp.firstNode;
		int num1 =0;
		int num2 =0;
		int extra =0;
		int num3 =0;
		while((thisCN!=null && otherCN !=null) || extra>0){ // starts off process of going through each node
			 num1 =0;
			 num2 =0;
			//Check if values are chars, then set values to num1 and num2
			if(thisCN!=null && (('A' <= thisCN.getData()) && (thisCN.getData() <= 'F'))){ //checks if value in thisCN is a char
				num1 = convCharToNum(thisCN.getData());
			}else if(thisCN!=null) {//end if
				num1 =  thisCN.getData() -48;
			}//end else
			if(otherCN!=null && (('A' <= otherCN.getData()) && (otherCN.getData() <= 'F'))){// check is value of otherCN is a char
				num2 = convCharToNum(otherCN.getData());
			}//end if
			else if(otherCN!=null){
				num2 = otherCN.getData() -48;
			}//end else
			num3 = num1-num2-extra; //calculate difference
			if(num3<0){ // if diff is less than 0 num1 is smaller than 2 so set up carry and subtract again
				num1+=16;
				num3 = num1-num2-extra;
				extra =1;
			}
			else{
				extra=0;
			}
			if(num3<=9){ // add num to answer linked list
				String s = ""+num3;
				char temp = s.charAt(0);
				answer.addItem(temp);
			}
			else if(num3>9 && num3<=15){// if num should be character convert and add to ReallyLongHex
				char temp = convNumToChar(num3);
				answer.addItem(temp);
			}
			else{//else set carry over to extra and add remainder to answer
				extra = num3/16;
				num3=num3%16;
				if(num3>9 && num3<=15){
					char temp = convNumToChar(num3);
					answer.addItem(temp);
				}
				else{
					String s = ""+num3;
					char temp = s.charAt(0);
					answer.addItem(temp);
				}
			}
				//Set currentnode to next node in sequence
				if(thisCN!=null)
				thisCN = thisCN.getNextNode();
				if(otherCN!=null)
				otherCN = otherCN.getNextNode();
		}//end while

		answer.reverse();
		Node curr = answer.firstNode;
		while(curr.getData()==48){
			answer.removeItem();
			curr = curr.getNextNode();
		}

		this.reverse();
		rightOp.reverse();
		return answer;
	}
	/**
	 * Compare hexadecimal numbers to see which is bigger
	 * @param  ReallyLongHex rOp           number to be compared to this one
	 * @return               positive number if this is greater, 0 if the same, negative if smaller
	 */
	public int compareTo(ReallyLongHex rOp)
	{
		int num =0;
		boolean stillGoing = true;
		if(this.size()> rOp.size())
			num =1;
		if(this.size()<rOp.size())
			num =-1;

		if(this.size()==rOp.size()){
			Node thisCN = firstNode;
			Node otherCN = rOp.firstNode;
			while(stillGoing && (thisCN!=null && otherCN!=null)){
				if(thisCN.getData()>otherCN.getData()){
					num =1;
					stillGoing = false;
				}
				else if(thisCN.getData()<otherCN.getData()){
					num = -1;
					stillGoing = false;
				}
				thisCN = thisCN.getNextNode();
				otherCN = otherCN.getNextNode();
			}
		}
		return num;
	}
	/**
	 * Checks if two hexadecimal numbers are equal
	 * @param  Object rightOp       hexadecimal number to check against
	 * @return        true if equal, otherwise false
	 */
	public boolean equals(Object rightOp)
	{
		ReallyLongHex rOp = (ReallyLongHex) rightOp;
		if(this.compareTo(rOp)==0){
			return true;
		}
		return false;
	}
	/**
	 * Multiply hex number by 16 by adding 0's
	 * @param int num num of times to multiply by 16
	 */
	public void mult16ToThe(int num)
	{
		String s = ""+0;
		char temp = s.charAt(0);
		for(int i=0; i<num;i++){
			addItem(temp);
		}
	}
	/**
	 * Divide hex nuber by 16 by shifting right
	 * @param int num num of times to shift right
	 */
	public void div16ToThe(int num)
	{
		for(int i=0; i<num;i++)
			shiftRight();
	}
	/**
	 * Helper method to convert char's to number in hex number
	 * @param  char s             character to be converted
	 * @return      number represented by character
	 */
	private int convCharToNum(char s){
		int num =0;
		switch(s){
			case 'A':
				num = 10;
			break;
			case 'B':
				num = 11;
			break;
			case 'C':
				num = 12;
			break;
			case 'D':
				num = 13;
			break;
			case 'E':
				num = 14;
			break;
			case 'F':
				num = 15;
			break;
		}
		return num;
	}
	/**
	 * Convert number back to char to put in linked list
	 * @param  int s             number to be converted to char
	 * @return     char representation of number
	 */
	private char convNumToChar(int s){
		char b= 0;
		switch(s){
			case 10:
				b = 'A';
			break;
			case 11:
				b = 'B';
			break;
			case 12:
				b = 'C';
			break;
			case 13:
				b = 'D';
			break;
			case 14:
				b = 'E';
			break;
			case 15:
				b = 'F';
			break;
		}
		return b;
	}
}
