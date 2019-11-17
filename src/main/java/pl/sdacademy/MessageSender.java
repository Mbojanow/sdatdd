package pl.sdacademy;

import pl.sdacademy.user.Person;

public class MessageSender {

  public void send (final Person person, final String message) {
    System.out.println("Sending message " + message + " to " + person.getFullName());
  }
}
