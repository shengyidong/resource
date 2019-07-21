### eureak服务端

自动装配配置类开启注册中心功能

```java
@EuableEurekaServer
```

application.properties配置文件增加

```properties
#不向注册中心自己注册
eureka.client.register-with-eureka=false
#不需要检测服务
eureka.client.fetch-registry=false
#设置服务访问地址
eureka.client.serviceUrl.defaultZone=http://localhost:8080/eureka
```

### eureka客户端

自动装配配置类，激活Eureka自动化配置

```java
@EnableDiscoveryClient
```

服务命名在application.properties配置文件增加

```properties
spring.application.name=user-service
```

### 高可用注册中心

双注册中心互相配置为eureka服务

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

