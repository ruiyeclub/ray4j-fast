**项目说明** 
- ray4j-fast是一个轻量级开发脚手架
- 整合Mybatis-plus持久层框架、Redis缓存、JWT登录鉴权、Kaptcha验证码、Swagger3接口文档、Validator校验框架

<br>
 
**项目结构** 
```
ray4j-fast
├─db  项目SQL语句
│
├─common 公共模块
│  ├─aspect 系统日志
│  ├─exception 异常处理
│  ├─validator 后台校验
│  └─xss XSS过滤
│ 
├─config 配置信息
│ 
├─manage 业务模块
│  ├─controller API接口
│  ├─interceptor 拦截器
│  ├─service 业务层
│  └─dao DAO层
│ 
├─Ray4jApplication 项目启动类
│  
├──resources 
│  ├─application 配置文件
```
<br> 

 **后端部署**
- 通过git下载源码
- idea、eclipse需安装lombok插件，不然会提示找不到entity的get set方法
- 创建数据库ray4j_fast，数据库编码为UTF-8
- 执行db/ray4j-fast.sql文件，初始化数据
- 修改application-dev.yml，更新MySQL账号和密码
- Eclipse、IDEA运行Ray4jApplication.java，则可启动项目
- Swagger文档路径：http://localhost:8080/swagger-ui/
<br>