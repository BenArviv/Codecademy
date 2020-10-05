package Codecademy;

import java.util.Random;
class Magic8 {
    public static String returnedString (int num){
      String s1 = "As I see it, yes.";
      String s2 = "Ask again later.";
      String s3 = "Don’t count on it.";
      String s4 = "It is certain.";
      String s5 = "Better not tell you now.";
      String s6 = "My sources say no.";
      String s7 = "Signs point to yes.";
      String s8 = "In my eyes, no.";
      int advice = num;
      switch (advice){
        case 1:
          return s1;
        case 2:
          return s2;
        case 3:
          return s3;
        case 4:
          return s4;
        case 5:
          return s5;
        case 6:
          return s6;
        case 7:
          return s7;
        case 8:
          return s8;
      }
      return s2;
    }

    public static void main (String args[]) {
      Random rand = new Random();
      int randomInt = rand.nextInt(8) + 1;
      String advice = returnedString(randomInt);
      System.out.println(advice);
    }
}
