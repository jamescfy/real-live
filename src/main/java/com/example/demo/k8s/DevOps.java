package com.example.demo.k8s;

/**
 * @Author cfy
 * @Date 2021-8-17 下午 4:42
 * @Version 1.0
 * 开发和运维
 * DevOps团队
 * PPT  -->  class
 * 将所有一切均纳入版本控制
 * Jenkins Master -< Jenkins slave
 * 在开发IDE上集成质量检测工具，例如SonarLint
 * 传统部署 -> 虚拟化部署 -> 容器部署
 */
public class DevOps {

    private void k8s(){
//         1、Docker编排服务：三驾马车
        /* ① Docker Swarm
         * ②Mesos
         * ③kubernetes*/
//         2、k8s Master 组件
        /*① API server         主要处理REST操作以及更新Etcd中的对象。所有资源增删改查的唯一入口。在设计上考虑了水平扩缩的需要，可以构建集群。
         *② Scheduler          集群的资源调度组件，用于绑定Pod到Node上。
         *③ Controller Manager 控制器组件，资源对象的自动化控制中心，例如Node Controller、Endpoint Controller等。
         *④ Etcd               是兼具一致性和高可用性的键值数据库，可以作为保存k8s所有集群数据的后台数据库。所有持久化信息存储在Etcd中。
         */
//         3、k8s Node 组件
        /*① Kubelet         一个在集群中每个节点上运行的代理。用于管理Pods以及容器、镜像、Volume等，实现对集群对节点的管理。
         *② Kube-proxy       是集群中每个节点上运行的网络代理，实现Kubernetes Service概念的一部分。提供网络代理以及负载均衡，kube-proxy
         *                   维护节点上的网络规则。这些网络规则允许从集群内部或外部的网络会话与Pod进行网络通信
         *③ Docker Engine    负责节点的容器管理工作，Kubernetes支持多个容器运行环境：Docker、containerd、cri-o、rktlet以及任何实现
         *                   Kubernetes CRI(容器运行环境接口)*/
// YAML使用一个固定的缩进风格表示数据层结构关系，每个缩进级别由两个空格组成。 使用一个短横杠加一个空格，使用同样的缩进级别作为同一列表的一部分。
// Helm是k8s应用的包管理工具，用来管理charts--预先配置好的安装包资源，有点类似于Ubuntu的APT和CentOS中的yum

    }
}
