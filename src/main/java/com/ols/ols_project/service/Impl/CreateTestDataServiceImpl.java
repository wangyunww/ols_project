package com.ols.ols_project.service.Impl;

import com.ols.ols_project.common.utils.GenerateNameOfPerson;
import com.ols.ols_project.common.utils.GenerateString;
import com.ols.ols_project.mapper.CreateTestDataMapper;
import com.ols.ols_project.model.TaskEntity;
import com.ols.ols_project.model.UserEntity;
import com.ols.ols_project.service.CreateTestDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Random;

/**
 * 向数据库添加测试数据的实现类
 * @author yuyy
 * @date 20-2-17 下午4:22
 */
@Service
public class CreateTestDataServiceImpl implements CreateTestDataService {

    @Autowired
    private CreateTestDataMapper createTestDataMapper;

    @Override
    public void createTestDataForOlsUser() {
        UserEntity userEntity=new UserEntity();
        Random random = new Random();
        userEntity.setName(GenerateNameOfPerson.randomName(true,3));
        userEntity.setBirthday(new Date(
                90+(int)(Math.random()*10),
                1+(int)(Math.random()*(12)),
                1+(int)(Math.random()*28)));
        userEntity.setPassword(GenerateString.generateString(8));
        userEntity.setSex(Math.random()>0.5?"男":"女");
        userEntity.setEmail(GenerateString.generateNumber(10)+"@qq.com");
        userEntity.setRole(Math.random()>0.5?1:0);
        userEntity.setPoints(random.nextInt(1000));
        //System.out.println(userEntity);
        createTestDataMapper.createTestDataForOlsUser(userEntity);
    }

    @Override
    public void createTestDataForOlsTask() {
        TaskEntity taskEntity = new TaskEntity();
        Random random = new Random();
        taskEntity.setName("测试数据名字-"+GenerateString.generateNumber(4));
        taskEntity.setUrl("测试数据的URL-"+GenerateString.generateString(30));
        taskEntity.setInformation("测试数据的详细信息-"+GenerateString.generateString(8));
        taskEntity.setPoints(random.nextInt(20)+10);
        taskEntity.setState(random.nextInt(4));
        taskEntity.setType(random.nextInt(2));
        taskEntity.setReleasetime(new Timestamp(
                119,
                random.nextInt(6)+1,
                random.nextInt(28)+1,
                random.nextInt(24),
                random.nextInt(60),
                random.nextInt(60),
                random.nextInt(10000000)
        ));
        taskEntity.setFinishtime(new Timestamp(
                119,
                random.nextInt(6)+7,
                random.nextInt(28)+1,
                random.nextInt(24),
                random.nextInt(60),
                random.nextInt(60),
                random.nextInt(10000000)
        ));

        //System.out.println(taskEntity);
        createTestDataMapper.createTestDataForOlsTask(taskEntity);
    }
}