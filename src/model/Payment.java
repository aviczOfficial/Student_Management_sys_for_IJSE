package model;

import java.time.LocalDate;

public class Payment {
    private String paymentID;
    private LocalDate date;
    private Double cost;
    private String registrationID;

    public Payment() {
    }

    public Payment(String paymentID, LocalDate date, Double cost, String registrationID) {
        this.setPaymentID(paymentID);
        this.setDate(date);
        this.setCost(cost);
        this.setRegistrationID(registrationID);
    }

    public String getPaymentID() {
        return paymentID;
    }

    public void setPaymentID(String paymentID) {
        this.paymentID = paymentID;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getRegistrationID() {
        return registrationID;
    }

    public void setRegistrationID(String registrationID) {
        this.registrationID = registrationID;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentID='" + paymentID + '\'' +
                ", date=" + date +
                ", cost=" + cost +
                ", registrationID='" + registrationID + '\'' +
                '}';
    }
}
