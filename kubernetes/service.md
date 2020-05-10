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

