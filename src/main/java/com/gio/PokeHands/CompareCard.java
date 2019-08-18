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

  private static Map<String, Integer> playerMap1 = null;
  private static Map<String, Integer> playerMap2 = null;

  public String judgeTwoPlayerPoke(List<Card> player1, List<Card> player2) {

    Integer playerCardType1 = getCardType(player1);
    Integer playerCardType2 = getCardType(player2);
    if (playerCardType1 > playerCardType2) {
      return PLAYER_1_WIN;
    } else if (playerCardType1 == playerCardType2) {
      String result = "";
      switch (playerCardType1) {
        case HIGHCARD:
        case STRAIGHT:
          result = compareCardTypeHighCard(player1, player2);
          break;
        case PAIR:
        case TWOPAIRS:
          result = compareCardTypePair(player1, player2);
          break;
        case THREE_OF_A_KIND:
          result = compareCardTypeThreeOfAKind(player1, player2);
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

  private int getCardType(List<Card> player) {
    if (isHighCard(player)) {
      return HIGHCARD;
    } else if (isPair(player)) {
      return PAIR;
    } else if (isTwoPair(player)) {
      return TWOPAIRS;
    } else if (isThreeOfAKind(player)) {
      return THREE_OF_A_KIND;
    } else if (isStraight(player)) {
      return STRAIGHT;
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
    if (count==0){
      List<Integer> playerCardNumberList = new ArrayList<>();
      player.forEach(e -> playerCardNumberList.add(Integer.parseInt(e.getNumber())));
      Integer listSum = playerCardNumberList.stream().reduce(Integer::sum).orElse(0);
      Integer n = playerCardNumberList.size();
      Integer arithmeticProgression = n * playerCardNumberList.get(0) + n * (n - 1) / 2;
      return !arithmeticProgression.equals(listSum);
    }else
    return false;
  }

  private boolean isPair(List<Card> player) {
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
    return count > 0 ? true : false;
  }

  private boolean isTwoPair(List<Card> player) {
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
    return count > 1 ? true : false;
  }

  private boolean isThreeOfAKind(List<Card> player) {
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
      if (map.getValue() > 2) {
        count++;
      }
    }
    return count > 1 ? true : false;
  }

  private boolean isStraight(List<Card> player) {
      List<Integer> playerCardNumberList = new ArrayList<>();
      player.forEach(e -> playerCardNumberList.add(Integer.parseInt(e.getNumber())));
      Integer listSum = playerCardNumberList.stream().reduce(Integer::sum).orElse(0);
      Integer n = playerCardNumberList.size();
      Integer arithmeticProgression = n * playerCardNumberList.get(0) + n * (n - 1) / 2;
      return arithmeticProgression.equals(listSum);
  }

  private String compareCardTypeThreeOfAKind(List<Card> player1, List<Card> player2) {
    List<Integer> player1CardNumberList = new ArrayList<>();
    player1.forEach(e -> player1CardNumberList.add(Integer.parseInt(e.getNumber())));
    List<Integer> player2CardNumberList = new ArrayList<>();
    player2.forEach(e -> player2CardNumberList.add(Integer.parseInt(e.getNumber())));

    List<Integer> player1DistinctList = player1CardNumberList.stream().distinct()
      .collect(Collectors.toList());
    List<Integer> player2DistinctList = player2CardNumberList.stream().distinct()
      .collect(Collectors.toList());

    List<Integer> player1PairList = player1CardNumberList.stream()
      .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
      .entrySet().stream() // Set<Entry>转换为Stream<Entry>
      .filter(entry -> entry.getValue() > 2) // 过滤出元素出现次数大于 2 的 entry
      .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
      .collect(Collectors.toList()); // 转化为 List
    List<Integer> player2PairList = player2CardNumberList.stream()
      .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
      .entrySet().stream() // Set<Entry>转换为Stream<Entry>
      .filter(entry -> entry.getValue() > 2) // 过滤出元素出现次数大于 2 的 entry
      .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
      .collect(Collectors.toList()); // 转化为 List
    if (player1DistinctList.size() < player2DistinctList.size()) {
      return PLAYER_1_WIN;
    } else if (player1DistinctList.size() > player2DistinctList.size()) {
      return PLAYER_2_WIN;
    } else {
      return compareCardTypeBase(player1PairList, player2PairList);
    }
  }

  private String compareCardTypePair(List<Card> player1, List<Card> player2) {
    List<Integer> player1CardNumberList = new ArrayList<>();
    player1.forEach(e -> player1CardNumberList.add(Integer.parseInt(e.getNumber())));
    List<Integer> player2CardNumberList = new ArrayList<>();
    player2.forEach(e -> player2CardNumberList.add(Integer.parseInt(e.getNumber())));

    List<Integer> player1DistinctList = player1CardNumberList.stream().distinct()
      .collect(Collectors.toList());
    List<Integer> player2DistinctList = player2CardNumberList.stream().distinct()
      .collect(Collectors.toList());

    List<Integer> player1PairList = player1CardNumberList.stream()
      .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
      .entrySet().stream() // Set<Entry>转换为Stream<Entry>
      .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
      .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
      .collect(Collectors.toList()); // 转化为 List
    List<Integer> player2PairList = player2CardNumberList.stream()
      .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
      .entrySet().stream() // Set<Entry>转换为Stream<Entry>
      .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
      .map(entry -> entry.getKey()) // 获得 entry 的键（重复元素）对应的 Stream
      .collect(Collectors.toList()); // 转化为 List
    if (player1DistinctList.size() < player2DistinctList.size()) {
      return PLAYER_1_WIN;
    } else if (player1DistinctList.size() > player2DistinctList.size()) {
      return PLAYER_2_WIN;
    } else {
      String result = compareCardTypeBase(player1PairList, player2PairList);
      if (result.equals(TIE)) {
        return compareCardTypeHighCard(player1, player2);
      } else {
        return result;
      }
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

  private String compareCardTypeBase(List<Integer> player1, List<Integer> player2) {
    Integer playerMax1 = player1.stream().reduce(Integer::max).get();
    Integer playerMax2 = player2.stream().reduce(Integer::max).get();
    if (playerMax1 > playerMax2) {
      return PLAYER_1_WIN;
    } else {
      if (playerMax1.equals(playerMax2)) {
        return TIE;
      } else
        return PLAYER_2_WIN;
    }
  }
}
