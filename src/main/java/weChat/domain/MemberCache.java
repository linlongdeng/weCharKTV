package weChat.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the wj_tbl_member_cache database table.
 * 
 */
@Entity
@Table(name="wj_tbl_member_cache")
@NamedQuery(name="MemberCache.findAll", query="SELECT m FROM MemberCache m")
public class MemberCache implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private String cacheid;

	private BigDecimal accountbalance;

	private BigDecimal accountcash;

	private BigDecimal accountpresent;

	@Temporal(TemporalType.DATE)
	private Date birthday;

	private String cardnum;

	private int companyid;

	private int consumeTimes;

	private BigDecimal consumeTotal;

	@Temporal(TemporalType.TIMESTAMP)
	private Date createCardTime;

	private int gradeID;

	private BigDecimal integralBalance;

	private String kmid;

	private int kmStatus;

	@Temporal(TemporalType.TIMESTAMP)
	private Date lastConsumeTime;

	private String memberid;

	private String memberName;

	private String mobile;

	private String paperNumber;

	private String paperType;

	private String sex;

	private String status;

	@Temporal(TemporalType.TIMESTAMP)
	private Date updateTime;

	@Temporal(TemporalType.TIMESTAMP)
	private Date useLimitDate;

	private int wechatPubInfoID;

	public MemberCache() {
	}

	public String getCacheid() {
		return this.cacheid;
	}

	public void setCacheid(String cacheid) {
		this.cacheid = cacheid;
	}

	public BigDecimal getAccountbalance() {
		return this.accountbalance;
	}

	public void setAccountbalance(BigDecimal accountbalance) {
		this.accountbalance = accountbalance;
	}

	public BigDecimal getAccountcash() {
		return this.accountcash;
	}

	public void setAccountcash(BigDecimal accountcash) {
		this.accountcash = accountcash;
	}

	public BigDecimal getAccountpresent() {
		return this.accountpresent;
	}

	public void setAccountpresent(BigDecimal accountpresent) {
		this.accountpresent = accountpresent;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getCardnum() {
		return this.cardnum;
	}

	public void setCardnum(String cardnum) {
		this.cardnum = cardnum;
	}

	public int getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(int companyid) {
		this.companyid = companyid;
	}

	public int getConsumeTimes() {
		return this.consumeTimes;
	}

	public void setConsumeTimes(int consumeTimes) {
		this.consumeTimes = consumeTimes;
	}

	public BigDecimal getConsumeTotal() {
		return this.consumeTotal;
	}

	public void setConsumeTotal(BigDecimal consumeTotal) {
		this.consumeTotal = consumeTotal;
	}

	public Date getCreateCardTime() {
		return this.createCardTime;
	}

	public void setCreateCardTime(Date createCardTime) {
		this.createCardTime = createCardTime;
	}

	public int getGradeID() {
		return this.gradeID;
	}

	public void setGradeID(int gradeID) {
		this.gradeID = gradeID;
	}

	public BigDecimal getIntegralBalance() {
		return this.integralBalance;
	}

	public void setIntegralBalance(BigDecimal integralBalance) {
		this.integralBalance = integralBalance;
	}

	public String getKmid() {
		return this.kmid;
	}

	public void setKmid(String kmid) {
		this.kmid = kmid;
	}

	public int getKmStatus() {
		return this.kmStatus;
	}

	public void setKmStatus(int kmStatus) {
		this.kmStatus = kmStatus;
	}

	public Date getLastConsumeTime() {
		return this.lastConsumeTime;
	}

	public void setLastConsumeTime(Date lastConsumeTime) {
		this.lastConsumeTime = lastConsumeTime;
	}

	public String getMemberid() {
		return this.memberid;
	}

	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPaperNumber() {
		return this.paperNumber;
	}

	public void setPaperNumber(String paperNumber) {
		this.paperNumber = paperNumber;
	}

	public String getPaperType() {
		return this.paperType;
	}

	public void setPaperType(String paperType) {
		this.paperType = paperType;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return this.updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getUseLimitDate() {
		return this.useLimitDate;
	}

	public void setUseLimitDate(Date useLimitDate) {
		this.useLimitDate = useLimitDate;
	}

	public int getWechatPubInfoID() {
		return this.wechatPubInfoID;
	}

	public void setWechatPubInfoID(int wechatPubInfoID) {
		this.wechatPubInfoID = wechatPubInfoID;
	}

}