package com.github.support.cbb.migration;

import java.util.Date;
import java.util.List;

public interface ISrcDao <T,Tmic>
{
	 List<T> getAll(int begin, int end, Date dateBeing, Date  DateEnd);
	
	 T get(Tmic bean);
}
