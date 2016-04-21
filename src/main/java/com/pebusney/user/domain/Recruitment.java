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
  private String desc;

  @Column(nullable = false)
  private String positionName;

  @Column(nullable = false)
  private String diplomaLimit;

  @Column(nullable = false)
  private String salary;

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

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
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

  public String getSalary() {
    return salary;
  }

  public void setSalary(String salary) {
    this.salary = salary;
  }

  public String getExtra() {
    return extra;
  }

  public void setExtra(String extra) {
    this.extra = extra;
  }

}
