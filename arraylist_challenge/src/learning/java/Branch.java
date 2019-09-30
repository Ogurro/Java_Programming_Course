package learning.java;

import java.util.ArrayList;
import java.util.Arrays;

public class Branch {

    private static final String INVALID_CUSTOMER_NAME = "Customer does not exists";
    private static final String CUSTOMER_EXIST = "Customer already exists";

    private ArrayList<Customer> customerList;
    private String branchName;

    private Branch(String branchName) {
        setBranchName(branchName);
        this.customerList = new ArrayList<>();
    }

    static Branch createBranch(String branchName) {
        return new Branch(branchName);
    }

    public String getBranchName() {
        return this.branchName;
    }

    void setBranchName(String branchName) {
        this.branchName = branchName.toLowerCase();
    }

    public void createCustomer(String customerName, double initialTransaction) {
        if (findCustomer(customerName)) {
            System.out.println(CUSTOMER_EXIST);
        } else {
            this.customerList.add(Customer.createCustomer(customerName, initialTransaction));
            System.out.println("Customer created");
        }
    }

    public void modifyCustomer(String customerName, String newCustomerName) {
        int customerId = getCustomerId(customerName);
        if (customerId < 0) {
            System.out.println(INVALID_CUSTOMER_NAME);
        } else {
            if (findCustomer(newCustomerName)) {
                System.out.println(CUSTOMER_EXIST);
            } else {
                this.customerList.get(customerId).setName(newCustomerName);
                System.out.println("Customer name updated");
            }
        }
    }

    public void removeCustomer(String customerName) {
        int customerId = getCustomerId(customerName);
        if (customerId < 0) {
            System.out.println(INVALID_CUSTOMER_NAME);
        } else {
            this.customerList.remove(customerId);
            System.out.println("Customer removed");
        }
    }

    public void addTransactionForCustomer(String customerName, double transaction) {
        Customer customer = this.getCustomer(customerName);
        if (customer != null) {
            if (customer.addTransaction(transaction)) {
                System.out.println("Transaction added");
            } else {
                System.out.println("Transaction failed");
            }
        }
    }

    public void getCustomerList() {
        System.out.println(String.format("Customers List for branch %s: ", this.getBranchName()));
        if (this.customerList.isEmpty()) {
            System.out.println("\tEMPTY");
        } else {
            for (Customer customer : this.customerList) {
                System.out.println(String.format("\t%s", customer.getName()));
            }
        }
    }

    public void getCustomerTransactions() {
        System.out.println(String.format("Customers Transactions for branch %s: ", this.getBranchName()));
        if (this.customerList.isEmpty()) {
            System.out.println("\tEMPTY");
        } else {
            for (Customer customer : this.customerList) {
                System.out.println(String.format("\t%s : %s", customer.getName(), Arrays.toString(customer.getTransactions())));
            }
        }
    }

    public void getCustomerTransactions(String customerName) {
        Customer customer = this.getCustomer(customerName);
        if (customer != null) {
            System.out.println(String.format("\t%s : %s", customer.getName(), Arrays.toString(customer.getTransactions())));
        }
    }

    public void getCustomerBalance() {
        System.out.println(String.format("Customers Balance for branch %s: ", this.getBranchName()));
        if (this.customerList.isEmpty()) {
            System.out.println("\tEMPTY");
        } else {
            for (Customer customer : this.customerList) {
                System.out.println(String.format("\t%s : %s", customer.getName(), customer.getBalance()));
            }
        }
    }

    public void getCustomerBalance(String customerName) {
        Customer customer = this.getCustomer(customerName);
        if (customer != null) {
            System.out.println(String.format("\t%s : %.2f", customer.getName(), customer.getBalance()));
        }
    }

    private Customer getCustomer(String customerName) {
        int customerId = getCustomerId(customerName);
        if (customerId < 0) {
            System.out.println(INVALID_CUSTOMER_NAME);
            return null;
        } else {
            return this.customerList.get(customerId);
        }
    }

    private int getCustomerId(String customerName) {
        for (Customer customer : this.customerList) {
            if (customer.getName().equals(customerName.toLowerCase())) {
                return this.customerList.indexOf(customer);
            }
        }
        return -1;
    }

    private boolean findCustomer(String customerName) {
        for (Customer customer : this.customerList) {
            if (customer.getName().equals(customerName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
