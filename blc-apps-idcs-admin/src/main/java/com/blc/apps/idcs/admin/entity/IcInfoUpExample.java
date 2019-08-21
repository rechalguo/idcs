package com.blc.apps.idcs.admin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class IcInfoUpExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IcInfoUpExample() {
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

        public Criteria andReportDateIsNull() {
            addCriterion("REPORT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andReportDateIsNotNull() {
            addCriterion("REPORT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andReportDateEqualTo(String value) {
            addCriterion("REPORT_DATE =", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotEqualTo(String value) {
            addCriterion("REPORT_DATE <>", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThan(String value) {
            addCriterion("REPORT_DATE >", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateGreaterThanOrEqualTo(String value) {
            addCriterion("REPORT_DATE >=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThan(String value) {
            addCriterion("REPORT_DATE <", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLessThanOrEqualTo(String value) {
            addCriterion("REPORT_DATE <=", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateLike(String value) {
            addCriterion("REPORT_DATE like", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotLike(String value) {
            addCriterion("REPORT_DATE not like", value, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateIn(List<String> values) {
            addCriterion("REPORT_DATE in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotIn(List<String> values) {
            addCriterion("REPORT_DATE not in", values, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateBetween(String value1, String value2) {
            addCriterion("REPORT_DATE between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andReportDateNotBetween(String value1, String value2) {
            addCriterion("REPORT_DATE not between", value1, value2, "reportDate");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("USER_ID like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("USER_ID not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andDataSrcIsNull() {
            addCriterion("DATA_SRC is null");
            return (Criteria) this;
        }

        public Criteria andDataSrcIsNotNull() {
            addCriterion("DATA_SRC is not null");
            return (Criteria) this;
        }

        public Criteria andDataSrcEqualTo(String value) {
            addCriterion("DATA_SRC =", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotEqualTo(String value) {
            addCriterion("DATA_SRC <>", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcGreaterThan(String value) {
            addCriterion("DATA_SRC >", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcGreaterThanOrEqualTo(String value) {
            addCriterion("DATA_SRC >=", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcLessThan(String value) {
            addCriterion("DATA_SRC <", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcLessThanOrEqualTo(String value) {
            addCriterion("DATA_SRC <=", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcLike(String value) {
            addCriterion("DATA_SRC like", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotLike(String value) {
            addCriterion("DATA_SRC not like", value, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcIn(List<String> values) {
            addCriterion("DATA_SRC in", values, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotIn(List<String> values) {
            addCriterion("DATA_SRC not in", values, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcBetween(String value1, String value2) {
            addCriterion("DATA_SRC between", value1, value2, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andDataSrcNotBetween(String value1, String value2) {
            addCriterion("DATA_SRC not between", value1, value2, "dataSrc");
            return (Criteria) this;
        }

        public Criteria andRNameIsNull() {
            addCriterion("R_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRNameIsNotNull() {
            addCriterion("R_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRNameEqualTo(String value) {
            addCriterion("R_NAME =", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotEqualTo(String value) {
            addCriterion("R_NAME <>", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThan(String value) {
            addCriterion("R_NAME >", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameGreaterThanOrEqualTo(String value) {
            addCriterion("R_NAME >=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThan(String value) {
            addCriterion("R_NAME <", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLessThanOrEqualTo(String value) {
            addCriterion("R_NAME <=", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameLike(String value) {
            addCriterion("R_NAME like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotLike(String value) {
            addCriterion("R_NAME not like", value, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameIn(List<String> values) {
            addCriterion("R_NAME in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotIn(List<String> values) {
            addCriterion("R_NAME not in", values, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameBetween(String value1, String value2) {
            addCriterion("R_NAME between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andRNameNotBetween(String value1, String value2) {
            addCriterion("R_NAME not between", value1, value2, "rName");
            return (Criteria) this;
        }

        public Criteria andCntIsNull() {
            addCriterion("CNT is null");
            return (Criteria) this;
        }

        public Criteria andCntIsNotNull() {
            addCriterion("CNT is not null");
            return (Criteria) this;
        }

        public Criteria andCntEqualTo(BigDecimal value) {
            addCriterion("CNT =", value, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntNotEqualTo(BigDecimal value) {
            addCriterion("CNT <>", value, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntGreaterThan(BigDecimal value) {
            addCriterion("CNT >", value, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("CNT >=", value, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntLessThan(BigDecimal value) {
            addCriterion("CNT <", value, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntLessThanOrEqualTo(BigDecimal value) {
            addCriterion("CNT <=", value, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntIn(List<BigDecimal> values) {
            addCriterion("CNT in", values, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntNotIn(List<BigDecimal> values) {
            addCriterion("CNT not in", values, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CNT between", value1, value2, "cnt");
            return (Criteria) this;
        }

        public Criteria andCntNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("CNT not between", value1, value2, "cnt");
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