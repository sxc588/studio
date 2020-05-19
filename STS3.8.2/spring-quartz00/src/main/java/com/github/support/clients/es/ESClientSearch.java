package com.github.support.clients.es;

/**
 * @author huangfox
 * @date 2014年2月10日 下午3:27:43
 *
 */
public interface ESClientSearch {

    void query(String query);
    void filter();
    void sort();
    void paging();
    void light();
    
    void multiSearch();

    void cache();

}
