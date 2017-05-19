package com.jhhy.road.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jhhy.road.dao.CarDao;
import com.jhhy.road.model.CarRequest;

@Service
public interface CarService {
	public void addCar(String carName);

	public List<CarRequest> carList();
}
