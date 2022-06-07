package machine;
import java.util.Scanner;

public class CoffeeMachine {
    final static Scanner scanner = new Scanner(System.in);
    static int waterAmount = 400;
    static int milkAmount = 540;
    static int beanAmount = 120;
    static int cupAmount = 9;
    static int money = 550;
    static String missingIngredient = "";
    static boolean acting = true;

    public enum Actions {
        BUY, FILL, TAKE, REMAINING, EXIT;
    }

    public static void main(String[] args) {
        String action;

        while (acting) {
            System.out.println("\n" + "Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            processing(action);
        }
    }

    public static void processing(String userInput) {
        String actionForEnum = userInput.toUpperCase();
        Actions userAction = Actions.valueOf(actionForEnum);

        switch (userAction) {
            case BUY:
                buy();
                break;

            case FILL:
                fill();
                break;

            case TAKE:
                System.out.println("I gave you $" + money);
                money -= money;
                break;

            case REMAINING:
                remaining();
                break;

            case EXIT:
                acting = false;
                break;

            default:
                System.out.println("Uh oh, something happened...");
                break;
        }
    }

    public static void buy(){
        System.out.println("What do you want to buy?" +
                " 1 - espresso, 2 - latte, 3 - cappuccino:, back - to main menu:");
        String coffeeType = scanner.nextLine();
        switch (coffeeType) {
            case "1":
                if (waterAmount - 250 >= 0 && beanAmount - 16 >= 0 && cupAmount - 1 >= 0) {
                    System.out.println("I have enough resources, making you a espresso!");
                    waterAmount -= 250;
                    beanAmount -= 16;
                    cupAmount -= 1;
                    money += 4;
                } else {
                    if (waterAmount - 250 <= 0) {
                        missingIngredient = "water";
                    } else if (beanAmount - 16 <= 0) {
                        missingIngredient = "bean";
                    } else if (cupAmount - 1 <= 0) {
                        missingIngredient = "cup";
                    }
                    System.out.println("Sorry, not enough " + missingIngredient + "!");
                }
                break;
            case "2":
                if (waterAmount - 350 >= 0 && milkAmount - 75 >= 0 && beanAmount - 20 >= 0 && cupAmount - 1 >= 0) {
                    System.out.println("I have enough resources, making you a latte!");
                    waterAmount -= 350;
                    milkAmount -= 75;
                    beanAmount -= 20;
                    cupAmount -= 1;
                    money += 7;
                } else {
                    if (waterAmount - 350 <= 0) {
                        missingIngredient = "water";
                    } else if (milkAmount - 75 <= 0) {
                        missingIngredient = "bean";
                    } else if (beanAmount - 20 <= 0) {
                        missingIngredient = "bean";
                    } else if (cupAmount - 1 <= 0) {
                        missingIngredient = "cup";
                    }
                    System.out.println("Sorry, not enough " + missingIngredient + "!");
                }
                break;
            case "3":
                if (waterAmount - 200 >= 0 && milkAmount - 100 >= 0 && beanAmount - 12 >= 0 && cupAmount - 1 >= 0) {
                    System.out.println("I have enough resources, making you a cappuccino!");
                    waterAmount -= 200;
                    milkAmount -= 100;
                    beanAmount -= 12;
                    cupAmount -= 1;
                    money += 6;
                } else {
                    if (waterAmount - 200 <= 0) {
                        missingIngredient = "water";
                    } else if (milkAmount - 100 <= 0) {
                        missingIngredient = "bean";
                    } else if (beanAmount - 12 <= 0) {
                        missingIngredient = "bean";
                    } else if (cupAmount - 1 <= 0) {
                        missingIngredient = "cup";
                    }
                    System.out.println("Sorry, not enough " + missingIngredient + "!");
                }
                break;
            case "back":
                break;
        }
    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        int waterToBeAdded = Integer.parseInt(scanner.nextLine());
        waterAmount += waterToBeAdded;

        System.out.println("Write how many ml of milk you want to add:");
        int milkToBeAdded = Integer.parseInt(scanner.nextLine());
        milkAmount += milkToBeAdded;

        System.out.println("Write how many grams of coffee beans you want to add:");
        int beansToBeAdded = Integer.parseInt(scanner.nextLine());
        beanAmount += beansToBeAdded;
        System.out.println("Write how many disposable cups of coffee you want to add:");
        int cupsToBeAdded = Integer.parseInt((scanner.nextLine()));
        cupAmount += cupsToBeAdded;
    }

    public static void remaining() {
        System.out.println("The coffee machine has: ");
        System.out.println(waterAmount + " ml of water");
        System.out.println(milkAmount + " ml of milk");
        System.out.println(beanAmount + " g of coffee beans");
        System.out.println(cupAmount + " disposable cups");
        System.out.println("$" + money + " of money");
    }

}
