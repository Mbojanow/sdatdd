package pl.sdacademy.services;

import pl.sdacademy.user.Person;

public class PersonSender {

  public void send(final Person person) {
    System.out.println("sending person " + person.getFullName() + " into space");
  }
}
