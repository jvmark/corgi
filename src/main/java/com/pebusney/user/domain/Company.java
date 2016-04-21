package com.pebusney.user.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author mark
 * @since 2016-04-21 17:22.
 */
@Entity
@Table(name = "company")
public class Company {

  @Id
  @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String name;

  @Column(nullable = false)
  private String city;

  @Column(nullable = false)
  private String description;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
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
}
