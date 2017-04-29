package com.github.support.mybatis.i18n.model;

import java.io.Serializable;
import java.util.Date;

public class I18nBean implements Serializable {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_i18n.I18N_KEY
     *
     * @mbggenerated
     */
    private String i18nKey;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_i18n.I18N_LANG
     *
     * @mbggenerated
     */
    private String i18nLang;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_i18n.DOMAIN_TYPE
     *
     * @mbggenerated
     */
    private String domainType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_i18n.I18N_CONTENT
     *
     * @mbggenerated
     */
    private String i18nContent;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_i18n.CREATE_TIME
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_i18n.LAST_UPDATE_TIME
     *
     * @mbggenerated
     */
    private Date lastUpdateTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column t_i18n.LAST_UPDATE_BY
     *
     * @mbggenerated
     */
    private String lastUpdateBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table t_i18n
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_i18n.I18N_KEY
     *
     * @return the value of t_i18n.I18N_KEY
     *
     * @mbggenerated
     */
    public String getI18nKey() {
        return i18nKey;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_i18n.I18N_KEY
     *
     * @param i18nKey the value for t_i18n.I18N_KEY
     *
     * @mbggenerated
     */
    public void setI18nKey(String i18nKey) {
        this.i18nKey = i18nKey == null ? null : i18nKey.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_i18n.I18N_LANG
     *
     * @return the value of t_i18n.I18N_LANG
     *
     * @mbggenerated
     */
    public String getI18nLang() {
        return i18nLang;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_i18n.I18N_LANG
     *
     * @param i18nLang the value for t_i18n.I18N_LANG
     *
     * @mbggenerated
     */
    public void setI18nLang(String i18nLang) {
        this.i18nLang = i18nLang == null ? null : i18nLang.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_i18n.DOMAIN_TYPE
     *
     * @return the value of t_i18n.DOMAIN_TYPE
     *
     * @mbggenerated
     */
    public String getDomainType() {
        return domainType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_i18n.DOMAIN_TYPE
     *
     * @param domainType the value for t_i18n.DOMAIN_TYPE
     *
     * @mbggenerated
     */
    public void setDomainType(String domainType) {
        this.domainType = domainType == null ? null : domainType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_i18n.I18N_CONTENT
     *
     * @return the value of t_i18n.I18N_CONTENT
     *
     * @mbggenerated
     */
    public String getI18nContent() {
        return i18nContent;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_i18n.I18N_CONTENT
     *
     * @param i18nContent the value for t_i18n.I18N_CONTENT
     *
     * @mbggenerated
     */
    public void setI18nContent(String i18nContent) {
        this.i18nContent = i18nContent == null ? null : i18nContent.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_i18n.CREATE_TIME
     *
     * @return the value of t_i18n.CREATE_TIME
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_i18n.CREATE_TIME
     *
     * @param createTime the value for t_i18n.CREATE_TIME
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_i18n.LAST_UPDATE_TIME
     *
     * @return the value of t_i18n.LAST_UPDATE_TIME
     *
     * @mbggenerated
     */
    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_i18n.LAST_UPDATE_TIME
     *
     * @param lastUpdateTime the value for t_i18n.LAST_UPDATE_TIME
     *
     * @mbggenerated
     */
    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_i18n.LAST_UPDATE_BY
     *
     * @return the value of t_i18n.LAST_UPDATE_BY
     *
     * @mbggenerated
     */
    public String getLastUpdateBy() {
        return lastUpdateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_i18n.LAST_UPDATE_BY
     *
     * @param lastUpdateBy the value for t_i18n.LAST_UPDATE_BY
     *
     * @mbggenerated
     */
    public void setLastUpdateBy(String lastUpdateBy) {
        this.lastUpdateBy = lastUpdateBy == null ? null : lastUpdateBy.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_i18n
     *
     * @mbggenerated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        I18nBean other = (I18nBean) that;
        return (this.getI18nKey() == null ? other.getI18nKey() == null : this.getI18nKey().equals(other.getI18nKey()))
            && (this.getI18nLang() == null ? other.getI18nLang() == null : this.getI18nLang().equals(other.getI18nLang()))
            && (this.getDomainType() == null ? other.getDomainType() == null : this.getDomainType().equals(other.getDomainType()))
            && (this.getI18nContent() == null ? other.getI18nContent() == null : this.getI18nContent().equals(other.getI18nContent()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getLastUpdateTime() == null ? other.getLastUpdateTime() == null : this.getLastUpdateTime().equals(other.getLastUpdateTime()))
            && (this.getLastUpdateBy() == null ? other.getLastUpdateBy() == null : this.getLastUpdateBy().equals(other.getLastUpdateBy()));
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_i18n
     *
     * @mbggenerated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getI18nKey() == null) ? 0 : getI18nKey().hashCode());
        result = prime * result + ((getI18nLang() == null) ? 0 : getI18nLang().hashCode());
        result = prime * result + ((getDomainType() == null) ? 0 : getDomainType().hashCode());
        result = prime * result + ((getI18nContent() == null) ? 0 : getI18nContent().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getLastUpdateTime() == null) ? 0 : getLastUpdateTime().hashCode());
        result = prime * result + ((getLastUpdateBy() == null) ? 0 : getLastUpdateBy().hashCode());
        return result;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_i18n
     *
     * @mbggenerated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", i18nKey=").append(i18nKey);
        sb.append(", i18nLang=").append(i18nLang);
        sb.append(", domainType=").append(domainType);
        sb.append(", i18nContent=").append(i18nContent);
        sb.append(", createTime=").append(createTime);
        sb.append(", lastUpdateTime=").append(lastUpdateTime);
        sb.append(", lastUpdateBy=").append(lastUpdateBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}