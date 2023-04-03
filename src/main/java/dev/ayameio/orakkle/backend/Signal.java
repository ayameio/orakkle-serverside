package dev.ayameio.orakkle.backend;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "SIGNALS")
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

    public Signal(Long id,
                  Long unixTime,
                  String asset,
                  String entryPrice,
                  String takeProfit,
                  String stopLoss,
                  boolean closed,
                  boolean wasSuccessful) {
        this.id = id;
        this.unixTime = unixTime;
        this.asset = asset;
        this.entryPrice = entryPrice;
        this.takeProfit = takeProfit;
        this.stopLoss = stopLoss;
        this.closed = closed;
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