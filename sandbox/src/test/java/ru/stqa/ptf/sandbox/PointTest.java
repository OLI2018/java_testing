package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test

  public void testArea (){

    Point p1 = new Point(10, 10);
    Point p2 = new Point(30, 30);

    double distance = p1.disCalculation(p2);

    Assert.assertEquals((Math.round(distance * 100.0)/100.0), 28.28);

  }
}


