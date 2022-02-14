# Spring  Framework

## 1. What is Spring Framework? Why we need it?

- Spring is one type of framework which use for developing web application. which using you can easily maintain the application Infrastructure.
It provide the `IOC Container` and `Dependency Injection`. which is used for develop loosely coupled application.


- Lossly coupled means if you have to any changed any object any class or another thing in feature then you can easily change it. if it tightly coupled then you have to change multiple files. so that why it helpful for Java developers.

## 2. why spring is better than other frameworks?

- Spring is more flexible than other frameworks and large support in community. Spring make programing easy, quicker, and safe for everybody. it focus on speed, efficiency, and productivity.

> if you read about more features of the Spring Framework see this blog [Spring Features](https://data-flair.training/blogs/spring-framework-features/)
>
> Unlike other frameworks, Spring focuses on several areas of an application and provides a wide range of features like **Spring ORM, Spring MVC, Hibernate**.

## 3. Singleton design Pattern

- It define a class that has only one instance and provides a global point of access to it. It means , a class must ensure that only single instance should be created and single object can be used by all other classes.


- To create the singleton class, we need to have static member of class, private constructor and static factory method.

> **Static member**: It gets memory only once because of static, itcontains the instance of the Singleton class.
>
> **Private constructor**: It will prevent to instantiate the Singleton class from outside the class.
>
> **Static factory method**: This provides the global point of access to the Singleton object and returns the instance to the caller.

