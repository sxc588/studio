package com.huawei.transactional;


////指定回滚
//@Transactional(rollbackFor=Exception.class) 
// public void methodName() {
//    // 不会回滚
//    throw new Exception("...");
// } 
////指定不回滚
//@Transactional(noRollbackFor=Exception.class)
// public ItimDaoImpl getItemDaoImpl() {
//     // 会回滚
//     throw new RuntimeException("注释");
// } 
//
// // 如果有事务,那么加入事务,没有的话新建一个(不写的情况下)
// @Transactional(propagation=Propagation.REQUIRED) 
// // 容器不为这个方法开启事务
// @Transactional(propagation=Propagation.NOT_SUPPORTED)
// // 不管是否存在事务,都创建一个新的事务,原来的挂起,新的执行完毕,继续执行老的事务
// @Transactional(propagation=Propagation.REQUIRES_NEW) 
// // 必须在一个已有的事务中执行,否则抛出异常
// @Transactional(propagation=Propagation.MANDATORY)
// // 必须在一个没有的事务中执行,否则抛出异常(与Propagation.MANDATORY相反)
// @Transactional(propagation=Propagation.NEVER) 
// // 如果其他bean调用这个方法,在其他bean中声明事务,那就用事务.如果其他bean没有声明事务,那就不用事务.
// @Transactional(propagation=Propagation.SUPPORTS) 
 
// /*
// public void methodName(){
//    // 本类的修改方法 1
//    update();
//    // 调用其他类的修改方法
//    otherBean.update();
//    // 本类的修改方法 2
//    update();
// }
// other失败了不会影响 本类的修改提交成功
// 本类update的失败,other也失败
// */
//@Transactional(propagation=Propagation.NESTED) 
////readOnly=true只读,不能更新,删除 
//@Transactional (propagation = Propagation.REQUIRED,readOnly=true) 
////设置超时时间
//@Transactional (propagation = Propagation.REQUIRED,timeout=30)
////设置数据库隔离级别
//@Transactional (propagation = Propagation.REQUIRED,isolation=Isolation.DEFAULT)

public class aaaaaasdf
{

}
