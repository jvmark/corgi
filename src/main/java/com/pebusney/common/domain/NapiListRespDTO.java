package com.pebusney.common.domain;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * @auther mark
 * @since 2016-04-03 17:07
 */
public class NapiListRespDTO {

  private int status;
  private String message;
  private Map<String, Object> data;

  public NapiListRespDTO(boolean hasMore, int nextStart, List<Object> objectList) {
    this.status = NapiStatus.SUCCESS.getValue();
    this.data = Maps.newHashMap();
    data.put("more", hasMore ? 1 : 0);
    data.put("next_start", nextStart);
    if (null == objectList) {
      objectList = Lists.newArrayList();
    }
    data.put("object_list", objectList);
  }

  public NapiListRespDTO(boolean hasMore, int limit, long totalCount, int nextStart,
      List<Object> objectList) {
    this.status = NapiStatus.SUCCESS.getValue();
    this.data = Maps.newHashMap();
    data.put("more", hasMore ? 1 : 0);
    data.put("total", totalCount);
    data.put("limit", limit);
    data.put("next_start", nextStart);
    if (null == objectList) {
      objectList = Lists.newArrayList();
    }
    data.put("object_list", objectList);
  }

  public NapiListRespDTO(NapiStatus napiStatus) {
    this.status = napiStatus.getValue();
    this.data = Maps.newHashMap();
    List<Object> objectList = Lists.newArrayList();
    data.put("object_list", objectList);
  }


  public NapiListRespDTO(NapiStatus napiStatus, String message) {
    this.status = napiStatus.getValue();
    this.message = message;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getData() {
    return data;
  }

  public void setData(Map<String, Object> data) {
    this.data = data;
  }
}
