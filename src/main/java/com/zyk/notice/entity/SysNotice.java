package com.zyk.notice.entity;


import java.io.Serializable;
import java.util.StringJoiner;

public class SysNotice implements Serializable {

    private Long noticeId;

    private String noticeTitle;

    private String noticeContent;

    private String beginTime;

    private String overTime;

    private String forceOfflineTime;

    private Integer status;

    private String createdTime;

    private String updatedTime;

    public Long getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Long noticeId) {
        this.noticeId = noticeId;
    }

    public String getNoticeTitle() {
        return noticeTitle;
    }

    public void setNoticeTitle(String noticeTitle) {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime;
    }

    public String getOverTime() {
        return overTime;
    }

    public void setOverTime(String overTime) {
        this.overTime = overTime;
    }

    public String getForceOfflineTime() {
        return forceOfflineTime;
    }

    public void setForceOfflineTime(String forceOfflineTime) {
        this.forceOfflineTime = forceOfflineTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(String createdTime) {
        this.createdTime = createdTime;
    }

    public String getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", SysNotice.class.getSimpleName() + "[", "]")
                .add("noticeId=" + noticeId)
                .add("noticeTitle='" + noticeTitle + "'")
                .add("noticeContent='" + noticeContent + "'")
                .add("beginTime='" + beginTime + "'")
                .add("overTime='" + overTime + "'")
                .add("forceOfflineTime='" + forceOfflineTime + "'")
                .add("status=" + status)
                .add("createdTime='" + createdTime + "'")
                .add("updatedTime='" + updatedTime + "'")
                .toString();
    }
}