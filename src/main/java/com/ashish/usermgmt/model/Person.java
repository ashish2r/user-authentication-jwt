package com.ashish.usermgmt.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "PERSON")
public class Person {
	 @Id
	    @Column(name = "ID")
	    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	    @SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 1)
	    private Integer id;

	    @Column(name = "FIRSTNAME", length = 50)
	    @NotNull
	    @Size(min = 4, max = 50)
	    private String firstname;

	    @Column(name = "LASTNAME", length = 50)
	    @NotNull
	    @Size(min = 4, max = 50)
	    private String lastname;

	    @Column(name = "EMAIL", length = 50)
	    @NotNull
	    @Size(min = 4, max = 50)
	    private String email;
	    
	    @Column(name = "PHONE", length = 50)
	    @NotNull
	    @Size(min = 4, max = 50)
	    private String phone;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}	    
}
