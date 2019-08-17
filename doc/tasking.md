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
  
  