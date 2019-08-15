package com.mh7649.springbootseckill.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mh7649.springbootseckill.entity.Seckill;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SeckillMapperTest {

    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void testFindAll() {
        List<Seckill> seckillList = seckillMapper.findAll();
        for (Seckill seckill : seckillList) {
            System.out.println(seckill.getTitle());
        }
    }
}