package com.wf.dao;

import com.wf.Exception.MyException;
import com.wf.model.StoreSetting;

import java.util.List;

public interface StoreSettingDao {

    StoreSetting findSetting(int storeId);

    void addSetting(StoreSetting storeSetting);

    boolean updateDerail(int storeId,int derail);

    List<StoreSetting> findAll();

    void saveAll(List<StoreSetting> list);
}
