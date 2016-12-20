package com.ssmo.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ssmo.pojo.Car;
import com.ssmo.service.CarService;
import com.ssmo.util.Pager;

public class CarServiceTest {
  private CarService carService;

  @Test
  public void findPager() {
    // easyui 必需参数
    Integer page = 1;
    Integer rows = 10;
    String sort = "id";
    String order = "asc";

    // 条件参数 (可选)
    String name = null;
    Date beginDate = null;
    Date endDate = null;

    // name = "%拉%";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    try {
      beginDate = sdf.parse("2016-12-05 00:00:00");
      endDate = sdf.parse("2016-12-13 23:59:59");
    } catch (ParseException e) {
      e.printStackTrace();
    }

    // 处理起始页和结束页
    Integer pageno = (page - 1) * rows;
    Integer pagesize = page * rows;

    Pager<Car> pager = carService.findPager(pageno, pagesize, sort, order, name, beginDate, endDate);
    System.out.println("分页总数: " + pager.getTotal());
    for (Car car : pager.getRows()) {
      System.out.println(car.getId() + " " + car.getName() + " " + car.getSaleDate() + " " + car.getPrice());
    }
  }

  @Test
  public void add() {
    Car car = new Car();
    car.setName("玛莎拉蒂");
    car.setSaleDate(new Date());
    car.setPrice(500000d);
    if (carService.add(car) > 0) {
      System.out.println("OK");
    } else {
      System.out.println("error");
    }
  }

  @Test
  public void modify() {
    Car car = new Car();
    car.setId(1);
    car.setName("玛莎拉蒂");
    car.setSaleDate(new Date());
    car.setPrice(9900000d);
    if (carService.modify(car) > 0) {
      System.out.println("OK");
    } else {
      System.out.println("error");
    }
  }

  @Test
  public void remove() {
    if (carService.remove(6) > 0) {
      System.out.println("OK");
    } else {
      System.out.println("error");
    }
  }

  @Test
  public void findById() {
    Car car = carService.find(1);
    System.out.println(car.getName() + " " + car.getPrice() + " " + car.getSaleDate());
  }

  @Test
  public void find() {
    for (Car car : carService.find()) {
      System.out.println(car.getName() + " " + car.getPrice() + " " + car.getSaleDate());
    }
  }

  @SuppressWarnings("resource")
  @Before
  public void init() {
    ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    carService = ctx.getBean("carService", CarService.class);
  }
}
