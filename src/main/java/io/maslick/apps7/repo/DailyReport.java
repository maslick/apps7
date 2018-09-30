package io.maslick.apps7.repo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "daily_report")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DailyReport implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    private String network;
    private Date date;
    private String app;
    private String platform;
    private Integer requests;
    private Integer impressions;
    private Double revenue;
    private String currency;
}