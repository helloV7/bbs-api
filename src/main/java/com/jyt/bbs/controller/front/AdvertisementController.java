package com.jyt.bbs.controller.front;

import com.jyt.bbs.model.entity.Advertisement;
import com.jyt.bbs.model.vo.R;
import com.jyt.bbs.service.AdvertisementService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(value = "",tags = "广告")
@RestController
@RequestMapping("/advertisement")
public class AdvertisementController {
    @Autowired
    AdvertisementService advertisementService;

    @ApiOperation(value = "随机获取一个广告")
    @RequestMapping(value = "/rand",method = RequestMethod.GET)
    public @ResponseBody R<Advertisement> randAd(){
        return R.ok().setData(advertisementService.getRandAdvertisement());
    }

    @ApiOperation(value = "根据广告id跳转")
    @RequestMapping(value = "/click",method = RequestMethod.GET)
    public void click(Integer id, HttpServletResponse response){
        String url = advertisementService.advertisementClick(id);

        try {
            response.sendRedirect(url);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
