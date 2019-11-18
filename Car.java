package com.example.CarRental;

	public class Car {
		
		private String plateNumber;
		private String brand;
		private int price;
		private int nbofseats;
		boolean rent;
		date begin;
		date end;
		public date getBegin() {
			return begin;
		}

		public void setBegin(date begin) {
			this.begin = begin;
		}

		public date getEnd() {
			return end;
		}

		public void setEnd(date end) {
			this.end = end;
		}

		
		
		public boolean isRent() {
			return rent;
		}

		public void setRent(boolean rent) {
			this.rent = rent;
		}

		public Car() {
			super();
		}
		
		public Car(String plateNumber, String brand, int price) {
			super();
			this.plateNumber = plateNumber;
			this.brand = brand;
			this.price = price;
			setNbofseats(4);
			rent=false;
		}
		
		public String getPlateNumber() {
			return plateNumber;
		}
		
		public void setPlateNumber(String plateNumber) {
			this.plateNumber = plateNumber;
		}
		
		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public int getPrice() {
			return price;
		}
		
		public void setPrice(int price) {
			this.price = price;
		}

		@Override
		public String toString() {
			return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
		}

		public int getNbofseats() {
			return nbofseats;
		}

		public void setNbofseats(int nbofseats) {
			this.nbofseats = nbofseats;
		}

	}
