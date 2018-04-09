package ru.stqa.pft.addressbook.model;

public class SecondaryData {

  private final String address2;
  private final String phone2;
  private final String notes;

  public SecondaryData(String address2, String phone2, String notes) {
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  public String getaddress2() {
    return address2;
  }

  public String getphone2() {
    return phone2;
  }

  public String getnotes() {
    return notes;
  }

}
