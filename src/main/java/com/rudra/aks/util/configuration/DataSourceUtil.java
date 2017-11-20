package com.rudra.aks.util.configuration;

import javax.sql.DataSource;

/**
 * This interface declares all the common configuration. 
 * Provide access to all the properties accordingly.
 * 
 * 
 * @author Ankush.Verman
 *
 */
public interface DataSourceUtil {
	
	
	DataSource	getMySQLDataSource();
	
	DataSource	getBasicDataSource();
	

}
