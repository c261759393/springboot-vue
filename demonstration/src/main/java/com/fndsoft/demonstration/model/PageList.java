package com.fndsoft.demonstration.model;

import com.fndsoft.demonstration.entity.Staff;

import java.util.List;

/**
 * @创建人 bob
 * @创建时间 2018/6/8
 * @描述：jpa的分页不会用，自己写一个
 */
public class PageList<T> {

    private Integer totalCount;

    private Integer totalPages;

    private List<T> list;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
