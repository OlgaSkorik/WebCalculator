package by.skorik.webcalculator.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Objects;

public class Operation {

    @JsonProperty("№")
    private long id;
    @JsonProperty("Number1")
    private double num1;
    @JsonProperty("Number2")
    private double num2;
    @JsonProperty("Type of operation")
    private String operation;
    @JsonIgnore
    private User user;

    public Operation() {}

    public Operation(long id, double num1, double num2, String operation, User user) {
        this.id = id;
        this.num1 = num1;
        this.num2 = num2;
        this.operation = operation;
        this.user = user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Operation operation1 = (Operation) o;
        return id == operation1.id && Double.compare(operation1.num1, num1) == 0 && Double.compare(operation1.num2, num2) == 0 && operation.equals(operation1.operation) && user.equals(operation1.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, num1, num2, operation, user);
    }


    @Override
    public String toString() {
        return '\n' + "Operation[" +
                "Number " + id +
                ", number1 = " + num1 +
                ", number2 = " + num2 +
                ", type of operation = " + operation +
                ']';
    }
}