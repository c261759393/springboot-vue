package com.fndsoft.demonstration.entity;

import javax.persistence.*;

/**
 * @创建人 bob
 * @创建时间 2018/6/7
 * @描述：
 */
@Entity
@Table(name = "c_provinces")
public class Provinces{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String province;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
