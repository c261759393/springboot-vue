package com.fndsoft.demonstration.entity;

import com.fndsoft.demonstration.model.StaffQuery;

import javax.persistence.*;

/**
 * @创建人 bob
 * @创建时间 2018/6/6
 * @描述：
 */
@Entity
@Table(name = "c_staff")
@NamedNativeQueries({
        @NamedNativeQuery(name = "list", query = "select * from c_staff s, c_provinces p WHERE s.province_id = p.id AND s.name LIKE :name AND p.province LIKE :province ORDER BY s.id;", resultClass = StaffQuery.class)
})
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private int sex;

    @Column(name = "provinceId")
    @Basic(optional = false)
    private Long provinceId;

    @Column(name = "description")
    private String description;

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

    public Long getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Long provinceId) {
        this.provinceId = provinceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
