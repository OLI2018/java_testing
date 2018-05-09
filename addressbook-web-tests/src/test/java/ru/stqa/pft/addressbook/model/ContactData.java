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
  private int id = Integer.MAX_VALUE;

  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String email1;
  private String email2;
  private String email3;

  public int getId() {
    return id;
  }

  private String homePage;
  private String group;

  private String address2;

  private String phone2;
  private String notes;

  @Override
  public String toString() {
    return "ContactData{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", id='" + id + '\'' +
            '}';
  }

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

//  public ContactData(String firstName, String lastName, String middleName, String nickName, String title, String company, String address) {
//    this.firstName = firstName;
//    this.middleName = middleName;
//    this.lastName = lastName;
//    this.nickName = nickName;
//    this.title = title;
//    this.company = company;
//    this.address = address;
//    this.id = Integer.MAX_VALUE;
//
//  }

//  public ContactData(int id, String firstName, String lastName, String middleName, String nickName, String title, String company, String address) {
//    this.firstName = firstName;
//    this.middleName = middleName;
//    this.lastName = lastName;
//    this.nickName = nickName;
//    this.title = title;
//    this.company = company;
//    this.address = address;
//    this.id = id;
//  }

  public ContactData withId (int id) {
    this.id = id;
    return this;
  }


  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withMiddleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withNickName(String nickName) {
    this.nickName = nickName;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withHome(String home) {
    this.home = home;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withWork(String work) {
    this.work = work;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withEmail1(String email1) {
    this.email1 = email1;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withHomePage(String homePage) {
    this.homePage = homePage;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withPhone2(String phone2) {
    this.phone2 = phone2;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }


//  public ContactData(String home, String mobile, String work, String fax, String email1, String email2, String email3, String homePage, String group) {
//    this.home = home;
//    this.mobile = mobile;
//    this.work = work;
//    this.fax = fax;
//    this.email1 = email1;
//    this.email2 = email2;
//    this.email3 = email3;
//    this.homePage = homePage;
//    this.group = group;
//  }
//
//  public ContactData(String address2, String phone2, String notes) {
//    this.address2 = address2;
//    this.phone2 = phone2;
//    this.notes = notes;
//  }

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

  public void setId(int id) {
    this.id = id;
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






