package com.kgc.vo;

import java.io.Serializable;

public class UserType implements Serializable{
  private Integer id;
  private String name;

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

  @Override
  public String toString() {
    return "UserType{" +
            "id=" + id +
            ", name='" + name + '\'' +
            '}';
  }
}
