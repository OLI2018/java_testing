package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test
  public void testArea1() {

    Point p1 = new Point(10, 10);
    Point p2 = new Point(30, 30);

    double distance = p1.disCalculation(p2);

    Assert.assertEquals((Math.round(distance * 100.0) / 100.0), 28.28);

  }

  @Test
  public void testArea2() {

    Point p1 = new Point(15, 25);
    Point p2 = new Point(45, 87);

    double distance = p1.disCalculation(p2);

    Assert.assertEquals((Math.round(distance * 100.0) / 100.0), 68.88);

  }

  @Test
  public void testArea3() {

    Point p1 = new Point(17, 27);
    Point p2 = new Point(16, 54);

    double distance = p1.disCalculation(p2);

    Assert.assertEquals((Math.round(distance * 100.0) / 100.0), 27.02);

  }

}


