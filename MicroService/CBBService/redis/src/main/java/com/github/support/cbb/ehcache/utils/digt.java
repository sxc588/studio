/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.github.support.cbb.ehcache.utils;
import java.security.*;
import java.io.*;
import java.util.*;
import java.security.cert.*;
import sun.security.x509.*;
import java.security.cert.Certificate;
import org.apache.log4j.Logger;

public class digt
{
	/**
	 * 01 . 用keytool将.keystore中的证书写入文件中 然后从该文件中读取证书信息
	 * 
	 * @throws CertificateException
	 * @throws FileNotFoundException
	 */
	private void digt01() throws CertificateException, FileNotFoundException
	{
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream in = new FileInputStream("out.csr");
		Certificate c = cf.generateCertificate(in);
		String s = c.toString();
	}

	/**
	 * 02.从密钥库中直接读取证书 然后从该文件中读取证书信息
	 * 
	 * @throws CertificateException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private void digt02(String alias) throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException
	{
		String pass = "123456";
		FileInputStream in = new FileInputStream(".keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(in, pass.toCharArray());

		java.security.cert.Certificate c = ks.getCertificate(alias);// alias为条目的别名
	}

	/**
	 * 03.JAVA程序中显示证书指定信息 然后从该文件中读取证书信息
	 * 
	 * @throws CertificateException
	 */
	private void digt03(Certificate c) throws CertificateException
	{
		System.out.println("输出证书信息:\n" + c.toString());

//		System.out.println("版本号:" + t.getVersion());
//		System.out.println("序列号:" + t.getSerialNumber().toString(16));
//		System.out.println("主体名：" + t.getSubjectDN());
//		System.out.println("签发者：" + t.getIssuerDN());
//		System.out.println("有效期：" + t.getNotBefore());
//		System.out.println("签名算法：" + t.getSigAlgName());
//		byte[] sig = t.getSignature();// 签名值
//		PublicKey pk = t.getPublicKey();
//		byte[] pkenc = pk.getEncoded();
//		System.out.println("公钥");
//		for (int i = 0; i < pkenc.length; i++)
//			System.out.print(pkenc[i] + ",");
	}

