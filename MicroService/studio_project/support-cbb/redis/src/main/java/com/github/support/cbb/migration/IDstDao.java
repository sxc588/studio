package com.github.support.cbb.migration;

import java.util.List;

public interface IDstDao <T_MIC,TSup,TEnt>
{
		 List<T_MIC> getAll(int begin, int end, String fromTable);

		 T_MIC getSup(TSup t2);
		 
		 T_MIC getEnt(TEnt t3);

		 int saveSup(List<TSup> list);
		 
		 int saveEnt(List<TEnt> list);
		 
		  int saveOne(T_MIC t1);
		 
		 int delete(List<T_MIC> list);  
}
