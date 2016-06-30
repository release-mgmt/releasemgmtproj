package com.evaluation.pojo;

import java.util.Date;
import java.util.List;

import javax.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "iteration_info")
public class IterationInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "iteration_id")
	private int iterationId;

	@ManyToOne
	@JoinColumn(name = "iteration_for_release", referencedColumnName = "release_id")
	//@JsonBackReference("iteration_info")
	@JsonIgnore
	private ReleaseInfo release;

	@Column(name = "iteration_title")
	private String iterationTitle;

	@Column(name = "iteration_description", columnDefinition = "VARCHAR(1024)")
	private String iterationDescription;

	@Temporal(TemporalType.DATE)
	@Column(name = "iteration_startdate")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date iterationStartDate;

	@Temporal(TemporalType.DATE)
	@Column(name = "iteration_enddate")
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date iterationEndDate;

	@Column(name = "iteration_status")
	private String iterationStatus;

	@Column(name = "iteration_type")
	private String iterationType;
	
	@OneToMany(mappedBy = "iteration",fetch=FetchType.EAGER)
	//@JsonManagedReference("item_info")
	@JsonIgnore
	private List<ItemsInfo> itemInfo;

	
	public IterationInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public IterationInfo(ReleaseInfo release, String iterationTitle, String iterationDescription,
			Date iterationStartDate, Date iterationEndDate, String iterationStatus, String iterationType)
 {
	
		this.release = release;
		this.iterationTitle = iterationTitle;
		this.iterationDescription = iterationDescription;
		this.iterationStartDate = iterationStartDate;
		this.iterationEndDate = iterationEndDate;
		this.iterationStatus = iterationStatus;
		this.iterationType = iterationType;

	}



	public int getIterationId() {
		return iterationId;
	}

	public void setIterationId(int iterationId) {
		this.iterationId = iterationId;
	}
	
	public ReleaseInfo getRelease() {
		return release;
	}

	public void setRelease(ReleaseInfo release) {
		this.release = release;
	}

	public String getIterationTitle() {
		return iterationTitle;
	}

	public void setIterationTitle(String iterationTitle) {
		this.iterationTitle = iterationTitle;
	}

	public String getIterationDescription() {
		return iterationDescription;
	}

	public void setIterationDescription(String iterationDescription) {
		this.iterationDescription = iterationDescription;
	}

	public Date getIterationStartDate() {
		return iterationStartDate;
	}

	public void setIterationStartDate(Date iterationStartDate) {
		this.iterationStartDate = iterationStartDate;
	}

	public Date getIterationEndDate() {
		return iterationEndDate;
	}

	public void setIterationEndDate(Date iterationEndDate) {
		this.iterationEndDate = iterationEndDate;
	}

	public String getIterationStatus() {
		return iterationStatus;
	}

	public void setIterationStatus(String iterationStatus) {
		this.iterationStatus = iterationStatus;
	}

	public String getIterationType() {
		return iterationType;
	}

	public void setIterationType(String iterationType) {
		this.iterationType = iterationType;
	}

	public List<ItemsInfo> getItemInfo() {
		return itemInfo;
	}

	public void setItemInfo(List<ItemsInfo> itemInfo) {
		this.itemInfo = itemInfo;
	}

}
