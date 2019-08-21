package com.kgc.vo;

import java.io.Serializable;

public class Users implements Serializable{
  private Integer id;
  private String name;
  private String password;
  private Integer status;
  private String lastModifyTime;
  private Integer typeId;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getLastModifyTime() {
    return lastModifyTime;
  }

  public void setLastModifyTime(String lastModifyTime) {
    this.lastModifyTime = lastModifyTime;
  }

  public Integer getTypeId() {
    return typeId;
  }

  public void setTypeId(Integer typeId) {
    this.typeId = typeId;
  }

  @Override
  public String toString() {
    return "Users{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", password='" + password + '\'' +
            ", status=" + status +
            ", lastModifyTime='" + lastModifyTime + '\'' +
            ", typeId=" + typeId +
            '}';
  }
}
