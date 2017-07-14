package com.dark.service.second;

import com.dark.entity.TmsDrivers;

public interface TmsDriversService {
    int deleteByPrimaryKey(Long did);

    int insert(TmsDrivers record);

    int insertSelective(TmsDrivers record);

    TmsDrivers selectByPrimaryKey(Long did);

    int updateByPrimaryKeySelective(TmsDrivers record);

    int updateByPrimaryKey(TmsDrivers record);
}