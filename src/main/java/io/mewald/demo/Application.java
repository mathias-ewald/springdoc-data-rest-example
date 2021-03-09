package io.mewald.demo;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import io.mewald.demo.model.Address;
import io.mewald.demo.model.medic.Clinic;
import io.mewald.demo.model.medic.Doctor;
import io.mewald.demo.model.pet.Cat;
import io.mewald.demo.model.pet.Dog;
import io.mewald.demo.model.pet.Owner;
import io.mewald.demo.model.pet.Pet;
import io.mewald.demo.model.treat.Diet;
import io.mewald.demo.model.treat.Treatment;
import io.mewald.demo.repo.ClinicRepo;
import io.mewald.demo.repo.DoctorRepo;
import io.mewald.demo.repo.OwnerRepo;
import io.mewald.demo.repo.PetRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Autowired
	private ClinicRepo cRepo;
	
	@Autowired
	private DoctorRepo dRepo;
	
	@Autowired
	private OwnerRepo oRepo;
	
	@Autowired
	private PetRepo pRepo;

	@EventListener(ApplicationReadyEvent.class)
	public void loadData() {
	    
		Clinic c1 = cRepo.save(Clinic.builder()
			.name("Clinic Under The Palm Trees")
			.addresses(Set.of(
					Address.builder().name("Clinic Under The Palm Trees")
						.street("Palm Ally").number("123")
						.zipcode("12345").city("Palm Springs")
						.country("Russia").build()
			))
			.build());
		
		
		Clinic c2 = cRepo.save(Clinic.builder()
			.name("Clinic On The Mountain Top")
			.addresses(Set.of(
					Address.builder().name("Clinic On The Mountain Top")
						.street("Peak Road").number("1")
						.zipcode("54321").city("Hilltown")
						.country("Switzerland").build()
			))
			.build());
		
		
		Doctor d1 = dRepo.save(Doctor.builder()
			.firstname("Rabbit").lastname("Eear")
			.clinics(Set.of(c1, c2))
			.build());
		
		Doctor d2 = dRepo.save(Doctor.builder()
			.firstname("Piglet").lastname("Belly")
			.clinics(Set.of(c1))
			.build());
		
		
		Owner o1 = oRepo.save(Owner.builder()
			.firstname("Scrooge ").lastname("McDuck")
			.addresses(Address.builder().name("Mini Mouse")
				.street("Mousehole").number("1")
				.zipcode("1111").city("Old McDonald's Fam")
				.country("Kentucky").build())
			.build());
		
		Pet p1 = pRepo.save(Dog.builder()
			.name("Bella")
			.owner(o1)
			.coat(Dog.CoatType.HAIRLESS)
			.treatments(List.of(
				Treatment.builder().name("Cut claws").description(null).build(),
				Diet.dietBuilder().name("Diet Plan").description(null).allowedFoods(Set.of("Rice", "Vegetables")).build()
			))
			.build());
		
		Pet p2 = pRepo.save(Dog.builder()
			.name("Luna")
			.weight(30.2)
			.owner(o1)
			.coat(Dog.CoatType.DOUBLE)
			.build());

		Pet p3 = pRepo.save(Cat.builder()
			.name("Charlie")
			.weight(25.8)
			.owner(o1)
			.coat(Cat.CoatType.COLORPOINT)
			.build());
		
		Pet p4 = pRepo.save(Cat.builder()
			.name("Lucy")
			.weight(3.5)
			.owner(o1)
			.coat(Cat.CoatType.SOLID)
			.build());
		
		Pet p5 = pRepo.save(Dog.builder()
			.name("Cooper")
			.owner(o1)
			.coat(Dog.CoatType.SHORT)
			.build());
				
		Owner o2 = oRepo.save(Owner.builder()
			.firstname("Minni").lastname("Mouse")
			.addresses(Address.builder().name("Mini Mouse")
				.street("Dollar Road").number("1")
				.zipcode("1231").city("McDuck Manor")
				.country("Glasgow").build())
			.build());
		
		Pet p6 = pRepo.save(Dog.builder()
			.name("Max")
			.owner(o2)
			.coat(Dog.CoatType.HEAVY)
			.build());

		Pet p7 = pRepo.save(Cat.builder()
			.name("Bailey")
			.owner(o2)
			.coat(Cat.CoatType.TRICOLOR)
			.build());
		
		Pet p8 = pRepo.save(Cat.builder()
			.name("Daisy")
			.owner(o2)
			.coat(Cat.CoatType.BICOLOR)
			.build());
	}

	
}
