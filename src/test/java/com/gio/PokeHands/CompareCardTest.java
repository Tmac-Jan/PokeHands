package com.gio.PokeHands;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class CompareCardTest {
  public static final String PLAYER_1_WIN = "player1Win";
  public static final String PLAYER_2_WIN = "player2Win";
  public static final String TIE = "TIE";
  @Test
  public void should_return_player1Win_when_Player1_HighCard_IsBiggerThan_Player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("D","3"));
      add(new Card("S","5"));
      add(new Card("C","9"));
      add(new Card("D","A"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("S","3"));
      add(new Card("D","5"));
      add(new Card("S","9"));
      add(new Card("C","K"));
    }};

    String result1 = new Card("S","A").getNumber();
    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_1_WIN,result);
  }
  @Test
  public void should_return_TIE_when_Player1_HighCard_Equal_Player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("D","3"));
      add(new Card("S","5"));
      add(new Card("C","9"));
      add(new Card("D","A"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("S","3"));
      add(new Card("D","5"));
      add(new Card("S","9"));
      add(new Card("C","A"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(TIE,result);
  }
  @Test
  public void should_return_player1Win_when_Player1_isPair_and_Player2_is_highCard(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("D","2"));
      add(new Card("S","5"));
      add(new Card("C","9"));
      add(new Card("D","A"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("H","3"));
      add(new Card("S","4"));
      add(new Card("D","5"));
      add(new Card("S","9"));
      add(new Card("C","A"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_1_WIN,result);
  }
}