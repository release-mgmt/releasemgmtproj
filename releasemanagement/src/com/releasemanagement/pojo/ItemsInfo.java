package com.releasemanagement.pojo;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "item_info")
public class ItemsInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "itm_seq")
	@SequenceGenerator(name = "itm_seq", initialValue = 1)
	@Column(name = "item_id")
	private int itemId;

	@Column(name = "item_title", unique = true, nullable = false)
	private String itemTitle;

	@Column(name = "item_description", columnDefinition = "VARCHAR(1024)")
	private String itemDescription;

	@Column(name = "item_status")
	private int itemStatus;

	@ManyToOne
	@JoinColumn(name = "item_for_release", referencedColumnName = "release_id")
	@JsonIgnore
	private ReleaseInfo release;

	@ManyToOne
	@JoinColumn(name = "item_for_iteration", referencedColumnName = "iteration_id")
	@JsonIgnore
	private IterationInfo iteration;

	@Column(name = "item_active")
	private int itemActive;

	public ItemsInfo() {
		super();
	}

	public ItemsInfo(String itemTitle, String itemDescription, int itemStatus, ReleaseInfo release,
			IterationInfo iteration) {
		super();
		this.itemTitle = itemTitle;
		this.itemDescription = itemDescription;
		this.itemStatus = itemStatus;
		this.release = release;
		this.iteration = iteration;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

	public String getItemTitle() {
		return itemTitle;
	}

	public void setItemTitle(String itemTitle) {
		this.itemTitle = itemTitle;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public int getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(int itemStatus) {
		this.itemStatus = itemStatus;
	}

	public ReleaseInfo getRelease() {
		return release;
	}

	public void setRelease(ReleaseInfo release) {
		this.release = release;
	}

	public IterationInfo getIteration() {
		return iteration;
	}

	public void setIteration(IterationInfo iteration) {
		this.iteration = iteration;
	}

}