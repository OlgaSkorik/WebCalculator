package by.skorik.webcalculator.dao;

import by.skorik.webcalculator.entity.Operation;

import java.util.ArrayList;
import java.util.List;

public class OperationDAO {

    private final List<Operation> storeOperation = new ArrayList<>();


    public List<Operation> getStoreOperation() {
        return storeOperation;
    }
}
