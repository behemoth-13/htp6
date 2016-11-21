package by.htp6.avtobase.dao.sql;

import java.util.ResourceBundle;

public class SqlHelper {
	
	private static SqlHelper instance;
	private static ResourceBundle bundle;
	
	private final static String BUNDLE_NAME = "by.htp6.avtobase.dao.sql.sql"; 
	
    //USERS
	public static final String SQL_ADD_USER = "SQL_ADD_USER";
    public static final String SQL_GET_USER = "SQL_GET_USER";
    public static final String SQL_GET_USERS = "SQL_GET_USERS";
    public static final String SQL_GET_USER_BY_ID = "SQL_GET_USER_BY_ID";
    
    //DRIVERS
    
    //ORDERS
    public static final String SQL_ADD_ORDER = "SQL_ADD_ORDER";
    public static final String SQL_GET_ORDERS = "SQL_GET_ORDERS";
    public static final String SQL_GET_ORDERS_BY_USERS_ID = "SQL_GET_ORDERS_BY_USERS_ID";
    public static final String SQL_UPDATE_STATUS_ORDER_BY_ID = "SQL_UPDATE_STATUS_ORDER_BY_ID";
    public static final String SQL_GET_ORDERS_BY_STATUS = "SQL_GET_ORDERS_BY_STATUS";
    
    //TRIPS
    public static final String SQL_ADD_TRIP = "SQL_ADD_TRIP";
    public static final String SQL_GET_TRIPS = "SQL_GET_TRIPS";
    public static final String SQL_GET_TRIP_BY_ORDERS_ID = "SQL_GET_TRIPS_BY_ORDERS_ID";
    
    //BRANDS_OF_CARS
    public static final String SQL_ADD_BRAND_OF_CAR = "SQL_ADD_BRAND_OF_CAR";
    public static final String SQL_GET_BRANDS_OF_CAR = "SQL_GET_BRANDS_OF_CAR";
    public static final String SQL_DELETE_BRAND_OF_CAR_BY_ID = "SQL_DELETE_BRAND_OF_CAR";
    public static final String SQL_GET_BRANDS_OF_CAR_BY_NAME = "SQL_GET_BRANDS_OF_CAR_BY_NAME";
    //CARS
    public static final String SQL_ADD_CAR = "SQL_ADD_CAR";
    public static final String SQL_DELETE_CAR_BY_STATE_NUMBER = "SQL_DELETE_CAR_BY_STATE_NUMBER";
    public static final String SQL_UPDATE_COUNT_OF_KM_BY_DRIVER_ID = "SQL_UPDATE_COUNT_OF_KM_BY_DRIVER_ID";
    public static final String SQL_GET_CARS = "SQL_GET_CARS";

	public static SqlHelper getInstance(){
		if(instance == null) {
			instance = new SqlHelper();
			bundle = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		return instance;
	}
	
	public String getProperty(String key) {
		return bundle.getString(key);
	}
}
