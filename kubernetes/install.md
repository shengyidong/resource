##### 设置master节点与work节点主机名

```shell
#设置master节点主机名
sudo hostnamectl set-hostname m
#设置work节点主机名
sudo hostnamectl set-hostname w
#修改host文件
```

##### 更新yum源

```shell
yum -y update
```

##### 安装依赖包

```shell
yum install -y conntrack ipvsadm ipset jq sysstat curl iptables libseccomp
sudo yum install -y yum-utils device-mapper-persistent-data lvm2
```

##### 设置docker仓库

```shell
sudo yum-config-manager --add-repo http://mirrors.aliyun.com/docker-ce/linux/centos/docker-ce.repo
```

##### 设置阿里云镜像加速器

```shell
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["a"]
}
EOF
sudo systemctl daemon-reload
```

##### 安装docker

```shell
yum install -y docker-ce-18.09.0 docker-ce-cli-18.09.0 containerd.io
```

##### 启动docker并设置开机启动

```shell
systemctl start docker && systemctl enable docker
```

##### 关闭防火墙并设置开机防火墙为关闭状态

```shell
systemctl stop firewalld && systemctl disable firewalld
```

##### 关闭selinux

```shell
setenforce 0
sed -i 's/^SELINUX=enforcing$/SELINUX=permissive/' /etc/selinux/config
```

##### 关闭swap

```shell
swapoff -a
sed -i '/swap/s/^\(.*\)$/#\1/g' /etc/fstab
```

##### 配置iptables的ACCEPT规则

```shell
iptables -F && iptables -X && iptables -F -t nat && iptables -X -t nat && iptables -P FORWARD ACCEPT
```

##### 设置kubernetes参数

```shell
cat <<EOF >  /etc/sysctl.d/k8s.conf
net.bridge.bridge-nf-call-ip6tables = 1
net.bridge.bridge-nf-call-iptables = 1
EOF
sysctl --system
```

##### 配置yum源

```shell
cat <<EOF > /etc/yum.repos.d/kubernetes.repo
[kubernetes]
name=Kubernetes
baseurl=http://mirrors.aliyun.com/kubernetes/yum/repos/kubernetes-el7-x86_64
enabled=1
gpgcheck=0
repo_gpgcheck=0
gpgkey=http://mirrors.aliyun.com/kubernetes/yum/doc/yum-key.gpg
       http://mirrors.aliyun.com/kubernetes/yum/doc/rpm-package-key.gpg
EOF
```

##### 安装kubeadm&kubelet&kubectl

```
yum install -y kubeadm-1.14.0-0 kubelet-1.14.0-0 kubectl-1.14.0-0
```

##### 设置docker与kubernetes为同一个cgroup

```shell
#docker配置
vi /etc/docker/daemon.json
#增加如下文本内容
"exec-opts": ["native.cgroupdriver=systemd"],
#重启docker
systemctl restart docker
#kubernetes配置
sed -i "s/cgroup-driver=systemd/cgroup-driver=cgroupfs/g" /etc/systemd/system/kubelet.service.d/10-kubeadm.conf
#启动kubernets
systemctl enable kubelet && systemctl start kubelet
```

##### 拉取k8s所需的镜像

```shell
docker pull k8s.gcr.io/kube-apiserver:v1.14.0
docker pull k8s.gcr.io/kube-controller-manager:v1.14.0
docker pull k8s.gcr.io/kube-scheduler:v1.14.0
docker pull k8s.gcr.io/kube-proxy:v1.14.0
docker pull k8s.gcr.io/pause:3.1
docker pull k8s.gcr.io/etcd:3.3.10
docker pull k8s.gcr.io/coredns:1.3.1
```

国际网络需要翻墙，也可以从阿里云拉取镜像并改名

```shell
#登录阿里云镜像仓库（公有仓库可以免登录）
sudo docker login --username=shengyd2020 registry.cn-beijing.aliyuncs.com
#输入密码
#拉取阿里云镜像
sudo docker pull registry.cn-beijing.aliyuncs.com/shengyd2020/kube-apiserver:v1.14.0
sudo docker pull registry.cn-beijing.aliyuncs.com/shengyd2020/kube-controller-manager:v1.14.0
sudo docker pull registry.cn-beijing.aliyuncs.com/shengyd2020/kube-scheduler:v1.14.0
sudo docker pull registry.cn-beijing.aliyuncs.com/shengyd2020/kube-proxy:v1.14.0
sudo docker pull registry.cn-beijing.aliyuncs.com/shengyd2020/pause:3.1
sudo docker pull registry.cn-beijing.aliyuncs.com/shengyd2020/etcd:3.3.10
sudo docker pull registry.cn-beijing.aliyuncs.com/shengyd2020/coredns:1.3.1
#修改本地镜像名称为官方名称
sudo docker tag registry.cn-beijing.aliyuncs.com/shengyd2020/kube-apiserver:v1.14.0 k8s.gcr.io/kube-apiserver:v1.14.0
sudo docker tag registry.cn-beijing.aliyuncs.com/shengyd2020/kube-controller-manager:v1.14.0 k8s.gcr.io/kube-controller-manager:v1.14.0
sudo docker tag registry.cn-beijing.aliyuncs.com/shengyd2020/kube-scheduler:v1.14.0 k8s.gcr.io/kube-scheduler:v1.14.0
sudo docker tag registry.cn-beijing.aliyuncs.com/shengyd2020/kube-proxy:v1.14.0 k8s.gcr.io/kube-proxy:v1.14.0
sudo docker tag registry.cn-beijing.aliyuncs.com/shengyd2020/pause:3.1 k8s.gcr.io/pause:3.1
sudo docker tag registry.cn-beijing.aliyuncs.com/shengyd2020/etcd:3.3.10 k8s.gcr.io/etcd:3.3.10
sudo docker tag registry.cn-beijing.aliyuncs.com/shengyd2020/coredns:1.3.1 k8s.gcr.io/coredns:1.3.1
#删除本地阿里云镜像
sudo docker rmi registry.cn-beijing.aliyuncs.com/shengyd2020/kube-apiserver:v1.14.0
sudo docker rmi registry.cn-beijing.aliyuncs.com/shengyd2020/kube-controller-manager:v1.14.0
sudo docker rmi registry.cn-beijing.aliyuncs.com/shengyd2020/kube-scheduler:v1.14.0
sudo docker rmi registry.cn-beijing.aliyuncs.com/shengyd2020/kube-proxy:v1.14.0
sudo docker rmi registry.cn-beijing.aliyuncs.com/shengyd2020/pause:3.1
sudo docker rmi registry.cn-beijing.aliyuncs.com/shengyd2020/etcd:3.3.10
sudo docker rmi registry.cn-beijing.aliyuncs.com/shengyd2020/coredns:1.3.1
```

