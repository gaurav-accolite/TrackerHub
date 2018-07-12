package com.accolite.hrms.generator;


import java.io.Serializable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;


public class ClientIdGenerator implements IdentifierGenerator {
	
	Logger  logger = LoggerFactory.getLogger(ClientIdGenerator.class);

	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
		String prefix = "CLI";
		Connection con = null;
		Statement stat = null;
		ResultSet rs = null;
		String generatedId = null;
		try {
			con = session.connection();
			stat = con.createStatement();
			rs = stat.executeQuery("SELECT nextval ('CLIENT_SEQ') as nextval");
			if (rs.next()) {
				Long id = rs.getLong(1) + 1;
				generatedId = prefix + new Long(id).toString();
				logger.debug("Generated Id :" + generatedId);

			}

		}catch (SQLException ex ) {
			logger.error("SQLException is  " + ex.getMessage());
		}catch(Exception ex) {
			logger.error("Exception is " + ex.getMessage());
		}
		
		return generatedId;
	}

}
