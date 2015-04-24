package weChat.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weChat.domain.Gradecollect;
import weChat.parameter.manage.MRequestParam;
import weChat.parameter.manage.MResponseParam;
import weChat.repository.GradecollectRepository;
import weChat.service.GradecollectService;
import weChat.utils.ResponseUtils;

@Service
public class GradecollectServiceImpl implements GradecollectService {

	@Autowired
	private GradecollectRepository gradecollectRepository;

	@Autowired
	private EntityManager entityManager;

	@Override
	public MResponseParam syncGrade(MRequestParam param) {
		List<Map<String, Object>> data = param.getData();
		String companycode = param.getCompanycode();
		String wechatPubInfoID = param.getWechatPubInfoID();
		if (data != null) {
			for (Map<String, Object> map : data) {
				Integer gradeid = (Integer) map.get("gradeid");
				 gradecollectRepository.findAll();
				Gradecollect gradecollect = gradecollectRepository
						.findFirstByCompanyidAndWechatpubinfoidAndGradeid(
								Integer.valueOf(companycode),
								Integer.valueOf(wechatPubInfoID), gradeid);
				String gradecode = (String) map.get("gradecode");
				String gradename = (String) map.get("gradename");
				Integer status = (Integer) map.get("status");
				if (gradecollect == null) {
					gradecollect = new Gradecollect();
					// 有问题
					gradecollect.setCompanyid(Integer.valueOf(companycode));
					// 格式不对
					gradecollect.setWechatpubinfoid(Integer
							.valueOf(wechatPubInfoID));
					// 格式不对
					gradecollect.setGradecollectid(Integer.valueOf(gradeid));
				}
				gradecollect.setGradecode(gradecode);
				gradecollect.setGradename(gradename);
				gradecollect.setStatus(status.byteValue());
				gradecollect.setCreatetime(new Date());
				gradecollect.setUpdatetime(new Date());
				gradecollectRepository.save(gradecollect);
			}
		}
		return ResponseUtils.successMR();
	}
}