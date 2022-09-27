package com.bapsim.sprapp.service;

import com.bapsim.sprapp.model.DBSequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import static org.springframework.data.mongodb.core.query.Query.query;
import static org.springframework.data.mongodb.core.query.Criteria.where;

import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class SequenceGeneratorService {

    private MongoOperations mongoOperations;

    @Autowired
    public SequenceGeneratorService(MongoOperations mongoOperations) {
        this.mongoOperations = mongoOperations;
    }

    public long generateSequence(String sequenceName) {
        DBSequence counter = mongoOperations
                .findAndModify(
                        query(where("_id").is(sequenceName)),
                        new Update().inc("sequence", 1),
                        FindAndModifyOptions.options().returnNew(true).upsert(true),
                        DBSequence.class
                );

        return Objects.isNull(counter) ? 0 : counter.getSequence();
    }

}
