package com.mh7649.springbootseckill.mapper;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class SeckillOrderMapperTest {

    @Autowired
    private SeckillOrderMapper seckillOrderMapper;


    @Test
    public void testFindById() {
        System.out.println(seckillOrderMapper.findById(1, 15999999988L));
    }

    @Test
    public void testInsertOrder() {
        System.out.println(seckillOrderMapper.insertOrder(1, new BigDecimal("123"), 15999999988L));
    }
}