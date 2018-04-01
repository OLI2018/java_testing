package ru.stqa.ptf.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

  @Test

  public void testArea (){

    Point point = new Point(10,10,30,30);
    Assert.assertEquals(point.disCalculation(), 28.284271247461902);

  }
}


