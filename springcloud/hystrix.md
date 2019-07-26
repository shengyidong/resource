### hystrix配置

启动类配置

```java
@EnableCircuitBreaker
```

或者使用

```java
@SpringCloudApplication
```

断路器方法类配置

```java
@HystrixCommand
```



