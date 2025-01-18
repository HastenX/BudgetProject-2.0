package Line;

import java.util.Scanner;

import Data.*;

public class Menu {
    public boolean isFinished;

    private Scanner scanner;

    public void path() {
        while (!isFinished) {
            // new Initalize().path();
            new Menu().listOptions();
            new Menu().sendToLocation(new Menu().getPlayerInput());
        }
    }

    private void listOptions() {
        System.out.println("Please selct an option for the Budget:"
                + "\n1 : Create a new source of spending"
                + "\n2 : Manage current budget"
                + "\n3 : Remove current budget data"
                + "\n4 : Get current budget data");
    }

    private int getPlayerInput() {
        scanner = new Scanner(System.in);
        return getLocation(scanner);
    }

    @SuppressWarnings("resource")
    private int getLocation(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Enter a listed number");
                scanner = new Scanner(System.in);
            }
        }
    }

    private void sendToLocation(int location) {
        switch (location) {
            case 1:
                new CreateData().path();
                break;
            case 2:
                new AdjustData().path();
                break;
            case 3:
                new RemoveData().path();
                break;
            case 4:
                new RemoveData().path();
                break;
            default:
                System.out.println("Enter a number with the given paremeters");
                new Menu().getPlayerInput();
                break;
        }
    }
}
