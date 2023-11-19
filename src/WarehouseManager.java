import java.util.ArrayList;
import java.util.List;

//Singleton
public class WarehouseManager {
    private static WarehouseManager instance;
    private List<Warehouse> warehouses;

    private WarehouseManager() {
        warehouses = new ArrayList<>();
    }

    public static WarehouseManager getInstance() {
        if (instance == null) {
            instance = new WarehouseManager();
        }
        return instance;
    }

    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
    }

    public Warehouse findWarehouseById(int warehouseId) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getId() == warehouseId) {
                return warehouse;
            }
        }
        return null;
    }
}
