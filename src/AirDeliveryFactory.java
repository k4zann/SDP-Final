public class AirDeliveryFactory implements DeliveryFactory {
    @Override
    public DeliveryStrategy createDelivery() {
        return new AirDeliveryStrategy();
    }
}
