package weChat.web;

import java.io.IOException;
import java.util.Map;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;

import weChat.core.metatype.BaseDto;
import weChat.json.PostJsonUtils;
import weChat.parameter.impl.RReqParam;
import weChat.parameter.impl.RRespParam;

public class WechatMqControllerTest {

	
	@Test
	public void testController() throws JsonGenerationException, JsonMappingException, IOException{
		String actionPath ="/RabbitmqRpc";
		RReqParam param = new RReqParam();
		param.setCmdid("WJ007");
		//可以
		param.setCompanycode("06375"); 
		//param.setCompanycode("01266");
		param.setWechatpubinfoid(1);
		BaseDto dto = new BaseDto();
		dto.put("cardnum", "10000582");
		param.setParams(dto);
		Map<String, Object> result = PostJsonUtils.postObject(actionPath, param);
		System.out.println(result);
	}
	@Test
	public void testHttp() throws JsonGenerationException, JsonMappingException, IOException{
		PostJsonUtils.ip ="http://192.168.82.67:3002";
		String actionPath ="";
		RReqParam param = new RReqParam();
		param.setCmdid("WJ007");
		//param.setCompanycode("06375"); 
		param.setCompanycode("01266");
		param.setWechatpubinfoid(1);
		BaseDto dto = new BaseDto();
		dto.put("cardnum", "10000582");
		param.setParams(dto);
		Map<String, Object> result = PostJsonUtils.postObject(actionPath, param);
		System.out.println(result);
	}
}
