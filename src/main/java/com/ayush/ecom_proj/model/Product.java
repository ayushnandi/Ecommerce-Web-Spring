package com.ayush.ecom_proj.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String description;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String brand;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal price;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private String category;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date releaseDate;
    @JsonFormat(shape = JsonFormat.Shape.BOOLEAN)
    private boolean available;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER_INT)
    private int quantity;
}

