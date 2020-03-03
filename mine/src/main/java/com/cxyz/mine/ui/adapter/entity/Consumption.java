package com.cxyz.mine.ui.adapter.entity;

import java.math.BigDecimal;
import java.util.List;

public class Consumption {

    /**
     * balance : 868:00
     * recording : [{"date":"2月10日11:00","money":"-100.00"},{"date":"2月10日11:00","money":"-100.00"},{"date":"2月10日11:00","money":"-100.00"},{"date":"2月10日11:00","money":"-100.00"},{"date":"2月10日11:00","money":"-100.00"}]
     */

    private BigDecimal balance;
    private List<RecordingBean> recording;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public List<RecordingBean> getRecording() {
        return recording;
    }

    public void setRecording(List<RecordingBean> recording) {
        this.recording = recording;
    }

    public static class RecordingBean {
        /**
         * date : 2月10日11:00
         * money : -100.00
         */

        private String date;
        private BigDecimal money;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public BigDecimal getMoney() {
            return money;
        }

        public void setMoney(BigDecimal money) {
            this.money = money;
        }
    }
}
