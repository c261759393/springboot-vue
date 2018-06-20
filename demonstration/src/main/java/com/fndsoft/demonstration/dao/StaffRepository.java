package com.fndsoft.demonstration.dao;

import com.fndsoft.demonstration.entity.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


/**
 * @创建人 bob
 * @创建时间 2018/6/7
 * @描述：
 */
public interface StaffRepository extends JpaRepository<Staff, Long> {

    //查询列表
    @Query(name = "list",nativeQuery = true)
    List<Staff> findAll(@Param("name") String name,@Param("province")String province);

}
