import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        WarehouseManager manager = WarehouseManager.getInstance();
        Package currentPackage = null;

        while (true) {
            System.out.println("Choose option:");
            System.out.println("1. Create new package");
            System.out.println("2. Add a new warehouse");
            System.out.println("3. Choose warehouse");
            System.out.println("4. Choose type of delivery");
            System.out.println("5. Add option of delivery");
            System.out.println("6. Send package");
            System.out.println("7. Type of notification");
            System.out.println("8. Delete the observer");
            System.out.println("9. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> {
                    System.out.println("Weight of package:: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.println("Place of destination: ");
                    String destination = scanner.nextLine();
                    currentPackage = new Package(weight, destination);
                }
                case 2 -> {
                    System.out.println("Enter warehouse ID to add: ");
                    int newWarehouseId = scanner.nextInt();
                    Warehouse newWarehouse = new Warehouse(newWarehouseId);
                    manager.addWarehouse(newWarehouse);
                    System.out.println("Warehouse added successfully.");
                }
                case 3 -> {
                    System.out.println("Enter warehouse ID to find: ");
                    int findWarehouseId = scanner.nextInt();
                    Warehouse foundWarehouse = manager.findWarehouseById(findWarehouseId);
                    if (foundWarehouse != null) {
                        System.out.println("Warehouse found: ID " + foundWarehouse.getId());
                        currentPackage.setWarehouseId(findWarehouseId);
                    } else {
                        System.out.println("Warehouse not found.");
                    }
                }
                case 4 -> {
                    System.out.println("Choose delivery type:");
                    System.out.println("1. Road delivery");
                    System.out.println("2. Air delivery");
                    int factoryChoice = scanner.nextInt();

                    DeliveryFactory deliveryFactory = null;

                    if (factoryChoice == 1) {
                        deliveryFactory = new RoadDeliveryFactory();
                    } else if (factoryChoice == 2) {
                        deliveryFactory = new AirDeliveryFactory();
                    }

                    if (currentPackage != null && deliveryFactory != null) {
                        DeliveryStrategy deliveryStrategy = deliveryFactory.createDelivery();
                        currentPackage.setDeliveryStrategy(deliveryStrategy);
                        System.out.println("Delivery strategy selected.");
                    } else {
                        System.out.println("First, create a package and choose a warehouse.");
                    }
                }
                case 5 -> {
                    System.out.println("Option of delivery:");
                    System.out.println("1. Fast delivery");
                    System.out.println("2. Regular delivery");
                    int optionChoice = scanner.nextInt();
                    if (optionChoice == 1) {
                        currentPackage.setDeliveryStrategy(new ExpressDeliveryDecorator(currentPackage.getDeliveryStrategy()));
                    } else if (optionChoice == 2) {
                        currentPackage.setDeliveryStrategy(new InsuranceDecorator(currentPackage.getDeliveryStrategy()));
                    }
                }
                case 6 -> {
                    if (currentPackage != null) {
                        Transport transport = new Transport();
                        DeliveryStrategy adaptedStrategy = new TransportAdapter(transport);
                        currentPackage.setDeliveryStrategy(adaptedStrategy);
                        currentPackage.deliver();
                        currentPackage.notifyObservers();
                        System.out.println("Package is on the way.");
                    } else {
                        System.out.println("First, create a package and configure delivery options.");
                    }
                }
                case 7 -> {
                    System.out.println("Choose type of notification:");
                    System.out.println("1. SMS notification");
                    System.out.println("2. Email notification");
                    int notificationChoice = scanner.nextInt();
                    DeliveryObserver notificationObserver = null;
                    if (notificationChoice == 1) {
                        notificationObserver = new SMSNotification();
                    } else if (notificationChoice == 2) {
                        notificationObserver = new EmailNotification();
                    }
                    if (currentPackage != null) {
                        currentPackage.addObserver(notificationObserver);
                        System.out.println("Notification type selected");
                    } else {
                        System.out.println("First, create a package and configure delivery options.");
                    }
                }
                case 8 -> {
                    System.out.println("Enter observer index to remove: ");
                    int observerIndex = 0;
                    while(true) {
                        observerIndex = scanner.nextInt();
                        if (observerIndex < 1) {
                            System.out.println("Type the correct index");
                        } else {
                            break;
                        }
                    }
                    if (currentPackage != null && observerIndex >= 0 && observerIndex < currentPackage.observers.size()) {
                        currentPackage.removeObserver(currentPackage.observers.get(observerIndex));
                        System.out.println("Observer removed successfully.");
                    } else {
                        System.out.println("Invalid observer index or no package created.");
                    }
                }
                case 9 -> {
                    System.out.println("Exit from programm");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Wrong choice try again");
            }
        }
    }
}


