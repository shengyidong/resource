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

隔离策略，默认方法为thread

```properties
hystrix.command.default.execution.isolation.strategy = thread
```

超时时间，默认1000毫秒

```properties
hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds = 1000
```

是否开启超时，默认为true

```properties
hystrix.command.default.execution.timeout.enabled = true
```

超时时是否应中断执行操作，默认为true

```properties
hystrix.command.default.execution.isolation.thread.interruptOnTimeout = true
```

信号量请求数，当设置为信号量隔离策略时，设置最大允许的请求数，默认为10

```properties
hystrix.command.default.execution.isolation.semaphore.maxConcurrentRequests = 10
```

Circuit Breaker设置打开fallback并启动fallback逻辑的错误比率，默认为50

```properties
hystrix.command.default.circuitBreaker.errorThresholdPercentage = 50
```

强制打开断路器，决绝所有请求，默认为false

```properties
hystrix.command.default.circuitBreaker.forceOpen = false
```

当为线程隔离时，线程池核心大小，默认为10

```properties
hystrix.threadpool.default.coreSize = 10
```

当hystrix隔离策略为线程池隔离模式时，最大线程池大小的配置如下，默认为10。在1.5.9版本中还需要配置allowMaximumSizeToDivergeFromCoreSize为true

```properties
hystrix.threadpool.default.maximumSize = 10
```

allowMaximumSizeToDivergeFromCoreSize,此属性允许配置maximumSize生效，默认为false

```properties
hystrix.threadpool.default.allowMaximumSizeToDivergeFromCoreSize = false
```

