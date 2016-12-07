package by.htp6.avtobase.bean.constants;

public enum CarStatus {
	READY(0), BROKEN(1);
	
	private int carStatus;

	private CarStatus (int carStatus){
		this.carStatus = carStatus;
	}
	
	public int getCarStatus(){
		return carStatus;
	}
}
