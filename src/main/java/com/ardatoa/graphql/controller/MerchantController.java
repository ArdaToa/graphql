package com.ardatoa.graphql.controller;

import com.ardatoa.graphql.Repository.MerchantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class MerchantController {

    private final MerchantRepository merchantRepository;

}
