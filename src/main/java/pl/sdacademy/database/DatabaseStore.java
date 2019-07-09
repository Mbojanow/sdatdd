package pl.sdacademy.database;

import pl.sdacademy.exceptions.DatabaseStoreException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatabaseStore {

    private List<String> data = new ArrayList<>();
    private final DatabaseConnection databaseConnection;

    public DatabaseStore(final DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public void clean() {
        data.clear();
    }

    public void addData(/*final String value,*/ final String ...values) {
        if (!databaseConnection.isOpened()) {
            throw new DatabaseStoreException("Connection is not opened. Cannot add data");
        }
        //data.add(value);
        data.addAll(Arrays.asList(values));
    }

    public void removeData(final String ...toRemove) {
        if (!databaseConnection.isOpened()) {
            throw new DatabaseStoreException("Connection is not opened. Cannot remove data");
        }
        data.removeAll(Arrays.asList(toRemove));
    }

    public List<String> getData() {
        return data;
    }
}
