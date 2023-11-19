import java.util.ArrayList;
import java.util.List;

public class Package {
    private double weight;
    private String destination;
    private int warehouseId;
    private DeliveryStrategy deliveryStrategy;
    public List<DeliveryObserver> observers;

    public Package(double weight, String destination) {
        this.weight = weight;
        this.destination = destination;
        this.observers = new ArrayList<>();
    }

    public double getWeight() {
        return weight;
    }

    public String getDestination() {
        return destination;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public DeliveryStrategy getDeliveryStrategy() {
        return deliveryStrategy;
    }

    public void setDeliveryStrategy(DeliveryStrategy deliveryStrategy) {
        this.deliveryStrategy = deliveryStrategy;
    }

    public void addObserver(DeliveryObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(DeliveryObserver observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (DeliveryObserver observer : observers) {
            observer.update(this);
        }
    }

    public void deliver() {
        if (deliveryStrategy != null) {
            deliveryStrategy.deliver(this);
            notifyObservers();
        } else {
            System.out.println("Error: Delivery strategy not selected.");
        }
    }
}
