public class ExpressDeliveryDecorator extends DeliveryDecorator {
    public ExpressDeliveryDecorator(DeliveryStrategy decoratedStrategy) {
        super(decoratedStrategy);
    }

    @Override
    public void deliver(Package pack) {
        decoratedStrategy.deliver(pack);
        System.out.println("Express delivery option added.");
    }
}
