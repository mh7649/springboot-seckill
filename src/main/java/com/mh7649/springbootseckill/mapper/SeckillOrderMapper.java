package com.mh7649.springbootseckill.mapper;

import java.math.BigDecimal;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mh7649.springbootseckill.entity.SeckillOrder;

@Mapper
public interface SeckillOrderMapper {

    /**
     *  根据秒杀商品ID查询订单明细数据并得到对应秒杀商品的数据，因为我们在SeckillOrder中已经定义了一个Seckill的属性
     * @param seckillId id
     * @return 订单
     */
    SeckillOrder findById(@Param("seckillId") long seckillId, @Param("phone") long phone);

    int insertOrder(@Param("seckillId") long seckillId, @Param("money")BigDecimal money, @Param("phone") long phone);
}
