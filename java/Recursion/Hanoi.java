package Recursion;

public class Hanoi {

  static void hanoi(char s, char m, char e, int n) {
    if(n == 1) {
      System.out.println(s + " -> " + e);
      return;
    }
    hanoi(s, e, m, n-1);
    System.out.println(s + " -> " + e);
    hanoi(m, s, e, n-1);
  }
  
  public static void main(String[] args) {
    hanoi('s', 'm', 'e', 400);
  }
}
