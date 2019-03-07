package src.test.java.com.github.support.mail;

package src.test.java.com.github.support.mail;

import java.io.FileOutputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import java.io.FileOutputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
* @ClassName: Sendmail
* @Description: 发送Email
* @author: 孤傲苍狼
* @date: 2015-1-12 下午9:42:56
*发送包含内嵌图片的邮件
*/ 
public class Sendmail4

	    /**
	     * @param args
	     * @throws Exception 
	     */
	    public static void main(String[] args) throws Exception {
	        
	        Properties prop = new Properties();
	        prop.setProperty("mail.host", "smtp.sohu.com");
	        prop.setProperty("mail.transport.protocol", "smtp");
	        prop.setProperty("mail.smtp.auth", "true");
	        //使用JavaMail发送邮件的5个步骤
	        //1、创建session
	        Session session = Session.getInstance(prop);
	        //开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
	        session.setDebug(true);
	        //2、通过session得到transport对象
	        Transport ts = session.getTransport();
	        //3、连上邮件服务器，需要发件人提供邮箱的用户名和密码进行验证
	        ts.connect("smtp.sohu.com", "gacl", "邮箱密码");
	        //4、创建邮件
	        Message message = createImageMail(session);
	        //5、发送邮件
	        ts.sendMessage(message, message.getAllRecipients());
	        ts.close();
	    }
	    
	    /**
	    * @Method: createImageMail
	    * @Description: 生成一封邮件正文带图片的邮件
	    * @Anthor:孤傲苍狼
	    *
	    * @param session
	    * @return
	    * @throws Exception
	    */ 
	    public static MimeMessage createImageMail(Session session) throws Exception {
	        //创建邮件
	        MimeMessage message = new MimeMessage(session);
	        // 设置邮件的基本信息
	        //发件人
	        message.setFrom(new InternetAddress("gacl@sohu.com"));
	        //收件人
	        message.setRecipient(Message.RecipientType.TO, new InternetAddress("xdp_gacl@sina.cn"));
	        //邮件标题
	        message.setSubject("带图片的邮件");

	        // 准备邮件数据
	        // 准备邮件正文数据
	        MimeBodyPart text = new MimeBodyPart();
	        text.setContent("这是一封邮件正文带图片<img src='cid:xxx.jpg'>的邮件", "text/html;charset=UTF-8");
	        // 准备图片数据
	        MimeBodyPart image = new MimeBodyPart();
	        DataHandler dh = new DataHandler(new FileDataSource("src\\1.jpg"));
	        image.setDataHandler(dh);
	        image.setContentID("xxx.jpg");
	        // 描述数据关系
	        MimeMultipart mm = new MimeMultipart();
	        mm.addBodyPart(text);
	        mm.addBodyPart(image);
	        mm.setSubType("related");

	        message.setContent(mm);
	        message.saveChanges();
	        //将创建好的邮件写入到E盘以文件的形式进行保存
	        message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
	        //返回创建好的邮件
	        return message;
	    }
	}