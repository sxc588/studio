package com.github.support.dbaccess.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.support.dbaccess.dto.MonMatrixDto;
import com.github.support.dbaccess.mapper.MonMatrixMapper;

@Repository
public class MonMatrixService {

	@Autowired
	private MonMatrixMapper mapper;

	public int insert(MonMatrixDto record) {
		return mapper.insert(record);
	}
}