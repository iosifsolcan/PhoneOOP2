package ro.Phones;

import ro.Phones.Phone.Phone;
import ro.Phones.Phone.Samsung.SamsungGalaxy6.SamsungGalaxy6;


public class Main {
    public static void main(String[] args) {
        //   Phone phone=new Samsung();
        Phone phone = new SamsungGalaxy6();
        phone.addContact("1", "0712345678", "John", "Cutler");
        phone.addContact("2", "0723456789", "Andrew", "McCarthy");
        phone.getFirstContact();
        phone.getLastContact();
        phone.sendMessage("0712345678", "what u doing , John?");
        phone.sendMessage("0723456789", "Can u help me, Andrew?");
        System.out.println();
        phone.getFirstMessage("0712345678");
        phone.getSecondMessage("0723456789");
        phone.call("0723456789");
        phone.viewHistory();

        // System.out.println("Remaining battery "+phone.getRemainingBaterryLife());
    }
}