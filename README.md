## 汽车租赁管理系统

基于 Spring Boot + Vue + Element UI 的汽车租赁管理平台，提供完整的车辆管理、客户管理、订单管理、维保管理等功能。

## 核心特性

- **用户权限管理** — 基于 Spring Security + JWT 的认证授权体系，支持角色、权限、部门的完整管理
- **车辆管理** — 车辆信息、品牌、厂商的CRUD操作，支持车辆状态管理（未租/已租/维保/自用）
- **客户管理** — 客户信息管理，支持黑白名单状态标记
- **订单管理** — 租赁订单的完整生命周期管理，包括出租、归还、押金返还等流程
- **维保管理** — 车辆维保记录管理，支持应保次数和实保次数统计
- **违章管理** — 车辆违章记录管理
- **数据持久化** — MyBatis Plus 增强数据访问，支持逻辑删除和自动填充
- **前端集成** — Vue + Element UI 构建的现代化管理后台

## 技术栈

| 层级         | 技术                            |
| ------------ | ------------------------------- |
| **后端框架** | Spring Boot 3.5.13              |
| **数据库**   | MySQL 8.3 + Redis               |
| **ORM**      | MyBatis Plus 3.5.15             |
| **安全框架** | Spring Security + JWT           |
| **前端框架** | Vue 3 + Element UI              |
| **工具库**   | Hutool 5.8.35 + Fastjson 2.0.52 |

## 架构概览

```
前端 (Vue + Element UI)
        │
        ▼
    API Gateway
        │
    ┌───┴───┐
    ▼       ▼
  Controller  Security
    │       │
    ▼       ▼
  Service  JWT/Filter
    │
    ▼
  Mapper (MyBatis Plus)
    │
    ▼
MySQL + Redis
```

## 快速开始

### 1. 环境要求

- JDK 21+
- MySQL 8.0+
- Redis 6.0+
- Maven 3.8+

### 2. 数据库配置

创建数据库并配置连接信息：

```sql
CREATE DATABASE auto_rental CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
```

### 3. 配置文件

修改 `src/main/resources/application.yml` 中的数据库连接信息：

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/auto_rental
    username: ####
    password: ####
  data:
    redis:
      host: 127.0.0.1
      port: 6379
```

### 4. 启动服务

```bash
# 进入项目目录
cd auto_rental

# 编译项目
mvn clean compile

# 运行项目
mvn spring-boot:run
```

### 5. 访问地址

- **后端服务**: <http://localhost:8080>
- **前端页面**: 访问 `vue-element-admin-master` 目录启动前端服务

## 项目结构

```
├── src/
│   └── main/
│       ├── java/com/tjgd/
│       │   ├── AppService.java              # Spring Boot 入口
│       │   └── rental/
│       │       ├── config/                  # 配置类
│       │       │   ├── CORSConfig.java
│       │       │   ├── GlobalException.java
│       │       │   └── MybatisPlusConfig.java
│       │       ├── controller/              # 控制层
│       │       │   ├── AuthController.java
│       │       │   ├── AutoInfoController.java
│       │       │   ├── CustomerController.java
│       │       │   ├── OrderController.java
│       │       │   └── ...
│       │       ├── service/                 # 服务层
│       │       │   ├── impl/
│       │       │   │   ├── UserServiceImpl.java
│       │       │   │   └── ...
│       │       │   ├── IUserService.java
│       │       │   └── ...
│       │       ├── mapper/                  # 数据访问层
│       │       │   ├── UserMapper.java
│       │       │   └── ...
│       │       ├── entity/                  # 实体类
│       │       │   ├── User.java
│       │       │   ├── AutoInfo.java
│       │       │   ├── Order.java
│       │       │   └── ...
│       │       ├── security/                # 安全模块
│       │       │   ├── SecurityConfig.java
│       │       │   ├── JwtUtils.java
│       │       │   └── ...
│       │       └── utils/                   # 工具类
│       │           ├── Result.java
│       │           └── ResultCode.java
│       └── resources/
│           ├── application.yml              # 应用配置
│           └── mapper/                      # MyBatis 映射文件
│               ├── UserMapper.xml
│               └── ...
├── vue-element-admin-master/                # 前端项目
│   └── src/
│       ├── api/                             # API 接口
│       ├── views/                           # 页面组件
│       └── ...
└── pom.xml                                  # Maven 依赖管理
```

## 功能模块

| 模块         | 说明                       | 核心实体                       |
| ------------ | -------------------------- | ------------------------------ |
| **系统管理** | 用户、角色、权限、部门管理 | User, Role, Permission, Dept   |
| **车辆管理** | 车辆信息、品牌、厂商管理   | AutoInfo, AutoBrand, AutoMaker |
| **业务管理** | 客户、订单、租赁类型管理   | Customer, Order, RentalType    |
| **维保管理** | 车辆维保记录管理           | Maintain                       |
| **违章管理** | 车辆违章记录管理           | Violation                      |

## 核心实体关系

```
User (用户) ──┬── Role (角色) ── Permission (权限)
              └── Dept (部门)

AutoInfo (车辆) ──┬── AutoBrand (品牌)
                 ├── AutoMaker (厂商)
                 ├── RentalType (租赁类型)
                 ├── Maintain (维保)
                 ├── Violation (违章)
                 └── Order (订单) ── Customer (客户)
```

## 界面展示

### 首页仪表盘

<img width="1024" height="640" alt="image" src="https://github.com/user-attachments/assets/105f7bb4-00bf-4244-8cab-c271814836cf" />


### 部门管理
<img width="1024" height="588" alt="image" src="https://github.com/user-attachments/assets/67e9a1fd-3fbb-450c-8b61-a0d81ab328cc" />


### 菜单管理

<img width="1024" height="570" alt="image" src="https://github.com/user-attachments/assets/2ae45b27-5165-4c09-a089-eef2f61ced2e" />

### 客户管理
<img width="1024" height="568" alt="image" src="https://github.com/user-attachments/assets/e90074dc-e1fe-425c-9fe1-203d7349716e" />


### 订单详情

<img width="1024" height="640" alt="image" src="https://github.com/user-attachments/assets/53cef962-adad-4596-8851-b27baf1ef829" />

## API 概览

| 模块     | 路径前缀           | 说明         |
| -------- | ------------------ | ------------ |
| 认证     | /rental/user/login | 用户登录     |
| 用户管理 | /api/user/\*       | 用户CRUD     |
| 角色管理 | /api/role/\*       | 角色CRUD     |
| 权限管理 | /api/permission/\* | 权限CRUD     |
| 车辆管理 | /api/autoInfo/\*   | 车辆信息CRUD |
| 客户管理 | /api/customer/\*   | 客户CRUD     |
| 订单管理 | /api/order/\*      | 订单CRUD     |

## 配置说明

### 数据库配置

```yaml
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/auto_rental
    username: ####
    password: ####
```

### Redis 配置

```yaml
spring:
  data:
    redis:
      host: 127.0.0.1
      port: 6379
      database: 0
```

### JWT 配置

```yaml
encoder:
  ctype:
    strength: 6
    secret: ${random.uuid}
```

## 许可证

MIT License
