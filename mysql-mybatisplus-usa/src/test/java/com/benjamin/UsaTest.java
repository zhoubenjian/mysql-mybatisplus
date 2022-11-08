package com.benjamin;

import com.benjamin.dao.PartyMapper;
import com.benjamin.entities.Party;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UsaTest {

    @Autowired
    private PartyMapper partyMapper;



    @Test
    public void stateTest() {
        log.info("开始测试...");
        List<Party> partyList = partyMapper.selectList(null);
        log.info("结束测试...");
    }
}
