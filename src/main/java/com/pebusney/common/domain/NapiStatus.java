package com.pebusney.common.domain;

/**
 * @auther mark
 * @since 2016-04-03 16:47.
 */
public enum NapiStatus {
  SUCCESS(1),

  NOT_LOGIN(2),

  INVALID_PARAM(4),

  INNER_ERROR(5),

  NOT_REGISTERED(7),

  ACCOUNT_ABNORMAL(8);

  public int apiCode;

  private NapiStatus(int value) {
    this.apiCode = value;
  }

  public int getValue() {
    return this.apiCode;
  }

  @Override
  public String toString() {
    return "NAPIStatus{" + "api_code=" + apiCode + '}';
  }
}
