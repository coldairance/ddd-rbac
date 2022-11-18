package com.coldairance.rbac.test;


import javax.sql.DataSource;

import com.coldairance.rbac.user.infrastructure.mapper.UserMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ConfigureTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testDBConnection() {
        Assertions.assertNotNull(dataSource);
    }

    @Test
    public void testMyBatis() {
        Assertions.assertNotNull(userMapper);
    }
}
