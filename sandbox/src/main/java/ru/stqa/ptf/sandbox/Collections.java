package ru.stqa.ptf.sandbox;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {

//    String [] langs = new String [4];
//    langs[0] = "Java";
//    langs[1] = "C#";
//    langs[2] = "Python";
//    langs[3] = "PHP";

//    String [] lands = {"Java", "C#", "Python", "PHP"};
//    for (int i = 0; i < lands.length; i++) {
//      System.out.println("I like " + lands[i]);
//    }

    String[] lands = {"Java", "C#", "Python", "PHP"};

    for (String l : lands) {
      System.out.println("I like " + l);
    }

//    List<String> languages = new ArrayList<>();    languages.add("Java");
//    languages.add("C#");
//    languages.add("Python");
//

    List<String> languages = Arrays.asList("Java", "C#", "Python");
    for (String l : languages) {
      System.out.println(l);
    }
  }
}
