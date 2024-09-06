# spring-boot-event

Example showing the use of the internal application events bus on a Spring application.

### Use cases

There are several strategies that can be used. The demo shows:
* Standard way using listeners based on an interface and with multiple threads managing 
the reception of the events (master branch)
* Same as previous but using annotations (@EventListener) instead of interface implementation 
on the listeners (event-listener-annotation branch)
* Using annotation and async listeners (decorated with @Async) instead of a thread pool

For managing multiple calls concurrent, the best ways are the first and second because you 
can execute more operations, they are faster. In case of simple processing, the best is the
third option. It depends on your needs.