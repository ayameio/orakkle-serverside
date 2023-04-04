package dev.ayameio.orakkle.backend;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Entity @Getter @Setter
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long unixTime;
    private String asset;
    private String entryPrice;
    private String takeProfit;
    private String stopLoss;
    private boolean closed;
    private boolean wasSuccessful;

    protected Signal() {}

    public Signal(
                  String asset,
                  String entryPrice,
                  String takeProfit,
                  String stopLoss,
                  boolean closed,
                  boolean wasSuccessful) {
        this.unixTime = Instant.now().getEpochSecond();
        this.asset = asset;
        this.entryPrice = entryPrice;
        this.takeProfit = takeProfit;
        this.stopLoss = stopLoss;
        this.closed = closed;
        this.wasSuccessful = wasSuccessful;
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

    public boolean isWasSuccessful() {
        return wasSuccessful;
    }

    public void setWasSuccessful(boolean wasSuccessful) {
        this.wasSuccessful = wasSuccessful;
    }

    @Override
    public String toString() {
        return "Signal{" +
                "id=" + id +
                ", unixTime=" + unixTime +
                ", asset='" + asset + '\'' +
                ", entryPrice='" + entryPrice + '\'' +
                ", takeProfit='" + takeProfit + '\'' +
                ", stopLoss='" + stopLoss + '\'' +
                ", closed=" + closed +
                ", wasSuccess=" + wasSuccessful +
                '}';
    }
}