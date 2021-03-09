package io.mewald.demo.model.treat;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class Diet extends Treatment {
	
	@JsonProperty("_type")
	@Transient
	private final String type = "diet";

	@NotNull
	@Size(min = 1)
	@ElementCollection
	private Set<String> allowedFoods;
	
	@Builder(builderMethodName = "dietBuilder")
	public Diet(String name, String description, Set<String> allowedFoods) {
		super(name);
		setDescription(description);
		this.allowedFoods = allowedFoods;
	}

}
