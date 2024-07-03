create database shop_db;
use shop_db;
drop table if exists users;
create table users(
  uid int primary key auto_increment comment '全平台用户的唯一ID。',
  create_time timestamp DEFAULT CURRENT_TIMESTAMP comment '创建账户的时间戳',
  update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '更新的时间戳',
  username varchar(100) comment '用户名，用于登录账户',
  password varchar(100) comment '账户密码，经过加密处理存储',
  create_ip varchar(100) comment '账户创建时的IP地址',
  status TINYINT comment '账户状态，用整数表示， 1表示启用， 0表示禁用， -1表示删除',
  sys_type int comment '用户类型，区分不同的系统用户类型，例如普通用户、商家端、平台端等',
  tenant_id int comment '租户ID，指明账户所属的租户'
)engine =innodb comment='用户信息表';


drop table if exists user_orders;
create table user_orders(
    order_id int primary key auto_increment comment '订单的唯一标识这是主键，用于唯一标识每个订单',
    create_time timestamp DEFAULT CURRENT_TIMESTAMP comment '订单创建时间',
    update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '订单更新时间',
    shop_id int comment '订单所属店铺的唯一标识',
    user_id int comment '下订单的用户的唯一标识，不能为空',
    delivery_type TINYINT comment '订单的配送类型',
    shop_name varchar(100) comment '店铺名称',
    total double comment '订单的总值',
    status TINYINT comment '订单的状态',
    all_count int comment '订单商品总数',
    pay_time datetime comment '订单的付款时间',
    delivery_time datetime comment '订单的发货时间',
    finally_time datetime comment '订单完成时间',
    settled_time datetime comment '订单结算时间',
    cancel_time datetime comment '订单取消时间',
    is_payed TINYINT comment '标识订单是否已支付',
    close_type int comment '订单关闭原因，默认值也可以为NULL',
    delete_status TINYINT comment '用户订单删除状态，默认值为0',
    version varchar(50) comment '订单版本号',
    order_addr_id int comment '用户订单地址的唯一标识'
)engine =innodb comment='用户订单表';

drop table if exists user_order_details;
create table user_order_details(
   order_item_id int primary key auto_increment comment '订单项的唯一标识',
   create_time timestamp DEFAULT CURRENT_TIMESTAMP comment '记录创建时间',
   update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '记录更新时间，在更新时自动更新为当前时间戳',
   shop_id int comment '订单项所属的店铺ID',
   order_id int comment '关联的订单ID',
   category_id int comment '产品分类ID',
   spu_id varchar(100) comment '产品ID，用于标识具体的产品。',
   sku_id varchar(100) comment '产品SKU ID，可能表示具体规格的产品ID。',
   user_id int comment '用户ID，与订单项相关联的用户ID。',
   count int comment '购物车中该产品的数量。',
   spu_name varchar(100) comment '产品名称。',
   sku_name varchar(100) comment '产品SKU名称。',
   pic varchar(100) comment '产品主图片路径。',
   delivery_type int comment '单个orderItem的配送类型，例如表示是否需要快递等。',
   shop_cart_time datetime comment '加入购物车时间，记录了订单项加入购物车的时间。',
   price double comment '产品价格。',
   spu_total_amount double comment '商品总金额，可能是某个产品在订单项中的总价。'
)engine =innodb comment='用户订单详情表';

drop table if exists order_address;
create table order_address(
  order_addr_id int primary key auto_increment comment '订单地址唯一标识',
  user_id int comment '用户ID',
  consignee varchar(100) comment '收货人。',
  province_id int comment '省份ID',
  province varchar(100) comment '省份名称',
  city_id int comment '城市ID',
  city varchar(100) comment '城市名称',
  area_id int comment '区域ID',
  area varchar(100) comment '区域名称',
  addr varchar(100) comment '具体地址',
  post_code varchar(100) comment '邮政编码',
  mobile varchar(100) comment '手机号码',
  lng varchar(100) comment '坐标经度',
  lat varchar(100) comment '坐标纬度',
  create_time timestamp DEFAULT CURRENT_TIMESTAMP comment '记录创建时间',
  update_time timestamp DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP comment '记录更新时间，在更新时自动更新为当前时间戳'
)engine =innodb comment='订单地址信息';

drop table if exists user_login_log;
create table user_login_log(
    log_id int primary key auto_increment comment '主键',
    uid int not null comment '登陆用户',
    ip_address varchar(50) comment '登陆IP',
    device varchar(50) comment '登陆设备',
    login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP comment '登陆时间'

)ENGINE=innodb comment='用户登陆日志';


