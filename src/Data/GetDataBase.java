package Data;

import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import Data.StoredData.Budget.BaseData;

public class GetDataBase extends DataTemplate {
    public boolean isCorrupt() {
        objectMapper = getObjectMapper();
        List<BaseData> dataBaseList = getBaseArrayList();
        try {
            dataBaseList = objectMapper.readValue(baseDataFile, new TypeReference<List<BaseData>>() {
            });
            return dataBaseList == null;
        } catch (IOException e) {
            System.out.println("It appears your data is corrupt");
            return true;
        }
    }

    @Override
    public void path() {
    }

    public List<BaseData> getBaseData() {
        objectMapper = getObjectMapper();
        List<BaseData> dataList = getBaseArrayList();
        try {
            dataList.addAll(objectMapper.readValue(baseDataFile, new TypeReference<List<BaseData>>() {
            }));
            System.out.println(dataList.size());
        } catch (Exception e) {
            System.out.println(e);
        }
        return dataList;
    }

    protected void getPlayerInput(int i) {
    }

    protected void listOrders(int i) {

    }
}
