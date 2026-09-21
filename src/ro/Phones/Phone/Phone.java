package ro.Phones.Phone;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.UUID;
import ro.Phones.Interface.PhoneOperations;

public abstract class Phone implements PhoneOperations {
    private String IMEI;

    public Phone() {
        IMEI = UUID.randomUUID().toString();
    }

    private final int BatteryLife = 14;
    private String color, material;
    int remainingBatteryLife = BatteryLife;
    String[] contacts = new String[10];
    String[] messageContent = new String[10];
    String[] calls = new String[10];
    int indexOfContacts = 0, indexOfMessages = 0, indexOfCalls = 0;

    public void setColor(String color) {
        this.color = color;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getRemainingBaterryLife() {
        return remainingBatteryLife;
    }

    public void addContact(
            String indexPhoneNumber, String phoneNumber, String firstName, String lastName) {
        contacts[indexOfContacts] =
                ("ContactAdded -> |"
                        + indexPhoneNumber
                        + "--"
                        + phoneNumber
                        + "--"
                        + firstName
                        + "--"
                        + lastName
                        + "|");
        indexOfContacts++;
    }

    public void getFirstContact() {
        System.out.println();
        System.out.println("First contact is " + contacts[0]);
    }

    public void getLastContact() {
        System.out.println("Last contact is " + contacts[indexOfContacts - 1]);
    }

    public void sendMessage(String phoneNumber, String message) {
        if (message.length() <= 100 && remainingBatteryLife != 0) {
            messageContent[indexOfMessages] = "-- ' " + message + " ' --" + "sent to " + phoneNumber;
            indexOfMessages++;
            remainingBatteryLife--;
        }
    }

    public void getFirstMessage(String phoneNumber) {
        if (messageContent[0].contains(phoneNumber)) {
            System.out.println("First message is " + messageContent[0]);
        }
    }

    public void getSecondMessage(String phoneNumber) {
        if (messageContent[1].contains(phoneNumber)) {
            System.out.println("Second message is " + messageContent[1]);
        }
    }

    public void call(String phoneNumber) {
        if (phoneNumber != null && remainingBatteryLife >= 2) {
            calls[indexOfCalls] = phoneNumber;
            indexOfCalls++;
            remainingBatteryLife -= 2;
        }
    }

    public void viewHistory() {
        System.out.println("\n==================================");
        System.out.println("View the history of ur phone :");
        System.out.println("==================================");
        System.out.println("                 ==");
        System.out.println("                 ==");
        System.out.println("         ==      ==      ==");
        System.out.println("             ==  ==  ==");
        System.out.println("                 ==");
        System.out.println("Contacts :");
        for (int i = 0; i < indexOfContacts; i++) {
            System.out.println(" " + contacts[i]);
        }
        System.out.println("\nMessages :");
        for (int i = 0; i < indexOfMessages; i++) {
            System.out.println(messageContent[i]);
        }
        System.out.println("\nCalls :");
        for (int i = 0; i < indexOfCalls; i++) {
            System.out.println("-> " + calls[i]);
        }
        System.out.println("\n==================================");
    }
}