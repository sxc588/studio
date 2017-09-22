package com.github.support.dao.htmlarea.model;

public class HtmlAreaBeanKey {
    private String areaId;

    private String areaLang;

    private Integer domainType;

    public String getAreaId() {
        return areaId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId == null ? null : areaId.trim();
    }

    public String getAreaLang() {
        return areaLang;
    }

    public void setAreaLang(String areaLang) {
        this.areaLang = areaLang == null ? null : areaLang.trim();
    }

    public Integer getDomainType() {
        return domainType;
    }

    public void setDomainType(Integer domainType) {
        this.domainType = domainType;
    }
}