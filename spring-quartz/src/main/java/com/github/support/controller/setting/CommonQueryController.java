package com.github.support.controller.setting;

import java.util.LinkedList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.github.support.quartz.model.User;
import com.github.support.validator.UserValidator;

/**
 * 功能说明：系统配置项Action
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "setting/commonquery")
public class CommonQueryController
{
	private static Logger log = LoggerFactory.getLogger(CommonQueryController.class);

//	 //我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
//    //所以在这里注册校验器
//    @InitBinder
//    public void initBainder(DataBinder binder){
//        binder.replaceValidators(new UserValidator());
//
//      //  CronExpression.isValidExpression(cronExpression)
//
//    }
//    //这个方法主要是跳转到登录页面
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
//    public String login(Model model){
//    	
//    	
//    	
//    	
//    	
//        model.addAttribute(new User());
//        return "/hello/login";
//    }
//    //处理登录表单
//    @RequestMapping(value = "/login",method = RequestMethod.POST)
//    public String login(@Validated User user, BindingResult br){
//
//        if (br.hasErrors()){
//            return "hello/login";
//        }
//        return "--";
//    }
//    
//    
//    @RequestMapping(value = "transactionFlow/informationQuery1", method = RequestMethod.POST)
//    public String informationQuery1(@ModelAttribute("form") @RequestParam (value = "sql") String sql, Model model) {
//        List<String> list3 = new LinkedList<>();
//        String query1 = customerLedgersService.query(sql);
//        Map map = new HashMap();
//        if (query1 != null) {
//
//            String[] key = query1.split(";");
//            for (int i = 0, len = key.length; i < len; i++) {
//                list3.add(key[i]);
//            }
//
//            model.addAttribute("sql", sql);
//            model.addAttribute("list3", list3);
//            return "/complement/informationQuery";
//        } else {
//            model.addAttribute("sql", sql);
//
//            return "/complement/informationQuery";
//        }
//
//    }
//    
//    //
//    @RequestMapping(value = "transactionFlow/informationQuery", method = RequestMethod.POST)
//    @ResponseBody
//    public GridData informationQuery(@RequestParam(value = "sql", required = false) String sql,
//                                     @RequestParam(value = "page", required = false) Integer page,
//                                     @RequestParam(value = "rows", required = false) Integer rows
//    ) {
//        List list7 = new LinkedList<>();
//        String queryValue = null;
//
//        String records1 = customerLedgersService.query1(sql);
//        int records = Integer.parseInt(records1);
//        GridData result = new GridData();
//
//        String listTotal = customerLedgersService.query2(sql, page, rows);
//        String query2 = null;
//        List<String> list6 = new ArrayList<>();
//        List<String> list5 = new ArrayList();
//        if (listTotal != null) {
//            String[] keyq3 = listTotal.split("%");
//            for (int i = 0, len = keyq3.length; i < len; i++) {
//                list6.add(keyq3[i]);
//            }
//            for (int m = 0; m < list6.size(); m++) {
//                queryValue = list6.get(m);
//                String[] value = queryValue.split(";");
//                List<String> list = Arrays.asList(value);
//                ListIterator<String> li = list.listIterator();
//                while (li.hasNext()) {
//                    Object obj = li.next();
//                    if (obj.equals("0E-8")) {
//                        li.set("0.00000000");
//                    }
//                    if (obj.equals("null")) {
//                        li.set("");
//                    }
//                }
//                list7.add(list);
//
//            }
//        }
//        long totaPage = records % rows == 0 ? records / rows : records / rows + 1;
//        result.setPage(page);
//        result.setRecords(records);
//        result.setTotal((int) totaPage);
//        if (list7 != null) {
//            result.getRows().addAll(list7);
//        }
//        return result;
//    }
}
