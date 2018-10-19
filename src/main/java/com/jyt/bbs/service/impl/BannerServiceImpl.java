package com.jyt.bbs.service.impl;

import com.jyt.bbs.dao.BannerMapper;
import com.jyt.bbs.model.entity.Banner;
import com.jyt.bbs.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Component
public class BannerServiceImpl implements BannerService{
    @Autowired
    BannerMapper bannerMapper;

    @Override
    public List<Banner> allBanner() {
        return bannerMapper.selectAll();
    }
}
