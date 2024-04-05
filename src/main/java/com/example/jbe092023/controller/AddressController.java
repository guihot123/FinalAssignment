package com.example.jbe092023.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jbe092023.exception.AddressNotFoundException;
import com.example.jbe092023.model.Address;
import com.example.jbe092023.service.AddressService;
import com.example.jbe092023.utils.ResponseCode;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/address")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	@GetMapping("")
	private ResponseEntity<?> getAll(){
		return BaseResponseController.success(this.addressService.getAll());
	}
	
	@GetMapping(path="/findByUserId/{id}")
	public List<Address> getAll(@PathVariable(name = "id")Integer id){
			if(id!=null) {
				return this.addressService.findAllByUserId(id);
			}
		return this.addressService.getAll();
	}
	
	@PostMapping("")
	public ResponseEntity<?> addAddress(@RequestBody Address address) {
		Address addedAddress = this.addressService.saveAddress(address);
		if(addedAddress==null) {
			return BaseResponseController.fail(null, "fail adding");
		}
		return BaseResponseController.success(addressService.saveAddress(address));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAddress(@PathVariable(name="id")Integer id){
		try {
			return BaseResponseController.success(this.addressService.deleteUser(id));
		}catch(AddressNotFoundException e) {
			return BaseResponseController.fail(ResponseCode.ADDRESS_NOT_FOUND.getCode(),
					ResponseCode.ADDRESS_NOT_FOUND.getMessage());
		}
	}
	
}
