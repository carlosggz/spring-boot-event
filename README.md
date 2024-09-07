# spring-boot-event

Example showing the use of the internal application events bus on a Spring application.

### Use cases

There are several strategies that can be used. The demo shows:
* Standard way using listeners based on an interface and with multiple threads managing 
the reception of the events ([master branch](https://github.com/carlosggz/spring-boot-event))
* Same as previous but using annotations (```@EventListener```) instead of interface implementation 
on the listeners ([event-listener-annotation branch](https://github.com/carlosggz/spring-boot-event/tree/event-listener-annotation)). The advantage is that a listener can
listen several events on the same method. 
* Using annotation and async listeners (decorated with ```@Async```) instead of a thread pool ([service-async branch](https://github.com/carlosggz/spring-boot-event/tree/service-async)). 
The 
advantage is that the same instance can handle how to manage the call (single thread or with a 
task executor as parameter)

For managing multiple calls concurrent, the best ways are the first and second because you 
can execute more operations, they are faster and centralized because they are sharing the same
executor. In case of simple processing, the best is the third option, however, you can set an 
executor by listener. It depends on your needs.