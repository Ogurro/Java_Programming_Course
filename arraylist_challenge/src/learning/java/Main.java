package learning.java;

import java.util.Scanner;

public class Main {

    private static final String INVALID_INPUT = "Invalid input";
    private static final String ACTION_FAILED = "Action Failed";

    private static Scanner scanner = new Scanner(System.in);
    private static Bank bank = new Bank("My Bank");
    private static Branch branch;

    public static void main(String[] args) {
        boolean quit = false;
        boolean quitBranch = false;
        int mainChoice;
        int branchChoice;
        System.out.println(String.format("Welcome to %s!", bank.getBankName()));
        printActions();
        while (!quit) {
            System.out.print("\nEnter choice (0 for action list): ");
            if (scanner.hasNextInt()) {
                mainChoice = scanner.nextInt();
            } else {
                System.out.println(INVALID_INPUT);
                mainChoice = 0;
            }
            scanner.nextLine();
            switch (mainChoice) {
                case -1:
                    System.out.println("Bye bye");
                    quit = true;
                    break;
                case 0:
                    printActions();
                    break;
                case 1:
                    bank.getBranchList();
                    break;
                case 2:
                    addBranch();
                    break;
                case 3:
                    modifyBranch();
                    break;
                case 4:
                    removeBranch();
                    break;
                case 5:
                    branch = chooseBranch();
                    if (branch != null) {
                        System.out.println(String.format("\nWorking on branch ! %s !", branch.getBranchName().toUpperCase()));
                        printBranchActions();
                        while (!quitBranch) {
                            System.out.println(String.format("\nWorking on branch ! %s !", branch.getBranchName().toUpperCase()));
                            System.out.print("\nEnter choice (0 for action list): ");
                            if (scanner.hasNextInt()) {
                                branchChoice = scanner.nextInt();
                            } else {
                                System.out.println(INVALID_INPUT);
                                branchChoice = 0;
                            }
                            scanner.nextLine();
                            switch (branchChoice) {
                                case -1:
                                    System.out.println(String.format("Going back to bank ! %s !", bank.getBankName().toUpperCase()));
                                    quitBranch = true;
                                    branch = null;
                                    break;
                                case 0:
                                    printBranchActions();
                                    break;
                                case 1:
                                    branch.getCustomerList();
                                    break;
                                case 2:
                                    addCustomer();
                                    break;
                                case 3:
                                    modifyCustomer();
                                    break;
                                case 4:
                                    removeCustomer();
                                    break;
                                case 5:
                                    addTransactionForCustomer();
                                    break;
                                case 6:
                                    showTransactionsForCustomer();
                                    break;
                                case 7:
                                    showBalanceForCustomer();
                                    break;
                                case 8:
                                    branch.getCustomerTransactions();
                                    break;
                                case 9:
                                    branch.getCustomerBalance();
                                    break;
                                default:
                                    System.out.println(INVALID_INPUT);
                                    printBranchActions();
                                    break;
                            }
                        }
                    } else {
                        System.out.println(INVALID_INPUT);
                    }
                    quitBranch = false;
                    break;
                case 6:
                    getCustomerListForBranch();
                    break;
                case 7:
                    getCustomersTransactionsForBranch();
                    break;
                case 8:
                    getCustomersBalanceForBranch();
                    break;
                case 9:
                    addCustomerToBranch();
                    break;
                case 10:
                    modifyCustomerInBranch();
                    break;
                case 11:
                    removeCustomerFromBranch();
                    break;
                case 12:
                    addTransactionForCustomerInBranch();
                    break;
                case 13:
                    showTransactionsForCustomerInBranch();
                    break;
                case 14:
                    showBalanceForCustomerInBranch();
                    break;
                default:
                    System.out.println(INVALID_INPUT);
                    printActions();
                    break;
            }
        }
    }

    private static void printActions() {
        System.out.println(
                "-1: Exit App\n" +
                "0: Print Actions\n" +
                "1: Show Branch List\n" +
                "2: Add Branch\n" +
                "3: Modify Branch\n" +
                "4: Remove Branch\n" +
                "5: Choose Branch to work on\n" +
                "6: Show Customer List for Branch\n" +
                "7: Show Customers Transactions Branch\n" +
                "8: Show Customers Balance Branch\n" +
                "9: Add Customer to Branch\n" +
                "10: Modify Customer in Branch\n" +
                "11: Remove Customer from Branch\n" +
                "12: Add Transaction for Customer in Branch\n" +
                "13: Show Transactions for Customer in Branch\n" +
                "14: Show Balance for Customer in Branch\n"
        );

    }

    private static void printBranchActions() {
        System.out.println(
                "-1: Exit Branch\n" +
                "0: Print Branch Actions\n" +
                "1: Show Customer List\n" +
                "2: Add Customer\n" +
                "3: Modify Customer\n" +
                "4: Remove Customer\n" +
                "5: Add Transaction For Customer\n" +
                "6: Get Customer Transactions\n" +
                "7: Get Customer Balance\n" +
                "8: Get All Customers Transactions\n" +
                "9: Get All Customers Balance\n"
        );

    }

    private static String getBranchNameInput() {
        System.out.print("Enter branch name: ");
        return scanner.nextLine();
    }

    private static String getCustomerNameInput() {
        System.out.print("Enter customer name: ");
        return scanner.nextLine();
    }

