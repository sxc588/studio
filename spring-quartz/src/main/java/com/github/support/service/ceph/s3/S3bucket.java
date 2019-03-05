package com.github.support.service.ceph.s3;

import java.util.List;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ObjectListing;

public interface S3bucket
{
	
	/**
	 * 查看所有bucket：
	 * @return
	 */
	 List<Bucket> S3bucketLst();
	
	/**
	 * 创建bucket：
	 * @return
	 */
	 Bucket S3bucketCreate();
	
	/**
	 * 
	 *删除bucket：
	 */
	 Bucket S3bucketDelete();
	
	/**
	 * 列出指定bucket中的对象：
	 */
	ObjectListing S3bucketObjectList();
}
