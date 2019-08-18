- ### Case1
  - input player1[Card("H","2");
                Card("D","3");
                Card("S","5");
                Card("C","9");
                Card("D","A");]
                
  - input player2[Card("H","2");
                Card("S","3");
                Card("D","5");
                Card("S","9");
                Card("C","K");]
  - ->(CompareCard) 

  - output player1 Win!
  
- ### Case2
  - input player1[Card("H","2");
                Card("D","3");
                Card("S","5");
                Card("C","9");
                Card("D","A");]
                
  - input player2[Card("H","2");
                Card("S","3");
                Card("D","5");
                Card("S","9");
                Card("C","A");]
  - ->(CompareCard) 

  - output TIE!
 - ### Case3
   - input player1[Card("H","2");
                  Card("D","2");
                  Card("S","5");
                  Card("C","9");
                  Card("D","A");]
                  
    - input player2[Card("H","3");
                  Card("S","4");
                  Card("D","5");
                  Card("S","9");
                  Card("C","A");]
    - ->(CompareCard) 
  
    - output player1 Win!
  - ### Case4
      - input  List<Card> player1 = new ArrayList<Card>(){{
                    add(new Card("H","4"));
                    add(new Card("D","4"));
                    add(new Card("S","5"));
                    add(new Card("C","5"));
                    add(new Card("D","A"));
                  }};
                     
       -  input List<Card> player2 = new ArrayList<Card>(){{
               add(new Card("H","3"));
               add(new Card("S","3"));
               add(new Card("S","4"));
               add(new Card("C","4"));
               add(new Card("C","A"));
             }};

       - ->(CompareCard) 
     
       - output player1 Win!  
 - ### Case5
    - input List<Card> player1 = new ArrayList<Card>(){{
                         add(new Card("H","4"));
                         add(new Card("D","4"));
                         add(new Card("S","5"));
                         add(new Card("C","5"));
                         add(new Card("D","K"));
                       }};
                   
     - input  List<Card> player2 = new ArrayList<Card>(){{
                   add(new Card("S","4"));
                   add(new Card("C","4"));
                   add(new Card("H","5"));
                   add(new Card("D","5"));
                   add(new Card("C","A"));
                 }};
     - ->(CompareCard) 
   
     - output player2 Win!
  - ### Case6
      - input List<Card> player1 = new ArrayList<Card>(){{
                   add(new Card("H","4"));
                   add(new Card("D","4"));
                   add(new Card("S","4"));
                   add(new Card("C","5"));
                   add(new Card("D","K"));
                 }};
                     
       - input   List<Card> player2 = new ArrayList<Card>(){{
                      add(new Card("S","3"));
                      add(new Card("C","3"));
                      add(new Card("H","3"));
                      add(new Card("D","5"));
                      add(new Card("C","A"));
                    }};

       - ->(CompareCard) 
     
       - output player1 Win!
  - ### Case7
       - input List<Card> player1 = new ArrayList<Card>(){{
                      add(new Card("H","2"));
                      add(new Card("D","2"));
                      add(new Card("S","5"));
                      add(new Card("C","9"));
                      add(new Card("D","A"));
                    }};
       - input List<Card> player2 = new ArrayList<Card>(){{
                         add(new Card("H","4"));
                         add(new Card("S","4"));
                         add(new Card("D","5"));
                         add(new Card("S","9"));
                         add(new Card("C","A"));
                       }};
  
       - ->(CompareCard) 
       
       - output player2 Win!
  - ### Case8
       - input List<Card> player1 = new ArrayList<Card>(){{
                    add(new Card("H","2"));
                    add(new Card("D","2"));
                    add(new Card("S","5"));
                    add(new Card("C","9"));
                    add(new Card("D","A"));
                  }};
       - input List<Card> player2 = new ArrayList<Card>(){{
                     add(new Card("S","2"));
                     add(new Card("C","2"));
                     add(new Card("D","5"));
                     add(new Card("S","5"));
                     add(new Card("C","A"));
                   }};
       - ->(CompareCard) 
         
       - output player2 Win!
   - ### Case9
       - input List<Card> player1 = new ArrayList<Card>(){{
                      add(new Card("H","2"));
                      add(new Card("D","2"));
                      add(new Card("S","5"));
                      add(new Card("C","9"));
                      add(new Card("D","A"));
                    }};
      - input List<Card> player2 = new ArrayList<Card>(){{
                       add(new Card("S","2"));
                       add(new Card("C","2"));
                       add(new Card("D","5"));
                       add(new Card("S","5"));
                       add(new Card("C","A"));
                     }};
      - ->(CompareCard) 
           
      - output player2 Win!    
   - ### Case10
       - input  List<Card> player1 = new ArrayList<Card>(){{
                     add(new Card("H","4"));
                     add(new Card("D","4"));
                     add(new Card("S","5"));
                     add(new Card("C","5"));
                     add(new Card("D","A"));
                   }};
       - input List<Card> player2 = new ArrayList<Card>(){{
                     add(new Card("H","3"));
                     add(new Card("S","3"));
                     add(new Card("S","4"));
                     add(new Card("C","4"));
                     add(new Card("C","A"));
                   }};
       - ->(CompareCard)  
       - output player1 Win!  
  - ### Case11
      - input   List<Card> player1 = new ArrayList<Card>(){{
                      add(new Card("H","4"));
                      add(new Card("D","4"));
                      add(new Card("S","5"));
                      add(new Card("C","5"));
                      add(new Card("D","K"));
                    }};
      - input  List<Card> player2 = new ArrayList<Card>(){{
                      add(new Card("S","4"));
                      add(new Card("C","4"));
                      add(new Card("H","5"));
                      add(new Card("D","5"));
                      add(new Card("C","A"));
                    }};
      - ->(CompareCard)  
      - output player2 Win!
  - ### Case12
       - input   List<Card> player1 = new ArrayList<Card>(){{
                         add(new Card("H","4"));
                         add(new Card("D","4"));
                         add(new Card("S","4"));
                         add(new Card("C","5"));
                         add(new Card("D","K"));
                       }};
       - input   List<Card> player2 = new ArrayList<Card>(){{
                         add(new Card("S","3"));
                         add(new Card("C","3"));
                         add(new Card("H","3"));
                         add(new Card("D","5"));
                         add(new Card("C","A"));
                       }};
       - ->(CompareCard)  
       - output player1 Win! 
  - ### Case13
      - input  List<Card> player1 = new ArrayList<Card>(){{
                          add(new Card("H","2"));
                          add(new Card("D","3"));
                          add(new Card("S","4"));
                          add(new Card("C","5"));
                          add(new Card("D","6"));
                        }};
      - input  List<Card> player2 = new ArrayList<Card>(){{
                            add(new Card("S","3"));
                            add(new Card("C","4"));
                            add(new Card("H","5"));
                            add(new Card("S","6"));
                            add(new Card("C","7"));
                          }};
      - ->(CompareCard)  
      - output player2 Win!                     