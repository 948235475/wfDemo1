package com.wf.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "storeSetting")
public class StoreSetting {
    /**
     * 场所id
     */
    private Integer storeId;

    /**
     * 开关 0：关  1：开
     */
    private int derail;

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public int getDerail() {
        return derail;
    }

    public void setDerail(int derail) {
        this.derail = derail;
    }

    @Override
    public String toString() {
        return "StoreSetting{" +
                "storeId=" + storeId +
                ", derail=" + derail +
                '}';
    }
}
