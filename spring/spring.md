org.springframework.context.support.AbstractApplicationContext.refresh()



##### 准备工作，例如记录事件，设置标志，检查环境变量等，并有留给子类扩展的位置，用来将属性加入到applicationContext中

prepareRefresh()



##### 创建beanFactory，这个对象作为applicationContext的成员变量，可以被applicationContext拿来用,并且解析资源（例如xml文件），取得bean的定义，放在beanFactory中

obtainFreshBeanFactory()



##### 对beanFactory做一些设置，例如类加载器、spel解析器、指定bean的某些类型的成员变量对应某些对象等

prepareBeanFactory(ConfigurableListableBeanFactory)



##### 子类扩展用，可以设置bean的后置处理器（bean在实例化之后这些后置处理器会执行）

postProcessBeanFactory(ConfigurableListableBeanFactory)



##### 执行beanFactory后置处理器（有别于bean后置处理器处理bean实例，beanFactory后置处理器处理bean定义）

invokeBeanFactoryPostProcessors(ConfigurableListableBeanFactory)



##### 将所有的bean的后置处理器排好序，但不会马上用，bean实例化之后会用到

registerBeanPostProcessors(ConfigurableListableBeanFactory)



##### 国际化服务

initMessageSource()



##### 创建事件广播器

initApplicationEventMulticaster()



##### 空方法，留给子类自己实现的，在实例化bean之前做一些ApplicationContext相关的操作

onRefresh()



##### 注册一部分特殊的事件监听器，剩下的只是准备好名字，留待bean实例化完成后再注册

registerListeners()



##### 单例模式的bean的实例化、成员变量注入、初始化等工作都在此完成

finishBeanFactoryInitialization(ConfigurableListableBeanFactory)



##### applicationContext刷新完成后的处理，例如生命周期监听器的回调，广播通知等

finishRefresh()

