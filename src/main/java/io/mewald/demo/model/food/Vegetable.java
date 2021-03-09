package io.mewald.demo.model.food;

import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

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
public class Vegetable extends Food {

	public static enum Type {
		LEAFY_GREEN, CRUCIFERIOUS, MARROW, ROOT, EDIBLE_PLANT_STEM, ALLIUM
	}

	@NotNull
	@Enumerated(EnumType.STRING)
	private Type type;
	
	@Enumerated(EnumType.STRING)
	@ElementCollection
	private Set<Vitamin> vitamins;
	
	@Builder
	public Vegetable(String name, Type type, Set<Vitamin> vitamins) {
		super(name);
		this.type = type;
		this.vitamins = vitamins;
	}

}
