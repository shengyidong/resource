### ribbon配置

```properties
#注册时间周期默认30秒
eureka.client.registryFetchIntervalSeconds = 5
```

### feign配置

启动类配置

```java
@EnableFeignClients
```

客户端远程接口

```java
@FeignClient
```

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

### zool配置

启动类配置

```java
@EnableZuulProxy
```

属性文件

```properties
zuul.routes.user.path=/user/**
zuul.routes.user.url=http://localhost:10811/user
```

### config配置

启动类配置

```java

```

属性文件

```properties

```

