package Data;

import java.io.File;
import java.util.ArrayList;

import Data.StoredData.Budget.SpendingData;

public class RemoveData extends DataTemplate {
    // From Create data, fix later
    public void path() {
        objectMapper = getObjectMapper();
        genData(managePlayerInput());
    }

    protected void getPlayerInput(int i) {
        scanner = getScanner();
        switch (i) {
            case 1:
                spendingName = scanner.nextLine();
                break;
            case 2:
                spendingCost = scanner.nextDouble();
                break;
            case 3:
                spendingValue = scanner.nextInt();
                break;
            default:
                break;
        }
    }

    protected ArrayList<SpendingData> managePlayerInput() {
        for (int i = 0; i <= 3; i++) {
            listOrders(i);
            getPlayerInput(i);
        }
        spendingArrayList = getSpendingArrayList();
        spendingArrayList.add(createSpendingObject());
        spendingArrayList.add(objectMapper.convertValue(createSpendingObject(), SpendingData.class));
        System.out.println(spendingArrayList);
        spendingName = null;
        spendingCost = -1;
        spendingValue = -1;
        return spendingArrayList;
    }

    private void genData(ArrayList<SpendingData> arrayList) {
        try {
            objectMapper.writeValue(new File("BaseData.json"), arrayList);
        } catch (Exception e) {
            System.out.println("Error in accessing File");
        }
    }

    protected void listOrders(int i) {
        switch (i) {
            case 1:
                System.out.println("Please Enter the name of the spending: ");
                break;
            case 2:
                System.out.println("Please Enter the cost: ");
                break;
            case 3:
                System.out.println("Please Enter the value(1-3, most to least important): ");
                break;
            default:
                break;
        }
    }
}
