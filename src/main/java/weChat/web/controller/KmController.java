package weChat.web.controller;

import static weChat.utils.AppConstants.WJMQ_CMDID;
import static weChat.utils.AppConstants.WJMQ_PARAM;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import weChat.core.exception.ArgumentErrorException;
import weChat.core.metatype.BaseDto;
import weChat.core.metatype.Dto;
import weChat.core.utils.CommonUtils;
import weChat.domain.primary.Company;
import weChat.domain.primary.Companywechatpub;
import weChat.parameter.IRespParam;
import weChat.parameter.impl.KDynamicReqParam;
import weChat.parameter.impl.RReqParam;
import weChat.repository.primary.CompanyRepository;
import weChat.repository.primary.CompanywechatpubRepository;
import weChat.repository.primary.WechatpubinfoRepository;
import weChat.service.AuthService;
import weChat.service.KmService;
import weChat.service.KmbindcardService;
import weChat.service.ValidationService;
import static weChat.utils.AppConstants.*;
import weChat.utils.AppConstants;
import weChat.utils.AppUtils;
import weChat.utils.RespUtils;

@RestController
@RequestMapping("/Km")
public class KmController {
	@Autowired
	private KmService kmService;

	


	@RequestMapping("/bindCardInfo")
	public IRespParam bindCardInfo(@ModelAttribute(COMPANY) Company company,
			@ModelAttribute(OTHER_PARAM) Dto otherParam,
			@ModelAttribute(AppConstants.WECHATPUBINFOID) int wechatpubinfoid) throws Exception {
		IRespParam resp = kmService.bindCardInfo(company, otherParam, wechatpubinfoid);
		return resp;

	}


}
