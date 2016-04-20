package com.pebusney.common.domain;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;

import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * @auther mark
 * @since 2016-04-03 16:40.
 */
public class NapiRespDTO {

  private int status;
  private String message;
  private Object data;

  public NapiRespDTO() {

  }

  /**
   * 封装好的 NAPIRespDTO，适合 List 数据返回
   *
   */
  public <T> NapiRespDTO(List<T> objectList, boolean hasMore, int next) {
    this.status = NapiStatus.SUCCESS.apiCode;
    this.data =
        Maps.newHashMap(ImmutableMap.of("object_list", objectList, "more", hasMore ? 1 : 0,
            "next_start", next));
  }

  /**
   * @param napiStatus 状态
   * @param message 错误信息
   * @param data JSON 数据
   */
  public NapiRespDTO(NapiStatus napiStatus, String message, Object data) {
    this.status = napiStatus.apiCode;
    this.message = StringUtils.isEmpty(message) ? "" : message;
    this.data = data == null ? Maps.newHashMap() : data;
  }

  /**
   * 封装好的 NAPIRespDTO，适合错误数据返回
   *
   * @param napiStatus 状态
   * @param message 错误信息
   */
  public static NapiRespDTO getWithMessage(NapiStatus napiStatus, String message) {
    NapiRespDTO dto = new NapiRespDTO();
    dto.status = napiStatus.apiCode;
    dto.message = message;
    return dto;
  }

  /**
   * 封装好的 NAPIRespDTO，普通 data 返回
   *
   */
  public NapiRespDTO(NapiStatus napiStatus, Object data) {
    this.status = napiStatus.apiCode;
    this.data = data;
  }

  /**
   * 封装好的 NAPIRespDTO, message 返回
   *
   */
  public NapiRespDTO(NapiStatus napiStatus, String message) {
    this.status = napiStatus.apiCode;
    this.message = message;
  }

  /**
   * 封装好的 NAPIRespDTO，普通 data 返回
   *
   */
  public NapiRespDTO(NapiStatus napiStatus) {
    this.status = napiStatus.apiCode;
    this.data = Maps.newHashMap();
  }

  /**
   * 封装好的 NAPIRespDTO，普通 data 返回
   *
   */
  public NapiRespDTO(Object data) {
    this.status = NapiStatus.SUCCESS.apiCode;
    this.data = data;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  /**
   * Getter method for property <tt>message</tt>.
   *
   * @return property value of message
   */
  public String getMessage() {
    return message;
  }

  /**
   * Setter method for property <tt>message</tt>.
   *
   * @param message value to be assigned to property message
   */
  public void setMessage(String message) {
    this.message = message;
  }
}
