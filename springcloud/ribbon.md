### ribbon配置

```properties
#注册时间周期默认30秒
eureka.client.registryFetchIntervalSeconds = 5
```

请求处理的超时时间

```properties
ribbon.ReadTimeout = 60000
```

请求连接的超时时间

```properties
ribbon.ConnectTimeout = 60000
```

对第一次请求的服务的重试次数

```properties
ribbon.MaxAutoRetries = 1
```

要重试的下一个服务的最大数量（不包括第一个服务）

```properties
ribbon.MaxAutoRetriesNextServer = 1
```

ribbon的饥饿加载

```properties
ribbon.eager-load.enabled = true
ribbon.eager-load.clients = client-a,client-b
```

