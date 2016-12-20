package com.qushuai.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.qushuai.pojo.Staff;
import com.qushuai.service.StaffService;

@Controller
public class StaffController {
	@Resource(name = "staffService")
	private StaffService staffService;

	@RequestMapping("staffController_list")
	public String list(ModelMap modelMap) {
		List<Staff> staffs = staffService.find();
		modelMap.put("staffs", staffs);
		return "index";
	}

	@RequestMapping("staffController_save")
	public String save(Staff staff) {
		if (staff != null && staff.getId() != null) {
			staffService.modify(staff);
		} else {
			staffService.add(staff);
		}
		return "redirect:staffController_list";
	}

	@RequestMapping(value = "staffController_findById")
	public ModelAndView findById(@RequestParam(value = "id", required = true) Integer id) {
		ModelAndView modelAndView = new ModelAndView("edit");
		Staff staff = staffService.find(id);
		modelAndView.addObject("staff", staff);
		return modelAndView;
	}

	@RequestMapping("staffController_remove")
	public String remove(@RequestParam(value = "id", required = true) Integer id) {
		staffService.remove(id);
		return "redirect:staffController_list";
	}
}
