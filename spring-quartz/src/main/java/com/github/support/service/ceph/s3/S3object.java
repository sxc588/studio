package com.github.support.service.ceph.s3;

public interface S3object
{
	/**
	 * 创建对象：
	 */
	void s3BucketobjectCreate();
	
	/**
	 * 下载对象：
	 */
	void s3BucketobjectDownload();
	
	/**
	 * 删除对象：
	 */
	void s3BucketobjectDelete();
}
