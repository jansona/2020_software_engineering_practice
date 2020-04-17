package software.practice.distribution.entity;

import java.util.ArrayList;
import java.util.List;

public class ApplicationExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public ApplicationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
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
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
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

        public Criteria andApplicationIdIsNull() {
            addCriterion("application_id is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIsNotNull() {
            addCriterion("application_id is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIdEqualTo(Integer value) {
            addCriterion("application_id =", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotEqualTo(Integer value) {
            addCriterion("application_id <>", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThan(Integer value) {
            addCriterion("application_id >", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_id >=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThan(Integer value) {
            addCriterion("application_id <", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdLessThanOrEqualTo(Integer value) {
            addCriterion("application_id <=", value, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdIn(List<Integer> values) {
            addCriterion("application_id in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotIn(List<Integer> values) {
            addCriterion("application_id not in", values, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdBetween(Integer value1, Integer value2) {
            addCriterion("application_id between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("application_id not between", value1, value2, "applicationId");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityIsNull() {
            addCriterion("application_community is null");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityIsNotNull() {
            addCriterion("application_community is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityEqualTo(Integer value) {
            addCriterion("application_community =", value, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityNotEqualTo(Integer value) {
            addCriterion("application_community <>", value, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityGreaterThan(Integer value) {
            addCriterion("application_community >", value, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_community >=", value, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityLessThan(Integer value) {
            addCriterion("application_community <", value, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityLessThanOrEqualTo(Integer value) {
            addCriterion("application_community <=", value, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityIn(List<Integer> values) {
            addCriterion("application_community in", values, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityNotIn(List<Integer> values) {
            addCriterion("application_community not in", values, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityBetween(Integer value1, Integer value2) {
            addCriterion("application_community between", value1, value2, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationCommunityNotBetween(Integer value1, Integer value2) {
            addCriterion("application_community not between", value1, value2, "applicationCommunity");
            return (Criteria) this;
        }

        public Criteria andApplicationUserIsNull() {
            addCriterion("application_user is null");
            return (Criteria) this;
        }

        public Criteria andApplicationUserIsNotNull() {
            addCriterion("application_user is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationUserEqualTo(Integer value) {
            addCriterion("application_user =", value, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserNotEqualTo(Integer value) {
            addCriterion("application_user <>", value, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserGreaterThan(Integer value) {
            addCriterion("application_user >", value, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserGreaterThanOrEqualTo(Integer value) {
            addCriterion("application_user >=", value, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserLessThan(Integer value) {
            addCriterion("application_user <", value, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserLessThanOrEqualTo(Integer value) {
            addCriterion("application_user <=", value, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserIn(List<Integer> values) {
            addCriterion("application_user in", values, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserNotIn(List<Integer> values) {
            addCriterion("application_user not in", values, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserBetween(Integer value1, Integer value2) {
            addCriterion("application_user between", value1, value2, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationUserNotBetween(Integer value1, Integer value2) {
            addCriterion("application_user not between", value1, value2, "applicationUser");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassIsNull() {
            addCriterion("application_isPass is null");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassIsNotNull() {
            addCriterion("application_isPass is not null");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassEqualTo(Byte value) {
            addCriterion("application_isPass =", value, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassNotEqualTo(Byte value) {
            addCriterion("application_isPass <>", value, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassGreaterThan(Byte value) {
            addCriterion("application_isPass >", value, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassGreaterThanOrEqualTo(Byte value) {
            addCriterion("application_isPass >=", value, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassLessThan(Byte value) {
            addCriterion("application_isPass <", value, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassLessThanOrEqualTo(Byte value) {
            addCriterion("application_isPass <=", value, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassIn(List<Byte> values) {
            addCriterion("application_isPass in", values, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassNotIn(List<Byte> values) {
            addCriterion("application_isPass not in", values, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassBetween(Byte value1, Byte value2) {
            addCriterion("application_isPass between", value1, value2, "applicationIspass");
            return (Criteria) this;
        }

        public Criteria andApplicationIspassNotBetween(Byte value1, Byte value2) {
            addCriterion("application_isPass not between", value1, value2, "applicationIspass");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table application
     *
     * @mbg.generated do_not_delete_during_merge Fri Apr 17 13:00:37 CST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table application
     *
     * @mbg.generated Fri Apr 17 13:00:37 CST 2020
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