package ru.stqa.pft.mantis.model;

public class MailMessage {

  public String to; // who got email
  public String text; // text/body of email

  public MailMessage(String to, String text) {
    this.to = to;
    this.text = text;
  }
}
