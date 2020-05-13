

##### kube init初始化master

```shell
kubeadm init --kubernetes-version=1.14.0 --apiserver-advertise-address=192.168.32.142 --pod-network-cidr=10.10.0.0/16
```

##### 查看生成日志，根据日志执行如下语句

```shell
mkdir -p $HOME/.kube
sudo cp -i /etc/kubernetes/admin.conf $HOME/.kube/config
sudo chown $(id -u):$(id -g) $HOME/.kube/config
```

##### 记录如下连接master语句（有效期24小时）

```shell
kubeadm join 192.168.32.142:6443 --token cee4ax.b4jzj74sgi5ji3zi \
    --discovery-token-ca-cert-hash sha256:99718c95eaa1264a2a3208abfa83fa04c51b18f73a2aebecc95c88e7e935be25 
```

##### 安装calico网络插件

###### 下载yaml文件

```shell
wget https://docs.projectcalico.org/v3.9/manifests/calico.yaml
```

###### 根据下载的yaml文件安装插件

```shell
kubectl apply -f calico.yaml
```

###### 等待所有calico网络插件安装完，工作节点再进行连接，使用如下命令查询所有pod状态

```shell
kubectl get pods --all-namespaces -w
```

##### 安装flannel网络插件

###### 下载yaml插件（kube-flannel.yml需要翻墙获取）

```shell
wget https://raw.githubusercontent.com/coreos/flannel/master/Documentation/kube-flannel.yml
```

###### 根据下载的yaml文件安装插件

```shell
kubectl apply -f kube-flannel.yaml
```

