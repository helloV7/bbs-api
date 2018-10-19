package com.jyt.bbs.service.impl;

import com.jyt.bbs.dao.ScoreWaterMapper;
import com.jyt.bbs.model.entity.ScoreWater;
import com.jyt.bbs.service.ScoreRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Component
@Transactional
public class ScoreRecordServiceImpl implements ScoreRecordService{
    @Autowired
    ScoreWaterMapper scoreWaterMapper;

    @Override
    public void addRecord(ScoreWater scoreWater) {
        scoreWater.setCreateTime(new Date());
        scoreWaterMapper.insert(scoreWater);
    }
}
