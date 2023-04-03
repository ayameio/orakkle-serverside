package dev.ayameio.orakkle.backend;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity @Getter
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long unixTime;
    private String asset;
    private String entryPrice;
    private String takeProfit;
    private String stopLoss;
    private boolean closed;
    private boolean wasSuccess;

    protected Signal() {}

    public Signal(Long id,
                  Long unixTime,
                  String asset,
                  String entryPrice,
                  String takeProfit,
                  String stopLoss,
                  boolean closed,
                  boolean wasSuccess) {
        this.id = id;
        this.unixTime = unixTime;
        this.asset = asset;
        this.entryPrice = entryPrice;
        this.takeProfit = takeProfit;
        this.stopLoss = stopLoss;
        this.closed = closed;
        this.wasSuccess = wasSuccess;
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
                ", wasSuccess=" + wasSuccess +
                '}';
    }
}