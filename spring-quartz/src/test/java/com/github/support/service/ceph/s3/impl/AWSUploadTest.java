package com.github.support.service.ceph.s3.impl;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GeneratePresignedUrlRequest;
import com.amazonaws.services.s3.model.ObjectMetadata;

/**
 * 上传文件
 * 
 * @author liuwei117
 *
 */
public class AWSUploadTest extends AWSBaseTest {
	private static Logger logger = LoggerFactory.getLogger(AWSUploadTest.class);

	private String contno = "12345678";

	// 本地的一个文件
	private File file = new File("E:" + File.separator + "EliteClient2017060710.log");
	// 这里做一下目录分级：上传的文件放在1/1TT/下面
	private String key = managecom + "/" + salecom + "/" + file.getName();
	private String managecom = "1";
	private String recordid = "11111111";

	private String salecom = "1TT";

	@Test
	public void listObjectWithClientBuilder() {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();

		try {
//			clientConfig.setProtocol(Protocol.HTTP);
//
//			AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard()
//					.withCredentials(new AWSStaticCredentialsProvider(credentials));
//			EndpointConfiguration endpointConfiguration = new EndpointConfiguration(
//					ENDPOINT,
//					Regions.AP_SOUTHEAST_1.getName());
//			builder.setEndpointConfiguration(endpointConfiguration);
//
//			AmazonS3 conn = builder.build();
//
//			ObjectMetadata metadata = new ObjectMetadata();
//			metadata.setContentLength(file.length());
//
//			metadata.addUserMetadata("managecom", managecom); // 可以设置一些属性，如公司码 =
//																// 1
//			metadata.addUserMetadata("salecom", salecom);
//			metadata.addUserMetadata("contno", contno);
//			metadata.addUserMetadata("recordid", recordid);
//
//			FileInputStream fi = new FileInputStream(file);
//
//			conn.putObject(new PutObjectRequest(bucket_name, key, fi, metadata));
			// conn.putObject(new PutObjectRequest(bucket_name, key, file));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void UploadObject() {
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();

		try {
			clientConfig.setProtocol(Protocol.HTTP);

			AmazonS3Client conn = new AmazonS3Client(credentials, clientConfig);
			conn.setEndpoint(ENDPOINT);

			ObjectMetadata metadata = new ObjectMetadata();
			metadata.setContentLength(file.length());

			metadata.addUserMetadata("managecom", managecom); // 可以设置一些属性，如公司码 =
																// 1
			metadata.addUserMetadata("salecom", salecom);
			metadata.addUserMetadata("contno", contno);
			metadata.addUserMetadata("recordid", recordid);

			FileInputStream fi = new FileInputStream(file);

			// 这里用managecom/salecom/filename作为文件的key,相当bucketName是一个根目录，创建了一级目录managecom和二级目录salecom，再放进去了一个文件
			conn.putObject(bucket_name, key, fi, metadata);
			// conn.putObject(new PutObjectRequest(bucket_name, key, file));

			// 将上传了的文件生成一个url连接，可以直接通过url连接访问文件
			GeneratePresignedUrlRequest urlRequest = new GeneratePresignedUrlRequest(bucket_name, key);
			URL url = conn.generatePresignedUrl(urlRequest);

			logger.info("[" + key + "]'s url is " + url);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
