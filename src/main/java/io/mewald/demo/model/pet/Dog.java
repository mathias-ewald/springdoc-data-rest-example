package io.mewald.demo.model.pet;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import io.mewald.demo.model.treat.Treatment;
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
public class Dog extends Pet {

	public static enum CoatType {
		SMOOTH, SHORT, COMBINATION, DOUBLE, HEAVY, SILKY, LONG, CURLY, WIRE, HAIRLESS
	}

	@Enumerated(EnumType.STRING)
	private CoatType coat;
	
	@Builder
	public Dog(String name, Owner owner, Double weight, CoatType coat, List<Treatment> treatments) {
		super(name, owner, weight, treatments);
		this.coat = coat;
	}

}