package com.example.CarRental;

import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
public class CarRentalService {
	
	private List<Car> cars = new ArrayList<Car>();
	
	public CarRentalService() {
		cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
	}
	
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){
		return cars;
	}
	
	@RequestMapping(value = "/cars", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.OK)
	public void addCar(@RequestBody Car car) throws Exception{
		System.out.println(car);
		cars.add(car);
	}
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public void RemoveCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		
		for(Car car : cars) {
		if (car.getPlateNumber().contentEquals(plateNumber))
			cars.remove(car);
			
		}
		
	}
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Car aCar(@PathVariable("plateNumber") String plateNumber) throws Exception{
		
		for(Car car : cars) {
		if (car.getPlateNumber().contentEquals(plateNumber))
			return car;
			
		}
		return null;
	} 
	
	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
public void rentAndGetBack(@PathVariable("plateNumber") String plateNumber, @RequestBody date date,
	@RequestParam(value="rent", required = true)boolean rent) throws Exception{
		System.out.println("Bonjour");
		
		if (rent==true) {
			aCar(plateNumber).setRent(true);
			aCar(plateNumber).setBegin(date);
			} 
		if (rent==false) {
			aCar(plateNumber).setRent(false);
			aCar(plateNumber).setEnd(date);
			
			}
	} 		

}
