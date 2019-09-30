package learning.java;

import java.util.ArrayList;

public class MobilePhone {

    private ArrayList<Contact> contactList;

    public MobilePhone() {
        this.contactList = new ArrayList<>();
    }

    public void printContactList() {
        StringBuilder contactListBuilder = new StringBuilder();
        contactListBuilder.append("Contact List: ");
        if (!this.contactList.isEmpty()) {
            for (Contact contact : this.contactList) {
                contactListBuilder.append(String.format("\n\t%s : %s", contact.getName(), contact.getPhoneNumber()));
            }
        } else {
            contactListBuilder.append("\n\tEMPTY");
        }
        System.out.println(contactListBuilder.toString());
    }

    public void printContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            printContact(position);
        } else {
            System.out.println("Action failed");
        }
    }

    private void printContact(int position) {
        Contact contact = this.contactList.get(position);
        System.out.println(String.format("%s : %s", contact.getName(), contact.getPhoneNumber()));
    }

    public void addContact(String contactName, String phoneNumber) {
        if (findContact(contactName.toLowerCase()) == -1) {
            this.contactList.add(Contact.createContact(contactName, phoneNumber));
            System.out.println("New contact created");
        } else {
            System.out.println("Contact with this name already exists");
        }
    }

    public void modifyContactName(String oldName, String newName) {
        int position = findContact(oldName);
        if (position >= 0) {
            modifyContactName(position, newName);

        } else {
            System.out.println("Contact does not exists");
        }
    }

    private void modifyContactName(int position, String newName) {
        Contact contact = this.contactList.get(position);
        if (contactOnFile(newName)) {
            System.out.println("Contact with this name already exists");
        } else {
            contact.setName(newName);
            this.contactList.set(position, contact);
            System.out.println("Contact name has been updated");
        }
    }

    public void modifyContactPhoneNumber(String name, String newPhoneNumber) {
        int position = findContact(name);
        if (position >= 0) {
            modifyContactPhoneNumber(position, newPhoneNumber);
            System.out.println("Contact phone number has been updated");
        } else {
            System.out.println("Contact does not exists");
        }
    }

    private void modifyContactPhoneNumber(int position, String newPhoneNumber) {
        Contact contact = this.contactList.get(position);
        contact.setPhoneNumber(newPhoneNumber);
        this.contactList.set(position, contact);
    }

    public void removeContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            removeContact(position);
        } else {
            System.out.println("Action failed");
        }
    }

    private void removeContact(int position) {
        this.contactList.remove(position);
        System.out.println("Contact has been removed");
    }

    public boolean contactOnFile(String contactName) {
        if (!this.contactList.isEmpty()) {
            for (Contact contact : this.contactList) {
                if (contact.getName().toLowerCase().equals(contactName.toLowerCase())) {
                    return true;
                }
            }
        }
        return false;
    }

    private int findContact(String contactName) {
        if (!this.contactList.isEmpty()) {
            for (Contact contact : this.contactList) {
                if (contact.getName().toLowerCase().equals(contactName.toLowerCase())) {
                    return contactList.indexOf(contact);
                }
            }
        }
        return -1;
    }

}
