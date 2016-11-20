package by.htp6.avtobase.bean;

import java.io.Serializable;

public class BrandOfCar implements Serializable {
	
	private static final long serialVersionUID = 2738462131836461988L;
	
	private int id;
	private String brandOfCar;
	private int loadingCapacity;
	private int capacity;
	private int costPerKM;
	
	
	public int getId() {
		return id;
	}
	public String getBrandOfCar() {
		return brandOfCar;
	}
	public int getLoadingCapacity() {
		return loadingCapacity;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getCostPerKM() {
		return costPerKM;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setBrandOfCar(String brandOfCar) {
		this.brandOfCar = brandOfCar;
	}
	public void setLoadingCapacity(int loadingCapacity) {
		this.loadingCapacity = loadingCapacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setCostPerKM(int costPerKM) {
		this.costPerKM = costPerKM;
	}
}
