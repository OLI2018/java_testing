package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private String firstName;
  private String middleName;
  private String lastName;
  private String nickName;
  private String title;
  private String company;
  private String address;
  private int id;

  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String email1;
  private String email2;
  private String email3;
  private String homePage;
  private String group;

  private String address2;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(firstName, lastName);
  }

  private String phone2;
  private String notes;

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String company, String address) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
  }

  public ContactData(int id, String firstName, String middleName, String lastName, String nickName, String title, String company, String address) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
    this.id = id;
  }


  public ContactData(String home, String mobile, String work, String fax, String email1, String email2, String email3, String homePage, String group) {
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homePage = homePage;

    this.group = group;
  }

  public ContactData(String address2, String phone2, String notes) {
    this.address2 = address2;
    this.phone2 = phone2;
    this.notes = notes;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getMiddleName() {
    return middleName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getNickName() {
    return nickName;
  }

  public String getTitle() {
    return title;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getHome() {
    return home;
  }

  public String getMobile() {
    return mobile;
  }

  public String getWork() {
    return work;
  }

  public String getFax() {
    return fax;
  }

  public String getEmail1() {
    return email1;
  }

  public String getEmail2() {
    return email2;
  }

  public String getEmail3() {
    return email3;
  }

  public String getHomePage() {
    return homePage;
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

  public String getGroup() {
    return group;
  }
}






