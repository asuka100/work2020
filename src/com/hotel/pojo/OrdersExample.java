package com.hotel.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrdersExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrdersExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNull() {
            addCriterion("client_id is null");
            return (Criteria) this;
        }

        public Criteria andClientIdIsNotNull() {
            addCriterion("client_id is not null");
            return (Criteria) this;
        }

        public Criteria andClientIdEqualTo(Integer value) {
            addCriterion("client_id =", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotEqualTo(Integer value) {
            addCriterion("client_id <>", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThan(Integer value) {
            addCriterion("client_id >", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("client_id >=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThan(Integer value) {
            addCriterion("client_id <", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdLessThanOrEqualTo(Integer value) {
            addCriterion("client_id <=", value, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdIn(List<Integer> values) {
            addCriterion("client_id in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotIn(List<Integer> values) {
            addCriterion("client_id not in", values, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdBetween(Integer value1, Integer value2) {
            addCriterion("client_id between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andClientIdNotBetween(Integer value1, Integer value2) {
            addCriterion("client_id not between", value1, value2, "clientId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdIsNull() {
            addCriterion("create_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdIsNotNull() {
            addCriterion("create_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdEqualTo(Integer value) {
            addCriterion("create_employee_id =", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdNotEqualTo(Integer value) {
            addCriterion("create_employee_id <>", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdGreaterThan(Integer value) {
            addCriterion("create_employee_id >", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("create_employee_id >=", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdLessThan(Integer value) {
            addCriterion("create_employee_id <", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("create_employee_id <=", value, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdIn(List<Integer> values) {
            addCriterion("create_employee_id in", values, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdNotIn(List<Integer> values) {
            addCriterion("create_employee_id not in", values, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("create_employee_id between", value1, value2, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCreateEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("create_employee_id not between", value1, value2, "createEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdIsNull() {
            addCriterion("check_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdIsNotNull() {
            addCriterion("check_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdEqualTo(Integer value) {
            addCriterion("check_employee_id =", value, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdNotEqualTo(Integer value) {
            addCriterion("check_employee_id <>", value, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdGreaterThan(Integer value) {
            addCriterion("check_employee_id >", value, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("check_employee_id >=", value, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdLessThan(Integer value) {
            addCriterion("check_employee_id <", value, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("check_employee_id <=", value, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdIn(List<Integer> values) {
            addCriterion("check_employee_id in", values, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdNotIn(List<Integer> values) {
            addCriterion("check_employee_id not in", values, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("check_employee_id between", value1, value2, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andCheckEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("check_employee_id not between", value1, value2, "checkEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdIsNull() {
            addCriterion("pay_employee_id is null");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdIsNotNull() {
            addCriterion("pay_employee_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdEqualTo(Integer value) {
            addCriterion("pay_employee_id =", value, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdNotEqualTo(Integer value) {
            addCriterion("pay_employee_id <>", value, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdGreaterThan(Integer value) {
            addCriterion("pay_employee_id >", value, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("pay_employee_id >=", value, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdLessThan(Integer value) {
            addCriterion("pay_employee_id <", value, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdLessThanOrEqualTo(Integer value) {
            addCriterion("pay_employee_id <=", value, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdIn(List<Integer> values) {
            addCriterion("pay_employee_id in", values, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdNotIn(List<Integer> values) {
            addCriterion("pay_employee_id not in", values, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdBetween(Integer value1, Integer value2) {
            addCriterion("pay_employee_id between", value1, value2, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andPayEmployeeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("pay_employee_id not between", value1, value2, "payEmployeeId");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNull() {
            addCriterion("total_price is null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIsNotNull() {
            addCriterion("total_price is not null");
            return (Criteria) this;
        }

        public Criteria andTotalPriceEqualTo(Double value) {
            addCriterion("total_price =", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotEqualTo(Double value) {
            addCriterion("total_price <>", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThan(Double value) {
            addCriterion("total_price >", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceGreaterThanOrEqualTo(Double value) {
            addCriterion("total_price >=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThan(Double value) {
            addCriterion("total_price <", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceLessThanOrEqualTo(Double value) {
            addCriterion("total_price <=", value, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceIn(List<Double> values) {
            addCriterion("total_price in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotIn(List<Double> values) {
            addCriterion("total_price not in", values, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceBetween(Double value1, Double value2) {
            addCriterion("total_price between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andTotalPriceNotBetween(Double value1, Double value2) {
            addCriterion("total_price not between", value1, value2, "totalPrice");
            return (Criteria) this;
        }

        public Criteria andDateIsNull() {
            addCriterion("date is null");
            return (Criteria) this;
        }

        public Criteria andDateIsNotNull() {
            addCriterion("date is not null");
            return (Criteria) this;
        }

        public Criteria andDateEqualTo(Date value) {
            addCriterion("date =", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotEqualTo(Date value) {
            addCriterion("date <>", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThan(Date value) {
            addCriterion("date >", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateGreaterThanOrEqualTo(Date value) {
            addCriterion("date >=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThan(Date value) {
            addCriterion("date <", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateLessThanOrEqualTo(Date value) {
            addCriterion("date <=", value, "date");
            return (Criteria) this;
        }

        public Criteria andDateIn(List<Date> values) {
            addCriterion("date in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotIn(List<Date> values) {
            addCriterion("date not in", values, "date");
            return (Criteria) this;
        }

        public Criteria andDateBetween(Date value1, Date value2) {
            addCriterion("date between", value1, value2, "date");
            return (Criteria) this;
        }

        public Criteria andDateNotBetween(Date value1, Date value2) {
            addCriterion("date not between", value1, value2, "date");
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