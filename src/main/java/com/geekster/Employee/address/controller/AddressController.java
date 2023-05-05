package com.geekster.Employee.address.controller;

import com.geekster.Employee.address.model.Address;
import com.geekster.Employee.address.service.AddressService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/addresses")

public class AddressController {

    @Autowired
    AddressService addressService;

    @GetMapping(value = "/getAllAddresses")
    public ResponseEntity<List<Address>> getAddresses(){
        List<Address> addressList=addressService.getAllAddresses();
        return new ResponseEntity<>(addressList, HttpStatus.OK);
    }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Address> getAddressById(@PathVariable Long id){
      Optional<Address> details=addressService.getAddressById(id);
      return details.map(value -> new ResponseEntity<>(value, HttpStatus.FOUND))
              .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
  }

  @PostMapping(value = "/create")
    public ResponseEntity<Address> insertAddress(@Valid @RequestBody Address address){
        Address addressObj=addressService.createAddress(address);
        return new ResponseEntity<>(addressObj,HttpStatus.CREATED);
  }

  @PutMapping(value = "/{id}")
    public ResponseEntity<Address>updateById(@PathVariable Long id, @Valid @RequestBody Address address){
        Optional<Address>exist=addressService.getAddressById(id);
        if(exist.isPresent()){
           address.setId(id);
           Address update=addressService.updateAddressById(address);
           return  new ResponseEntity<>(update,HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }

  @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void>deleteById(@PathVariable Long id){
      Optional<Address>exist=addressService.getAddressById(id);
      if(exist.isPresent()){
          addressService.deleteAddressById(id);
          return new ResponseEntity<>(HttpStatus.OK);
      }
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
  }
}
