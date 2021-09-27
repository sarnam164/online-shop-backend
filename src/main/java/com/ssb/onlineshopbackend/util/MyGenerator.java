package com.ssb.onlineshopbackend.util;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyGenerator implements IdentifierGenerator{

    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        String prefix = "P0";
        String suffix = "";
        try{
            Connection connection = session.connection();
            Statement statement = connection.createStatement();
            String sql = "SELECT nextval('product_id_seq')";
            ResultSet rs = statement.executeQuery(sql);
            if(rs.next()){
                int seqval = rs.getInt(1);
                suffix = String.valueOf(seqval);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return (prefix+suffix);
    }
}
