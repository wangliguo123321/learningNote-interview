[TOC]

### Spring 的事务抽象
    PlatformTransactionManager
    • DataSourceTransactionManager
    • HibernateTransactionManager
    • JtaTransactionManager
 #### TransactionDefinition  四点：
         
            • Propagation
            • Isolation
            • Timeout
            • Read-only status
 ####  Propagation传播特性七种:
          
    PROPAGATION_Required    0 当前有事务就⽤当前的，没有就⽤新的
    PROPAGATION_Supports    1 事务可有可⽆，不是必须的
    PROPAGATION_mandatory   2 当前⼀定要有事务，不然就抛异常
    PROPAGATION_requires_new  3 ⽆论是否有事务，都起个新的事务
    PROPAGATION_NOT_supported 4 不⽀持事务，按⾮事务⽅式运⾏
    PROPAGATION_never         5 不⽀持事务，如果有事务则抛异常
    PROPAGATION_nested        6 当前有事务就在当前事务⾥再起⼀个事务
  #### Isolation隔离特性
            
        读未提交    脏读
        读已提交    不可重复读
        可重复度    幻读
        序列化
  ####  开启事务注解
            
    @EnableTransactionManagement
    //在方法增加@Transactional注解



   
   
###  Spring注解总结：
        
    Java Config 相关注解
    • @Configuration
    • @ImportResource
    • @ComponentScan
    • @Bean
    • @ConfigurationProperties   
    定义相关注解
    • @Component / @Repository 数据库访问层/ @Service
    • @Controller / @RestController(ResposeBody+Controller)
    • @RequestMapping
    注⼊相关注解
    • @Autowired / @Qualifier（指定名字） / @Resource
    • @Value（注入常量）
### 如何解禁 Endpoint
    (/actuator/health 健康检查
    /actuator/beans 查看容器中的所有 Bean
    /actuator/mappings 查看 Web 的 URL 映射
    /actuator/env 查看环境信息)
    默认
    • /actuator/health 和 /actuator/info 可 Web 访问
    解禁所有 Endpoint
    • application.properties / application.yml
    • management.endpoints.web.exposure.include=* 


### Spring的JDBC的异常
   spring对于数据源封装后，统一转化为 DataAccessException 

### JPA总结：
       O/R映射
  #### 常⽤ JPA 注解
   实体
           
     • @Entity、@MappedSuperclass
     • @Table(name)
     主键
     • @Id
     • @GeneratedValue(strategy, generator)
     • @SequenceGenerator(name, sequenceName)
   Repository
       
       @EnableJpaRepositories
       Repository<T, ID> 接⼝
       • CrudRepository<T, ID>
       • PagingAndSortingRepository<T, ID>
       • JpaRepository<T, ID>
   定义查询
   
    根据⽅法名定义查询
    • find…By… / read…By… / query…By… / get…By…
    • count…By…
    • …OrderBy…[Asc / Desc]
    • And / Or / IgnoreCase
    • Top / First / Distinct
    
   分⻚查询
    
    • PagingAndSortingRepository<T, ID>
    • Pageable / Sort
    • Slice<T> / Page<T>
    