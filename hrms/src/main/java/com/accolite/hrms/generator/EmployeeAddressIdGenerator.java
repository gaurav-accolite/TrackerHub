package com.accolite.hrms.generator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EmployeeAddressIdGenerator implements IdentifierGenerator{

	Logger  logger = LoggerFactory.getLogger(EmployeeAddressIdGenerator.class);

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		String prefix = "EA";
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		String generatedId = null;
		try {
			con = session.connection();
			stat = con.createStatement();

			rs = stat.executeQuery("SELECT nextval ('EMPLOYEE_ADDRESS_SEQ') as nextval");
			if (rs.next()) {
				Long id = rs.getLong(1) + 1;
				generatedId = prefix + new Long(id).toString();
				logger.debug("Generated Id :" + generatedId);

			}
		}catch (SQLException ex ) {
			logger.debug("SQLException is " + ex.getMessage());
			logger.debug(ex.getMessage());
		}catch(Exception ex) {
			logger.debug("Exception is " + ex.getMessage());
		}
		
		return generatedId;
	}



}
