package ru.stqa.ptf.soap;

import com.lavasoft.GeoIPService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GeoIpServiceTest {

  @Test
  public void testMyIp() {

    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("67.160.67.132");
    System.out.println(ipLocation);
    Assert.assertEquals(ipLocation, "<GeoIP><Country>US</Country><State>WA</State></GeoIP>");
  }

  @Test
  public void testInvalidMyIp() {

    String ipLocation = new GeoIPService().getGeoIPServiceSoap12().getIpLocation("67.888.00.000");
    System.out.println(ipLocation);
    Assert.assertEquals(ipLocation, "<GeoIP><Country>US</Country><State>WA</State></GeoIP>");
  }
}
