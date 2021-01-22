package io.kobedi.tech.demo.show.domain;

/*

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

import java.util.Date;
*/


public class Registration {
	
	private long id;
	private long seatNumber;
	private String name;
	private String surname;
	private String email;
	private String cellPhone;
	private String dateCreated;
	private String dateUpDated;
	private String updatedBy;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(long seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCellPhone() {
		return cellPhone;
	}
	public void setCellPhone(String cellPhone) {
		this.cellPhone = cellPhone;
	}
	public String getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getDateUpDated() {
		return dateUpDated;
	}
	public void setDateUpDated(String dateUpDated) {
		this.dateUpDated = dateUpDated;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", seatNumber=" + seatNumber + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", cellPhone=" + cellPhone + ", dateCreated=" + dateCreated + ", dateUpDated="
				+ dateUpDated + ", updatedBy=" + updatedBy + "]";
	}	
	
	

}
