##### 查询当前命名空间所有service信息

```shell
kubectl get svc
```



##### 查询指定命令空间所有service信息

```shell
kubectl get svc -n namespace
```



##### 查询service详细信息

```shell
kubectl describe svc servicerName
```



##### 根据命令创建service

```shell
kubectl expose objectType objectName --name=serviceName --type=type
```

service的type默认为clusterIp，集群内部使用



##### service的type为nodePort，映射每台node，生产环境不太常用

```shell
kubectl expose objectType objectName --type=NodePort
```

指定为NodePort，也可以通过clusterIp内部访问



##### service的type为LoadBalance，需要厂商提供







