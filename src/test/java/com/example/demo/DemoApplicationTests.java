package com.example.demo;

import com.wf.dao.impl.StoreSettingDaoImpl;
import com.wf.model.StoreSetting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Resource
    private StoreSettingDaoImpl storeSettingDao;

    @Test
    public void wfTest(){
        StoreSetting storeSetting = new StoreSetting();
        storeSetting.setStoreId(2);
        storeSetting.setDerail(0);
        storeSettingDao.addSetting(storeSetting);
    }
}
