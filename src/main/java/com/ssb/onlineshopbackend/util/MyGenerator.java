package com.ssb.onlineshopbackend.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MyGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "P0";
        Connection connection = session.connection();
        try {
            Statement statement=connection.createStatement();
            ResultSet rs=statement.executeQuery("SELECT COUNT(PRODUCT_ID) AS ID FROM PRODUCT");
            if(rs.next())
            {
                int id=rs.getInt(1)+1;
                String generatedId = prefix + String.valueOf(id);
                System.out.println("Generated Id: " + generatedId);
                return generatedId;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
