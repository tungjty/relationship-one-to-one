package com.example.demo;

import com.example.demo.model.Address;
import com.example.demo.model.Office;
import com.example.demo.repository.AddressRepository;
import com.example.demo.repository.OfficeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class RelationshipOneToOneApplication {

	public static void main(String[] args) {
		SpringApplication.run(RelationshipOneToOneApplication.class, args);
	}

	@Bean
	CommandLineRunner run(OfficeRepository officeRepository,
						  AddressRepository addressRepository) {
		return args -> {

			// SAVE OFFICE -> SAVE ADDRESS
			Address acomAddress = new Address("01 Leon Street Ward 1, USA");
			Address vinfastAddress = new Address("Landmark 81 Vincom Centre VN");
			Address appleAddress = new Address("01 Mongola Avenue , California , USA");

			Office acom = new Office("Acom Office", "US-000111", acomAddress);
			Office vinfast = new Office("Vinfast Office", "VN-555555", vinfastAddress);
			Office apple = new Office("Apple Office", "US-000222", appleAddress);

			List<Office> list = List.of(acom, vinfast, apple);
			officeRepository.saveAll(list);

			// SAVE OFFICE ONLY
			Office onlyOffice = new Office("office without address", "TL-010305", null);
			officeRepository.save(onlyOffice);

			// SAVE ADDRESS ONLY
			Address samsungAddress = new Address("Bitexco Tower, 02 Hai Trieu District 1, VN");
			addressRepository.save(samsungAddress);
		};
	}
}
