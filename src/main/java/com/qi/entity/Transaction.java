package com.qi.entity;


import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * Created by zs on 2017/12/18.
 */
public class Transaction {

    //产品编号
    @NotNull
    private Integer productId;

    //用户编号
    @NotNull
    private Integer userId;

    //交易日期
    @Future
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private Date date;

    //交易价格
    @NotNull
    @DecimalMin(value = "0.1")
    private Double price;

    //交易数量
    @NotNull
    @Min(1)
    @Max(100)
    private Integer quantity;

    //总价
    @NotNull
    @DecimalMax("50000.0")
    @DecimalMin("1.00")
    private Double amount;

    //邮件
    @NotNull
    @Pattern(regexp = "/^\\\\w+([-+.]\\\\w+)*@\\\\w+([-.]\\\\w+)*\\\\.\\\\w+([-.]\\\\w+)*$/", message = "格式不对")
    private String email;

    //备注
    @Size(min = 0,max = 256)  //字符
    private String note;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
