package by.htp6.avtobase.service.validation;

import java.util.regex.Pattern;

public class DataValidation {
	
	/**
     * ������ ��������� ��� ������ ������� ����� ������ �� 15-� ��������
     * <br/>
     * Only latin or only russian letters up to 15 symbols
     */
    public static final Pattern namePattern = 
            Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[�-�]?[�-�]{1,15}\\z)");
	
	/**
     * ������ ��������� ��� ������ ������� ����� ������ �� 15-� ��������
     * <br/>
     * Only latin or only russian letters up to 15 symbols
     */
    public static final Pattern surnamePattern = 
            Pattern.compile("(\\A[A-Z]?[a-z]{1,15}\\z)|(\\A[�-�]?[�-�]{1,15}\\z)");
    
	/**
     * ��������� ����� ��� �����, �� 3-� �� 15-� ��������
     * <br/>
     * Latin letters or digits at least 3 symbols up to 15
     */
    public static final Pattern loginPattern = 
            Pattern.compile("\\A[a-zA-Z0-9]{3,15}\\z");
    
    /**
     * ��������� �����, �����, *, ! ��� ^,<br/>�� 6-� �� 15-� ��������
     * <br/>
     * Latin letters, digits, *, ! or ^ at least 6<br/>symbols up to 15
     */
    public static final Pattern passwordPattern = 
            Pattern.compile("\\A[a-zA-Z0-9_\\*\\!\\^]{6,15}\\z");
    
    /**
     * ������: vasia.pupkin@gmail.com.
     * <br/>
     * Examples: vasia.pupkin@gmail.com.
     */
    public static final Pattern emailPattern = 
            Pattern.compile("\\A[a-z0-9\\.]{3,25}@[a-z\\.]{3,10}\\.{1}[a-z]{2,5}\\z");
    
    /**
     * ������: +375 29 1234567, 123-45-67,<br/>+375 44 123-45-67
     * <br/>
     * Examples: +375 29 1234567, 123-45-67,<br/>+375 44 123-45-67
     */
    public static final Pattern phonePattern = 
            Pattern.compile("\\A(\\+\\d{3}\\s\\d{2})?\\s?\\d{3}(-|\\s)?\\d{2}(-|\\s)?\\d{2}\\z");
    
    /**
     * ������ �����, �� 1 �� 6 ����
     * <br/>
     * Only digits, at least 1 digits up to 6
     */
    public static final Pattern countOfKMPattern = 
            Pattern.compile("\\A[0-9]{3,15}\\z");
    
    /**
     * ������: 5543 TE-5
     * <br/>
     * Examples: 5543 TE-5
     */
    public static final Pattern stateNumberPattern = 
            Pattern.compile("\\A[0-9]{4} (A|B|E|�|K|M|H|O|P|C|T|X){2}-[1-7]{1}\\z");
    
    /**
     * ������: 5543 TE-5
     * <br/>
     * Examples: 5543 TE-5
     */
    public static final Pattern statusCarPattern = 
            Pattern.compile("\\A[0-1]{1}\\z");
    
	///////////////////////////////////////////////////////////////
    
    
    
    
    
    
    
    
    
    
    
    /**
     * ��������� ��� ������� �����, �����, '.', ',' ��� '-'
     * <br/>
     * Latin or russian letters, digits, '.', ',' or '-'
     */
    public static final Pattern addressPattern = 
            Pattern.compile("\\A[A-Za-z�-��-�\\d\\s\\.,\\-]{1,250}\\z");
    
    /**
     * ��������� ��� ������� �����, �����, '.', ',' ��� '-'
     * <br/>
     * Latin or russian letters, digits, '.', ',' or '-'
     */
    public static final Pattern detailsPattern = 
            Pattern.compile("\\A[A-Za-z�-��-�\\d\\s\\.,\\-]{1,250}\\z");
}
