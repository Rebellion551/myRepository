package com.qushuai.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.qushuai.dao.StaffMapper;
import com.qushuai.pojo.Staff;

@Service("staffService")
public class StaffService {
	@Resource(name = "staffMapper")
	private StaffMapper staffMapper;

	public int add(Staff staff) {
		return staffMapper.add(staff);
	}

	public int modify(Staff staff) {
		return staffMapper.modify(staff);
	}

	public int remove(Integer id) {
		return staffMapper.remove(id);
	}

	public Staff find(Integer id) {
		return staffMapper.findById(id);
	}

	public List<Staff> find() {
		return staffMapper.find();
	}
}
