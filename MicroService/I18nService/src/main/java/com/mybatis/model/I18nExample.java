package com.mybatis.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class I18nExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public I18nExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLangkeyIsNull() {
            addCriterion("langkey is null");
            return (Criteria) this;
        }

        public Criteria andLangkeyIsNotNull() {
            addCriterion("langkey is not null");
            return (Criteria) this;
        }

        public Criteria andLangkeyEqualTo(String value) {
            addCriterion("langkey =", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyNotEqualTo(String value) {
            addCriterion("langkey <>", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyGreaterThan(String value) {
            addCriterion("langkey >", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyGreaterThanOrEqualTo(String value) {
            addCriterion("langkey >=", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyLessThan(String value) {
            addCriterion("langkey <", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyLessThanOrEqualTo(String value) {
            addCriterion("langkey <=", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyLike(String value) {
            addCriterion("langkey like", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyNotLike(String value) {
            addCriterion("langkey not like", value, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyIn(List<String> values) {
            addCriterion("langkey in", values, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyNotIn(List<String> values) {
            addCriterion("langkey not in", values, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyBetween(String value1, String value2) {
            addCriterion("langkey between", value1, value2, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangkeyNotBetween(String value1, String value2) {
            addCriterion("langkey not between", value1, value2, "langkey");
            return (Criteria) this;
        }

        public Criteria andLangtypeIsNull() {
            addCriterion("langtype is null");
            return (Criteria) this;
        }

        public Criteria andLangtypeIsNotNull() {
            addCriterion("langtype is not null");
            return (Criteria) this;
        }

        public Criteria andLangtypeEqualTo(String value) {
            addCriterion("langtype =", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotEqualTo(String value) {
            addCriterion("langtype <>", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeGreaterThan(String value) {
            addCriterion("langtype >", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeGreaterThanOrEqualTo(String value) {
            addCriterion("langtype >=", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeLessThan(String value) {
            addCriterion("langtype <", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeLessThanOrEqualTo(String value) {
            addCriterion("langtype <=", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeLike(String value) {
            addCriterion("langtype like", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotLike(String value) {
            addCriterion("langtype not like", value, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeIn(List<String> values) {
            addCriterion("langtype in", values, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotIn(List<String> values) {
            addCriterion("langtype not in", values, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeBetween(String value1, String value2) {
            addCriterion("langtype between", value1, value2, "langtype");
            return (Criteria) this;
        }

        public Criteria andLangtypeNotBetween(String value1, String value2) {
            addCriterion("langtype not between", value1, value2, "langtype");
            return (Criteria) this;
        }

        public Criteria andContentIsNull() {
            addCriterion("content is null");
            return (Criteria) this;
        }

        public Criteria andContentIsNotNull() {
            addCriterion("content is not null");
            return (Criteria) this;
        }

        public Criteria andContentEqualTo(String value) {
            addCriterion("content =", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotEqualTo(String value) {
            addCriterion("content <>", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThan(String value) {
            addCriterion("content >", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentGreaterThanOrEqualTo(String value) {
            addCriterion("content >=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThan(String value) {
            addCriterion("content <", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLessThanOrEqualTo(String value) {
            addCriterion("content <=", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentLike(String value) {
            addCriterion("content like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotLike(String value) {
            addCriterion("content not like", value, "content");
            return (Criteria) this;
        }

        public Criteria andContentIn(List<String> values) {
            addCriterion("content in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotIn(List<String> values) {
            addCriterion("content not in", values, "content");
            return (Criteria) this;
        }

        public Criteria andContentBetween(String value1, String value2) {
            addCriterion("content between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andContentNotBetween(String value1, String value2) {
            addCriterion("content not between", value1, value2, "content");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNull() {
            addCriterion("createtime is null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIsNotNull() {
            addCriterion("createtime is not null");
            return (Criteria) this;
        }

        public Criteria andCreatetimeEqualTo(Date value) {
            addCriterion("createtime =", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotEqualTo(Date value) {
            addCriterion("createtime <>", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThan(Date value) {
            addCriterion("createtime >", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createtime >=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThan(Date value) {
            addCriterion("createtime <", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeLessThanOrEqualTo(Date value) {
            addCriterion("createtime <=", value, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeIn(List<Date> values) {
            addCriterion("createtime in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotIn(List<Date> values) {
            addCriterion("createtime not in", values, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeBetween(Date value1, Date value2) {
            addCriterion("createtime between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andCreatetimeNotBetween(Date value1, Date value2) {
            addCriterion("createtime not between", value1, value2, "createtime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNull() {
            addCriterion("lastupdatetime is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIsNotNull() {
            addCriterion("lastupdatetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeEqualTo(Date value) {
            addCriterion("lastupdatetime =", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotEqualTo(Date value) {
            addCriterion("lastupdatetime <>", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThan(Date value) {
            addCriterion("lastupdatetime >", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastupdatetime >=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThan(Date value) {
            addCriterion("lastupdatetime <", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("lastupdatetime <=", value, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeIn(List<Date> values) {
            addCriterion("lastupdatetime in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotIn(List<Date> values) {
            addCriterion("lastupdatetime not in", values, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeBetween(Date value1, Date value2) {
            addCriterion("lastupdatetime between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("lastupdatetime not between", value1, value2, "lastupdatetime");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeIsNull() {
            addCriterion("lastupdatetype is null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeIsNotNull() {
            addCriterion("lastupdatetype is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeEqualTo(String value) {
            addCriterion("lastupdatetype =", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeNotEqualTo(String value) {
            addCriterion("lastupdatetype <>", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeGreaterThan(String value) {
            addCriterion("lastupdatetype >", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeGreaterThanOrEqualTo(String value) {
            addCriterion("lastupdatetype >=", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeLessThan(String value) {
            addCriterion("lastupdatetype <", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeLessThanOrEqualTo(String value) {
            addCriterion("lastupdatetype <=", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeLike(String value) {
            addCriterion("lastupdatetype like", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeNotLike(String value) {
            addCriterion("lastupdatetype not like", value, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeIn(List<String> values) {
            addCriterion("lastupdatetype in", values, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeNotIn(List<String> values) {
            addCriterion("lastupdatetype not in", values, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeBetween(String value1, String value2) {
            addCriterion("lastupdatetype between", value1, value2, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andLastupdatetypeNotBetween(String value1, String value2) {
            addCriterion("lastupdatetype not between", value1, value2, "lastupdatetype");
            return (Criteria) this;
        }

        public Criteria andDomainIsNull() {
            addCriterion("domain is null");
            return (Criteria) this;
        }

        public Criteria andDomainIsNotNull() {
            addCriterion("domain is not null");
            return (Criteria) this;
        }

        public Criteria andDomainEqualTo(String value) {
            addCriterion("domain =", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotEqualTo(String value) {
            addCriterion("domain <>", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThan(String value) {
            addCriterion("domain >", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainGreaterThanOrEqualTo(String value) {
            addCriterion("domain >=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThan(String value) {
            addCriterion("domain <", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLessThanOrEqualTo(String value) {
            addCriterion("domain <=", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainLike(String value) {
            addCriterion("domain like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotLike(String value) {
            addCriterion("domain not like", value, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainIn(List<String> values) {
            addCriterion("domain in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotIn(List<String> values) {
            addCriterion("domain not in", values, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainBetween(String value1, String value2) {
            addCriterion("domain between", value1, value2, "domain");
            return (Criteria) this;
        }

        public Criteria andDomainNotBetween(String value1, String value2) {
            addCriterion("domain not between", value1, value2, "domain");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}