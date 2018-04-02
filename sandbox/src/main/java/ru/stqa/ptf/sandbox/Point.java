package ru.stqa.ptf.sandbox;

public class Point {

  public double x;
  public double y;

  public Point (double x, double y) {
    this.x = x;
    this.y = y;
  }

  public double disCalculation (Point secondPoint) {
    double difX = secondPoint.x - this.x;
    double difY = secondPoint.y - this.y;

    double dis = Math.sqrt(Math.pow(difX, 2) + Math.pow(difY,2));

    return dis;
  }

}
