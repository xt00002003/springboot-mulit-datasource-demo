package com.dark.service.first;

import com.dark.entity.PmsCommodity;

public interface PmsCommodityService {
    int deleteByPrimaryKey(Long id);

    int insert(PmsCommodity record);

    int insertSelective(PmsCommodity record);

    PmsCommodity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(PmsCommodity record);

    int updateByPrimaryKey(PmsCommodity record);
}