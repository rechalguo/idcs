package com.blc.apps.idcs.admin.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class IcUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public IcUserExample() {
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

        public Criteria andUTypeIsNull() {
            addCriterion("U_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUTypeIsNotNull() {
            addCriterion("U_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUTypeEqualTo(String value) {
            addCriterion("U_TYPE =", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotEqualTo(String value) {
            addCriterion("U_TYPE <>", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeGreaterThan(String value) {
            addCriterion("U_TYPE >", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeGreaterThanOrEqualTo(String value) {
            addCriterion("U_TYPE >=", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeLessThan(String value) {
            addCriterion("U_TYPE <", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeLessThanOrEqualTo(String value) {
            addCriterion("U_TYPE <=", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeLike(String value) {
            addCriterion("U_TYPE like", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotLike(String value) {
            addCriterion("U_TYPE not like", value, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeIn(List<String> values) {
            addCriterion("U_TYPE in", values, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotIn(List<String> values) {
            addCriterion("U_TYPE not in", values, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeBetween(String value1, String value2) {
            addCriterion("U_TYPE between", value1, value2, "uType");
            return (Criteria) this;
        }

        public Criteria andUTypeNotBetween(String value1, String value2) {
            addCriterion("U_TYPE not between", value1, value2, "uType");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNull() {
            addCriterion("U_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andUPasswordIsNotNull() {
            addCriterion("U_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andUPasswordEqualTo(String value) {
            addCriterion("U_PASSWORD =", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotEqualTo(String value) {
            addCriterion("U_PASSWORD <>", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThan(String value) {
            addCriterion("U_PASSWORD >", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("U_PASSWORD >=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThan(String value) {
            addCriterion("U_PASSWORD <", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLessThanOrEqualTo(String value) {
            addCriterion("U_PASSWORD <=", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordLike(String value) {
            addCriterion("U_PASSWORD like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotLike(String value) {
            addCriterion("U_PASSWORD not like", value, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordIn(List<String> values) {
            addCriterion("U_PASSWORD in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotIn(List<String> values) {
            addCriterion("U_PASSWORD not in", values, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordBetween(String value1, String value2) {
            addCriterion("U_PASSWORD between", value1, value2, "uPassword");
            return (Criteria) this;
        }

        public Criteria andUPasswordNotBetween(String value1, String value2) {
            addCriterion("U_PASSWORD not between", value1, value2, "uPassword");
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

        public Criteria andCreateDateIsNull() {
            addCriterion("CREATE_DATE is null");
            return (Criteria) this;
        }

        public Criteria andCreateDateIsNotNull() {
            addCriterion("CREATE_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDateEqualTo(Date value) {
            addCriterion("CREATE_DATE =", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotEqualTo(Date value) {
            addCriterion("CREATE_DATE <>", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThan(Date value) {
            addCriterion("CREATE_DATE >", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE >=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThan(Date value) {
            addCriterion("CREATE_DATE <", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateLessThanOrEqualTo(Date value) {
            addCriterion("CREATE_DATE <=", value, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateIn(List<Date> values) {
            addCriterion("CREATE_DATE in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotIn(List<Date> values) {
            addCriterion("CREATE_DATE not in", values, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andCreateDateNotBetween(Date value1, Date value2) {
            addCriterion("CREATE_DATE not between", value1, value2, "createDate");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNull() {
            addCriterion("PAY_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andPayTypeIsNotNull() {
            addCriterion("PAY_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andPayTypeEqualTo(String value) {
            addCriterion("PAY_TYPE =", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotEqualTo(String value) {
            addCriterion("PAY_TYPE <>", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThan(String value) {
            addCriterion("PAY_TYPE >", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeGreaterThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE >=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThan(String value) {
            addCriterion("PAY_TYPE <", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLessThanOrEqualTo(String value) {
            addCriterion("PAY_TYPE <=", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeLike(String value) {
            addCriterion("PAY_TYPE like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotLike(String value) {
            addCriterion("PAY_TYPE not like", value, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeIn(List<String> values) {
            addCriterion("PAY_TYPE in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotIn(List<String> values) {
            addCriterion("PAY_TYPE not in", values, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeBetween(String value1, String value2) {
            addCriterion("PAY_TYPE between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andPayTypeNotBetween(String value1, String value2) {
            addCriterion("PAY_TYPE not between", value1, value2, "payType");
            return (Criteria) this;
        }

        public Criteria andReqTypeIsNull() {
            addCriterion("REQ_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andReqTypeIsNotNull() {
            addCriterion("REQ_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andReqTypeEqualTo(String value) {
            addCriterion("REQ_TYPE =", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeNotEqualTo(String value) {
            addCriterion("REQ_TYPE <>", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeGreaterThan(String value) {
            addCriterion("REQ_TYPE >", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeGreaterThanOrEqualTo(String value) {
            addCriterion("REQ_TYPE >=", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeLessThan(String value) {
            addCriterion("REQ_TYPE <", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeLessThanOrEqualTo(String value) {
            addCriterion("REQ_TYPE <=", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeLike(String value) {
            addCriterion("REQ_TYPE like", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeNotLike(String value) {
            addCriterion("REQ_TYPE not like", value, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeIn(List<String> values) {
            addCriterion("REQ_TYPE in", values, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeNotIn(List<String> values) {
            addCriterion("REQ_TYPE not in", values, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeBetween(String value1, String value2) {
            addCriterion("REQ_TYPE between", value1, value2, "reqType");
            return (Criteria) this;
        }

        public Criteria andReqTypeNotBetween(String value1, String value2) {
            addCriterion("REQ_TYPE not between", value1, value2, "reqType");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNull() {
            addCriterion("ORG_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("ORG_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(String value) {
            addCriterion("ORG_ID =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(String value) {
            addCriterion("ORG_ID <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(String value) {
            addCriterion("ORG_ID >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(String value) {
            addCriterion("ORG_ID >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(String value) {
            addCriterion("ORG_ID <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(String value) {
            addCriterion("ORG_ID <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLike(String value) {
            addCriterion("ORG_ID like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotLike(String value) {
            addCriterion("ORG_ID not like", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<String> values) {
            addCriterion("ORG_ID in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<String> values) {
            addCriterion("ORG_ID not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(String value1, String value2) {
            addCriterion("ORG_ID between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(String value1, String value2) {
            addCriterion("ORG_ID not between", value1, value2, "orgId");
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