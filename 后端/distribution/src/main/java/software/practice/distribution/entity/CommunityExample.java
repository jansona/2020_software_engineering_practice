package software.practice.distribution.entity;

import java.util.ArrayList;
import java.util.List;

public class CommunityExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public CommunityExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
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
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
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

        public Criteria andCommunityIdIsNull() {
            addCriterion("community_id is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIsNotNull() {
            addCriterion("community_id is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIdEqualTo(Integer value) {
            addCriterion("community_id =", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotEqualTo(Integer value) {
            addCriterion("community_id <>", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThan(Integer value) {
            addCriterion("community_id >", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_id >=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThan(Integer value) {
            addCriterion("community_id <", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdLessThanOrEqualTo(Integer value) {
            addCriterion("community_id <=", value, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdIn(List<Integer> values) {
            addCriterion("community_id in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotIn(List<Integer> values) {
            addCriterion("community_id not in", values, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdBetween(Integer value1, Integer value2) {
            addCriterion("community_id between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityIdNotBetween(Integer value1, Integer value2) {
            addCriterion("community_id not between", value1, value2, "communityId");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNull() {
            addCriterion("community_name is null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIsNotNull() {
            addCriterion("community_name is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityNameEqualTo(String value) {
            addCriterion("community_name =", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotEqualTo(String value) {
            addCriterion("community_name <>", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThan(String value) {
            addCriterion("community_name >", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameGreaterThanOrEqualTo(String value) {
            addCriterion("community_name >=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThan(String value) {
            addCriterion("community_name <", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLessThanOrEqualTo(String value) {
            addCriterion("community_name <=", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameLike(String value) {
            addCriterion("community_name like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotLike(String value) {
            addCriterion("community_name not like", value, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameIn(List<String> values) {
            addCriterion("community_name in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotIn(List<String> values) {
            addCriterion("community_name not in", values, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameBetween(String value1, String value2) {
            addCriterion("community_name between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityNameNotBetween(String value1, String value2) {
            addCriterion("community_name not between", value1, value2, "communityName");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordIsNull() {
            addCriterion("community_password is null");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordIsNotNull() {
            addCriterion("community_password is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordEqualTo(String value) {
            addCriterion("community_password =", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordNotEqualTo(String value) {
            addCriterion("community_password <>", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordGreaterThan(String value) {
            addCriterion("community_password >", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("community_password >=", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordLessThan(String value) {
            addCriterion("community_password <", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordLessThanOrEqualTo(String value) {
            addCriterion("community_password <=", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordLike(String value) {
            addCriterion("community_password like", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordNotLike(String value) {
            addCriterion("community_password not like", value, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordIn(List<String> values) {
            addCriterion("community_password in", values, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordNotIn(List<String> values) {
            addCriterion("community_password not in", values, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordBetween(String value1, String value2) {
            addCriterion("community_password between", value1, value2, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityPasswordNotBetween(String value1, String value2) {
            addCriterion("community_password not between", value1, value2, "communityPassword");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressIsNull() {
            addCriterion("community_address is null");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressIsNotNull() {
            addCriterion("community_address is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressEqualTo(String value) {
            addCriterion("community_address =", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressNotEqualTo(String value) {
            addCriterion("community_address <>", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressGreaterThan(String value) {
            addCriterion("community_address >", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressGreaterThanOrEqualTo(String value) {
            addCriterion("community_address >=", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressLessThan(String value) {
            addCriterion("community_address <", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressLessThanOrEqualTo(String value) {
            addCriterion("community_address <=", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressLike(String value) {
            addCriterion("community_address like", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressNotLike(String value) {
            addCriterion("community_address not like", value, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressIn(List<String> values) {
            addCriterion("community_address in", values, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressNotIn(List<String> values) {
            addCriterion("community_address not in", values, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressBetween(String value1, String value2) {
            addCriterion("community_address between", value1, value2, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityAddressNotBetween(String value1, String value2) {
            addCriterion("community_address not between", value1, value2, "communityAddress");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalIsNull() {
            addCriterion("community_interval is null");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalIsNotNull() {
            addCriterion("community_interval is not null");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalEqualTo(Integer value) {
            addCriterion("community_interval =", value, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalNotEqualTo(Integer value) {
            addCriterion("community_interval <>", value, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalGreaterThan(Integer value) {
            addCriterion("community_interval >", value, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalGreaterThanOrEqualTo(Integer value) {
            addCriterion("community_interval >=", value, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalLessThan(Integer value) {
            addCriterion("community_interval <", value, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalLessThanOrEqualTo(Integer value) {
            addCriterion("community_interval <=", value, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalIn(List<Integer> values) {
            addCriterion("community_interval in", values, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalNotIn(List<Integer> values) {
            addCriterion("community_interval not in", values, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalBetween(Integer value1, Integer value2) {
            addCriterion("community_interval between", value1, value2, "communityInterval");
            return (Criteria) this;
        }

        public Criteria andCommunityIntervalNotBetween(Integer value1, Integer value2) {
            addCriterion("community_interval not between", value1, value2, "communityInterval");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table community
     *
     * @mbg.generated do_not_delete_during_merge Fri Apr 24 17:32:50 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table community
     *
     * @mbg.generated Fri Apr 24 17:32:50 CST 2020
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