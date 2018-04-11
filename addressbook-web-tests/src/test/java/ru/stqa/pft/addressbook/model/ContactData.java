package ru.stqa.pft.addressbook.model;

public class ContactData {

  private String firstName;
  private String middleName;
  private String lastName;
  private String nickName;
  private String title;
  private String company;
  private String address;

  private String home;
  private String mobile;
  private String work;
  private String fax;
  private String email1;
  private String email2;
  private String email3;
  private String homePage;

  private String address2;
  private String phone2;
  private String notes;

  public ContactData(String firstName, String middleName, String lastName, String nickName, String title, String company, String address) {
    this.firstName = firstName;
    this.middleName = middleName;
    this.lastName = lastName;
    this.nickName = nickName;
    this.title = title;
    this.company = company;
    this.address = address;
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


  public ContactData(String home, String mobile, String work, String fax, String email1, String email2, String email3, String homePage) {
    this.home = home;
    this.mobile = mobile;
    this.work = work;
    this.fax = fax;
    this.email1 = email1;
    this.email2 = email2;
    this.email3 = email3;
    this.homePage = homePage;

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


  public ContactData(String address2, String phone2, String notes) {
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





