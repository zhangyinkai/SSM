package com.zyk.notice.service;


import com.zyk.notice.entity.SysNotice;

public interface SysNoticeService {
    int insert(SysNotice record);

    SysNotice selectByPrimaryKey(Long noticeId);

    SysNotice updateByPrimaryKeySelective(SysNotice record);

    void cleanAllCache();
     SysNotice getSysNoticeById(Long noticeId);

    int addNotice();

    int createNotice();
}