public class AirDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void deliver(Package pack) {
        System.out.println("Delivering package by air to " + pack.getDestination());
    }
}
