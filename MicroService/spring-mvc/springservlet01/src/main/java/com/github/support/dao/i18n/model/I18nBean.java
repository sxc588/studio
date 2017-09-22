package com.github.support.dao.i18n.model;

import java.util.Date;

public class I18nBean extends I18nBeanKey {
    private String i18nContent;

    private Date createTime;

    private Date lastUpdateTime;

    private String lastUpdateBy;

    public String getI18nContent() {
        return i18nContent;
    }

    public void setI18nContent(String i18nContent) {
        this.i18nContent = i18nContent == null ? null : i18nContent.trim();
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