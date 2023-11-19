public class InsuranceDecorator extends DeliveryDecorator {
    public InsuranceDecorator(DeliveryStrategy decoratedStrategy) {
        super(decoratedStrategy);
    }

    @Override
    public void deliver(Package pack) {
        decoratedStrategy.deliver(pack);
        System.out.println("Regular option added.");
    }
}
