package com.ssmo.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Car implements Serializable {
  private static final long serialVersionUID = 1L;
  private Integer id;
  private String name;

  // 把表单的字符串转换为日期类型
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date saleDate;
  private Double price;

  public Car() {

  }

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

  public Date getSaleDate() {
    return saleDate;
  }

  public void setSaleDate(Date saleDate) {
    this.saleDate = saleDate;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
