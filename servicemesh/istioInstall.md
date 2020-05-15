##### 安装crd

```shell
curl -L https://istio.io/downloadIstio | sh -
tar -zxvf istio-1.x.y.tar.gz
export PATH=$PWD/bin:$PATH
cd istio-1.0.6/install/kubernetes/helm/istio/templates
kubectl apply -f crds.yaml  
```

##### 下载镜像，备份镜像，删除镜像

```shell
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxy_init:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/hyperkube:v1.7.6_coreos.0
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/galley:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxyv2:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/grafana:5.2.3
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/mixer:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/pilot:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/prometheus:v2.3.1
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/citadel:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/servicegraph:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/sidecar_injector:1.0.6
docker pull registry.cn-hangzhou.aliyuncs.com/istio-k8s/all-in-one:1.5

docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxy_init:1.0.6\ docker.io/istio/proxy_init:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/hyperkube:v1.7.6_coreos.0\ quay.io/coreos/hyperkube:v1.7.6_coreos.0
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/galley:1.0.6\ docker.io/istio/galley:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxyv2:1.0.6\ 
docker.io/istio/proxyv2:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/grafana:5.2.3\ grafana/grafana:5.2.3
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/mixer:1.0.6\ docker.io/istio/mixer:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/pilot:1.0.6\ docker.io/istio/pilot:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/prometheus:v2.3.1\ docker.io/prom/prometheus:v2.3.1
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/citadel:1.0.6\ docker.io/istio/citadel:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/servicegraph:1.0.6\ docker.io/istio/servicegraph:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/sidecar_injector:1.0.6\ docker.io/istio/sidecar_injector:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/all-in-one:1.5\ docker.io/jaegertracing/all-in-one:1.5

docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/sidecar_injector:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/sidecar_injector:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/servicegraph:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/servicegraph:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxyv2:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/proxyv2:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxy_init:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/proxy_init:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/pilot:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/pilot:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/mixer:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/mixer:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/galley:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/galley:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/citadel:1.0.6 registry.cn-beijing.aliyuncs.com/shengyd2020/citadel:1.0.6
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/grafana:5.2.3 registry.cn-beijing.aliyuncs.com/shengyd2020/grafana:5.2.3
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/prometheus:v2.3.1 registry.cn-beijing.aliyuncs.com/shengyd2020/prometheus:v2.3.1
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/all-in-one:1.5 registry.cn-beijing.aliyuncs.com/shengyd2020/all-in-one:1.5
docker tag registry.cn-hangzhou.aliyuncs.com/istio-k8s/hyperkube:v1.7.6_coreos.0 registry.cn-beijing.aliyuncs.com/shengyd2020/hyperkube:v1.7.6_coreos.0

docker push registry.cn-beijing.aliyuncs.com/shengyd2020/sidecar_injector:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/servicegraph:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/proxyv2:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/proxy_init:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/pilot:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/mixer:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/galley:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/citadel:1.0.6
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/grafana:5.2.3
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/prometheus:v2.3.1
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/all-in-one:1.5
docker push registry.cn-beijing.aliyuncs.com/shengyd2020/hyperkube:v1.7.6_coreos.0

docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxy_init:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/hyperkube:v1.7.6_coreos.0
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/galley:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/proxyv2:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/grafana:5.2.3
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/mixer:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/pilot:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/prometheus:v2.3.1
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/citadel:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/servicegraph:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/sidecar_injector:1.0.6
docker rmi registry.cn-hangzhou.aliyuncs.com/istio-k8s/all-in-one:1.5
```

##### 安装核心组件

```shell
kubectl apply -f istio-demo.yaml
```

