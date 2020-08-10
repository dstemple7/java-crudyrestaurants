package com.lambdaschool.crudyrestaurants.services;

import com.lambdaschool.crudyrestaurants.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service(value = "restaurantService")
public class RestaurantServiceImplementation implements RestaurantService
{
    @Autowired
    RestaurantRepository restrepos;
}
