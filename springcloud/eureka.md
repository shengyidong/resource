### eureak服务端

自动装配配置类增加

```java
@EuableEurekaServer
```

注解开启注册中心功能



application.properties配置文件增加

```
eureka.client.register-with-eureka=false
```

 代表不向注册中心自己注册



application.properties配置文件增加

```
eureka.client.fetch-registry=false
```

不需要检测服务



application.properties配置文件增加

```
eureka.client.serviceUrl.defaultZone=http://localhost:8080/eureka
```

设置服务访问地址



### eureka客户端

自动装配配置类增加

```java
@EnableDiscoveryClient
```



服务命名在application.properties配置文件增加

```
spring.application.name=user-service
```



### 高可用注册中心

双注册中心互相配置为eureka服务


