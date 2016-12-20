package com.ssmo.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssmo.dao.CarMapper;
import com.ssmo.pojo.Car;
import com.ssmo.util.Pager;

// Spring 注解此类是业务逻辑层
@Service("carService")
public class CarService {
  @Resource(name = "carMapper")
  private CarMapper carMapper;

  public Pager<Car> findPager(Integer pageno, Integer pagesize, String sort, String order, String name, Date beginDate,
      Date endDate) {
    Pager<Car> pager = new Pager<Car>();
    pager.setRows(carMapper.findPager(pageno, pagesize, sort, order, name, beginDate, endDate));
    pager.setTotal(carMapper.findTotal(name, beginDate, endDate));
    return pager;
  }

  public int add(Car car) {
    return carMapper.add(car);
  }

  public int modify(Car car) {
    return carMapper.modify(car);
  }

  public int remove(Integer id) {
    return carMapper.remove(id);
  }

  public Car find(Integer id) {
    return carMapper.findById(id);
  }

  public List<Car> find() {
    return carMapper.find();
  }
}