    private static double getTransactionInput() {
        double transaction;
        while (true) {
            System.out.print("Enter transaction value: ");
            if (scanner.hasNextDouble()) {
                transaction = scanner.nextDouble();
                break;
            } else {
                System.out.println(INVALID_INPUT);
            }
            scanner.nextLine();
        }
        return transaction;
    }

    private static void addBranch() {
        System.out.println("Adding new branch");
        String branchName = getBranchNameInput();
        bank.createBranch(branchName);
    }

    private static void addCustomer() {
        System.out.println("Adding new customer");
        String customerName = getCustomerNameInput();
        double initialTransaction = getTransactionInput();
        branch.createCustomer(customerName, initialTransaction);
    }

    private static void modifyBranch() {
        System.out.println("Modifying branch");
        String branchName = getBranchNameInput();
        System.out.print("Enter NEW branch name: ");
        String newBranchName = scanner.nextLine();
        bank.modifyBranch(branchName, newBranchName);
    }

    private static void modifyCustomer() {
        System.out.println("Modifying customer");
        String customerName = getCustomerNameInput();
        System.out.print("Enter NEW Customer name: ");
        String newCustomerName = scanner.nextLine();
        branch.modifyCustomer(customerName, newCustomerName);
    }

    private static void removeBranch() {
        System.out.println("Removing branch");
        String branchName = getBranchNameInput();
        System.out.print(String.format("Confirm delete of %s branch [y|n]: ", branchName.toUpperCase()));
        if (scanner.nextLine().toLowerCase().equals("y")) {
            bank.removeBranch(branchName);
        } else {
            System.out.println(ACTION_FAILED);
        }
    }

    private static void removeCustomer() {
        System.out.println("Removing customer");
        String customerName = getCustomerNameInput();
        System.out.print(String.format("Confirm delete of %s customer [y|n]: ", customerName.toUpperCase()));
        if (scanner.nextLine().toLowerCase().equals("y")) {
            branch.removeCustomer(customerName);
        } else {
            System.out.println(ACTION_FAILED);
        }
    }

    private static Branch chooseBranch() {
        System.out.println("Moving to branch");
        String branchName = getBranchNameInput();
        if (bank.findBranch(branchName)) {
            return bank.getBranch(branchName);
        }
        return null;
    }

    private static void getCustomerListForBranch() {
        System.out.println("Choosing branch for customer list");
        String branchName = getBranchNameInput();
        bank.getCustomerList(branchName);
    }

    private static void getCustomersTransactionsForBranch() {
        System.out.println("Choosing branch for customers transactions");
        String branchName = getBranchNameInput();
        bank.getCustomersTransactions(branchName);
    }

    private static void getCustomersBalanceForBranch() {
        System.out.println("Choosing branch for customers balance");
        String branchName = getBranchNameInput();
        bank.getCustomersBalance(branchName);
    }

    private static void addCustomerToBranch() {
        System.out.println("Adding new customer to branch");
        String branchName = getBranchNameInput();
        String customerName = getCustomerNameInput();
        double initialTransaction = getTransactionInput();
        bank.addCustomerToBranch(branchName, customerName, initialTransaction);
    }

    private static void modifyCustomerInBranch() {
        System.out.println("Modifying customer in branch");
        String branchName = getBranchNameInput();
        String customerName = getCustomerNameInput();
        System.out.print("Enter NEW customer name: ");
        String newCustomerName = scanner.nextLine();
        bank.modifyCustomerInBranch(branchName, customerName, newCustomerName);
    }

    private static void removeCustomerFromBranch() {
        System.out.println("Removing customer from branch");
        String branchName = getBranchNameInput();
        String customerName = getCustomerNameInput();
        System.out.print(String.format("Confirm delete of %s user in %s branch [y|n]: ", customerName.toUpperCase(), branchName.toUpperCase()));
        if (scanner.nextLine().toLowerCase().equals("y")) {
            bank.removeCustomerFromBranch(branchName, customerName);
        } else {
            System.out.println(ACTION_FAILED);
        }
    }

    private static void addTransactionForCustomerInBranch() {
        System.out.println("Adding transaction for customer in branch");
        String branchName = getBranchNameInput();
        String customerName = getCustomerNameInput();
        double transaction = getTransactionInput();
        bank.addTransactionForCustomerInBranch(branchName, customerName, transaction);
    }

    private static void addTransactionForCustomer() {
        System.out.println("Adding transaction for customer");
        String customerName = getCustomerNameInput();
        double transaction = getTransactionInput();
        branch.addTransactionForCustomer(customerName, transaction);
    }

    private static void showTransactionsForCustomerInBranch() {
        System.out.println("Showing transactions for customer in branch");
        String branchName = getBranchNameInput();
        String customerName = getCustomerNameInput();
        bank.showCustomerTransactions(branchName, customerName);
    }

    private static void showTransactionsForCustomer() {
        System.out.println("Showing transactions for customer");
        String customerName = getCustomerNameInput();
        branch.getCustomerTransactions(customerName);
    }

    private static void showBalanceForCustomerInBranch() {
        System.out.println("Showing balance for customer in branch");
        String branchName = getBranchNameInput();
        String customerName = getCustomerNameInput();
        bank.showCustomerBalance(branchName, customerName);
    }

    private static void showBalanceForCustomer() {
        System.out.println("Showing balance for customer");
        String customerName = getCustomerNameInput();
        branch.getCustomerBalance(customerName);
    }
}
