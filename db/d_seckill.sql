CREATE DATABASE d_seckillseckill DEFAULT CHARACTER SET utf8;
use seckill;

drop table if exists `seckill`;
drop table if exists `seckill_order`;

-- 创建秒杀商品表
create table `seckill`(
  `seckill_id` bigint NOT NULL AUTO_INCREMENT COMMENT '商品ID',
  `title` varchar (1000) DEFAULT NULL COMMENT '商品标题',
  `image` varchar (1000) DEFAULT NULL COMMENT '商品图片',
  `price` decimal (10,2) DEFAULT NULL COMMENT '商品原价格',
  `cost_price` decimal (10,2) DEFAULT NULL COMMENT '商品秒杀价格',
  `stock_count` bigint DEFAULT NULL COMMENT '剩余库存数量',
  `start_time` timestamp NOT NULL DEFAULT '1970-02-01 00:00:01' COMMENT '秒杀开始时间',
  `end_time` timestamp NOT NULL DEFAULT '1970-02-01 00:00:01' COMMENT '秒杀结束时间',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY (`seckill_id`),
  KEY `idx_start_time` (`start_time`),
  KEY `idx_end_time` (`end_time`),
  KEY `idx_create_time` (`end_time`)
) CHARSET=utf8 ENGINE=InnoDB COMMENT '秒杀商品表';

-- 创建秒杀订单表
CREATE TABLE `seckill_order`(
  `seckill_id` bigint NOT NULL COMMENT '秒杀商品ID',
  `money` decimal (10, 2) DEFAULT NULL COMMENT '支付金额',
  `user_phone` bigint NOT NULL COMMENT '用户手机号',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `state` tinyint NOT NULL DEFAULT -1 COMMENT '状态：-1无效 0成功 1已付款',
  PRIMARY KEY (`seckill_id`, `user_phone`) /*联合主键，保证一个用户只能秒杀一件商品*/
) CHARSET=utf8 ENGINE=InnoDB COMMENT '秒杀订单表';

-- 插入秒杀商品数据
-- INSERT INTO `seckill` (`seckill_id`, `title`, `image`, `price`, `cost_price`, `stock_count`, `start_time`, `end_time`, `create_time`) VALUES (1, 'iPhoneX', 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i3/2249262840/O1CN011WqlHkrSuPEiHxd_!!2249262840.jpg_230x230.jpg', 9999.00, 8888.00, 9, '2019-08-06 00:00:01', '2019-08-07 23:00:01', '2019-08-06 22:07:07');
-- INSERT INTO `seckill` (`seckill_id`, `title`, `image`, `price`, `cost_price`, `stock_count`, `start_time`, `end_time`, `create_time`) VALUES (2, 'doll', 'https://g-search3.alicdn.com/img/bao/uploaded/i4/i2/3828650009/TB22CvKkeOSBuNjy0FdXXbDnVXa_!!3828650009.jpg_230x230.jpg', 999.00, 888.00, 8, '2019-02-01 00:00:01', '2019-08-10 00:00:01', '2019-08-06 22:09:20');
