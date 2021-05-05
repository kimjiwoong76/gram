package com.gram;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;




@Component
@Slf4j
public class TestDB implements ApplicationRunner {

	@Autowired
	DataSource dataSource;
	@Override
	public void run(ApplicationArguments args) throws Exception {
		// TODO Auto-generated method stub
		Connection con = dataSource.getConnection();
		System.out.println(con);
	}

}
