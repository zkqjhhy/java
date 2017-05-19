/**
 * 
 */
package com.jhhy.road.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhhy.road.dao.CarDao;
import com.jhhy.road.model.CarRequest;
import com.jhhy.road.model.ZkqException;
import com.jhhy.road.service.CarService;

/**
 * @author KQ
 *
 * 2017年4月20日
 */
@Service
public class CarServiceImpl implements CarService {
        @Autowired
        private CarDao carDao;
        
//        新增车段
        public void addCar(String carName){
        	if(carName==null){
        		throw new ZkqException("信息不规范");
        	}else{
        		CarRequest carRequest=new CarRequest();
        		carRequest.setCarName(carName);
        		carDao.saveCar(carName);
        	}
        }
//        查询全部车段
         public List<CarRequest> carList(){
        	 List<CarRequest> carList=carDao.queryCar();
        	 return carList;
         }
}
