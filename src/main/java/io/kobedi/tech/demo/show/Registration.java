package io.kobedi.tech.demo.show;



import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;

import java.util.Date;





@Entity
@Table(name = "members")
@EntityListeners(AuditingEntityListener.class)
public class Registration {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name = "seat_number", nullable = true)
	private long seatNumber;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "surname", nullable = true)
	private String surname;
	
	@Column(name = "email", nullable = true)
	private String email;
	
	@Column(name = "cell_phone", nullable = false)
	private String cellPhone;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = true)
	private Date dateCreated;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated_at", nullable = true)
	private Date dateUpDated;
	
	
	@Column(name = "updated_by", nullable = false)
	@LastModifiedBy
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
	
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpDated() {
		return dateUpDated;
	}
	public void setDateUpDated(Date dateUpDated) {
		this.dateUpDated = dateUpDated;
	}
	@Override
	public String toString() {
		return "Registration [id=" + id + ", seatNumber=" + seatNumber + ", name=" + name + ", surname=" + surname
				+ ", email=" + email + ", cellPhone=" + cellPhone + ", dateCreated=" + dateCreated + ", dateUpDated="
				+ dateUpDated + ", updatedBy=" + updatedBy + "]";
	}	
	
	

}
