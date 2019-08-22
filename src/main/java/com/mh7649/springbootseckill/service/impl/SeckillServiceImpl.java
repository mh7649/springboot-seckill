/*
 Copyright (c) 2002-2019 WiseCRM.com. All rights reserved.
 WiseCRM.com PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.mh7649.springbootseckill.service.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import com.mh7649.springbootseckill.dto.Exposer;
import com.mh7649.springbootseckill.dto.SeckillExecution;
import com.mh7649.springbootseckill.entity.Seckill;
import com.mh7649.springbootseckill.entity.SeckillOrder;
import com.mh7649.springbootseckill.enums.SeckillEnum;
import com.mh7649.springbootseckill.exception.RepeatSeckillException;
import com.mh7649.springbootseckill.exception.SeckillCloseException;
import com.mh7649.springbootseckill.exception.SeckillException;
import com.mh7649.springbootseckill.mapper.SeckillMapper;
import com.mh7649.springbootseckill.mapper.SeckillOrderMapper;
import com.mh7649.springbootseckill.service.SeckillService;

/**
 * @author laimh
 * @since 2019/8/20 21:40
 */
@Service
public class SeckillServiceImpl implements SeckillService {

    private static final String salt = "34dsAsfS%D@%23$%23%";

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;

    @Autowired
    private SeckillMapper seckillMapper;

    @Override
    public Seckill findById(long seckillId) {
        return seckillMapper.findById(seckillId);
    }

    @Override
    public List<Seckill> findAll() {
        return seckillMapper.findAll();
    }

    @Override
    public Exposer exposer(long seckillId) {
        Seckill seckill = seckillMapper.findById(seckillId);
        long beginTime = seckill.getStartTime().getTime();
        long endTime = seckill.getEndTime().getTime();
        long nowTime = Calendar.getInstance().getTime().getTime();
        if (nowTime < beginTime || nowTime > endTime) {
            return new Exposer(false, beginTime, endTime, nowTime);
        }
        String md5 = md5(seckillId);
        return new Exposer(true, md5);
    }

    public String md5(Long seckillId) {
        String base = seckillId + salt;
        return DigestUtils.md5DigestAsHex(base.getBytes());

    }

    @Override
    @Transactional
    public SeckillExecution execution(long seckillId, long phone, BigDecimal money, String md5) throws SeckillException {
        if (StringUtils.isEmpty(md5) || !md5.equals(md5(seckillId))) {
            throw new SeckillException("data rewrite!");
        }
        Date nowTime = Calendar.getInstance().getTime();
        try {
            int i = seckillOrderMapper.insertOrder(seckillId, money, phone);
            if (i <= 0) {
                throw new RepeatSeckillException("repeat seckill");
            } else {
                int result = seckillMapper.reduceStock(seckillId, nowTime);
                if (result <= 0) {
                    throw new SeckillException("seckill close");
                } else {
                    SeckillOrder seckillOrder = seckillOrderMapper.findById(seckillId, phone);
                    return new SeckillExecution(seckillId, seckillOrder, SeckillEnum.SUCCESS);
                }
            }
        } catch (SeckillException e) {
            throw e;
        } catch (Exception e) {
            throw new SeckillException(e.getMessage(), e);
        }
    }
}
