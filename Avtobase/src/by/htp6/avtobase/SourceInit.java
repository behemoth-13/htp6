package by.htp6.avtobase;

import by.htp6.avtobase.exception.InitException;

public interface SourceInit {
	
	public void init() throws InitException ;
	
	public void destroy();

}
