package coffee;

import org.jetbrains.annotations.Contract;

public class CoffeeMachine {
    private Integer cups = 10;
    public Integer sugar = 500;
    public Integer milk = 500;
    public Integer cofe = 200;

    private Boolean pay(Integer banknoteNominal) {
        return banknoteNominal == 5 || banknoteNominal == 10;
    }

    @Contract(pure = true)
    private Boolean enoughComponents(Integer cofe, Integer cups) {
        return (this.cofe > 0 && this.cups > 0);
    }

    private void UpdateIngridiens(Integer cofe, Integer sugar, Integer milk, Integer cups) {
        this.cups = cups - 1;
        this.cofe = cofe - 1;
        this.milk = milk - 3;
        this.sugar = sugar - 3;
    }

    private void UpdateIngridiens(Integer cofe, Integer cups) {
        this.cups = cups - 1;
        this.cofe = cofe - 1;
    }

    private String choose(Integer option) {
        if (option == 1) {
            UpdateIngridiens(cofe, cups);
            return "Coffee";
        } else if (option == 2) {
            UpdateIngridiens(cofe, sugar, milk, cups);
            return "Cappuccino";
        }
        return "Incorrect option";
    }

    private void showInfo(String message) {
        System.out.println(message);
    }

    private String done(String coffeeType) {
        return coffeeType;
    }

//    private Integer updateCup(Integer cups) {
//        return cups;
//    }

    public void prepare() {
        String coffeeType;
        this.showInfo("Please insert banknote");
        if (this.pay(5)) {
            this.showInfo("Please chose option");
            coffeeType = this.choose(1);
            this.showInfo(
                    "You choose is: " + coffeeType
            );
            if (enoughComponents(cofe, cups)) {
                this.showInfo("Preparing...");
//                cups -= 1;
//                updateCup(cups);
                this.showInfo(
                        "Done: " + this.done(coffeeType)
                );
            } else {
                this.showInfo("No cup for preparing you " + this.done(coffeeType));
            }
        } else {
            this.showInfo("Please insert correct banknote");
        }
    }
}