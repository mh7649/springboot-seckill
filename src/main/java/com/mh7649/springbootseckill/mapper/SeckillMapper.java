package com.mh7649.springbootseckill.mapper;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mh7649.springbootseckill.entity.Seckill;

@Mapper
public interface SeckillMapper {

    /**
     * 减库存
     * 对于Mapper映射接口方法中存在多个参数的要加@Param()注解标识字段名称，不然Mybatis不能识别出来哪个字段相互对应
     *
     * @param seckillId 秒杀商品id
     * @param killTime 秒杀时间
     * @return 返回此SQL更新的记录数， 如果>=表示更新成功
     */
    int reduceStock(@Param("seckillId") long seckillId, @Param("seckillTime") Date killTime);

    /**
     * 插入购买订单明细
     *
     * @param seckillId 秒杀到的商品ID
     * @param money     秒杀的金额
     * @param userPhone 秒杀的用户
     * @return 返回该SQL更新的记录数，如果>=1则更新成功
     */
    int insertOrder(@Param("seckillId") long seckillId, @Param("money") BigDecimal money, @Param("userPhone") long userPhone);

    List<Seckill> findAll();

    Seckill findById(long seckillId);
}
