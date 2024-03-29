package com.gio.PokeHands;

import java.util.HashMap;


public class Card  {
  private String color;
  private String number;
  public static HashMap<String, String>  integerHashMap = new HashMap<String, String>();
  static {
    integerHashMap.put("T","10");
    integerHashMap.put("J","11");
    integerHashMap.put("Q","12");
    integerHashMap.put("K","13");
    integerHashMap.put("A","14");
  }

  public Card(String color, String number) {
    this.color = color;
    this.number = number;
  }

  public Card(){}

  public String getColor() {

    return color;
  }

  public void setNumber(String number) {

    this.number = number;
  }

  public String getNumber() {
    return integerHashMap.get(this.number)==null?this.number:integerHashMap.get(this.number);
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
}
