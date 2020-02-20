package com.github.support.service.ceph.s3.impl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazonaws.services.s3.model.S3ObjectSummary;
import com.github.support.service.ceph.s3.S3HellowWorld;
import com.github.support.service.ceph.s3.S3bucket;
import com.github.support.service.ceph.s3.S3object;
import com.github.support.service.ceph.s3.S3rgw;

public class S3Impl implements S3bucket, S3object, S3rgw, S3HellowWorld
{

	private static Logger logger = LoggerFactory.getLogger(S3Impl.class);

	final String accessKey = "xxxxx";
	final String bucket_name = "bucket";
	// 测试环境
	final String ENDPOINT = "http://10.0.0.12:8080";
	final String secretKey = "yyyyy";

	@Override
	public void helloWord()
	{
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();

		try
		{
			clientConfig.setProtocol(Protocol.HTTP);

			AmazonS3Client amazonS3 = new AmazonS3Client(credentials, clientConfig);
			amazonS3.setEndpoint(ENDPOINT);

			List<Bucket> listBuckets = amazonS3.listBuckets();
			for (Bucket bucket : listBuckets)
			{
				logger.info(bucket.getName());
			}

			ObjectListing objects = amazonS3.listObjects(bucket_name);
			do
			{
				for (S3ObjectSummary objectSummary : objects.getObjectSummaries())
				{
					logger.info("\t" + objectSummary.getKey() + "\t" + objectSummary.getSize() + "\t"
							+ objectSummary.getOwner() + "\t" + objectSummary.getLastModified().toString());

				}
			} while (objects.isTruncated());

			System.out.println("Uploading a new object to S3 from a file\n");

			AmazonS3Client s3Client = amazonS3;

			// 枚举bucket
			List<Bucket> buckets = s3Client.listBuckets();
			for (Bucket bucket : buckets)
			{
				System.out.println("Bucket: " + bucket.getName());
			}

			// 文件上传
			try
			{
				s3Client.putObject("bucketname", "keyname", new File("your file path"));
			} catch (AmazonServiceException e)
			{
				System.err.println(e.getErrorMessage());
				System.exit(1);
			}

			// 文件下载
			try
			{
				S3Object o = s3Client.getObject("bucketname", "your file's keyname");
				S3ObjectInputStream s3is = o.getObjectContent();
				FileOutputStream fos = new FileOutputStream(new File("your save file path"));
				byte[] read_buf = new byte[1024];
				int read_len = 0;
				while ((read_len = s3is.read(read_buf)) > 0)
				{
					fos.write(read_buf, 0, read_len);
				}
				s3is.close();
				fos.close();
			} catch (AmazonServiceException e)
			{
				System.err.println(e.getErrorMessage());
				System.exit(1);
			} catch (FileNotFoundException e)
			{
				System.err.println(e.getMessage());
				System.exit(1);
			} catch (IOException e)
			{
				System.err.println(e.getMessage());
				System.exit(1);
			}

		} catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Override
	public String rgwConnect()
	{
		AWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

		ClientConfiguration clientConfig = new ClientConfiguration();

		try
		{
			clientConfig.setProtocol(Protocol.HTTP);

			AmazonS3Client amazonS3 = new AmazonS3Client(credentials, clientConfig);
			amazonS3.setEndpoint(ENDPOINT);

			List<Bucket> listBuckets = amazonS3.listBuckets();
			for (Bucket bucket : listBuckets)
			{
				logger.info(bucket.getName());

			}

			ObjectListing objects = amazonS3.listObjects(bucket_name);
			do
			{
				for (S3ObjectSummary objectSummary : objects.getObjectSummaries())
				{
					logger.info("\t" + objectSummary.getKey() + "\t" + objectSummary.getSize() + "\t"
							+ objectSummary.getOwner() + "\t" + objectSummary.getLastModified().toString());

				}
			} while (objects.isTruncated());

		} catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bucket S3bucketCreate()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bucket S3bucketDelete()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bucket> S3bucketLst()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void s3BucketobjectCreate()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void s3BucketobjectDelete()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void s3BucketobjectDownload()
	{
		// TODO Auto-generated method stub

	}

	@Override
	public ObjectListing S3bucketObjectList()
	{
		// TODO Auto-generated method stub
		return null;
	}
}
