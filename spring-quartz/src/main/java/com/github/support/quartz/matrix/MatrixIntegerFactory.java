package com.github.support.quartz.matrix;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public final class MatrixIntegerFactory {
	private Map<String, MatrixInteger> map = new HashMap<String, MatrixInteger>();

	public synchronized void inc(String matrixFiled) {
	}

}
