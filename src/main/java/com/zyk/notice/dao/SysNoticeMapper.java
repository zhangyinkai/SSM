package com.zyk.notice.dao;

import com.zyk.notice.entity.SysNotice;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SysNoticeMapper {
    int deleteByPrimaryKey(Long noticeId);

    int insert(SysNotice record);

    int insertSelective(SysNotice record);

    SysNotice selectByPrimaryKey(Long noticeId);

    int updateByPrimaryKeySelective(SysNotice record);

    int updateByPrimaryKey(SysNotice record);
}