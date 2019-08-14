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
import com.github.support.utils.HostUtils;

@Component
public final class MatrixInteger
{
	private Map<String, Integer> map = new HashMap<String, Integer>();

	private static final DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");

	@Autowired
	private MonMatrixService monMatrixService;

	private static String machineName = HostUtils.getHostNameAndIp();
	
	private static String matrixFiled = "SyncJobFactory";
	
	public synchronized void inc(String matrixFiled)
	{
		
		
		String tm = sdf.format(new Date());
		
		if (map.containsKey(tm))
		{
			int value = map.get(tm) + 1;
			map.put(tm, value);
			return;
		}
		map.put(tm, 1);
	}

	@Scheduled(fixedRate=6000)
	public synchronized void archive()
	{

		for (Map.Entry<String, Integer> entry : map.entrySet())
		{

			MonMatrixDto record = new MonMatrixDto();

			record.setMachineName(machineName);
			record.setMatrixFiled(matrixFiled);
			record.setMatrixKey(entry.getKey());
			record.setMatrixValue(entry.getValue());
			monMatrixService.insert(record);
		}

		map.clear();
	}

}
