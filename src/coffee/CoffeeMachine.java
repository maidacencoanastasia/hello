package coffee;

public class CoffeeMachine {
    private Integer cups = 0;

    private Boolean pay(Integer banknoteNominal) {
        if (banknoteNominal == 5 || banknoteNominal == 10) {
            return true;
        }
        return false;
    }

    private Boolean enoughComponents() {
        if (this.cups > 0) {
            return true;
        }
        return false;
    }

    private String choose(Integer option) {
        if (option == 1) {
            return "Coffee";
        } else if (option == 2) {
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

    private Integer updateCup(Integer cups) {
        return cups;
    }

    public void prepare() {
        String coffeeType = "";
        this.showInfo("Please insert banknote");
        if (this.pay(5)) {
            this.showInfo("Please chose option");
            coffeeType = this.choose(1);
            this.showInfo(
                    "You choose is: " + coffeeType
            );
            if (enoughComponents()) {
                this.showInfo("Preparing...");
                cups -= 1;
                updateCup(cups);
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