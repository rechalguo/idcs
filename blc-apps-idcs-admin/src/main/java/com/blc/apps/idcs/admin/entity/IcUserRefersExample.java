package com.blc.apps.idcs.admin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IcUserRefersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IcUserRefersExample() {
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

        public Criteria andRUserIdIsNull() {
            addCriterion("R_USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andRUserIdIsNotNull() {
            addCriterion("R_USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRUserIdEqualTo(String value) {
            addCriterion("R_USER_ID =", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdNotEqualTo(String value) {
            addCriterion("R_USER_ID <>", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdGreaterThan(String value) {
            addCriterion("R_USER_ID >", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("R_USER_ID >=", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdLessThan(String value) {
            addCriterion("R_USER_ID <", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdLessThanOrEqualTo(String value) {
            addCriterion("R_USER_ID <=", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdLike(String value) {
            addCriterion("R_USER_ID like", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdNotLike(String value) {
            addCriterion("R_USER_ID not like", value, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdIn(List<String> values) {
            addCriterion("R_USER_ID in", values, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdNotIn(List<String> values) {
            addCriterion("R_USER_ID not in", values, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdBetween(String value1, String value2) {
            addCriterion("R_USER_ID between", value1, value2, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRUserIdNotBetween(String value1, String value2) {
            addCriterion("R_USER_ID not between", value1, value2, "rUserId");
            return (Criteria) this;
        }

        public Criteria andRSeqNoIsNull() {
            addCriterion("R_SEQ_NO is null");
            return (Criteria) this;
        }

        public Criteria andRSeqNoIsNotNull() {
            addCriterion("R_SEQ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andRSeqNoEqualTo(BigDecimal value) {
            addCriterion("R_SEQ_NO =", value, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoNotEqualTo(BigDecimal value) {
            addCriterion("R_SEQ_NO <>", value, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoGreaterThan(BigDecimal value) {
            addCriterion("R_SEQ_NO >", value, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("R_SEQ_NO >=", value, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoLessThan(BigDecimal value) {
            addCriterion("R_SEQ_NO <", value, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("R_SEQ_NO <=", value, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoIn(List<BigDecimal> values) {
            addCriterion("R_SEQ_NO in", values, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoNotIn(List<BigDecimal> values) {
            addCriterion("R_SEQ_NO not in", values, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("R_SEQ_NO between", value1, value2, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRSeqNoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("R_SEQ_NO not between", value1, value2, "rSeqNo");
            return (Criteria) this;
        }

        public Criteria andRWeightIsNull() {
            addCriterion("R_WEIGHT is null");
            return (Criteria) this;
        }

        public Criteria andRWeightIsNotNull() {
            addCriterion("R_WEIGHT is not null");
            return (Criteria) this;
        }

        public Criteria andRWeightEqualTo(BigDecimal value) {
            addCriterion("R_WEIGHT =", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightNotEqualTo(BigDecimal value) {
            addCriterion("R_WEIGHT <>", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightGreaterThan(BigDecimal value) {
            addCriterion("R_WEIGHT >", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("R_WEIGHT >=", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightLessThan(BigDecimal value) {
            addCriterion("R_WEIGHT <", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("R_WEIGHT <=", value, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightIn(List<BigDecimal> values) {
            addCriterion("R_WEIGHT in", values, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightNotIn(List<BigDecimal> values) {
            addCriterion("R_WEIGHT not in", values, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("R_WEIGHT between", value1, value2, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("R_WEIGHT not between", value1, value2, "rWeight");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredIsNull() {
            addCriterion("R_IS_EXPIRED is null");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredIsNotNull() {
            addCriterion("R_IS_EXPIRED is not null");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredEqualTo(Date value) {
            addCriterion("R_IS_EXPIRED =", value, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredNotEqualTo(Date value) {
            addCriterion("R_IS_EXPIRED <>", value, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredGreaterThan(Date value) {
            addCriterion("R_IS_EXPIRED >", value, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredGreaterThanOrEqualTo(Date value) {
            addCriterion("R_IS_EXPIRED >=", value, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredLessThan(Date value) {
            addCriterion("R_IS_EXPIRED <", value, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredLessThanOrEqualTo(Date value) {
            addCriterion("R_IS_EXPIRED <=", value, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredIn(List<Date> values) {
            addCriterion("R_IS_EXPIRED in", values, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredNotIn(List<Date> values) {
            addCriterion("R_IS_EXPIRED not in", values, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredBetween(Date value1, Date value2) {
            addCriterion("R_IS_EXPIRED between", value1, value2, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsExpiredNotBetween(Date value1, Date value2) {
            addCriterion("R_IS_EXPIRED not between", value1, value2, "rIsExpired");
            return (Criteria) this;
        }

        public Criteria andRIsOffIsNull() {
            addCriterion("R_IS_OFF is null");
            return (Criteria) this;
        }

        public Criteria andRIsOffIsNotNull() {
            addCriterion("R_IS_OFF is not null");
            return (Criteria) this;
        }

        public Criteria andRIsOffEqualTo(String value) {
            addCriterion("R_IS_OFF =", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffNotEqualTo(String value) {
            addCriterion("R_IS_OFF <>", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffGreaterThan(String value) {
            addCriterion("R_IS_OFF >", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffGreaterThanOrEqualTo(String value) {
            addCriterion("R_IS_OFF >=", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffLessThan(String value) {
            addCriterion("R_IS_OFF <", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffLessThanOrEqualTo(String value) {
            addCriterion("R_IS_OFF <=", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffLike(String value) {
            addCriterion("R_IS_OFF like", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffNotLike(String value) {
            addCriterion("R_IS_OFF not like", value, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffIn(List<String> values) {
            addCriterion("R_IS_OFF in", values, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffNotIn(List<String> values) {
            addCriterion("R_IS_OFF not in", values, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffBetween(String value1, String value2) {
            addCriterion("R_IS_OFF between", value1, value2, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRIsOffNotBetween(String value1, String value2) {
            addCriterion("R_IS_OFF not between", value1, value2, "rIsOff");
            return (Criteria) this;
        }

        public Criteria andRDescriptionIsNull() {
            addCriterion("R_DESCRIPTION is null");
            return (Criteria) this;
        }

        public Criteria andRDescriptionIsNotNull() {
            addCriterion("R_DESCRIPTION is not null");
            return (Criteria) this;
        }

        public Criteria andRDescriptionEqualTo(String value) {
            addCriterion("R_DESCRIPTION =", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotEqualTo(String value) {
            addCriterion("R_DESCRIPTION <>", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionGreaterThan(String value) {
            addCriterion("R_DESCRIPTION >", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("R_DESCRIPTION >=", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionLessThan(String value) {
            addCriterion("R_DESCRIPTION <", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionLessThanOrEqualTo(String value) {
            addCriterion("R_DESCRIPTION <=", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionLike(String value) {
            addCriterion("R_DESCRIPTION like", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotLike(String value) {
            addCriterion("R_DESCRIPTION not like", value, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionIn(List<String> values) {
            addCriterion("R_DESCRIPTION in", values, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotIn(List<String> values) {
            addCriterion("R_DESCRIPTION not in", values, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionBetween(String value1, String value2) {
            addCriterion("R_DESCRIPTION between", value1, value2, "rDescription");
            return (Criteria) this;
        }

        public Criteria andRDescriptionNotBetween(String value1, String value2) {
            addCriterion("R_DESCRIPTION not between", value1, value2, "rDescription");
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