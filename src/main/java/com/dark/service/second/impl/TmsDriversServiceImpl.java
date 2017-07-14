package com.dark.service.second.impl;

import com.dark.dao.second.TmsDriversMapper;
import com.dark.entity.TmsDrivers;
import com.dark.service.second.TmsDriversService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * springboot-mulit-datasource-demo
 * User: dark xue
 * Date: 2017/7/14
 * Time: 16:13
 * description:
 */
@Service
public class TmsDriversServiceImpl implements TmsDriversService {

    @Autowired
    private TmsDriversMapper tmsDriversMapper;

    @Override
    public int deleteByPrimaryKey(Long did) {
        return tmsDriversMapper.deleteByPrimaryKey(did);
    }

    @Override
    public int insert(TmsDrivers record) {
        return tmsDriversMapper.insert(record);
    }

    @Override
    public int insertSelective(TmsDrivers record) {
        return tmsDriversMapper.insertSelective(record);
    }

    @Override
    public TmsDrivers selectByPrimaryKey(Long did) {
        return tmsDriversMapper.selectByPrimaryKey(did);
    }

    @Override
    public int updateByPrimaryKeySelective(TmsDrivers record) {
        return tmsDriversMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(TmsDrivers record) {
        return tmsDriversMapper.updateByPrimaryKey(record);
    }
}
