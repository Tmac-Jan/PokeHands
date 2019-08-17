package com.gio.PokeHands;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompareCard implements Comparator<Card> {

  public static final String PLAYER_1_WIN = "player1Win";
  public static final String PLAYER_2_WIN = "player2Win";
  public static final String TIE = "TIE";
  public static final int HIGHCARD = 1;
  public static final int PAIR = 2;
  public static final int TWOPAIRS = 3;
  public static final int THREE_OF_A_KIND = 4;
  public static final int STRAIGHT = 5;
  public static final int FLUSH = 6;
  public static final int FULL_HOUSE = 7;
  private static final int FOUR_OF_A_KIND = 8;
  private static final int STRAIGHTFLUSH = 9;

  private static Map<String,Integer> playerMap1= null;
  private static Map<String,Integer> playerMap2= null;
  public String judgeTwoPlayerPoke(List<Card> player1, List<Card> player2) {

    Integer playerCardType1 = getCardType(player1);
    Integer playerCardType2 = getCardType(player2);
    if (playerCardType1 > playerCardType2) {
      return PLAYER_1_WIN;
    } else if (playerCardType1 == playerCardType2) {
      String result = "";
      switch (playerCardType1) {
        case HIGHCARD:
          result= compareCardTypeHighCard(player1, player2);
          break;
        case PAIR:
          result = compareCardTypePair(player1,player2);
          break;
      }
      return result;
    } else {
      return PLAYER_2_WIN;
    }
  }


  @Override
  public int compare(Card c1, Card c2) {
    System.out.println("c1" + c1.getNumber() + "\nc2:" + c2.getNumber());
    return Integer.parseInt(c1.getNumber()) -
      Integer.parseInt(c2.getNumber());
  }

  //  private int compareCardType(Integer player1, Integer player2){
//    return player1-player2;
//  }
  private int getCardType(List<Card> player) {
    if (isHighCard(player)) {
      return HIGHCARD;
    }
    if (isPair(player)){
      return PAIR;
    }
    return 0;
  }

  private boolean isHighCard(List<Card> player) {
    int count = 0;
    Map<String, Integer> cardMap = new HashMap<>();
    player.stream().forEach(e -> {
      if (cardMap.get(e.getNumber()) == null) {
        cardMap.put(e.getNumber(), 1);
      } else {
        Integer result = cardMap.get(e.getNumber());
        cardMap.put(e.getNumber(), result + 1);
      }
    });

    for (Map.Entry<String, Integer> map : cardMap.entrySet()) {
      if (map.getValue() > 1) {
        count++;
      }
    }
    return count == 0 ? true : false;
  }

  private boolean isPair(List<Card> player){
    int count = 0;
    Map<String, Integer> cardMap = new HashMap<>();
    player.stream().forEach(e -> {
      if (cardMap.get(e.getNumber()) == null) {
        cardMap.put(e.getNumber(), 1);
      } else {
        Integer result = cardMap.get(e.getNumber());
        cardMap.put(e.getNumber(), result + 1);
      }
    });

    for (Map.Entry<String, Integer> map : cardMap.entrySet()) {
      if (map.getValue() > 1) {
        count++;
      }
    }
    if (playerMap1 == null){
      playerMap1=cardMap;
    }else
      playerMap2=cardMap;
    return count>0?true:false;
  }
  private String compareCardTypePair(List<Card> player1,List<Card> player2){
//    int pairCount1 = (int) playerMap1.entrySet().stream().filter(e->e.getValue()>1).count();
////    int pairCount2 = (int) playerMap1.entrySet().stream().filter(e->e.getValue()>1).count();
    //String result = "";
    List<Integer> player1CardNumberList = new ArrayList<>();
    player1.forEach(e->player1CardNumberList.add(Integer.parseInt(e.getNumber())));
    List<Integer> player2CardNumberList = new ArrayList<>();
    player2.forEach(e->player2CardNumberList.add(Integer.parseInt(e.getNumber())));

    List<Integer> player1DistinctList = player1CardNumberList.stream().distinct()
      .collect(Collectors.toList());
    List<Integer> player2DistinctList = player2CardNumberList.stream().distinct()
      .collect(Collectors.toList());
    if (player1DistinctList.size()<player2DistinctList.size()){
      return PLAYER_1_WIN;
    }else if (player1DistinctList.size()>player2DistinctList.size()){
      return PLAYER_2_WIN;
    }else{
     return compareCardTypeHighCard(player1,player2);
    }
  }
  private String compareCardTypeHighCard(List<Card> player1, List<Card> player2) {
    Card playerMax1 = player1.stream().max(new CompareCard()).get();
    Card playerMax2 = player2.stream().max(new CompareCard()).get();

    if (compare(playerMax1, playerMax2) == 1) {
      return PLAYER_1_WIN;
    } else {
      if (Integer.parseInt(playerMax1.getNumber())
        == Integer.parseInt(playerMax2.getNumber())) {
        return TIE;
      } else
        return PLAYER_2_WIN;
    }
  }
}
