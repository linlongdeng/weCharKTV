package weChat.utils;

import org.springframework.util.Assert;

import weChat.core.metatype.Dto;
import weChat.core.utils.CommonUtils;
import weChat.domain.primary.Company;
import weChat.domain.primary.Companywechatpub;
import weChat.domain.primary.Interfacecheck;
import weChat.domain.primary.Wechatpubinfo;
import static weChat.utils.AppConstants.*;

/**
 * 一些方法集合
 * 
 * @author deng
 * @date 2015年6月4日
 * @version 1.0.0
 */
public abstract class AppUtils {
	/**
	 * 判断code是否和success_code相等，如果不等，返回false,如果相等，返回true
	 * 
	 * @param code
	 * @return
	 */
	public static boolean checkSuccess(int code) {
		return RespMsgCode.SUCCESS_CODE == code;
	}

	public static void assertCompanyNotNull(Company company) {
		Assert.notNull(company, "商家信息不能为空");
	}

	/**
	 * 商家密码是否正确
	 * 
	 * @param companypsw
	 * @param company
	 */
	public static void assertCompanyPassError(String companypsw, Company company) {
		Assert.isTrue(company.getCompanyPsw().equals(companypsw), "商家密码错误");
	}

	/**
	 * 微信公众号是否存在
	 * 
	 * @param wechatpubinfo
	 */
	public static void assertWechatpubinfoNotNull(Wechatpubinfo wechatpubinfo) {
		Assert.notNull(wechatpubinfo, "微信公众号不存在");
	}

	/**
	 * 根据返回参数，判断微信接口调用是否成功,如果接口调用成功返回true,否则返回失败。
	 * 
	 * @param pDto
	 * @return
	 */
	public static boolean checkWeixinApi(Dto pDto) {
		// 查询errcode是否存在，如果不存在，肯定调用成功
		Integer errcode = pDto.getAsInteger(WEIXIN_ERRCODE);
		if (CommonUtils.isEmpty(errcode)) {
			return true;
		} else {
			// 如果errcode，则看一下是否等于0
			if (WEIXIN_SUCCESS == errcode) {
				return true;
			} else {
				return false;
			}
		}
	}

	public static void assertInterfacecheckNotNull(Interfacecheck interfacecheck) {
		Assert.notNull(interfacecheck, "K米应用授权失败");
	}

	public static void assertTrueAccess(boolean flag) {
		Assert.isTrue(flag, "权限验证失败");
	}
	

	public static void assertWechatNotNull(Companywechatpub companywechatpub) {
		Assert.notNull(companywechatpub, "商家公众号信息验证失败");

	}
	

}
