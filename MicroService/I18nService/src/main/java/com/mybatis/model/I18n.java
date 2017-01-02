package com.mybatis.model;

import java.util.Date;

public class I18n {
    private String langkey;

    private String langtype;

    private String content;

    private Date createtime;

    private Date lastupdatetime;

    private String lastupdatetype;

    private String domain;

    public String getLangkey() {
        return langkey;
    }

    public void setLangkey(String langkey) {
        this.langkey = langkey == null ? null : langkey.trim();
    }

    public String getLangtype() {
        return langtype;
    }

    public void setLangtype(String langtype) {
        this.langtype = langtype == null ? null : langtype.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
    }

    public String getLastupdatetype() {
        return lastupdatetype;
    }

    public void setLastupdatetype(String lastupdatetype) {
        this.lastupdatetype = lastupdatetype == null ? null : lastupdatetype.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }
}