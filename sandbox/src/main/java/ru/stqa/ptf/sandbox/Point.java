package ru.stqa.ptf.sandbox;

public class Point {

  public double px1;
  public double py1;

  public double px2;
  public double py2;

  public double dis;

  public Point(double px1, double py1, double px2, double py2) {
    this.px1 = px1;
    this.py1 = py1;
    this.px2 = px2;
    this.py2 = py2;
  }

  public double disCalculation() {

    dis = Math.sqrt(((px2 - px1) * (px2 - px1)) + ((py2 - py1) * (py2 - py1)));
    return dis;
  }
}

