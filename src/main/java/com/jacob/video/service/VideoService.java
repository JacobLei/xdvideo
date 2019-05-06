package com.jacob.video.service;

import com.jacob.video.domain.Video;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 视频业务类接口
 */
public interface VideoService {
    List<Video> findAll();
    Video findById(int id);
    int update(Video video);
    int delete(int id);
    int save(Video video);
}
