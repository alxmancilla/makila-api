package org.makila.api.model.mongodb;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;
import org.makila.api.model.mongodb.OrdersOrderlinesInnerEntity;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import javax.validation.constraints.NotNull;


import java.util.*;
import javax.annotation.Generated;

/**
 * Generated by MongoDB Relational Migrator 
* https://www.mongodb.com/products/relational-migrator 
* Collection: orders
* Language: Java
* Template: POJO
* Generated on 11/13/24

 */
@JsonTypeName("orders")
@Generated(value = "com.mongodb.migrator.application.codegen.config.java.JavaSpringCodegenConfig", date = "2024-11-13T10:01:35.799579-06:00[America/Chicago]", comments = "Generator version: 7.7.0")@Document("orders")
public class OrdersEntity {

  @BsonProperty("_id")
  private ObjectId id = null;

  @BsonProperty("orderid")
  private Integer orderid;

  @BsonProperty("orderdate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime orderdate;

  @BsonProperty("customerid")
  private Integer customerid;

  @BsonProperty("netamount")
  private BigDecimal netamount;

  @BsonProperty("tax")
  private BigDecimal tax;

  @BsonProperty("totalamount")
  private BigDecimal totalamount;

  @BsonProperty("orderlines")
  
  private List<OrdersOrderlinesInnerEntity> orderlines = new ArrayList<>();

  public OrdersEntity id(ObjectId id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @JsonProperty("_id")
  public ObjectId getId() {
    return id;
  }

  public void setId(ObjectId id) {
    this.id = id;
  }

  public OrdersEntity orderid(Integer orderid) {
    this.orderid = orderid;
    return this;
  }

  /**
   * Get orderid
   * @return orderid
   */
  
  @JsonProperty("orderid")
  public Integer getOrderid() {
    return orderid;
  }

  public void setOrderid(Integer orderid) {
    this.orderid = orderid;
  }

  public OrdersEntity orderdate(LocalDateTime orderdate) {
    this.orderdate = orderdate;
    return this;
  }

  /**
   * Get orderdate
   * @return orderdate
   */
  
  @JsonProperty("orderdate")
  public LocalDateTime getOrderdate() {
    return orderdate;
  }

  public void setOrderdate(LocalDateTime orderdate) {
    this.orderdate = orderdate;
  }

  public OrdersEntity customerid(Integer customerid) {
    this.customerid = customerid;
    return this;
  }

  /**
   * Get customerid
   * @return customerid
   */
  
  @JsonProperty("customerid")
  public Integer getCustomerid() {
    return customerid;
  }

  public void setCustomerid(Integer customerid) {
    this.customerid = customerid;
  }

  public OrdersEntity netamount(BigDecimal netamount) {
    this.netamount = netamount;
    return this;
  }

  /**
   * Get netamount
   * @return netamount
   */
  
  @JsonProperty("netamount")
  public BigDecimal getNetamount() {
    return netamount;
  }

  public void setNetamount(BigDecimal netamount) {
    this.netamount = netamount;
  }

  public OrdersEntity tax(BigDecimal tax) {
    this.tax = tax;
    return this;
  }

  /**
   * Get tax
   * @return tax
   */
  
  @JsonProperty("tax")
  public BigDecimal getTax() {
    return tax;
  }

  public void setTax(BigDecimal tax) {
    this.tax = tax;
  }

  public OrdersEntity totalamount(BigDecimal totalamount) {
    this.totalamount = totalamount;
    return this;
  }

  /**
   * Get totalamount
   * @return totalamount
   */
  
  @JsonProperty("totalamount")
  public BigDecimal getTotalamount() {
    return totalamount;
  }

  public void setTotalamount(BigDecimal totalamount) {
    this.totalamount = totalamount;
  }

  public OrdersEntity orderlines(List<OrdersOrderlinesInnerEntity> orderlines) {
    this.orderlines = orderlines;
    return this;
  }

  public OrdersEntity addOrderlinesItem(OrdersOrderlinesInnerEntity orderlinesItem) {
    if (this.orderlines == null) {
      this.orderlines = new ArrayList<>();
    }
    this.orderlines.add(orderlinesItem);
    return this;
  }

  /**
   * Get orderlines
   * @return orderlines
   */
  
  @JsonProperty("orderlines")
  public List<OrdersOrderlinesInnerEntity> getOrderlines() {
    return orderlines;
  }

  public void setOrderlines(List<OrdersOrderlinesInnerEntity> orderlines) {
    this.orderlines = orderlines;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrdersEntity orders = (OrdersEntity) o;
    return Objects.equals(this.id, orders.id) &&
        Objects.equals(this.orderid, orders.orderid) &&
        Objects.equals(this.orderdate, orders.orderdate) &&
        Objects.equals(this.customerid, orders.customerid) &&
        Objects.equals(this.netamount, orders.netamount) &&
        Objects.equals(this.tax, orders.tax) &&
        Objects.equals(this.totalamount, orders.totalamount) &&
        Objects.equals(this.orderlines, orders.orderlines);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, orderid, orderdate, customerid, netamount, tax, totalamount, orderlines);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrdersEntity {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    orderid: ").append(toIndentedString(orderid)).append("\n");
    sb.append("    orderdate: ").append(toIndentedString(orderdate)).append("\n");
    sb.append("    customerid: ").append(toIndentedString(customerid)).append("\n");
    sb.append("    netamount: ").append(toIndentedString(netamount)).append("\n");
    sb.append("    tax: ").append(toIndentedString(tax)).append("\n");
    sb.append("    totalamount: ").append(toIndentedString(totalamount)).append("\n");
    sb.append("    orderlines: ").append(toIndentedString(orderlines)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
