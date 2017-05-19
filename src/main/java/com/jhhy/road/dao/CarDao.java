package com.jhhy.road.dao;

import java.util.List;

import com.jhhy.road.model.CarRequest;

public interface CarDao {
   void saveCar(String carName);//新增车段
   
   List<CarRequest> queryCar(); //全部车段
}

