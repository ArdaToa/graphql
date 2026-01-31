package com.ardatoa.graphql.controller;

import com.ardatoa.graphql.Repository.MerchantRepository;
import com.ardatoa.graphql.model.Address;
import com.ardatoa.graphql.model.Contact;
import com.ardatoa.graphql.model.Merchant;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantRepository merchantRepository;

    @MutationMapping
    public Merchant createMerchant(@Argument("merchant") Merchant merchant) {

        return merchantRepository.save(merchant);

    }

    @QueryMapping
    public List<Merchant> getMerchants(){

        return merchantRepository.findAll();

    }

    @QueryMapping
    public Merchant getMerchantById(@Argument("id") Integer id) {

        return merchantRepository.findById(id).orElseThrow(() -> new RuntimeException("Merchant mot found with id: " + id));

    }

    @SchemaMapping
    public List<Contact> contacts(Merchant merchant) {

        return merchant.getContacts();

    }

    @SchemaMapping
    public Address address(Merchant merchant) {

        return merchant.getAddress();

    }

}
