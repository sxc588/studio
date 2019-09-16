package com.github.support.service.ceph.s3;

/**
 * 
 * s3对象操作功能开发可以分为三个部分： 1.rgw网关连接 2.bucket桶操作 3.object对象操作。
 * 
 * @author Administrator
 *
 */
public interface S3rgw {
	/**
	 * 新建AmazonS3对象，连接对象网关：
	 */
	String rgwConnect();
}
