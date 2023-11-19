public abstract class DeliveryDecorator implements DeliveryStrategy {
    protected DeliveryStrategy decoratedStrategy;

    public DeliveryDecorator(DeliveryStrategy decoratedStrategy) {
        this.decoratedStrategy = decoratedStrategy;
    }

    @Override
    public void deliver(Package pack) {
        decoratedStrategy.deliver(pack);
    }
}
