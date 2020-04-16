package software.practice.distribution.entity;

import java.util.ArrayList;
import java.util.List;

public class DealExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public DealExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
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

        public Criteria andDealIdIsNull() {
            addCriterion("deal_id is null");
            return (Criteria) this;
        }

        public Criteria andDealIdIsNotNull() {
            addCriterion("deal_id is not null");
            return (Criteria) this;
        }

        public Criteria andDealIdEqualTo(Integer value) {
            addCriterion("deal_id =", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotEqualTo(Integer value) {
            addCriterion("deal_id <>", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThan(Integer value) {
            addCriterion("deal_id >", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_id >=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThan(Integer value) {
            addCriterion("deal_id <", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdLessThanOrEqualTo(Integer value) {
            addCriterion("deal_id <=", value, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdIn(List<Integer> values) {
            addCriterion("deal_id in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotIn(List<Integer> values) {
            addCriterion("deal_id not in", values, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdBetween(Integer value1, Integer value2) {
            addCriterion("deal_id between", value1, value2, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealIdNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_id not between", value1, value2, "dealId");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNull() {
            addCriterion("deal_user is null");
            return (Criteria) this;
        }

        public Criteria andDealUserIsNotNull() {
            addCriterion("deal_user is not null");
            return (Criteria) this;
        }

        public Criteria andDealUserEqualTo(Integer value) {
            addCriterion("deal_user =", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotEqualTo(Integer value) {
            addCriterion("deal_user <>", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThan(Integer value) {
            addCriterion("deal_user >", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_user >=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThan(Integer value) {
            addCriterion("deal_user <", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserLessThanOrEqualTo(Integer value) {
            addCriterion("deal_user <=", value, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserIn(List<Integer> values) {
            addCriterion("deal_user in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotIn(List<Integer> values) {
            addCriterion("deal_user not in", values, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserBetween(Integer value1, Integer value2) {
            addCriterion("deal_user between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealUserNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_user not between", value1, value2, "dealUser");
            return (Criteria) this;
        }

        public Criteria andDealPackageIsNull() {
            addCriterion("deal_package is null");
            return (Criteria) this;
        }

        public Criteria andDealPackageIsNotNull() {
            addCriterion("deal_package is not null");
            return (Criteria) this;
        }

        public Criteria andDealPackageEqualTo(Integer value) {
            addCriterion("deal_package =", value, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageNotEqualTo(Integer value) {
            addCriterion("deal_package <>", value, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageGreaterThan(Integer value) {
            addCriterion("deal_package >", value, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageGreaterThanOrEqualTo(Integer value) {
            addCriterion("deal_package >=", value, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageLessThan(Integer value) {
            addCriterion("deal_package <", value, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageLessThanOrEqualTo(Integer value) {
            addCriterion("deal_package <=", value, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageIn(List<Integer> values) {
            addCriterion("deal_package in", values, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageNotIn(List<Integer> values) {
            addCriterion("deal_package not in", values, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageBetween(Integer value1, Integer value2) {
            addCriterion("deal_package between", value1, value2, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealPackageNotBetween(Integer value1, Integer value2) {
            addCriterion("deal_package not between", value1, value2, "dealPackage");
            return (Criteria) this;
        }

        public Criteria andDealContentIsNull() {
            addCriterion("deal_content is null");
            return (Criteria) this;
        }

        public Criteria andDealContentIsNotNull() {
            addCriterion("deal_content is not null");
            return (Criteria) this;
        }

        public Criteria andDealContentEqualTo(String value) {
            addCriterion("deal_content =", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentNotEqualTo(String value) {
            addCriterion("deal_content <>", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentGreaterThan(String value) {
            addCriterion("deal_content >", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentGreaterThanOrEqualTo(String value) {
            addCriterion("deal_content >=", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentLessThan(String value) {
            addCriterion("deal_content <", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentLessThanOrEqualTo(String value) {
            addCriterion("deal_content <=", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentLike(String value) {
            addCriterion("deal_content like", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentNotLike(String value) {
            addCriterion("deal_content not like", value, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentIn(List<String> values) {
            addCriterion("deal_content in", values, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentNotIn(List<String> values) {
            addCriterion("deal_content not in", values, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentBetween(String value1, String value2) {
            addCriterion("deal_content between", value1, value2, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealContentNotBetween(String value1, String value2) {
            addCriterion("deal_content not between", value1, value2, "dealContent");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneIsNull() {
            addCriterion("deal_isdone is null");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneIsNotNull() {
            addCriterion("deal_isdone is not null");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneEqualTo(Byte value) {
            addCriterion("deal_isdone =", value, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneNotEqualTo(Byte value) {
            addCriterion("deal_isdone <>", value, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneGreaterThan(Byte value) {
            addCriterion("deal_isdone >", value, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneGreaterThanOrEqualTo(Byte value) {
            addCriterion("deal_isdone >=", value, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneLessThan(Byte value) {
            addCriterion("deal_isdone <", value, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneLessThanOrEqualTo(Byte value) {
            addCriterion("deal_isdone <=", value, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneIn(List<Byte> values) {
            addCriterion("deal_isdone in", values, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneNotIn(List<Byte> values) {
            addCriterion("deal_isdone not in", values, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneBetween(Byte value1, Byte value2) {
            addCriterion("deal_isdone between", value1, value2, "dealIsdone");
            return (Criteria) this;
        }

        public Criteria andDealIsdoneNotBetween(Byte value1, Byte value2) {
            addCriterion("deal_isdone not between", value1, value2, "dealIsdone");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table deal
     *
     * @mbg.generated do_not_delete_during_merge Thu Apr 16 15:44:10 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table deal
     *
     * @mbg.generated Thu Apr 16 15:44:10 CST 2020
     */
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