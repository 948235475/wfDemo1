package com.wf.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("sequence")
public class Sequence {

    @Id
    private String id;

    @Indexed(unique = true)
    private String username;

    private long seqId;

    private List<Object> list;
}
