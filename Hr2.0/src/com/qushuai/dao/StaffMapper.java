package com.qushuai.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.qushuai.pojo.Staff;

@Repository("staffMapper")
public interface StaffMapper {

	@Insert("insert into STAFF(S_ID,S_NAME,S_JOB,S_PHONE,S_EMAIL) values(#{id},#{name,jdbcType=VARCHAR},#{job,jdbcType=VARCHAR},#{phone},#{email})")
	@SelectKey(statement = "select SEQ_STAFF.nextval from DUAL", keyProperty = "id", resultType = int.class, before = true)
	int add(Staff staff);

	@Update("update STAFF set S_NAME=#{name,jdbcType=VARCHAR},S_JOB=#{job,jdbcType=VARCHAR},S_PHONE=#{phone},S_EMAIL=#{email} where S_ID=#{id}")
	int modify(Staff staff);

	@Delete("delete from STAFF where S_ID=#{id}")
	int remove(Integer id);

	@Select("select S_ID id,S_NAME name,S_JOB job,S_PHONE phone,S_EMAIL email from STAFF where S_ID=#{id}")
	Staff findById(Integer id);

	@Select("select S_ID id,S_NAME name,S_JOB job,S_PHONE phone,S_EMAIL email from STAFF")
	List<Staff> find();
}
