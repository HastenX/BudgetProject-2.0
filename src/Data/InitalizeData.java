package Data;

import java.io.IOException;
import java.util.Scanner;

import com.fasterxml.jackson.databind.ObjectMapper;

import Data.StoredData.Budget.BaseData;

public class InitalizeData extends DataTemplate {

    private Scanner scanner;

    public void path() {
        objectMapper = getObjectMapper();
        if ((new GetDataBase().isCorrupt())) {
            BaseData newData = managePlayerInput();
            genData(newData);
            // }
            // try {
            // List<BaseData> baseData = objectMapper.readValue(baseDataFile, new
            // TypeReference<List<BaseData>>() {
            // });
            // } catch (Exception e) {
            // }
            // getFromMenu(false);
        }
    }

    public void getFromMenu() {
        BaseData newData = managePlayerInput();
        genData(newData);
    }

    public void listOrders(int i) {
        switch (i) {
            case 1:
                System.out.println("Enter your new Annual Salary: ");
                break;
            case 2:
                System.out.println("Enter your new Debt: ");
                break;
            case 3:
                System.out.println("Enter your new Savings");
                break;
            case 4:
                System.out.println("Enter your new APY");
            default:
                break;
        }
    }

    protected void getPlayerInput(int i) {
        scanner = new Scanner(System.in);
        switch (i) {
            case 1:
                baseSalary = scanner.nextDouble();
                break;
            case 2:
                baseDebt = scanner.nextDouble();
                break;
            case 3:
                baseSavings = scanner.nextDouble();
                break;
            case 4:
                baseAPY = scanner.nextDouble();
                break;
            default:
                break;
        }
    }

    private BaseData managePlayerInput() {
        for (int i = 1; i <= 4; i++) {
            listOrders(i);
            getPlayerInput(i);
        }
        return new BaseData(baseSalary, baseDebt, baseSavings, baseAPY);
    }

    private void genData(BaseData baseData) {
        objectMapper = new ObjectMapper();
        baseDataList = getBaseArrayList();
        baseDataList.add(baseData);
        try {
            objectMapper.writeValue(baseDataFile, baseDataList);
        } catch (IOException e) {
        }

    }
}
