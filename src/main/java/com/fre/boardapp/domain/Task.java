package com.fre.boardapp.domain;

//import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

//@Data // this tells lombok to create constructors, getters and setters, toString, equals and hashCode methods
@Entity // this tells hibernate to create table in database
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Summary cannot be blank")
    private String summary;
    private String acceptanceCriteria;
    private String status;
     // Getter
  public String getStatus() {
    return status;
  }

  // Setter
  public void setStatus(String newName) {
    this.status = newName;
  }
    // Getter
  public String getSummary() {
    return summary;
  }

  // Setter
  public void setSummary(String newName) {
    this.summary = newName;
  }
    // Getter
  public String getAcceptanceCriteria() {
    return acceptanceCriteria;
  }

  // Setter
  public void setAcceptanceCriteria(String newName) {
    this.acceptanceCriteria = newName;
  }

}
