package coffee;

public class CoffeeMachine {
    private Integer cups = 10;
    public Integer sugar = 500;
    public Integer milk = 500;
    public Integer cofe = 200;

    private Boolean pay(Integer banknoteNominal) {
        return banknoteNominal == 5 || banknoteNominal == 10;
    }

    private Boolean enoughComponents() {
        return (this.cups > 0 && this.cofe > 0);
    }

    private String choose(Integer option) {
        if (option == 1) {
            cofe = -1;
            return "Coffee";
        } else if (option == 2) {
            sugar = -3;
            milk = -3;
            cofe = -1;
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
        String coffeeType;
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