package io.mewald.demo.model.food;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;

import io.mewald.demo.model.BaseEntity;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity

@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

@Data
@NoArgsConstructor
@RequiredArgsConstructor

@JsonTypeInfo(
  use = JsonTypeInfo.Id.NAME, 
  include = JsonTypeInfo.As.PROPERTY, 
  property = "_type")
@JsonSubTypes({ 
  @Type(value = Vegetable.class, name = "vegetable"),
  @Type(value = Meat.class, name = "meat")
})
public abstract class Food extends BaseEntity {

	@NonNull
	@NotNull
	private String name;

}
