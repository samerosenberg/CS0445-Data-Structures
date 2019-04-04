import java.util.*;
import java.io.*;

class Snap{
  public static void main(String[] args) {
    int numberOfRounds = 0;
    int nPlayers = 0;
    if(args.length!=2){
      System.out.println("Usage: program ");
      System.exit(0);
    }else{
      numberOfRounds = Integer.parseInt(args[0]);
      nPlayers = Integer.parseInt(args[1]);
    }
    int round =0;
    boolean isGameOver = false;
    Player[] players = new Player[nPlayers];
    Card[] cards = new Card[52];
    MultiDS<Card> deck = new MultiDS<Card>(52);
    MultiDS<Card> snapPool = new MultiDS<Card>(52);


    for(int i=0;i<nPlayers;i++){
      players[i] = new Player(52);
    }

    for(Card.Ranks rankOfCards : Card.Ranks.values()){
			for (Card.Suits suitOfCards : Card.Suits.values()) {
				deck.addItem(new Card(suitOfCards,rankOfCards));
			}
		}


    deck.shuffle();

    for(int i=0;i<players.length;i++){
      for(int s=0;s<52/players.length;s++){
        players[i].addtoFaceDown(deck.top());
        deck.removeItem();
      }
    }
    if(deck.size()>0){
      for(int s=0;s<deck.size();s++){
        snapPool.addItem(deck.top());
        deck.removeItem();
      }
    }

    for(int i=0; i<players.length;i++){
      System.out.println("Player "+ i);
      System.out.println(players[i].getFD());
      System.out.println();
    }
    System.out.println("Snap Pool Contents");
    System.out.println(snapPool.toString());

    System.out.println();
    System.out.println("Starting the game!");
    System.out.println();

    while(round< numberOfRounds && !isGameOver){
      System.out.print("Round: "+ round+" ");

      for(int i=0; i<players.length;i++){
        if(players[i].getnumFD()==0){
          while(players[i].getnumFU()>0)
            players[i].addtoFaceDown(players[i].removeFromFU());
        }
        else if(players[i].isEmpty()){
          isGameOver= true;
          break;
        }
      }
        int shouted = 0;
        int match =0;
        boolean someoneshouted = false;
        if(!isGameOver){
          for(int i=0;i<players.length;i++){
            players[i].addtoFaceUp(players[i].removeFromFD());
          }
        for(int i=1;i<players.length;i++){
          if(players[i-1].getnumFU()==0)
            players[i-1].addtoFaceUp(players[i-1].removeFromFD());
          if(players[i].getnumFU()==0)
            players[i].addtoFaceUp(players[i].removeFromFD());
          if(players[i-1].getTop().compareTo(players[i].getTop())==0 ){
            System.out.println("Match");
            for(int s=1; s<players.length;s++){
              if(players[s].shout(.4,true)==1&&!someoneshouted){
                shouted =s;
                match = s-1;
                someoneshouted = true;
              }
              else if(players[s].shout(.4,true)==1&&someoneshouted){
                someoneshouted = false;
                System.out.println("Multiple players yelled shout");

                while(players[s].getnumFU()>0){
                  snapPool.shuffle();
                  snapPool.addItem(players[s].removeFromFU());
                }
                System.out.println("Cards added to snap pool");
               }
            }
            if(someoneshouted==true){
              System.out.println("Player" + shouted+" shouted correctly");
              while(players[match].getnumFU()>1)
               players[shouted].addtoFaceDown(players[match].removeFromFU());
              System.out.println("Cards added to players facedown pile");
            }
          }
          if((players[i].shout(.01,false)==2)){
            System.out.println("Player "+i+" incorrectly yelled shout");
            while(players[i].getnumFU()>0){
              snapPool.addItem(players[i].removeFromFU());
            }
            System.out.println("Players cards added to snap pool");
          }

        }
      }

      System.out.println();
      round++;
    }
    String s = "";
    int mostcards=0;
    for(int i=0;i<players.length;i++){
      System.out.println("Player "+i+" has "+(players[i].getnumFU()+players[i].getnumFD())+" cards");
      if(players[i].getnumFU()+players[i].getnumFD()>mostcards){
        mostcards = players[i].getnumFU()+players[i].getnumFD();
        s= " "+i;
      }
      else if(players[i].getnumFU()+players[i].getnumFD()==mostcards){
        s+=" "+i;
      }
    }
    System.out.println("The winner is Player "+s);


  }

}
