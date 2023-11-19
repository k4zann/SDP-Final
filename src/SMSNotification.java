public class SMSNotification implements DeliveryObserver {
    @Override
    public void update(Package pack) {
        System.out.println("SMS notification sent for package to " + pack.getDestination());
    }
}
