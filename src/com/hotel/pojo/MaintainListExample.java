package com.hotel.pojo;

import java.util.ArrayList;
import java.util.List;

public class MaintainListExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MaintainListExample() {
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

        public Criteria andMaintainIdIsNull() {
            addCriterion("maintain_id is null");
            return (Criteria) this;
        }

        public Criteria andMaintainIdIsNotNull() {
            addCriterion("maintain_id is not null");
            return (Criteria) this;
        }

        public Criteria andMaintainIdEqualTo(Integer value) {
            addCriterion("maintain_id =", value, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdNotEqualTo(Integer value) {
            addCriterion("maintain_id <>", value, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdGreaterThan(Integer value) {
            addCriterion("maintain_id >", value, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("maintain_id >=", value, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdLessThan(Integer value) {
            addCriterion("maintain_id <", value, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdLessThanOrEqualTo(Integer value) {
            addCriterion("maintain_id <=", value, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdIn(List<Integer> values) {
            addCriterion("maintain_id in", values, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdNotIn(List<Integer> values) {
            addCriterion("maintain_id not in", values, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdBetween(Integer value1, Integer value2) {
            addCriterion("maintain_id between", value1, value2, "maintainId");
            return (Criteria) this;
        }

        public Criteria andMaintainIdNotBetween(Integer value1, Integer value2) {
            addCriterion("maintain_id not between", value1, value2, "maintainId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNull() {
            addCriterion("room_id is null");
            return (Criteria) this;
        }

        public Criteria andRoomIdIsNotNull() {
            addCriterion("room_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoomIdEqualTo(Integer value) {
            addCriterion("room_id =", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotEqualTo(Integer value) {
            addCriterion("room_id <>", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThan(Integer value) {
            addCriterion("room_id >", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("room_id >=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThan(Integer value) {
            addCriterion("room_id <", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdLessThanOrEqualTo(Integer value) {
            addCriterion("room_id <=", value, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdIn(List<Integer> values) {
            addCriterion("room_id in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotIn(List<Integer> values) {
            addCriterion("room_id not in", values, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdBetween(Integer value1, Integer value2) {
            addCriterion("room_id between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andRoomIdNotBetween(Integer value1, Integer value2) {
            addCriterion("room_id not between", value1, value2, "roomId");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListIsNull() {
            addCriterion("employee_id_list is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListIsNotNull() {
            addCriterion("employee_id_list is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListEqualTo(String value) {
            addCriterion("employee_id_list =", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListNotEqualTo(String value) {
            addCriterion("employee_id_list <>", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListGreaterThan(String value) {
            addCriterion("employee_id_list >", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListGreaterThanOrEqualTo(String value) {
            addCriterion("employee_id_list >=", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListLessThan(String value) {
            addCriterion("employee_id_list <", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListLessThanOrEqualTo(String value) {
            addCriterion("employee_id_list <=", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListLike(String value) {
            addCriterion("employee_id_list like", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListNotLike(String value) {
            addCriterion("employee_id_list not like", value, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListIn(List<String> values) {
            addCriterion("employee_id_list in", values, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListNotIn(List<String> values) {
            addCriterion("employee_id_list not in", values, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListBetween(String value1, String value2) {
            addCriterion("employee_id_list between", value1, value2, "employeeIdList");
            return (Criteria) this;
        }

        public Criteria andEmployeeIdListNotBetween(String value1, String value2) {
            addCriterion("employee_id_list not between", value1, value2, "employeeIdList");
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