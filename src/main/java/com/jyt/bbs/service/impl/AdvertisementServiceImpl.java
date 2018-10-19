package com.jyt.bbs.service.impl;

import com.jyt.bbs.dao.AdClickMapper;
import com.jyt.bbs.dao.AdvertisementMapper;
import com.jyt.bbs.model.entity.AdClick;
import com.jyt.bbs.model.entity.Advertisement;
import com.jyt.bbs.service.AdvertisementService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Transactional
@Component
public class AdvertisementServiceImpl implements AdvertisementService {
    @Autowired
    AdvertisementMapper advertisementMapper;
    @Autowired
    AdClickMapper adClickMapper;
    @Override
    public Advertisement getRandAdvertisement() {
        return advertisementMapper.getAdvertisementRand();
    }

    @Override
    public String advertisementClick(Integer advertisementId) {

        Advertisement advertisement = advertisementMapper.selectByPrimaryKey(advertisementId);
        if (advertisement==null){
            throw new RuntimeException("无效id");
        }

        AdClick adClick = new AdClick();
        adClick.setCreateTime(new Date());
        adClick.setAdId(advertisement.getId());
        adClick.setIp(SecurityUtils.getSubject().getSession().getHost().toString());
        adClickMapper.insert(adClick);

        return advertisement.getJumpUrl();
    }
}
