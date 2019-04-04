import java.util.*;
public class Player<T> extends MultiDS<T> implements PrimQ<T>,Reorder{
  private Card[] faceDown;
  private Card[] faceUp;
  private int numOfFD = 0;
  private int numOfFU = 0;

  private Random rand  = new Random();


  /**
    Player constructor
    @param capacity to set facedown and faceup arrays to
  */
  public Player(int cap){
    faceDown = new Card[cap];
    faceUp = new Card[cap];
  }

  /**
    Get top card in faceup pile
    @return card on top of pile
  */
  public Card getTop(){
    return faceUp[numOfFU-1];
  }

  /**
    Add card to face down pile
    @param item to be added to face down array
  */
  public void addtoFaceDown(Card item){
    faceDown[numOfFD] = item;
    numOfFD++;
  }

  /**
    Add item to faceup array
    @param item to be added to face up array
  */
  public void addtoFaceUp(Card item){
    faceUp[numOfFU] = item;
    numOfFU++;
  }

  /**
    Remove and return card from facedown pile
    @return first card in face down pile
  */
  public Card removeFromFD(){
    Card result = faceDown[0];
    for(int i=1; i<numOfFD;i++){
      faceDown[i-1] = faceDown[i];
    }
    if(numOfFD < faceDown.length)
      faceDown[numOfFD] = null;
    numOfFD--;
    return result;
  }

  /**
    Remove and return card from face up pile
    @return first card in face up pile
  */
  public Card removeFromFU(){
    Card result = faceUp[0];
    for(int i=1; i<numOfFU;i++){
      faceUp[i-1] = faceUp[i];
    }
    if(numOfFU < faceUp.length)
      faceUp[numOfFU] = null;
    numOfFU--;
    return result;
  }

  /**
    Return string version of face down pile
    @return face down pile as string
  */
  public String getFD(){
    String str = "";
    for(int i=0;i<numOfFD;i++){
      str += faceDown[i]+" ";
    }
    return str;
  }

  /**
    Return string version of face up pile
    @return face up pile as string
  */
  public String getFU(){
    String str = "";
    for(int i=0;i<numOfFU;i++){
      str += faceUp[i]+" ";
    }
    return str;
  }

  /**
    Checks if player is totally out of cards
    @return true if player is out of cards
  */
  public boolean isEmpty(){
    return (numOfFU+numOfFD)==0;
  }

  /**
    Shout method to check if a player yells shout
    @param prob is probability of shouting based on match or no match
    @param match is true if there was a match or false if there was none
    @return 1 if match and shout, 2 if shout and no match and 3 if nothing
  */
  public int shout(double prob, boolean match){
    double num = rand.nextDouble();
    if(num<prob && match)
      return 1;
    else if(num<prob && !match)
      return 2;
    else  return 3;

  }

  /**
    Get number of cards in face up pile
    @return number of cards in face up pile
  */
  public int getnumFU(){
    return numOfFU;
  }
  /**
    Get number of cards in face down pile
    @return number of cards in face down pile
  */
  public int getnumFD(){
    return numOfFD;
  }


}
