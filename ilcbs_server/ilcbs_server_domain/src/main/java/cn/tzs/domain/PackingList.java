//package cn.tzs.domain;
//
//import org.hibernate.annotations.DynamicInsert;
//import org.hibernate.annotations.DynamicUpdate;
//import org.hibernate.annotations.GenericGenerator;
//
//import javax.persistence.*;
//import java.io.Serializable;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Table(name="PACKING_LIST_C")
//@DynamicInsert(true)
//@DynamicUpdate(true)
//public class PackingList implements Serializable {
//	@Id
//	@Column(name="PACKING_LIST_ID")
//	@GeneratedValue(generator = "system-assigned")
//	@GenericGenerator(name = "system-assigned", strategy = "assigned")
//	private String id;//购销合同id
//
//	@Column(name = "SELLER")
//	private String seller;			//卖方
//	@Column(name = "BUYER")
//	private String buyer;			//买方
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "PACKING_LIST_ID")
//	private String invoiceNo;		//发票号 ---> 	一对一
//	@Column(name = "INVOICE_DATE")
//	@Temporal(TemporalType.TIMESTAMP)
//	private Date invoiceDate;		//发票日期
//	@Column(name = "MARKS")
//	private String marks;			//唛头
//
//	@Column(name = "DESCRIPTIONS")
//	private String description;		//描述
//	@Column(name = "EXPORT_IDS")
//	private String exportIds;		//EXPORT_IDS
//	@Column(name = "EXPORT_NOS")
//	private String exportNos;		//EXPORT_NOS
//	@Column(name = "STATE")
//	private Integer state;			//状态
//
//	@Column(name="CREATE_BY")
//	protected String createBy;		//创建者的id
//	@Column(name="CREATE_DEPT")
//	protected String createDept;	//创建者所在部门的id
//	@Column(name="CREATE_TIME")
//	@Temporal(TemporalType.TIMESTAMP)
//	protected Date createTime;		//创建时间
//
//
//}
