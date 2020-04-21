**基于分布式事务中间件seata的分布式解决方案**

本Demo工程基于seata/seata-sample实现AT/MT模式

涉及技术栈：

springboot   dubbo zookeeper

**使用本案例demo步骤**

**1.准备项目**

 克隆此项目到本地，导入idea，JDK为1.8  创建业务数据库 sql在项目中 包括undo表

模块：

Seata-order  订单服务模块

Seata-storage 库存服务模块

Seata-account 账户服务模块

Seata-common 公共模块

Seata-transcation-manage TM模块

**2.环境准备**

1）先下载seata-server  地址：https://github.com/seata/seata/releases 下载完后修其 数据库配置

由于demo使用的是db模式存储事务日志，要创建三张表：global_table，branch_table，lock_table，建表sql在上面下载的seata-server的/conf/db_store.sql中； 配置文件事务组也可以自己修改，修改的话项目中也要对应变更

2）启动本地zookeeper

3）启动seata-server    

**3.启动项目**

分别启动项目四个子模块

**4.模拟请求**

AT模式

Commit：

```java
curl -H "Content-Type:application/json" -X POST -d '{"userId":"1","commodityCode":"C201901140001","name":"电脑","count":1,"amount":"10"}' 'localhost:8004/tmManager/buy'
```

Rollback：

```java
curl -H "Content-Type:application/json" -X POST -d '{"userId":"1","commodityCode":"C201901140001","name":"电脑","count":1,"amount":"10"}' 'localhost:8004/tmManager/buy?throwExp=true'
```

MT模式：

Commit:

```java
curl -H "Content-Type:application/json" -X POST -d ''  'localhost:8004/tcc/bug'
```

Rollback:

```java
curl -H "Content-Type:application/json" -X POST -d ''  'localhost:8004/tcc/bug?throwExp=true'

```

