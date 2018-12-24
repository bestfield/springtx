# spring事务管理
本项目实现了Spring声明式事务实现的三种方式 ref:https://www.imooc.com/learn/478
## 事务的特性

**原子性** -> 指事务是一个不可分割的工作单位，事务中的操作要么都发生，要么都不发生。<br>
**一致性** -> 指事务前后的数据的完整性必须保持一致。 <br>
**隔离性** -> 指多个用户并发访问数据库时，一个用户的事务不能被其他用户的事务所干扰，多个并发事务之间数据要互相隔离。<br>
**持久性** -> 指一个事务一旦被提交，它对数据库中数据的改变就是永久性的，即使数据库发<br>

## 隔离级别(4种)：
·READ_UNCOMMITED<BR>
·READ_COMMITTED<BR>
·REPEATABLE_READ<BR>
·SERIALIZABLE<BR>

![](https://github.com/bestfield/springtx/blob/master/1.png)
<br>
注：以上隔离级别从上到下分别由低到高。SERIALIZABLE串行：排成串依次执行。

·脏读：一个事务读取了另一个事务未提交的数据<br>
·不可重复读：一个事务两次读取的结果不同 (由update语句引发)<br>
·幻读：一个事务两次条件相同的读取获取的记录行数不同<br>

## 传播行为(7种)：
![](https://github.com/bestfield/springtx/blob/master/2.png)
**REQUIRED**: 保证两个操作在同一个事务里面<br>
**REQUIRES_NEW**: 保证两个操作不在同一个事务里面<br>
**NESTED**: a()执行完后，设置一个savepoint，若b()发生了异常，可以让其回滚到savepoint位置或者初始状态<br>

## Spring声明式事务管理——三种方式：
**1）基于TransactionProxyFactoryBean方式**：配置transactionManager、业务层(Service)的代理，在xml中创建一个id="accountServiceProxy"的bean，业务层中注入时不再使用@Resource(name="accountService")、而是使用@Resource(name="accountServiceProxy")来进行注入。
![](https://github.com/bestfield/springtx/blob/master/3.png)
<br>
**2）基于AspectJ的XML方式**：引入aop/tx的命名空间，配置transactionManager、tx(配置事务的通知/增强)、aop等。配置好后注入时不需再注入代理对象(在产生的过程中已经完成了增强)
![](https://github.com/bestfield/springtx/blob/master/4.png)
<br>
**3）基于注解的方式**：配置transactionManager、开启注解事务(tx:annotation-driven)，在业务层实现类上添加注解@Transactional即可
![](https://github.com/bestfield/springtx/blob/master/5.png)
<br>
