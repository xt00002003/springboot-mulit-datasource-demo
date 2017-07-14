package com.dark.service.first.impl;

import com.dark.dao.first.PmsCommodityMapper;
import com.dark.entity.PmsCommodity;
import com.dark.service.first.PmsCommodityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * springboot-mulit-datasource-demo
 * User: dark xue
 * Date: 2017/7/14
 * Time: 15:43
 * description:
 */
@Service
public class PmsCommodityServiceImpl implements PmsCommodityService {

    @Autowired
    private PmsCommodityMapper pmsCommodityMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return pmsCommodityMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(PmsCommodity record) {
        return pmsCommodityMapper.insert(record);
    }

    @Override
    public int insertSelective(PmsCommodity record) {
        return pmsCommodityMapper.insertSelective(record);
    }

    @Override
    public PmsCommodity selectByPrimaryKey(Long id) {
        return pmsCommodityMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(PmsCommodity record) {
        return pmsCommodityMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(PmsCommodity record) {
        return pmsCommodityMapper.updateByPrimaryKey(record);
    }
}
