package com.jyt.bbs.service;

import com.jyt.bbs.model.entity.Advertisement;

public interface AdvertisementService {

    public Advertisement getRandAdvertisement();

    String advertisementClick(Integer advertisementId);
}
