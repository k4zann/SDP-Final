public class EmailNotification implements DeliveryObserver {
    @Override
    public void update(Package pack) {
        System.out.println("Email notification sent for package to " + pack.getDestination());
    }
}
