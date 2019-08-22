package com.mh7649.springbootseckill.service;

import java.math.BigDecimal;
import java.util.List;

import com.mh7649.springbootseckill.dto.Exposer;
import com.mh7649.springbootseckill.dto.SeckillExecution;
import com.mh7649.springbootseckill.entity.Seckill;
import com.mh7649.springbootseckill.exception.SeckillException;

/**
 * @author laimh
 * @since 2019/8/20 21:35
 */
public interface SeckillService {

    Seckill findById(long seckillId);

    List<Seckill> findAll();

    Exposer exposer(long seckillId);

    SeckillExecution execution(long seckillId, long phone, BigDecimal money, String md5)
            throws SeckillException;
}
