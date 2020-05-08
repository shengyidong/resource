##### node连接master（node端执行）

```shell
kubeadm join 192.168.32.138:6443 --token cfrt39.hkaptpvgssuwu8zt \
    --discovery-token-ca-cert-hash sha256:ff3f8023f0a806abb148ea25cda3efaac08613db8c6467afe025988375833fb4
```

##### 查询令牌（master端执行）

```shell
kubeadm token list
```

##### 生成令牌（master端执行，默认24小时有效期）

```
kubeadm token create
```

##### 查询认证（master端执行）

```shell
openssl x509 -pubkey -in /etc/kubernetes/pki/ca.crt | openssl rsa -pubin -outform der 2>/dev/null | openssl dgst -sha256 -hex | sed 's/^.* //'
```

