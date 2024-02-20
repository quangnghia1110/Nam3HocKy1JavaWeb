package hcmute.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import hcmute.embeddedId.BranchMilkTeaId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "branch_milk_tea")
public class BranchMilkTea implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EmbeddedId
	private BranchMilkTeaId branchMilkTeaId;
	
	@Column(name = "remain_quantity")
	private int remainQuantity;
	
	@ManyToOne
	@JoinColumn(name = "id_branch",insertable = false, updatable = false)
	private BranchEntity branchByBranchMilkTea;
	
	@ManyToOne
	@JoinColumn(name = "id_milk_tea",insertable = false, updatable = false)
	private MilkTeaEntity milkTeaByBranchMilkTea;

	public BranchMilkTeaId getBranchMilkTeaId() {
		return branchMilkTeaId;
	}

	public void setBranchMilkTeaId(BranchMilkTeaId branchMilkTeaId) {
		this.branchMilkTeaId = branchMilkTeaId;
	}

	public int getRemainQuantity() {
		return remainQuantity;
	}

	public void setRemainQuantity(int remainQuantity) {
		this.remainQuantity = remainQuantity;
	}

	public BranchEntity getBranchByBranchMilkTea() {
		return branchByBranchMilkTea;
	}

	public void setBranchByBranchMilkTea(BranchEntity branchByBranchMilkTea) {
		this.branchByBranchMilkTea = branchByBranchMilkTea;
	}

	public MilkTeaEntity getMilkTeaByBranchMilkTea() {
		return milkTeaByBranchMilkTea;
	}

	public void setMilkTeaByBranchMilkTea(MilkTeaEntity milkTeaByBranchMilkTea) {
		this.milkTeaByBranchMilkTea = milkTeaByBranchMilkTea;
	}

	public BranchMilkTea(BranchMilkTeaId branchMilkTeaId, int remainQuantity, BranchEntity branchByBranchMilkTea,
			MilkTeaEntity milkTeaByBranchMilkTea) {
		super();
		this.branchMilkTeaId = branchMilkTeaId;
		this.remainQuantity = remainQuantity;
		this.branchByBranchMilkTea = branchByBranchMilkTea;
		this.milkTeaByBranchMilkTea = milkTeaByBranchMilkTea;
	}

	public BranchMilkTea() {
		super();
	}
	
}
