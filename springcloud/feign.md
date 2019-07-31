### feign配置

启动类配置

```java
@EnableFeignClients
```

客户端远程接口

```java
@FeignClient
```

### 解决Feign首次请求失败的问题

方法一、将hystrix的超时时间修改为1分钟，配置如下

```properties
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds = 60000
```

方法二、禁用hystrix的超时时间，配置如下

```properties
hystrix.command.default.execution.timeout.enabled = false
```

方法三、直接关闭hystrix，该方式不推荐使用

```properties
feign.hystrix.enabled = false
```

