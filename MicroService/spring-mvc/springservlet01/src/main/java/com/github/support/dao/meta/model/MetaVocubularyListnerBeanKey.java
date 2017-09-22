package com.github.support.dao.meta.model;

public class MetaVocubularyListnerBeanKey {
    private String vid;

    private String listnerId;

    public String getVid() {
        return vid;
    }

    public void setVid(String vid) {
        this.vid = vid == null ? null : vid.trim();
    }

    public String getListnerId() {
        return listnerId;
    }

    public void setListnerId(String listnerId) {
        this.listnerId = listnerId == null ? null : listnerId.trim();
    }
}