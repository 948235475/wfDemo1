package com.wf.dao.impl;

import com.mongodb.client.result.UpdateResult;
import com.wf.Exception.MyException;
import com.wf.dao.StoreSettingDao;
import com.wf.model.StoreSetting;
import org.springframework.data.mongodb.core.BulkOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class StoreSettingDaoImpl implements StoreSettingDao {

    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public StoreSetting findSetting(int storeId) {
        Query query = new Query();
        query.addCriteria(Criteria.where("storeId").is(storeId));
        return mongoTemplate.findOne(query,StoreSetting.class);
    }

    @Override
    public void addSetting(StoreSetting storeSetting) {
        mongoTemplate.insert(storeSetting);
    }

    @Override
    public boolean updateDerail(int storeId, int derail) {
        Query query = new Query();
        query.addCriteria(Criteria.where("storeId").is(storeId));
        Update update = new Update();
        update.set("derail",derail);
        UpdateResult updateResult = mongoTemplate.updateFirst(query,update,StoreSetting.class);
        return updateResult.getMatchedCount() > 1;
    }

    @Override
    public List<StoreSetting> findAll() {
        Query query = new Query();
        query.addCriteria(Criteria.where("storeId").exists(true));
        return mongoTemplate.find(query,StoreSetting.class);
    }

    @Override
    public void saveAll(List<StoreSetting> list) {
        BulkOperations bulkOperations = mongoTemplate.bulkOps(BulkOperations.BulkMode.UNORDERED, "storeSetting");
        bulkOperations.insert(list);
        bulkOperations.execute();
    }
}
