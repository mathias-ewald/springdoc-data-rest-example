package io.mewald.demo.model.pet;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import io.mewald.demo.model.BaseEntity;
import io.mewald.demo.model.treat.Treatment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "_type"
)
@JsonSubTypes({ 
  @Type(value = Cat.class, name = "cat"),
  @Type(value = Dog.class, name = "dog")
})
public abstract class Pet extends BaseEntity {

	@NonNull
	@NotNull
	private String name;

	@NonNull
	@ManyToOne
	private Owner owner;
	
	private Double weight;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Treatment> treatments;

}
