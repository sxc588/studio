package com.github.support.service.mail;

import java.io.FileOutputStream;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.junit.Test;

/**
 * @ClassName: Sendmail
 * @Description: 发送Email
 * @author: 孤傲苍狼
 * @date: 2015-1-12 下午9:42:56
 *
 * 3.6、发送包含内嵌图片和附件的复杂邮件
 *
 */
public class SendMailService
{
	@Test
	public void sendMailmain() throws Exception
	{
		Properties prop = new Properties();
		prop.setProperty("mail.host", "smtp.exmail.qq.com");
		prop.setProperty("mail.transport.protocol", "smtp");
		prop.setProperty("mail.smtp.auth", "true");

		// 使用JavaMail发送邮件的5个步骤
		// 1、创建session
		Session session = Session.getInstance(prop);
		// 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
		session.setDebug(true);

		// 2、通过session得到transport对象
		Transport ts = session.getTransport();

		// 3、连上邮件服务器，需要发件人提供邮箱的用户名和密码进行验证
		ts.connect("smtp.exmail.qq.com", "54472951@qq.com", "86862362.t");

		// 4、创建邮件
		Message message = createImageMail(session);

		// 5、发送邮件
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
	public MimeMessage createImageMail(Session session) throws Exception
	{

		// 创建邮件
		MimeMessage message = new MimeMessage(session);

		// 设置邮件的基本信息-发件人
		message.setFrom(new InternetAddress("54472951@qq.com"));
		// 收件人
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("54472951@qq.com"));

		// 邮件标题
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
		// 将创建好的邮件写入到E盘以文件的形式进行保存
		message.writeTo(new FileOutputStream("E:\\ImageMail.eml"));
		// 返回创建好的邮件
		return message;
	}

	/**
	 * @Method: createMixedMail
	 * @Description: 生成一封带附件和带图片的邮件
	 * @Anthor:孤傲苍狼
	 *
	 * @param session
	 * @return
	 * @throws Exception
	 */
	public static MimeMessage createMixedMail(Session session) throws Exception
	{
		// 创建邮件
		MimeMessage message = new MimeMessage(session);

		// 设置邮件的基本信息
		message.setFrom(new InternetAddress("gacl@sohu.com"));
		message.setRecipient(Message.RecipientType.TO, new InternetAddress("xdp_gacl@sina.cn"));
		message.setSubject("带附件和带图片的的邮件");

		// 正文
		MimeBodyPart text = new MimeBodyPart();
		text.setContent("xxx这是女的xxxx<br/><img src='cid:aaa.jpg'>", "text/html;charset=UTF-8");

		// 图片
		MimeBodyPart image = new MimeBodyPart();
		image.setDataHandler(new DataHandler(new FileDataSource("src\\3.jpg")));
		image.setContentID("aaa.jpg");

		// 附件1
		MimeBodyPart attach = new MimeBodyPart();
		DataHandler dh = new DataHandler(new FileDataSource("src\\4.zip"));
		attach.setDataHandler(dh);
		attach.setFileName(dh.getName());

		// 附件2
		MimeBodyPart attach2 = new MimeBodyPart();
		DataHandler dh2 = new DataHandler(new FileDataSource("src\\波子.zip"));
		attach2.setDataHandler(dh2);
		attach2.setFileName(MimeUtility.encodeText(dh2.getName()));

		// 描述关系:正文和图片
		MimeMultipart mp1 = new MimeMultipart();
		mp1.addBodyPart(text);
		mp1.addBodyPart(image);
		mp1.setSubType("related");

		// 描述关系:正文和附件
		MimeMultipart mp2 = new MimeMultipart();
		mp2.addBodyPart(attach);
		mp2.addBodyPart(attach2);

		// 代表正文的bodypart
		MimeBodyPart content = new MimeBodyPart();
		content.setContent(mp1);
		mp2.addBodyPart(content);
		mp2.setSubType("mixed");

		message.setContent(mp2);
		message.saveChanges();

		message.writeTo(new FileOutputStream("E:\\MixedMail.eml"));
		// 返回创建好的的邮件
		return message;
	}
}