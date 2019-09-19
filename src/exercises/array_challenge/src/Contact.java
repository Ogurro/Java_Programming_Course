package exercises.array_challenge.src;

public class Contact {

    private String name;
    private String phoneNumber;

    private Contact(String name, String phoneNumber) {
        setName(name);
        setPhoneNumber(phoneNumber);
    }

    public static Contact createContact(String name, String phoneNUmber) {
        return new Contact(name, phoneNUmber);
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    void setName(String name) {
        this.name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }

    void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
