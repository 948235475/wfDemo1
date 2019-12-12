package com.wf.service.impl;

import com.wf.model.Sequence;
import com.wf.service.SequenceService;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SequenceServiceImpl implements SequenceService {

    @Resource
    private MongoTemplate mongoTemplate;

    private static final int LIMIT = 10;

    @Override
    public long addResource(String username, int num, Object o) {
        Query query = new Query();
        query.addCriteria(Criteria.where("username").is(username));
        query.addCriteria(Criteria.where("seqId").lt(LIMIT));
        Update update = new Update();
        update.inc("seqId",num);
        update.push("list",o);
        FindAndModifyOptions options = new FindAndModifyOptions();
        options.upsert(true);
        options.returnNew(true);
        Sequence sequence = mongoTemplate.findAndModify(query,update,options,Sequence.class);
        if (sequence == null){
            return 0;
        }
        return sequence.getSeqId();
    }
}
