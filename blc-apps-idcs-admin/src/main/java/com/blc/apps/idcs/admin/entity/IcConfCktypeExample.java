package com.blc.apps.idcs.admin.entity;

import java.util.ArrayList;
import java.util.List;

public class IcConfCktypeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IcConfCktypeExample() {
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

        public Criteria andCkIdIsNull() {
            addCriterion("CK_ID is null");
            return (Criteria) this;
        }

        public Criteria andCkIdIsNotNull() {
            addCriterion("CK_ID is not null");
            return (Criteria) this;
        }

        public Criteria andCkIdEqualTo(String value) {
            addCriterion("CK_ID =", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdNotEqualTo(String value) {
            addCriterion("CK_ID <>", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdGreaterThan(String value) {
            addCriterion("CK_ID >", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdGreaterThanOrEqualTo(String value) {
            addCriterion("CK_ID >=", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdLessThan(String value) {
            addCriterion("CK_ID <", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdLessThanOrEqualTo(String value) {
            addCriterion("CK_ID <=", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdLike(String value) {
            addCriterion("CK_ID like", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdNotLike(String value) {
            addCriterion("CK_ID not like", value, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdIn(List<String> values) {
            addCriterion("CK_ID in", values, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdNotIn(List<String> values) {
            addCriterion("CK_ID not in", values, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdBetween(String value1, String value2) {
            addCriterion("CK_ID between", value1, value2, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkIdNotBetween(String value1, String value2) {
            addCriterion("CK_ID not between", value1, value2, "ckId");
            return (Criteria) this;
        }

        public Criteria andCkNameIsNull() {
            addCriterion("CK_NAME is null");
            return (Criteria) this;
        }

        public Criteria andCkNameIsNotNull() {
            addCriterion("CK_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andCkNameEqualTo(String value) {
            addCriterion("CK_NAME =", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotEqualTo(String value) {
            addCriterion("CK_NAME <>", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameGreaterThan(String value) {
            addCriterion("CK_NAME >", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameGreaterThanOrEqualTo(String value) {
            addCriterion("CK_NAME >=", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameLessThan(String value) {
            addCriterion("CK_NAME <", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameLessThanOrEqualTo(String value) {
            addCriterion("CK_NAME <=", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameLike(String value) {
            addCriterion("CK_NAME like", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotLike(String value) {
            addCriterion("CK_NAME not like", value, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameIn(List<String> values) {
            addCriterion("CK_NAME in", values, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotIn(List<String> values) {
            addCriterion("CK_NAME not in", values, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameBetween(String value1, String value2) {
            addCriterion("CK_NAME between", value1, value2, "ckName");
            return (Criteria) this;
        }

        public Criteria andCkNameNotBetween(String value1, String value2) {
            addCriterion("CK_NAME not between", value1, value2, "ckName");
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