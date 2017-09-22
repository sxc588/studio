package com.github.support.dao.i18n.model;

public class I18nBeanKey {
    private String i18nKey;

    private String i18nLang;

    private Integer domainType;

    public String getI18nKey() {
        return i18nKey;
    }

    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey == null ? null : i18nKey.trim();
    }

    public String getI18nLang() {
        return i18nLang;
    }

    public void setI18nLang(String i18nLang) {
        this.i18nLang = i18nLang == null ? null : i18nLang.trim();
    }

    public Integer getDomainType() {
        return domainType;
    }

    public void setDomainType(Integer domainType) {
        this.domainType = domainType;
    }
}