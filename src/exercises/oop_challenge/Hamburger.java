package exercises.oop_challenge;

import java.util.ArrayList;

public class Hamburger {

    private final String INVALID_VALUE_MSG = "Invalid Value";
    String limitReachedMessage = String.format("Max number of additions %d reached!", this.maxAdditionsCount);

    private String breadRollType;
    private String meatType;
    private double basePrice;
    int maxAdditionsCount = 4;
    private int additionsCount;
    private double additionPrice = 1.50;
    private ArrayList<String> additionList = new ArrayList<>();


    public Hamburger(String breadRollType, String meatType, double basePrice) {
        this.breadRollType = breadRollType;
        this.meatType = meatType;
        setBasePrice(basePrice);
        this.additionsCount = 0;
    }

    private void setBasePrice(double basePrice) {
        this.basePrice = (basePrice > 0.00) ? basePrice : -1;
    }

    public String getHamburgerInfo() {
        String price = getHamburgerPrice();
        String hamburgerName = getHamburgerName();
        return String.format("%s\n%s", hamburgerName, price);
    }

    public void addAddition(String additionName) {

        if (this.additionsCount < this.maxAdditionsCount) {
            additionName = additionName.toLowerCase();
            boolean isAdditionInList = false;
            for (String addition : this.additionList) {
                if (addition.equals(additionName)) {
                    isAdditionInList = true;
                    break;
                }
            }

            if (!isAdditionInList) {
                this.additionList.add(additionName);
                this.additionsCount++;
            }
        } else {
            System.out.println(limitReachedMessage);
        }
    }

    public void removeAddition(String additionName) {
        if (this.additionsCount > 0) {
            boolean isAdditionRemoved = false;
            additionName = additionName.toLowerCase();
            for (String addition : this.additionList) {
                if (addition.equals(additionName)) {
                    this.additionList.remove(additionName);
                    this.additionsCount--;
                    isAdditionRemoved = true;
                    break;
                }
            }
            if (!isAdditionRemoved) {
                System.out.println("No addition '" + additionName + "' found");
            }
        } else {
            System.out.println("No additions to remove!");
        }
    }

    public String getHamburgerPrice() {
        if (this.basePrice != -1) {
            StringBuilder hamburgerPriceBuilder = new StringBuilder();
            hamburgerPriceBuilder.append(String.format("Base Price: %.2f", this.basePrice));
            if (this.additionsCount > 0) {
                hamburgerPriceBuilder.append(getAdditionsString());
            } else {
                hamburgerPriceBuilder.append("\nAdditions: None");
            }
            hamburgerPriceBuilder.append(getHamburgerTotalPrice());
            return hamburgerPriceBuilder.toString();
        }
        return INVALID_VALUE_MSG;
    }

    private String getAdditionsString() {
        StringBuilder additionsBuilder = new StringBuilder();
        additionsBuilder.append(String.format("\nAdditions: %.2f = %d * %.2f", getAdditionsPrice(), this.additionsCount, this.additionPrice));
        for (String addition : this.additionList) {
            additionsBuilder.append(String.format("\n\t%s", addition));
        }
        return additionsBuilder.toString();
    }

    private String getHamburgerTotalPrice() {
        double totalPrice = this.basePrice;
        if (this.additionsCount > 0) {
            totalPrice += getAdditionsPrice();
        }
        return String.format("\nTotal price: %.2f", totalPrice);
    }

    private double getAdditionsPrice() {
        return (this.additionsCount * additionPrice);
    }

    private String getHamburgerName() {
        return String.format("%s hamburger in %s bread.", this.meatType, this.breadRollType);
    }
}