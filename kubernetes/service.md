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

##### 根据deployment创建service

```shell
kubectl expose deployment deployName
```

##### service的type为clusterIp，集群内部使用

##### service的type为nodePort，映射每台node，生产环境不太常用

##### service的type为LoadBalance，不太常用

##### Ingress





