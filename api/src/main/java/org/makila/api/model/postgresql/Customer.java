package org.makila.api.model.postgresql;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customerid")
    private Integer customerId;
    
    private String firstName;
    private String lastName;
    private String address1;
    private String address2;
    private String city;
    private String state;
    
    @Column(name="zip")
    private Integer zip;

    private String country;

    @Column(name="region")
    private Integer region;

    private String email;
    private String phone;

    @Column(name="creditcardtype")
    private Integer creditCardType;

    private String creditCard;
    private String creditCardExpirationDate;
    private String username;
    private String password;
    
    @Column(name="age")
    private Integer age;

    @Column(name="income")
    private Integer income;

    private String gender;

    public class delivery_info {
        @JsonProperty("type")
        private String type;

        public static class address {
            @JsonProperty("zip")
            private Integer zip;

            @JsonProperty("city")
            private String city;

            @JsonProperty("state")
            private String state;

            @JsonProperty("address1")
            private String address1;
        }
    }

}
