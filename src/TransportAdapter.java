// Adapter
public class TransportAdapter implements DeliveryStrategy {
    private Transport transport;

    public TransportAdapter(Transport transport) {
        this.transport = transport;
    }

    @Override
    public void deliver(Package pack) {
        transport.deliverByTransport(pack);
    }
}
