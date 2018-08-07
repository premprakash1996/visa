package com.visa.training.domain;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends Account{

	@Column(name="OD_limit")
	float odLimit;

	public CurrentAccount() {
		super();
		
	}

	public CurrentAccount(float balance,float odLimit) {
		super(balance);
		this.odLimit = odLimit;
	}

	public float getOdLimit() {
		return odLimit;
	}

	public void setOdLimit(float odLimit) {
		this.odLimit = odLimit;
	}

	@Override
	public String toString() {
		return "CurrentAccount [odLimit=" + odLimit + ", id=" + id + ", balance=" + balance + "]";
	}
	
	
}
