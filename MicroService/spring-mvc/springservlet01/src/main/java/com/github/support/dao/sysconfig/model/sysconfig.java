package com.github.support.dao.sysconfig.model;

import java.util.Date;

public class sysconfig {
    private String key;

    private String supKey;

    private String content;

    private String descprption;

    private Date createTime;

    private Date lastUpdateTime;

    private String lastUpdateBy;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getSupKey() {
        return supKey;
    }

    public void setSupKey(String supKey) {
        this.supKey = supKey == null ? null : supKey.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDescprption() {
        return descprption;
    }

    public void setDescprption(String descprption) {
        this.descprption = descprption == null ? null : descprption.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }
}