	/**
	 * 04.JAVA程序列出密钥库所有条目 然后从该文件中读取证书信息
	 * 
	 * @throws CertificateException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private void digt04() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException
	{
		String pass = "123456";
		FileInputStream in = new FileInputStream(".keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(in, pass.toCharArray());
		Enumeration e = ks.aliases();
		while (e.hasMoreElements())
		{
			java.security.cert.Certificate c = ks.getCertificate((String) e.nextElement());
		}
	}

	/**
	 * 05.JAVA程序修改密钥库口令 然后从该文件中读取证书信息
	 * 
	 * @throws CertificateException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private void digt05() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException
	{
		String oldpass = "123456";
		String newpass = "654321";
		FileInputStream in = new FileInputStream(".keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(in, oldpass.toCharArray());
		in.close();
		FileOutputStream output = new FileOutputStream(".keystore");
		ks.store(output, newpass.toCharArray());
		output.close();
	}

	/**
	 * 06.JAVA程序修改密钥库口令 然后从该文件中读取证书信息
	 * 
	 * @param newkeypass
	 * @param oldkeypass
	 * @throws CertificateException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private void digt06(String storepass, String alias, String newkeypass, String oldkeypass)
																									throws CertificateException,
																								KeyStoreException,
																								NoSuchAlgorithmException,
																								IOException
	{
//		FileInputStream in = new FileInputStream(".keystore");
//		KeyStore ks = KeyStore.getInstance("JKS");
//		ks.load(in, storepass.toCharArray());
//		Certificate[] cchain = ks.getCertificate(alias);// 获取别名对应条目的证书链
//		PrivateKey pk = (PrivateKey) ks.getKey(alias, oldkeypass.toCharArray());// 获取别名对应条目的私钥
//		ks.setKeyEntry(alias, pk, newkeypass.toCharArray(), cchain);// 向密钥库中添加条目
//		// 第一个参数指定所添加条目的别名，
//		// 假如使用已存在别名将覆盖已存在条目，使用新别名将增加一个新条目，
//		// 第二个参数为条目的私钥，第三个为设置的新口令，第四个为该私钥的公钥的证书链
//		FileOutputStream output = new FileOutputStream("another");
//		ks.store(output, storepass.toCharArray());// 将keystore对象内容写入新文件
	}

	/**
	 * 07.JAVA程序修改密钥库条目的口令及添加条目 然后从该文件中读取证书信息
	 * 
	 * @param storepass
	 * @throws CertificateException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private void digt07(String storepass) throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException
	{

//		FileInputStream in = new FileInputStream(".keystore");
//		KeyStore ks = KeyStore.getInstance("JKS");
//		ks.load(in, storepass.toCharArray());
//		Certificate[] cchain = ks.getCertificate(alias);// 获取别名对应条目的证书链
//		PrivateKey pk = (PrivateKey) ks.getKey(alias, oldkeypass.toCharArray());// 获取别名对应条目的私钥
//		ks.setKeyEntry(alias, pk, newkeypass.toCharArray(), cchain);// 向密钥库中添加条目
//		// 第一个参数指定所添加条目的别名，假如使用已存在别名将覆盖已存在条目，使用新别名将增加一个新条目，
//		// 第二个参数为条目的私钥，第三个为设置的新口令，第四个为该私钥的公钥的证书链
//		FileOutputStream output = new FileOutputStream("another");
//		ks.store(output, storepass.toCharArray());// 将keystore对象内容写入新文件
	}

/**
 * 08：JAVA程序检验别名和删除条目
 * 然后从该文件中读取证书信息
 * @throws CertificateException 
 * @throws KeyStoreException 
 * @throws IOException 
 * @throws NoSuchAlgorithmException 
 */
private void digt08() throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException
{
//	   FileInputStream in=new FileInputStream(".keystore");
//	    KeyStore ks=KeyStore.getInstance("JKS");
//	    ks.load(in,storepass.toCharArray());
//	    Certificate [] cchain=ks.getCertificate(alias);获取别名对应条目的证书链
//	    PrivateKey pk=(PrivateKey)ks.getKey(alias,oldkeypass.toCharArray());获取别名对应条目的私钥
//	    ks.setKeyEntry(alias,pk,newkeypass.toCharArray(),cchain);向密钥库中添加条目
//	    第一个参数指定所添加条目的别名，假如使用已存在别名将覆盖已存在条目，使用新别名将增加一个新条目，第二个参数为条目的私钥，第三个为设置的新口令，第四个为该私钥的公钥的证书链
//	    FileOutputStream output=new FileOutputStream("another");
//	    ks.store(output,storepass.toCharArray())将keystore对象内容写入新文件
}

