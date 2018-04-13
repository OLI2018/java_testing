package ru.stqa.ptf.sandbox;

public class Equality {

  public static void main (String[] args) {
    String s1 = "firefox";
    String s2 = new String(s1);

    System.out.println(s1 == s2);
    System.out.println(s1.equals(s2));


    String x1 = "word";
    String x2 = x1;

    System.out.println(x1 == x2);
    System.out.println(x1.equals(x2));


    String q1 = "new";
    String q2 = "new";
    System.out.println(q1 == q2);
    System.out.println(q1.equals(q2));
  }

}
