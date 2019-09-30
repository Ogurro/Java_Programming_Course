package learning.java;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone();
    private static final String CONTACT_NOT_FOUND = "Contact does not exists";

    public static void main(String[] args) {
        boolean runApp = true;
        int choice = 0;
        printInstructions();
        while (runApp) {
            System.out.print("\nEnter your choice: ");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            } else {
                System.out.println("Invalid input");
            }
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    mobilePhone.printContactList();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    findContact();
                    break;
                case 9:
                    runApp = false;
                    System.out.println("Turned off mobile phone");
            }
        }
    }

    private static void printInstructions() {
        System.out.println("0: print instructions");
        System.out.println("1: print contacts");
        System.out.println("2: add contact");
        System.out.println("3: modify contact");
        System.out.println("4: remove contact");
        System.out.println("5: find contact");
        System.out.println("9: Turn off mobile phone");
    }

    private static void addContact() {
        System.out.print("Enter contact name: ");
        String name = scanner.nextLine();

        System.out.print("Enter contact phone number: ");
        String phoneNumber = scanner.nextLine();

        mobilePhone.addContact(name, phoneNumber);
    }

    private static void modifyContact() {
        System.out.print("Enter name of contact to modify: ");
        String name = scanner.nextLine();
        if (mobilePhone.contactOnFile(name)) {
            System.out.println("1: modify name");
            System.out.println("2: modify phone");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    mobilePhone.modifyContactName(name, newName);
                    break;
                case 2:
                    System.out.print("Enter new phone number: ");
                    String phoneNumber = scanner.nextLine();
                    mobilePhone.modifyContactPhoneNumber(name, phoneNumber);
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;
            }
        } else {
            System.out.println(CONTACT_NOT_FOUND);
        }
    }

    private static void removeContact() {
        System.out.print("Enter name of contact to remove: ");
        String name = scanner.nextLine();
        if (mobilePhone.contactOnFile(name)) {
            mobilePhone.printContact(name);
            System.out.print("Confirm removal [y|n]: ");
            if (scanner.nextLine().toLowerCase().equals("y")) {
                mobilePhone.removeContact(name);
            } else {
                System.out.println("Action failed");
            }
        } else {
            System.out.println(CONTACT_NOT_FOUND);
        }
    }
    
    private static void findContact() {
        System.out.print("Enter name of contact to find: ");
        String name = scanner.nextLine();
        if (mobilePhone.contactOnFile(name)) {
            mobilePhone.printContact(name);
        } else {
            System.out.println(CONTACT_NOT_FOUND);
        }
    }
}
