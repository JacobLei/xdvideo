package com.jacob.video.controller.admin;

import com.jacob.video.domain.Video;
import com.jacob.video.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员控制权限
 */
@RestController
@RequestMapping("/admin/api/v1/video")
public class VideoAdminController {

    @Autowired
    private VideoService videoService;

    /**
     * 根据Id删除视频
     * @param videoId
     * @return
     */
    @DeleteMapping("del_by_id")
    public Object delById(@RequestParam(value = "video_id", required = true)int videoId){

        return videoService.delete(videoId);
    }

    /**
     * 根据Id更新视频
     * @param video 视频实体
     * @return
     */
    @PutMapping("update_by_id")
    public Object update(@RequestBody Video video){

        return videoService.update(video);
    }

    /**
     * 保存视频
     * @param video 视频实体
     * @return
     */
    @PostMapping("save")
    public Object save(@RequestBody Video video){
        int res = videoService.save(video);
        System.out.println("videoId = " + video.getId());
        return res;
    }
}
