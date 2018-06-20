package com.fndsoft.demonstration.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @创建人 bob
 * @创建时间 2018/6/7
 * @描述：
 */
@Entity
public class StaffQuery {

    @Id
    private Long id;

    private String name;

    private int sex;

    private String description;

    private String province;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }
}
