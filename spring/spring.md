##### Spring上下文常用的三种ClassPathXmlApplicationContext，FileSystemXmlApplicationContext，AnnotationConfigApplicationContext的继承关系

###### ClassPathXmlApplicationContext

```java
ClassPathXmlApplicationContext extends AbstractXmlApplicationContext
AbstractXmlApplicationContext extends AbstractRefreshableConfigApplicationContext
AbstractRefreshableConfigApplicationContext extends AbstractRefreshableApplicationContext
AbstractRefreshableApplicationContext extends AbstractApplicationContext
AbstractApplicationContext implements ConfigurableApplicationContext
ConfigurableApplicationContext extends ApplicationContext
ApplicationContext extends ListableBeanFactory
ListableBeanFactory extends BeanFactory
```

###### FileSystemXmlApplicationContext

```java
FileSystemXmlApplicationContext extends AbstractXmlApplicationContext
AbstractXmlApplicationContext extends AbstractRefreshableConfigApplicationContext
AbstractRefreshableConfigApplicationContext extends AbstractRefreshableApplicationContext
AbstractRefreshableApplicationContext extends AbstractApplicationContext
AbstractApplicationContext implements ConfigurableApplicationContext
ConfigurableApplicationContext extends ApplicationContext
ApplicationContext extends ListableBeanFactory
ListableBeanFactory extends BeanFactory
```

###### AnnotationConfigApplicationContext

```java
AnnotationConfigApplicationContext extends GenericApplicationContext
GenericApplicationContext extends AbstractApplicationContext
AbstractApplicationContext implements ConfigurableApplicationContext
ConfigurableApplicationContext extends ApplicationContext
ApplicationContext extends ListableBeanFactory
ListableBeanFactory extends BeanFactory
```



##### 常用的接口

BeanFactory单个bean工厂

ListableBeanFactory集合bean工厂

HierarchicalBeanFactory父子关系的bean工厂

AutowireCapableBeanFactory自动装配bean工厂





##### spring容器启动

```java
org.springframework.context.support.AbstractApplicationContext.refresh()
```

###### 1.准备工作，例如记录事件，设置标志，检查环境变量等，并有留给子类扩展的位置，用来将属性加入到applicationContext中

```java
prepareRefresh()
```

###### 2.创建beanFactory，这个对象作为applicationContext的成员变量，可以被applicationContext拿来用,并且解析资源（例如xml文件），取得bean的定义，放在beanFactory中

```java
obtainFreshBeanFactory()
```

###### 3.对beanFactory做一些设置，例如类加载器、spel解析器、指定bean的某些类型的成员变量对应某些对象等

```java
prepareBeanFactory(ConfigurableListableBeanFactory)
```

###### 4.子类扩展用，可以设置bean的后置处理器（bean在实例化之后这些后置处理器会执行）

```java
postProcessBeanFactory(ConfigurableListableBeanFactory)
```

###### 5.执行beanFactory后置处理器（有别于bean后置处理器处理bean实例，beanFactory后置处理器处理bean定义）

```java
invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory)
```

###### 6.将所有的bean的后置处理器排好序，但不会马上用，bean实例化之后会用到

```java
registerBeanPostProcessors(ConfigurableListableBeanFactory)
```

###### 7.国际化服务

```java
initMessageSource()
```

###### 8.创建事件广播器

```java
initApplicationEventMulticaster()
```

###### 9.空方法，留给子类自己实现的，在实例化bean之前做一些ApplicationContext相关的操作

```java
onRefresh()
```

###### 10.注册一部分特殊的事件监听器，剩下的只是准备好名字，留待bean实例化完成后再注册

```java
registerListeners()
```

###### 11.单例模式的bean的实例化、成员变量注入、初始化等工作都在此完成

```java
finishBeanFactoryInitialization(ConfigurableListableBeanFactory)
```

###### 12.applicationContext刷新完成后的处理，例如生命周期监听器的回调，广播通知等

```java
finishRefresh()
```