	/**
	 * 09：JAVA程序检验别名和删除条目 然后从该文件中读取证书信息
	 * 
	 * @param storepass
	 * @param cakeypass
	 * @param alias
	 * @throws CertificateException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 * @throws SignatureException
	 * @throws NoSuchProviderException
	 * @throws InvalidKeyException
	 * @throws UnrecoverableKeyException 
	 */
	private void digt09(String storepass, String cakeypass, String alias)
																				throws CertificateException,
																			KeyStoreException,
																			NoSuchAlgorithmException,
																			IOException,
																			InvalidKeyException,
																			NoSuchProviderException,
																			SignatureException, UnrecoverableKeyException
	{
		// （1）从密钥库中读取CA的证书
		FileInputStream in = new FileInputStream(".keystore");
		KeyStore ks = KeyStore.getInstance("JKS");
		ks.load(in, storepass.toCharArray());
		java.security.cert.Certificate c1 = ks.getCertificate("caroot");
		// （2）从密钥库中读取CA的私钥
		PrivateKey caprk = (PrivateKey) ks.getKey(alias, cakeypass.toCharArray());
		// （3）从CA的证书中提取签发者的信息
		byte[] encod1 = c1.getEncoded(); // 提取CA证书的编码
		X509CertImpl cimp1 = new X509CertImpl(encod1); // 用该编码创建X509CertImpl类型对象
		X509CertInfo cinfo1 = (X509CertInfo) cimp1.get(X509CertImpl.NAME + "." + X509CertImpl.INFO);// 获取X509CertInfo对象
		X500Name issuer = (X500Name) cinfo1.get(X509CertInfo.SUBJECT + "." + CertificateIssuerName.DN_NAME); // 获取X509Name类型的签发者信息
		// （4）获取待签发的证书
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		FileInputStream in2 = new FileInputStream("user.csr");
		java.security.cert.Certificate c2 = cf.generateCertificate(in);
		// （5）从待签发的证书中提取证书信息
		byte[] encod2 = c2.getEncoded();
		X509CertImpl cimp2 = new X509CertImpl(encod2); // 用该编码创建X509CertImpl类型对象
		X509CertInfo cinfo2 = (X509CertInfo) cimp2.get(X509CertImpl.NAME + "." + X509CertImpl.INFO); // 获取X509CertInfo对象
		// （6）设置新证书有效期
		Date begindate = new Date();// 获取当前时间
		Date enddate = new Date(begindate.getTime() + 3000 * 24 * 60 * 60 * 1000L); // 有效期为3000天
		CertificateValidity cv = new CertificateValidity(begindate, enddate); // 创建对象
		cinfo2.set(X509CertInfo.VALIDITY, cv);// 设置有效期
		// （7）设置新证书序列号
		int sn = (int) (begindate.getTime() / 1000); // 以当前时间为序列号
		CertificateSerialNumber csn = new CertificateSerialNumber(sn);
		cinfo2.set(X509CertInfo.SERIAL_NUMBER, csn);
		// （8）设置新证书签发者
		cinfo2.set(X509CertInfo.ISSUER + "." + CertificateIssuerName.DN_NAME, issuer);// 应用第三步的结果
		// （9）设置新证书签名算法信息
		AlgorithmId algorithm = new AlgorithmId(AlgorithmId.md5WithRSAEncryption_oid);
		cinfo2.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algorithm);
		// （10）创建证书并使用CA的私钥对其签名
		X509CertImpl newcert = new X509CertImpl(cinfo2);
		newcert.sign(caprk, "MD5WithRSA");// 使用CA私钥对其签名
		// （11）将新证书写入密钥库
		ks.setCertificateEntry("lf_signed", newcert);
	}

	/**
	 * 10：JAVA程序检验别名和删除条目 然后从该文件中读取证书信息
	 * 
	 * @param in2
	 * @throws CertificateException
	 * @throws KeyStoreException
	 * @throws IOException
	 * @throws NoSuchAlgorithmException
	 */
	private void digt10(FileInputStream in2) throws CertificateException, KeyStoreException, NoSuchAlgorithmException, IOException
	{
		// （1）验证证书的有效期
		// （a）获取X509Certificate类型对象
//
//		CertificateFactory cf = CertificateFactory.getInstance("X.509");
//		FileInputStream in1 = new FileInputStream("aa.crt");
//		java.security.cert.Certificate c1 = cf.generateCertificate(in1);
//		X509Certificate t = (X509Certificate) c1;
//		in2.close();
//		// （b）获取日期
//		Date TimeNow = new Date();
//		// （c）检验有效性
//		try
//		{
//			t.checkValidity(TimeNow);
//			System.out.println("OK");
//		}
//		catch (CertificateExpiredException e)
//		{ // 过期
//			System.out.println("Expired");
//			System.out.println(e.getMessage());
//		}
//		catch (CertificateNotYetValidException e)
//		{ // 尚未生效
//			System.out.println("Too early");
//			System.out.println(e.getMessage());
//		}
//
//		// （2）验证证书签名的有效性
//		// （a）获取CA证书
//		{
//			CertificateFactory cf = CertificateFactory.getInstance("X.509");
//			FileInputStream in3 = new FileInputStream("caroot.crt");
//			java.security.cert.Certificate cac = cf.generateCertificate(in3);
//			in3.close();
//			// （c）获取CA的公钥
//			PublicKey pbk = cac.getPublicKey();
//			// （b）获取待检验的证书（上步已经获取了，就是C1）
//			// （c）检验证书
//			boolean pass = false;
//			try
//			{
//				c1.verify(pbk);
//				pass = true;
//			}
//			catch (Exception e)
//			{
//				pass = false;
//				System.out.println(e);
//			}
//			// 1019 8.37
//		}
	}

}
