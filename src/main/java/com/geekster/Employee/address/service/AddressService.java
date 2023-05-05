package com.geekster.Employee.address.service;

import com.geekster.Employee.address.model.Address;
import com.geekster.Employee.address.repository.AddressDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    @Autowired
    AddressDao addressDao;

    public List<Address> getAllAddresses() {
        return addressDao.findAll();
    }

    public Optional<Address> getAddressById(Long id) {
        return addressDao.findById(id);
    }

    public Address createAddress(Address address) {
        return addressDao.save(address);
    }

    public Address updateAddressById(Address address) {
        return addressDao.save(address);
    }

    public void deleteAddressById(Long id) {
        addressDao.deleteById(id);
    }
}
