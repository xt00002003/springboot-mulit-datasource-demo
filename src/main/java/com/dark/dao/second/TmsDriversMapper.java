package com.dark.dao.second;

import com.dark.entity.TmsDrivers;

public interface TmsDriversMapper {
    int deleteByPrimaryKey(Long did);

    int insert(TmsDrivers record);

    int insertSelective(TmsDrivers record);

    TmsDrivers selectByPrimaryKey(Long did);

    int updateByPrimaryKeySelective(TmsDrivers record);

    int updateByPrimaryKey(TmsDrivers record);
}