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

饥饿加载

```properties
zuul.ribbon.eager-load.enabled = true
```

