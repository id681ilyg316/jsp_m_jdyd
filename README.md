## 本项目实现的最终作用是基于JSP宾馆预定管理系统
## 分为2个角色
### 第1个角色为管理员角色，实现了如下功能：
 - 员工管理
 - 员工视图
 - 增加员工
 - 管理员登录
### 第2个角色为员工角色，实现了如下功能：
 - 办理退房
 - 员工登录
 - 客房选择
 - 房间价格修改
 - 房间查询
 - 房间概览
 - 房间续费
 - 新增客房
 - 订单支付
 - 订单查询
 - 预订客房
## 数据库设计如下：
# 数据库设计文档

**数据库名：** m_jdyd

**文档版本：** 


| 表名                  | 说明       |
| :---: | :---: |
| [customers](#customers) | 住客表 |
| [orders](#orders) | 订单表 |
| [ordertracking](#ordertracking) | 入住信息表 |
| [room](#room) | 房间表 |
| [roomtypeandprice](#roomtypeandprice) | 房间类型价格表 |
| [systemadministrator](#systemadministrator) | 管理员表 |
| [timeextension](#timeextension) | 续住表 |
| [viplevel](#viplevel) | VIP等级仪表 |
| [waiter](#waiter) | 服务员表 |

**表名：** <a id="customers">customers</a>

**说明：** 住客表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | customerIDCard |   char   | 18 |   0    |    N     |  Y   |       | 身份证ID  |
|  2   | customerGender |   char   | 4 |   0    |    Y     |  N   |   NULL    | 性别  |
|  3   | customerName |   varchar   | 16 |   0    |    N     |  N   |       | 姓名  |
|  4   | customerBirthday |   date   | 10 |   0    |    Y     |  N   |   NULL    | 生日  |
|  5   | customerVIPLevel |   smallint   | 6 |   0    |    Y     |  N   |   NULL    | VIP等级  |
|  6   | customerPhoneNumber |   char   | 11 |   0    |    Y     |  N   |   NULL    | 电话号码  |
|  7   | totalAmount |   int   | 10 |   0    |    Y     |  N   |   NULL    | 人数  |
|  8   | remarks |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="orders">orders</a>

**说明：** 订单表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | orderNumber |   char   | 32 |   0    |    N     |  Y   |       | 订单号  |
|  2   | orderStatus |   enum   | 3 |   0    |    Y     |  N   |   NULL    | 订单状态  |
|  3   | customerIDCard |   char   | 18 |   0    |    Y     |  N   |   NULL    | 房客ID  |
|  4   | roomNumber |   char   | 6 |   0    |    N     |  N   |       | 房间号  |
|  5   | checkInTime |   date   | 10 |   0    |    N     |  N   |       | 入住时间  |
|  6   | checkOutTime |   date   | 10 |   0    |    N     |  N   |       | 离开时间  |
|  7   | totalMoney |   int   | 10 |   0    |    N     |  N   |       | 总价格  |
|  8   | waiterID |   varchar   | 255 |   0    |    N     |  N   |       | 服务员ID  |
|  9   | remarks |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |
|  10   | orderTime |   date   | 10 |   0    |    N     |  N   |       | 订单生成时间  |

**表名：** <a id="ordertracking">ordertracking</a>

**说明：** 入住信息表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | orderNumber |   char   | 32 |   0    |    N     |  Y   |       | 订单编号  |
|  2   | orderTime |   date   | 10 |   0    |    N     |  N   |       | 预定时间  |
|  3   | checkInTime |   date   | 10 |   0    |    Y     |  N   |   NULL    | 入住时间  |
|  4   | checkOutTime |   date   | 10 |   0    |    Y     |  N   |   NULL    | 离店时间  |
|  5   | remarks |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="room">room</a>

**说明：** 房间表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | roomNumber |   char   | 6 |   0    |    N     |  Y   |       | 房间ID  |
|  2   | roomType |   varchar   | 255 |   0    |    N     |  N   |       | 房间类型  |
|  3   | roomStatus |   char   | 6 |   0    |    Y     |  N   |   NULL    | 房间状态  |
|  4   | remarks |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="roomtypeandprice">roomtypeandprice</a>

**说明：** 房间类型价格表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | roomType |   varchar   | 255 |   0    |    N     |  Y   |       | 房间类型  |
|  2   | price |   int   | 10 |   0    |    N     |  N   |       | 价格  |
|  3   | desc |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 描述  |
|  4   | url |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 房间图片地址  |

**表名：** <a id="systemadministrator">systemadministrator</a>

**说明：** 管理员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | userID |   varchar   | 255 |   0    |    N     |  Y   |       | 用户ID  |
|  2   | userName |   varchar   | 255 |   0    |    N     |  N   |       | 用户名  |
|  3   | userPassword |   varchar   | 255 |   0    |    N     |  N   |       | 用户密码  |

**表名：** <a id="timeextension">timeextension</a>

**说明：** 续住表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | operatingID |   int   | 10 |   0    |    N     |  Y   |       | 操作ID  |
|  2   | orderNumber |   char   | 32 |   0    |    Y     |  N   |   NULL    | 订单编号  |
|  3   | oldExpiryDate |   date   | 10 |   0    |    N     |  N   |       | 原入住时间  |
|  4   | newExpiryDate |   date   | 10 |   0    |    N     |  N   |       | 现入住时间  |
|  5   | addedMoney |   int   | 10 |   0    |    N     |  N   |       | 额外付费  |

**表名：** <a id="viplevel">viplevel</a>

**说明：** VIP等级仪表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | level |   smallint   | 6 |   0    |    N     |  Y   |       | 等级名字  |
|  2   | discount |   decimal   | 10 |   2    |    Y     |  N   |   NULL    | 折扣  |
|  3   | totalAmount |   bigint   | 20 |   0    |    Y     |  N   |   NULL    | 价格  |
|  4   | remarks |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**表名：** <a id="waiter">waiter</a>

**说明：** 服务员表

**数据列：**

| 序号 | 名称 | 数据类型 |  长度  | 小数位 | 允许空值 | 主键 | 默认值 | 说明 |
| :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: | :---: |
|  1   | waiterID |   varchar   | 255 |   0    |    N     |  Y   |       | 服务员ID  |
|  2   | waiterName |   varchar   | 255 |   0    |    N     |  N   |       | 名字  |
|  3   | waiterBirthday |   date   | 10 |   0    |    N     |  N   |       | 生日  |
|  4   | waiterIDCard |   char   | 18 |   0    |    N     |  N   |       | 身份证  |
|  5   | waiterPassword |   varchar   | 255 |   0    |    N     |  N   |       | 密码  |
|  6   | waiterJoinDate |   date   | 10 |   0    |    N     |  N   |       | 入职时间  |
|  7   | waiterPhoneNumber |   char   | 11 |   0    |    Y     |  N   |   NULL    | 手机号  |
|  8   | remarks |   varchar   | 255 |   0    |    Y     |  N   |   NULL    | 备注  |

**运行不出来可以微信 javape 我的公众号：源码码头**
