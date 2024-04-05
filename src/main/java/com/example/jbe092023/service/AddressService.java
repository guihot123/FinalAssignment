package com.example.jbe092023.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jbe092023.exception.AddressNotFoundException;
import com.example.jbe092023.model.Address;
import com.example.jbe092023.repository.AddressRepository;

@Service
public class AddressService {

	@Autowired
	private AddressRepository addressRepository;
	
	public List<Address> getAll() {
		return this.addressRepository.findAll();
	}

	public List<Address> findAllByUserId(Integer id) {
		if(id!=null) {
			return this.addressRepository.findAllByProductId(id); 
		}
		return this.addressRepository.findAll();
	}

	public Address saveAddress(Address address) {
		return this.addressRepository.save(address);
	}

	public Boolean deleteUser(Integer id)throws AddressNotFoundException {
		Optional<Address> foundAddress = this.addressRepository.findById(id);
		if(foundAddress.isEmpty()) {
			throw new AddressNotFoundException();
		}
		this.addressRepository.deleteById(id);
		return true;
	}


}
