package com.luzhoumin.mblog.management.constant;

/**
 * 常量类
 */
public class MBlogConstant {
	//UNKNOWN
	public static final String UNKNOWN = "UNKNOWN";

	/*Http请求*/
	//文件系统接口 开始
	public static final String HTTP_FILE_UPLOAD = "httpFileUpload";
	public static final String HTTP_CHECK_FILE_EXIST = "httpCheckFileExist";
	//文件系统接口 结束

	//列表页默认一页的条数
	public static final int LIST_DEFAULT_PAGE_SIZE = 10;

	//Session-忘记密码-验证码
	public static final String SESSION_M_VERIFICATION_CODE_FOR_RESET_PASSWORD = "verificationCodeForResetPassword";
	//Session-登陆后-用户名
	public static final String SESSION_M_USER_NAME = "sessionMUserName";
	//Session-登陆后-用户Uid
	public static final String SESSION_M_USER_UID = "sessionMUserUid";
}
