package com.jyt.bbs.model.vo;

import com.jyt.bbs.model.entity.Post;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

public class PostDetail extends Post{

    @Getter
    @Setter
    @ApiModelProperty(value = "是否可以显示附件")
    private boolean showFile;

    @Getter
    @Setter
    @ApiModelProperty(value = "是否可以下载")
    private boolean canDownload;
}
