package by.htp6.avtobase.bean;

import java.io.Serializable;

public class Order implements Serializable {

	private static final long serialVersionUID = -8560462537196218698L;
	
	private int Id;
	private int userId;
	private int weight;
	private int capacity;
	private int distance;
	private int statusOrder;
	private String timeStatusOrder;
	private String creationTime;
	
	
	public int getId() {
		return Id;
	}
	public int getUserId() {
		return userId;
	}
	public int getWeight() {
		return weight;
	}
	public int getCapacity() {
		return capacity;
	}
	public int getDistance() {
		return distance;
	}
	public int getStatusOrder() {
		return statusOrder;
	}
	public String getTimeStatusOrder() {
		return timeStatusOrder;
	}
	public String getCreationTime() {
		return creationTime;
	}
	
	
	public void setId(int id) {
		Id = id;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public void setStatusOrder(int status_order) {
		this.statusOrder = status_order;
	}
	public void setTimeStatusOrder(String time_status_order) {
		this.timeStatusOrder = time_status_order;
	}
	public void setCreationTime(String creation_time) {
		this.creationTime = creation_time;
	}
}
