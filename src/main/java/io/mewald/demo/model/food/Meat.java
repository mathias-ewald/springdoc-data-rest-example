package io.mewald.demo.model.food;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

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
public class Meat extends Food {

	public enum Type {
		RED, POULTRY, SEAFOOD
	}
	
	public enum Level {
		LOW, MEDIUM, HIGH
	}
	
	@Enumerated(EnumType.STRING)
	private Type type;

	private Level fat;
	
	private Level protein;
	
	@Builder
	public Meat(String name, Type type, Level fat, Level protein) {
		super(name);
		this.type = type;
		this.fat = fat;
		this.protein = protein;
	}
	
}
