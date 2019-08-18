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
  @Test
  public void should_return_player2Win_when_Player1_isPair_and_player2_too_and_player1_isSmallerThan_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("D","2"));
      add(new Card("S","5"));
      add(new Card("C","9"));
      add(new Card("D","A"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("S","4"));
      add(new Card("D","5"));
      add(new Card("S","9"));
      add(new Card("C","A"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player2Win_when_Player1_isPair_and_player2_too_and_player2Has2Pair(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("D","2"));
      add(new Card("S","5"));
      add(new Card("C","9"));
      add(new Card("D","A"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","2"));
      add(new Card("C","2"));
      add(new Card("D","5"));
      add(new Card("S","5"));
      add(new Card("C","A"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player1Win_when_player1_is_two_pair_and_player2_too_and_player1_is_bigger_than_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("D","4"));
      add(new Card("S","5"));
      add(new Card("C","5"));
      add(new Card("D","A"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("H","3"));
      add(new Card("S","3"));
      add(new Card("S","4"));
      add(new Card("C","4"));
      add(new Card("C","A"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_1_WIN,result);
  }
  @Test
  public void should_return_player2Win_when_player1_is_two_pair_and_player2_too_and_player1_equal_player2_but_player2_highCard_is_bigger(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("D","4"));
      add(new Card("S","5"));
      add(new Card("C","5"));
      add(new Card("D","K"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","4"));
      add(new Card("C","4"));
      add(new Card("H","5"));
      add(new Card("D","5"));
      add(new Card("C","A"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player1Win_when_player1_is_ThreeOfAKind_and_player2_too_and_player1_isBiggerThan_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("D","4"));
      add(new Card("S","4"));
      add(new Card("C","5"));
      add(new Card("D","K"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","3"));
      add(new Card("C","3"));
      add(new Card("H","3"));
      add(new Card("D","5"));
      add(new Card("C","A"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_1_WIN,result);
  }
  @Test
  public void should_return_player1Win_when_player1_is_Straight_and_player2_too_and_player1_isSmallerThan_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("D","3"));
      add(new Card("S","4"));
      add(new Card("C","5"));
      add(new Card("D","6"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","3"));
      add(new Card("C","4"));
      add(new Card("H","5"));
      add(new Card("S","6"));
      add(new Card("C","7"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player1Win_when_player1_is_Straight_and_player2_is_HighCard(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","2"));
      add(new Card("D","3"));
      add(new Card("S","4"));
      add(new Card("C","5"));
      add(new Card("D","6"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","8"));
      add(new Card("C","T"));
      add(new Card("H","A"));
      add(new Card("S","K"));
      add(new Card("C","7"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_1_WIN,result);
  }
  @Test
  public void should_return_player2Win_when_player1_is_Flush_and_player2_is_Flush_and_player1_isSmallerThan_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("H","9"));
      add(new Card("H","Q"));
      add(new Card("H","J"));
      add(new Card("H","6"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","8"));
      add(new Card("S","T"));
      add(new Card("S","A"));
      add(new Card("S","K"));
      add(new Card("S","7"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player1Win_when_player1_is_Flush_and_player2_is_NotFlush_and_player2_is_HighCard(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("H","9"));
      add(new Card("H","Q"));
      add(new Card("H","J"));
      add(new Card("H","6"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","8"));
      add(new Card("D","T"));
      add(new Card("S","A"));
      add(new Card("S","K"));
      add(new Card("S","7"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_1_WIN,result);
  }
  @Test
  public void should_return_player2Win_when_player1_is_FullHouse_and_player2_too_and_player1_isSmallerThan_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("S","4"));
      add(new Card("C","4"));
      add(new Card("H","J"));
      add(new Card("H","J"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","8"));
      add(new Card("D","8"));
      add(new Card("C","8"));
      add(new Card("S","K"));
      add(new Card("C","K"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player2Win_when_player1_is_FullOfAKind_and_player2_too_and_player1_isSmallerThan_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","4"));
      add(new Card("S","4"));
      add(new Card("C","4"));
      add(new Card("H","4"));
      add(new Card("H","K"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","8"));
      add(new Card("D","8"));
      add(new Card("C","8"));
      add(new Card("S","8"));
      add(new Card("C","J"));
    }};

    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player2Win_when_player1_is_StraightFlush_and_player2_too_and_player1_isSmallerThan_player2(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","3"));
      add(new Card("H","4"));
      add(new Card("H","5"));
      add(new Card("H","6"));
      add(new Card("H","7"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","6"));
      add(new Card("S","7"));
      add(new Card("S","8"));
      add(new Card("S","9"));
      add(new Card("S","T"));
    }};
    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_2_WIN,result);
  }
  @Test
  public void should_return_player1Win_when_player1_is_StraightFlush_and_player2_is_Straight(){
    List<Card> player1 = new ArrayList<Card>(){{
      add(new Card("H","3"));
      add(new Card("H","4"));
      add(new Card("H","5"));
      add(new Card("H","6"));
      add(new Card("H","7"));
    }};
    List<Card> player2 = new ArrayList<Card>(){{
      add(new Card("S","6"));
      add(new Card("S","7"));
      add(new Card("S","8"));
      add(new Card("H","9"));
      add(new Card("S","T"));
    }};
    CompareCard compareCard = new CompareCard();
    String result = compareCard.judgeTwoPlayerPoke(player1,player2);
    Assert.assertEquals(PLAYER_1_WIN,result);
  }
}