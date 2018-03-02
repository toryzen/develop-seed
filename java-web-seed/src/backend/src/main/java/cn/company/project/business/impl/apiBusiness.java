package cn.company.project.business.impl;

import cn.company.project.model.*;
import cn.company.project.business.ApiBusiness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.company.project.dao.ApiDao;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;

@Service
@Transactional
public class apiBusiness implements ApiBusiness {

	protected final Logger logger= LoggerFactory.getLogger(this.getClass());

	@Autowired(required = false)
	private ApiDao apiDao;

	@Override
	public List<Data> getData(){
		List<Data> msgList = apiDao.queryData();
		return msgList;
	}


}