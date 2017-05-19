/**
 * 
 */
package com.jhhy.road.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jhhy.road.dao.CarDao;
import com.jhhy.road.model.ApiResponse;
import com.jhhy.road.model.CarRequest;
import com.jhhy.road.service.CarService;

/**
 * @author KQ
 *
 *         2017年4月20日
 */
@Controller
public class CarController {
	@Autowired
	private CarService carService;
//添加车段
	@CrossOrigin
	@RequestMapping(value = "/addCar", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse addCar(String carName) {
		if (carName == null) {
			return new ApiResponse(false, "请填写车段名", null);
		} else {
			try {
				carService.addCar(carName);
				return new ApiResponse(true, "添加成功", null);
			} catch (Exception e) {
				e.printStackTrace();
				return new ApiResponse(false, e.getMessage(), null);
			}
		}
	}
//查询所有车段
	@CrossOrigin
	@RequestMapping(value = "/queryAllCar", method = RequestMethod.POST)
	@ResponseBody
	public ApiResponse carList(){
		try {
			List<CarRequest> carList=carService.carList();
			return new ApiResponse(true, "查询成功", carList);
		} catch (Exception e) {
			e.printStackTrace();
			return new ApiResponse(false, e.getMessage(), null);
		}
	}
}
