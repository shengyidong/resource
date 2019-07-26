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

### eureka主要类

##### InstanceInfo

com.netflix.appinfo.InstanceInfo代表服务注册实例类

##### LeaseInfo

com.netflix.appinfo.LeaseInfo标识应用实例的租约信息

##### ServiceInstance

org.springframework.cloud.client.ServiceInstance是Spring Cloud对服务发现的抽象接口

##### LeaseManager

com.netflix.eureka.lease.LeaseManager定义了应用服务实例在服务中心操作的接口

##### LookupService

com.netflix.discovery.shared.LookupService Enreka客户端从注册中心获取服务实例的接口

### 主要参数