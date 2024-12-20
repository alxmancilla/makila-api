package org.makila.api.model.mongodb;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.bson.codecs.pojo.annotations.BsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;
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
@JsonTypeName("orders_orderlines_inner")
@Generated(value = "com.mongodb.migrator.application.codegen.config.java.JavaSpringCodegenConfig", date = "2024-11-13T10:01:35.799579-06:00[America/Chicago]", comments = "Generator version: 7.7.0")@Document("orders_orderlines_inner")
public class OrdersOrderlinesInnerEntity {

  @BsonProperty("prodId")
  private Integer prodId;

  @BsonProperty("quantity")
  private Integer quantity;

  public OrdersOrderlinesInnerEntity prodId(Integer prodId) {
    this.prodId = prodId;
    return this;
  }

  /**
   * Get prodId
   * @return prodId
   */
  
  @JsonProperty("prodId")
  public Integer getProdId() {
    return prodId;
  }

  public void setProdId(Integer prodId) {
    this.prodId = prodId;
  }

  public OrdersOrderlinesInnerEntity quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Get quantity
   * @return quantity
   */
  
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrdersOrderlinesInnerEntity ordersOrderlinesInner = (OrdersOrderlinesInnerEntity) o;
    return Objects.equals(this.prodId, ordersOrderlinesInner.prodId) &&
        Objects.equals(this.quantity, ordersOrderlinesInner.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(prodId, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrdersOrderlinesInnerEntity {\n");
    sb.append("    prodId: ").append(toIndentedString(prodId)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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

