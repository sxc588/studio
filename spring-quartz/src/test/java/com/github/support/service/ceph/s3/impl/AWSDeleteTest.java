package com.github.support.service.ceph.s3.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.camel.EndpointConfiguration;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.github.support.controller.debug.BeanController;
import com.github.support.service.ceph.s3.S3HellowWorld;
import com.github.support.service.ceph.s3.S3bucket;
import com.github.support.service.ceph.s3.S3object;
import com.github.support.service.ceph.s3.S3rgw;

/**
 * 遍历文件
 * 
 * @author liuwei117
 *
 */
public class AWSDeleteTest extends AWSBaseTest
{
	private static Logger logger = LoggerFactory.getLogger(AWSDeleteTest.class);

	// 本地的一个文件
	private File file = new File("E:" + File.separator + "EliteClient2017060710.log");

	private String managecom = "1";
	private String salecom = "1TT";
	private String contno = "12345678";
	private String recordid = "11111111";

	// 这里做一下目录分级：上传的文件放在1/1TT/下面
	// private String key = managecom + "/" + salecom + "/" + file.getName();
	private String key = "1/1TT/11111111";
	@Test
	public void deleteObject()
	{
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();

		try
		{
			clientConfig.setProtocol(Protocol.HTTP);

			AmazonS3Client conn = new AmazonS3Client(credentials, clientConfig);
			conn.setEndpoint(ENDPOINT);

			conn.deleteObject(bucket_name, key);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test
	public void deleteObjectWithClientBuilder()
	{
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();

		try
		{
			clientConfig.setProtocol(Protocol.HTTP);

//			AmazonS3ClientBuilder builder = AmazonS3ClientBuilder.standard()
//					.withCredentials(new AWSStaticCredentialsProvider(credentials));
//			EndpointConfiguration endpointConfiguration = new EndpointConfiguration(
//					ENDPOINT,
//					Regions.AP_SOUTHEAST_1.getName());
//			builder.setEndpointConfiguration(endpointConfiguration);
//
//			AmazonS3 conn = builder.build();
//
//			conn.deleteObject(bucket_name, key);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
