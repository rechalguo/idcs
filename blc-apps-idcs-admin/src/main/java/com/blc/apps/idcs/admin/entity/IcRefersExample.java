package com.blc.apps.idcs.admin.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IcRefersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IcRefersExample() {
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

        public Criteria andSeqNoIsNull() {
            addCriterion("SEQ_NO is null");
            return (Criteria) this;
        }

        public Criteria andSeqNoIsNotNull() {
            addCriterion("SEQ_NO is not null");
            return (Criteria) this;
        }

        public Criteria andSeqNoEqualTo(BigDecimal value) {
            addCriterion("SEQ_NO =", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotEqualTo(BigDecimal value) {
            addCriterion("SEQ_NO <>", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThan(BigDecimal value) {
            addCriterion("SEQ_NO >", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQ_NO >=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThan(BigDecimal value) {
            addCriterion("SEQ_NO <", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoLessThanOrEqualTo(BigDecimal value) {
            addCriterion("SEQ_NO <=", value, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoIn(List<BigDecimal> values) {
            addCriterion("SEQ_NO in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotIn(List<BigDecimal> values) {
            addCriterion("SEQ_NO not in", values, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQ_NO between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andSeqNoNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("SEQ_NO not between", value1, value2, "seqNo");
            return (Criteria) this;
        }

        public Criteria andRUrlIsNull() {
            addCriterion("R_URL is null");
            return (Criteria) this;
        }

        public Criteria andRUrlIsNotNull() {
            addCriterion("R_URL is not null");
            return (Criteria) this;
        }

        public Criteria andRUrlEqualTo(String value) {
            addCriterion("R_URL =", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlNotEqualTo(String value) {
            addCriterion("R_URL <>", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlGreaterThan(String value) {
            addCriterion("R_URL >", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlGreaterThanOrEqualTo(String value) {
            addCriterion("R_URL >=", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlLessThan(String value) {
            addCriterion("R_URL <", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlLessThanOrEqualTo(String value) {
            addCriterion("R_URL <=", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlLike(String value) {
            addCriterion("R_URL like", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlNotLike(String value) {
            addCriterion("R_URL not like", value, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlIn(List<String> values) {
            addCriterion("R_URL in", values, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlNotIn(List<String> values) {
            addCriterion("R_URL not in", values, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlBetween(String value1, String value2) {
            addCriterion("R_URL between", value1, value2, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUrlNotBetween(String value1, String value2) {
            addCriterion("R_URL not between", value1, value2, "rUrl");
            return (Criteria) this;
        }

        public Criteria andRUserKeyIsNull() {
            addCriterion("R_USER_KEY is null");
            return (Criteria) this;
        }

        public Criteria andRUserKeyIsNotNull() {
            addCriterion("R_USER_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andRUserKeyEqualTo(String value) {
            addCriterion("R_USER_KEY =", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyNotEqualTo(String value) {
            addCriterion("R_USER_KEY <>", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyGreaterThan(String value) {
            addCriterion("R_USER_KEY >", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyGreaterThanOrEqualTo(String value) {
            addCriterion("R_USER_KEY >=", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyLessThan(String value) {
            addCriterion("R_USER_KEY <", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyLessThanOrEqualTo(String value) {
            addCriterion("R_USER_KEY <=", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyLike(String value) {
            addCriterion("R_USER_KEY like", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyNotLike(String value) {
            addCriterion("R_USER_KEY not like", value, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyIn(List<String> values) {
            addCriterion("R_USER_KEY in", values, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyNotIn(List<String> values) {
            addCriterion("R_USER_KEY not in", values, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyBetween(String value1, String value2) {
            addCriterion("R_USER_KEY between", value1, value2, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRUserKeyNotBetween(String value1, String value2) {
            addCriterion("R_USER_KEY not between", value1, value2, "rUserKey");
            return (Criteria) this;
        }

        public Criteria andRTimeOutIsNull() {
            addCriterion("R_TIME_OUT is null");
            return (Criteria) this;
        }

        public Criteria andRTimeOutIsNotNull() {
            addCriterion("R_TIME_OUT is not null");
            return (Criteria) this;
        }

        public Criteria andRTimeOutEqualTo(BigDecimal value) {
            addCriterion("R_TIME_OUT =", value, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutNotEqualTo(BigDecimal value) {
            addCriterion("R_TIME_OUT <>", value, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutGreaterThan(BigDecimal value) {
            addCriterion("R_TIME_OUT >", value, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("R_TIME_OUT >=", value, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutLessThan(BigDecimal value) {
            addCriterion("R_TIME_OUT <", value, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutLessThanOrEqualTo(BigDecimal value) {
            addCriterion("R_TIME_OUT <=", value, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutIn(List<BigDecimal> values) {
            addCriterion("R_TIME_OUT in", values, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutNotIn(List<BigDecimal> values) {
            addCriterion("R_TIME_OUT not in", values, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("R_TIME_OUT between", value1, value2, "rTimeOut");
            return (Criteria) this;
        }

        public Criteria andRTimeOutNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("R_TIME_OUT not between", value1, value2, "rTimeOut");
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

        public Criteria andIsOffIsNull() {
            addCriterion("IS_OFF is null");
            return (Criteria) this;
        }

        public Criteria andIsOffIsNotNull() {
            addCriterion("IS_OFF is not null");
            return (Criteria) this;
        }

        public Criteria andIsOffEqualTo(String value) {
            addCriterion("IS_OFF =", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffNotEqualTo(String value) {
            addCriterion("IS_OFF <>", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffGreaterThan(String value) {
            addCriterion("IS_OFF >", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffGreaterThanOrEqualTo(String value) {
            addCriterion("IS_OFF >=", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffLessThan(String value) {
            addCriterion("IS_OFF <", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffLessThanOrEqualTo(String value) {
            addCriterion("IS_OFF <=", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffLike(String value) {
            addCriterion("IS_OFF like", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffNotLike(String value) {
            addCriterion("IS_OFF not like", value, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffIn(List<String> values) {
            addCriterion("IS_OFF in", values, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffNotIn(List<String> values) {
            addCriterion("IS_OFF not in", values, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffBetween(String value1, String value2) {
            addCriterion("IS_OFF between", value1, value2, "isOff");
            return (Criteria) this;
        }

        public Criteria andIsOffNotBetween(String value1, String value2) {
            addCriterion("IS_OFF not between", value1, value2, "isOff");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNull() {
            addCriterion("EXPIRED_DATE is null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIsNotNull() {
            addCriterion("EXPIRED_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andExpiredDateEqualTo(Date value) {
            addCriterion("EXPIRED_DATE =", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotEqualTo(Date value) {
            addCriterion("EXPIRED_DATE <>", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThan(Date value) {
            addCriterion("EXPIRED_DATE >", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateGreaterThanOrEqualTo(Date value) {
            addCriterion("EXPIRED_DATE >=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThan(Date value) {
            addCriterion("EXPIRED_DATE <", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateLessThanOrEqualTo(Date value) {
            addCriterion("EXPIRED_DATE <=", value, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateIn(List<Date> values) {
            addCriterion("EXPIRED_DATE in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotIn(List<Date> values) {
            addCriterion("EXPIRED_DATE not in", values, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateBetween(Date value1, Date value2) {
            addCriterion("EXPIRED_DATE between", value1, value2, "expiredDate");
            return (Criteria) this;
        }

        public Criteria andExpiredDateNotBetween(Date value1, Date value2) {
            addCriterion("EXPIRED_DATE not between", value1, value2, "expiredDate");
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

        public Criteria andClassNameIsNull() {
            addCriterion("CLASS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andClassNameIsNotNull() {
            addCriterion("CLASS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andClassNameEqualTo(String value) {
            addCriterion("CLASS_NAME =", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotEqualTo(String value) {
            addCriterion("CLASS_NAME <>", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThan(String value) {
            addCriterion("CLASS_NAME >", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameGreaterThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME >=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThan(String value) {
            addCriterion("CLASS_NAME <", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLessThanOrEqualTo(String value) {
            addCriterion("CLASS_NAME <=", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameLike(String value) {
            addCriterion("CLASS_NAME like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotLike(String value) {
            addCriterion("CLASS_NAME not like", value, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameIn(List<String> values) {
            addCriterion("CLASS_NAME in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotIn(List<String> values) {
            addCriterion("CLASS_NAME not in", values, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameBetween(String value1, String value2) {
            addCriterion("CLASS_NAME between", value1, value2, "className");
            return (Criteria) this;
        }

        public Criteria andClassNameNotBetween(String value1, String value2) {
            addCriterion("CLASS_NAME not between", value1, value2, "className");
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

        public Criteria andRIdIsNull() {
            addCriterion("R_ID is null");
            return (Criteria) this;
        }

        public Criteria andRIdIsNotNull() {
            addCriterion("R_ID is not null");
            return (Criteria) this;
        }

        public Criteria andRIdEqualTo(String value) {
            addCriterion("R_ID =", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotEqualTo(String value) {
            addCriterion("R_ID <>", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThan(String value) {
            addCriterion("R_ID >", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdGreaterThanOrEqualTo(String value) {
            addCriterion("R_ID >=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThan(String value) {
            addCriterion("R_ID <", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLessThanOrEqualTo(String value) {
            addCriterion("R_ID <=", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdLike(String value) {
            addCriterion("R_ID like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotLike(String value) {
            addCriterion("R_ID not like", value, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdIn(List<String> values) {
            addCriterion("R_ID in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotIn(List<String> values) {
            addCriterion("R_ID not in", values, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdBetween(String value1, String value2) {
            addCriterion("R_ID between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRIdNotBetween(String value1, String value2) {
            addCriterion("R_ID not between", value1, value2, "rId");
            return (Criteria) this;
        }

        public Criteria andRServerKeyIsNull() {
            addCriterion("R_SERVER_KEY is null");
            return (Criteria) this;
        }

        public Criteria andRServerKeyIsNotNull() {
            addCriterion("R_SERVER_KEY is not null");
            return (Criteria) this;
        }

        public Criteria andRServerKeyEqualTo(String value) {
            addCriterion("R_SERVER_KEY =", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyNotEqualTo(String value) {
            addCriterion("R_SERVER_KEY <>", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyGreaterThan(String value) {
            addCriterion("R_SERVER_KEY >", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyGreaterThanOrEqualTo(String value) {
            addCriterion("R_SERVER_KEY >=", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyLessThan(String value) {
            addCriterion("R_SERVER_KEY <", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyLessThanOrEqualTo(String value) {
            addCriterion("R_SERVER_KEY <=", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyLike(String value) {
            addCriterion("R_SERVER_KEY like", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyNotLike(String value) {
            addCriterion("R_SERVER_KEY not like", value, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyIn(List<String> values) {
            addCriterion("R_SERVER_KEY in", values, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyNotIn(List<String> values) {
            addCriterion("R_SERVER_KEY not in", values, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyBetween(String value1, String value2) {
            addCriterion("R_SERVER_KEY between", value1, value2, "rServerKey");
            return (Criteria) this;
        }

        public Criteria andRServerKeyNotBetween(String value1, String value2) {
            addCriterion("R_SERVER_KEY not between", value1, value2, "rServerKey");
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