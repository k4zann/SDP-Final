public class RoadDeliveryStrategy implements DeliveryStrategy {
    @Override
    public void deliver(Package pack) {
        System.out.println("Delivering package by road to " + pack.getDestination());
    }
}
