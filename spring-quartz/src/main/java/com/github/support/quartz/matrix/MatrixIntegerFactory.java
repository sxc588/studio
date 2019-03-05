package com.github.support.quartz.matrix;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.github.support.dbaccess.dto.MonMatrixDto;
import com.github.support.dbaccess.service.MonMatrixService;
import com.github.support.utils.http.HostUtils;

@Component
public final class MatrixIntegerFactory
{
	private Map<String, MatrixInteger> map = new HashMap<String, MatrixInteger>();

	public synchronized void inc(String matrixFiled)
	{
	}


}
