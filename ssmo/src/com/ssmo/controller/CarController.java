package com.ssmo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ssmo.pojo.Car;
import com.ssmo.service.CarService;

// spring 注解此类是页面控制器(处理器)
@Controller
public class CarController {
  @Resource(name = "carService")
  private CarService carService;

  /**
   * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配， 自动为该对象填充属性值。支持级联属性。
   * 如：dept.deptId、dept.address.tel 等
   */
  @RequestMapping("carController_save")
  public String save(Car car) {
    if (car != null && car.getId() != null) {
      carService.modify(car);
    } else {
      carService.add(car);
    }
    return "redirect:carController_list";
  }

  @RequestMapping(value = "carController_findById")
  public ModelAndView findById(@RequestParam(value = "id", required = true) Integer id) {

    // 实例化模型和视图对象,且设置逻辑视图名
    ModelAndView modelAndView = new ModelAndView("caredit");
    // ModelAndView modelAndView = new ModelAndView();
    // modelAndView.setViewName("caredit");

    Car car = carService.find(id);
    // 设置模型数据
    modelAndView.addObject("car", car);

    return modelAndView;
  }

  @RequestMapping("carController_remove")
  public String remove(@RequestParam(value = "id", required = true) Integer id) {

    // 表单参数可选,且设置默认值
    // value="id",required=false,defaultValue="3"
    // @RequestParam("id") 相当于 id = request.getParameter("id");
    carService.remove(id);
    return "redirect:carController_list";
  }

  /**
   * 1. 使用 @RequestMapping 注解来映射请求的 URL 2. 返回值会通过视图解析器解析为实际的物理视图, 对于
   * InternalResourceViewResolver 视图解析器, 会做如下的解析: 通过 prefix + returnVal + suffix
   * 这样的方式得到实际的物理视图, 然会做转发操作
   * 
   * /carlist.jsp
   * 
   * @return
   */
  @RequestMapping("carController_list")
  public String list(ModelMap modelMap) {
    // 访问模型(业务逻辑层,返回模型数据)
    List<Car> cars = carService.find();

    // modelMap 相当于 map,request作用域
    modelMap.put("cars", cars);
    // 逻辑视图名
    return "carlist";
  }
  /*
   * public ModelAndView list() { // 访问模型(业务逻辑层,返回模型数据) List<Car> cars =
   * carService.find();
   * 
   * // 实例化模型和视图对象 // ModelAndView modelAndView = new ModelAndView(); //
   * 设置(逻辑)视图 // modelAndView.setViewName("carlist");
   * 
   * // 实例化模型和视图对象且视图名 ModelAndView modelAndView = new ModelAndView("carlist");
   * // 设置模型数据 modelAndView.addObject("cars", cars);
   * 
   * return modelAndView; }
   */

}
