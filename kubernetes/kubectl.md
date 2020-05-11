##### 查询所有node信息

```shell
kubectl get nodes
```



##### 查询node详细信息

```shell
kubectl describe node nodeName
```



##### 查询当前命名空间所有pod信息

```shell
kubectl get pods -n namespaceName
```



##### 查询pod详细信息

```shell
kubectl describe pod podname -n namespaceName
```



##### 通过expose创建service

```shell
kubectl expose deployment deploymentName
```

