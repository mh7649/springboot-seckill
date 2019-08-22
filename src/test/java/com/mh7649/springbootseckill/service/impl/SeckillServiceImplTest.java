package com.mh7649.springbootseckill.service.impl;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mh7649.springbootseckill.entity.Seckill;
import com.mh7649.springbootseckill.service.SeckillService;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SeckillServiceImplTest {

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testFindById() {
        System.out.println(seckillService.findById(1));
    }

    @Test
    public void testFindAll() {
        List<Seckill> all = seckillService.findAll();
        for (Seckill seckill : all) {
            System.out.println(seckill);
        }
    }

    @Test
    public void testExposer() {
        System.out.println(seckillService.exposer(1));
    }

    @Test
    public void testExecution() {
        System.out.println(seckillService.execution(1, 18899998888L, new BigDecimal("9999"), new SeckillServiceImpl().md5(1L)));
    }
}