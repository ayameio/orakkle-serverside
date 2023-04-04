package dev.ayameio.orakkle.backend;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long unixTime;
    private String asset;
    private String orderType;
    private String entryPrice;
    private String takeProfit;
    private String stopLoss;
    private boolean closed;
    private boolean successful;

    protected Signal() {}

    public Signal(
                  String asset,
                  String orderType,
                  String entryPrice,
                  String takeProfit,
                  String stopLoss,
                  boolean closed,
                  boolean successful) {
        this.unixTime = Instant.now().getEpochSecond();
        this.asset = asset;
        this.orderType = orderType;
        this.entryPrice = entryPrice;
        this.takeProfit = takeProfit;
        this.stopLoss = stopLoss;
        this.closed = closed;
        this.successful = successful;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUnixTime() {
        return unixTime;
    }

    public void setUnixTime(Long unixTime) {
        this.unixTime = unixTime;
    }

    public String getAsset() {
        return asset;
    }

    public void setAsset(String asset) {
        this.asset = asset;
    }

    public String getEntryPrice() {
        return entryPrice;
    }

    public void setEntryPrice(String entryPrice) {
        this.entryPrice = entryPrice;
    }

    public String getTakeProfit() {
        return takeProfit;
    }

    public void setTakeProfit(String takeProfit) {
        this.takeProfit = takeProfit;
    }

    public String getStopLoss() {
        return stopLoss;
    }

    public void setStopLoss(String stopLoss) {
        this.stopLoss = stopLoss;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "id=" + id +
                ", unixTime=" + unixTime +
                ", asset='" + asset + '\'' +
                ", orderType='" + orderType + '\'' +
                ", entryPrice='" + entryPrice + '\'' +
                ", takeProfit='" + takeProfit + '\'' +
                ", stopLoss='" + stopLoss + '\'' +
                ", closed=" + closed +
                ", successful=" + successful +
                '}';
    }
}