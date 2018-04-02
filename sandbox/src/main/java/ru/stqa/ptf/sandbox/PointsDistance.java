package ru.stqa.ptf.sandbox;

public class PointsDistance {

  public static void main(String[] args) {

    Point p1 = new Point(10,10);
    Point p2 = new Point(30, 30);


    double distance = p1.disCalculation(p2);
    System.out.println((Math.round(distance * 100.0)/100.0));

  }

}
