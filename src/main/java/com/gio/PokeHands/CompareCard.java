package com.gio.PokeHands;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class CompareCard implements Comparator<Card>  {

  public static final String PLAYER_1_WIN = "player1Win";
  public static final String PLAYER_2_WIN = "player2Win";
  public static final String TIE = "TIE";

  public String judgeTwoPlayerPoke(List<Card> player1, List<Card> player2) {

    HashMap<String, Integer> hashMap = new HashMap<>();

    Card playerMax1 = player1.stream().max(new CompareCard()).get();
    Card playerMax2 = player2.stream().max(new CompareCard()).get();

    if (compare(playerMax1, playerMax2) == 1) {
      return PLAYER_1_WIN;
    } else {
      if (Integer.parseInt(playerMax1.getNumber().substring(0,1))
        ==Integer.parseInt(playerMax2.getNumber().substring(0,1))){
        return TIE;
      }else
        return PLAYER_2_WIN;
    }
  }
  @Override
  public int compare(Card c1, Card c2) {
    System.out.println("c1"+c1.getNumber()+"\nc2:"+c2.getNumber());
    return Integer.parseInt(c1.getNumber())-
      Integer.parseInt(c2.getNumber());
  }

}
