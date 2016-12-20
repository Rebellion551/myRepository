package com.ssmo.dao;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.ssmo.pojo.Car;

// spring 注解此接口/类是持久层
@Repository("carMapper")
public interface CarMapper {

	List<Car> findPager(@Param("pageno") Integer pageno, @Param("pagesize") Integer pagesize,
			@Param("sort") String sort, @Param("order") String order, @Param("name") String name,
			@Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

	int findTotal(@Param("name") String name, @Param("beginDate") Date beginDate, @Param("endDate") Date endDate);

	@Insert("insert into T_CAR(ID,NAME,SALE_DATE,PRICE) values(#{id},#{name},#{saleDate},#{price,jdbcType=DOUBLE})")
	@SelectKey(statement = "select SEQ_CAR.nextval from DUAL", keyProperty = "id", resultType = int.class, before = true)
	int add(Car car);

	@Update("update T_CAR set NAME=#{name},SALE_DATE=#{saleDate},PRICE=#{price} where ID=#{id}")
	int modify(Car car);

	@Delete("delete from T_CAR where ID=#{id}")
	int remove(Integer id);

	@Select("select ID,NAME,SALE_DATE saleDate,PRICE from T_CAR where ID=#{id}")
	Car findById(Integer id);

	@Select("select ID,NAME,SALE_DATE saleDate,PRICE from T_CAR")
	List<Car> find();

}
