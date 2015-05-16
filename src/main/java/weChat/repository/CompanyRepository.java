package weChat.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import weChat.domain.Company;

public interface CompanyRepository extends JpaRepository<Company, Integer> {

	/**
	 * 通过商家编号查找商家信息
	 * 
	 * @param companyCode
	 * @return
	 */
	public Company findFirstByCompanyCode(String companyCode);
}