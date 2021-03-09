package io.mewald.demo.model.treat;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrePersist;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.mewald.demo.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;


@Entity

@EqualsAndHashCode(callSuper=false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Builder

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "_type")
@JsonSubTypes({ 
  @Type(value = Treatment.class, name = "other"),
  @Type(value = Diet.class, name = "diet")
})
public class Treatment extends BaseEntity {

	@NonNull
	@NotNull
	private String name;
	
	private String description;
	
	@NotNull
	private LocalDate prescriptionDate;
	
	@JsonProperty("_type")
	@Transient
	private final String type = "other";
	
	@PrePersist
	private void setPrescriptionDate() {
		if (prescriptionDate == null)
			prescriptionDate = LocalDate.now();
	}

}
