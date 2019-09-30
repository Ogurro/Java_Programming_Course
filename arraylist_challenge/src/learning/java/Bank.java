package learning.java;

import java.util.ArrayList;

public class Bank {

    private static final String INVALID_BRANCH_NAME = "Branch does not exists";
    private static final String BRANCH_EXIST = "Branch already exists";

    private String bankName;
    private ArrayList<Branch> branchList;

    public Bank(String bankName) {
        this.bankName = bankName.toLowerCase();
        this.branchList = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void getBranchList() {
        System.out.println("Branch List:");
        if (this.branchList.isEmpty()) {
            System.out.println("\tEMPTY");
        }
        for (Branch branch : this.branchList) {
            System.out.println(String.format("\t%s", branch.getBranchName()));
        }
    }

    public void createBranch(String branchName) {
        if (findBranch(branchName)) {
            System.out.println(BRANCH_EXIST);
        } else {
            this.branchList.add(Branch.createBranch(branchName));
            System.out.println("Branch created");
        }
    }

    public void modifyBranch(String branchName, String newBranchName) {
        int branchId = getBranchId(branchName);
        if (branchId < 0) {
            System.out.println(INVALID_BRANCH_NAME);
        } else {
            if (findBranch(newBranchName)) {
                System.out.println(BRANCH_EXIST);
            } else {
                this.branchList.get(branchId).setBranchName(newBranchName);
                System.out.println("Branch name updated");
            }
        }
    }

    public void removeBranch(String branchName) {
        int branchId = getBranchId(branchName);
        if (branchId < 0) {
            System.out.println(INVALID_BRANCH_NAME);
        } else {
            this.branchList.remove(branchId);
            System.out.println("Branch removed");
        }
    }

    public void getCustomerList(String branchName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.getCustomerList();
        }
    }

    public void getCustomersTransactions(String branchName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.getCustomerTransactions();
        }
    }

    public void getCustomersBalance(String branchName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.getCustomerBalance();
        }
    }

    public void addCustomerToBranch(String branchName, String customerName, double initialTransaction) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.createCustomer(customerName, initialTransaction);
        }
    }

    public void modifyCustomerInBranch(String branchName, String customerName, String newCustomerName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.modifyCustomer(customerName, newCustomerName);
        }
    }

    public void removeCustomerFromBranch(String branchName, String customerName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.removeCustomer(customerName);
        }
    }

    public void addTransactionForCustomerInBranch(String branchName, String customerName, double transaction) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.addTransactionForCustomer(customerName, transaction);
        }
    }

    public void showCustomerBalance(String branchName, String customerName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.getCustomerBalance(customerName);
        }
    }

    public void showCustomerTransactions(String branchName, String customerName) {
        Branch branch = getBranch(branchName);
        if (branch != null) {
            branch.getCustomerTransactions(customerName);
        }
    }

    public Branch getBranch(String branchName) {
        int branchId = getBranchId(branchName);
        if (branchId < 0) {
            System.out.println(INVALID_BRANCH_NAME);
            return null;
        } else {
            return this.branchList.get(branchId);
        }
    }

    private int getBranchId(String branchName) {
        for (Branch branch : this.branchList) {
            if (branch.getBranchName().equals(branchName.toLowerCase())) {
                return this.branchList.indexOf(branch);
            }
        }
        return -1;
    }

    public boolean findBranch(String branchName) {
        for (Branch branch : this.branchList) {
            if (branch.getBranchName().equals(branchName.toLowerCase())) {
                return true;
            }
        }
        return false;
    }
}
