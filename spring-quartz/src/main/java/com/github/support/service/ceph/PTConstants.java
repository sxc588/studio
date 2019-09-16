package com.github.support.service.ceph;

public interface PTConstants {
	/***
	 * 删除状态
	 */
	public static enum DeleteStatus {
		DELETE("1", "DELETE", "删除"), NORMAL("0", "NORMAL", "正常");
		private final String desc;
		private final String name;
		private final String value;

		private DeleteStatus(String value, String name, String desc) {
			this.value = value;
			this.name = name;
			this.desc = desc;
		}

		public String getDesc() {
			return desc;
		}

		public String getName() {
			return name;
		}

		public String getValue() {
			return value;
		}
	}

	/***
	 * Result code
	 */
	public static enum ResultCode {
		/** 发生异常 */
		EXCEPTION("401", "发生异常"),
		/** AuthCode错误 */
		INVALID_AUTHCODE("444", "无效的AuthCode"),
		/** 没有登录 */
		NOT_LOGIN("400", "没有登录"),

		/** 不支持或已经废弃 */
		NOT_SUPPORTED("410", "不支持或已经废弃"),

		NULL_DATA("205", "无数据"),

		/** 参数错误 */
		PARAMS_ERROR("403", "参数错误 "),

		/** 成功 */
		SUCCESS("200", "成功"),

		/** 系统错误 */
		SYS_ERROR("402", "系统错误"),

		/** 太频繁的调用 */
		TOO_FREQUENT("445", "太频繁的调用"),

		/** 未知的错误 */
		UNKNOWN_ERROR("499", "未知错误");

		private String msg;

		private String val;

		private ResultCode(String value, String msg) {
			this.val = value;
			this.msg = msg;
		}

		public String msg() {
			return msg;
		}

		public String val() {
			return val;
		}
	}

}