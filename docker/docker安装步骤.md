##### 1.安装所需的软件包。yum-utils 提供了 yum-config-manager 实用程序，并且 devicemapper 存储驱动需要 device-mapper-persistent-data 和 lvm2。

```linux
yum install -y yum-utils device-mapper-persistent-data lvm2
```

##### 2.使用下列命令设置 stable 镜像仓库。您始终需要使用 stable 镜像仓库，即使您还需要通过 edge 或 testing 镜像仓库安装构建也是如此。

```linux
sudo yum-config-manager \
     --add-repo \
     https://download.docker.com/linux/centos/docker-ce.repo
```

##### 3.设置阿里云镜像加速器。

```linux
sudo mkdir -p /etc/docker
sudo tee /etc/docker/daemon.json <<-'EOF'
{
  "registry-mirrors": ["阿里云镜像加速地址"]
}
EOF
sudo systemctl daemon-reload
```

##### 4.更新 yum 软件包索引。

```linux
sudo yum makecache fast
```

##### 5.安装最新版本的 Docker CE，或者转至下一步以安装特定版本。

```linux
sudo yum install docker-ce -y
```

##### 6.启动docker

```linux
systemctl start docker
```

##### 7.开机启动docker

```
systemctl enable docker
```

