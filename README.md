# SDP-Final

**Name of project:** Package delivery system <br>
**Group:** SE-2219<br>
**Team members:** Abidzhanov Ilyas, Aitkozha Arshat<br>
**Project overview:**<br>
The Package delivery system is designed to streamline the process of package delivery by incorporating various delivery strategies, options, and notifications. The system aims to provide flexibility in choosing delivery methods, adding options, and notifying users about their packages. The primary goal is to enhance the overall delivery experience for both users and delivery personnel.
<br>

**Main body:**<br>
1. Factory Method Pattern<br>
Classes: `AirDeliveryFactory, RoadDeliveryFactory, DeliveryFactory`<br>
Description: The Factory Method Pattern is used to create instances of delivery strategies, allowing flexibility in selecting the type of delivery.<br>
2. Strategy Pattern<br>
Classes: `AirDeliveryStrategy, RoadDeliveryStrategy, DeliveryStrategy`<br>
Description: The Strategy Pattern is implemented to define a family of algorithms (delivery strategies) and make them interchangeable. It enables selecting a delivery strategy dynamically.<br>
3. Decorator Pattern<br>
Classes: `ExpressDeliveryDecorator, InsuranceDecorator, DeliveryDecorator`<br>
Description: Decorator Pattern is employed to add optional features to the delivery process dynamically. For example, adding express delivery or insurance options.<br>
4. Observer Pattern<br>
Classes: `DeliveryObserver, EmailNotification, SMSNotification`<br>
Description: The Observer Pattern is used for implementing a notification system. Observers (notification types) are notified when a package's status changes.<br>
5. Adapter Pattern<br>
Classes: `Transport, TransportAdapter`<br>
Description: The Adapter Pattern is implemented to adapt the Transport class into the DeliveryStrategy interface, providing a seamless integration of specialized transport in the delivery process.<br>
6. Singleton Pattern<br>
Classes: `WarehouseManager`<br>
Description: The Singleton Pattern ensures that there is a single instance of the WarehouseManager, providing centralized management of warehouses.<br>

**UML diagram:**
 ![image](https://github.com/ilich956/sdp-final/assets/125411778/24eaff5e-580c-43a4-80ed-e3b80f8f37a3)


**Conclusion:**<br>
•  Key Points:<br>

The project successfully implements various design patterns to achieve flexibility, extensibility, and maintainability in the delivery management system.<br>
Design patterns such as Factory Method, Strategy, Decorator, Observer, and Adapter are utilized to address specific requirements.<br>

•  Outcomes and Challenges:<br>

Challenges were faced in integrating different design patterns seamlessly<br>
The project successfully provides a modular and extensible solution for package delivery.<br>

•  Future Improvements:<br>

Enhance user interface for better user experience.<br>
Integrate real-time tracking features for packages.<br>
Implement additional delivery strategies and options.<br>
