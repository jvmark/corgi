package com.pebusney.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mark
 * @since 2016-04-21 17:28.
 */
@Entity
@Table(name = "recruitment")
public class Recruitment {

  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String companyName;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String description = "";

  @Column(nullable = false)
  private String positionName = "";

  @Column(nullable = false)
  private String diplomaLimit = "";

  @Column(nullable = false)
  private int minSalary = 0;

  @Column(nullable = false)
  private int maxSalary = 0;

  @Column(nullable = false)
  private String extra;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public String getDiplomaLimit() {
    return diplomaLimit;
  }

  public void setDiplomaLimit(String diplomaLimit) {
    this.diplomaLimit = diplomaLimit;
  }

  public int getMinSalary() {
    return minSalary;
  }

  public void setMinSalary(int minSalary) {
    this.minSalary = minSalary;
  }

  public int getMaxSalary() {
    return maxSalary;
  }

  public void setMaxSalary(int maxSalary) {
    this.maxSalary = maxSalary;
  }

  public String getExtra() {
    return extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }

}
