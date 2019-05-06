package com.jacob.video.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jacob.video.domain.Video;
import com.jacob.video.service.VideoService;
import org.apache.ibatis.annotations.Param;
import org.hibernate.validator.constraints.pl.REGON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    /**
     * 分页接口
     * @param page 当前第几页，默认是第一页
     * @param size 每页显示几条，默认显示十条
     * @return
     */
    @GetMapping("page")
    public Object pageVide(@RequestParam(value = "page", defaultValue = "1") int page,
                           @RequestParam(value = "size", defaultValue = "10") int size){
        PageHelper.startPage(page, size);
        List<Video> list = videoService.findAll();
        PageInfo<Video> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 根据Id查找视频
     * @param videoId
     * @return
     */
    @GetMapping("find_by_id")
    public Object findById(@RequestParam(value = "video_id", required = true) int videoId){

        return videoService.findById(videoId);
    }

}
