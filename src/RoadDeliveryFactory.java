public class RoadDeliveryFactory implements DeliveryFactory {
    @Override
    public DeliveryStrategy createDelivery() {
        return new RoadDeliveryStrategy();
    }
}
