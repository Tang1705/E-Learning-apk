package edu.bjtu.android.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.bjtu.android.entity.Customers;

@Component
public class CustomersDao implements CustomersMapper {
	
	@Autowired
	CustomersMapper mapper;
	
	@Override
    public int deleteByPrimaryKey(String username)
    {
    	return mapper.deleteByPrimaryKey(username);
    }


    public int insert(Customers record) {
    	return mapper.insert(record);
    }

	@Override
    public Customers selectByPrimaryKey(String username)
    {
		return mapper.selectByPrimaryKey(username);
    }

	@Override
    public List<Customers> selectAll()
    {
		return mapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Customers record)
    {
    	return mapper.updateByPrimaryKey(record);
    }
}