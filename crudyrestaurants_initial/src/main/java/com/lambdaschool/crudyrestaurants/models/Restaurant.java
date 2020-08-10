package com.lambdaschool.crudyrestaurants.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The entity allowing interaction with the restaurants table.
 */
@Entity
@Table(name = "restaurants")
public class Restaurant
{
    /**
     * The primary key number (long) of the restaurants table.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long restaurantid;

    /**
     * The name (String) of the restaurant. Cannot be null and must be unique.
     */
    @Column(unique = true,
            nullable = false)
    private String name;

    /**
     * The address (String) of the restaurant. Any format is acceptable.
     */
    private String address;

    /**
     * The city (String) of the restaurant. Any format is acceptable.
     */
    private String city;

    /**
     * The state (String) of the restaurant. The format is the two character abbreviation of the state.
     */
    private String state;

    /**
     * The telephone number (String) of the restaurant. Any format is acceptable.
     */
    private String telephone;

    /**
     * The seating capacity (integer) of the restaurant.
     * This was added to specifically show how to update fields that do not have a NULL value.
     */
    private int seatcapacity;

    @OneToMany(mappedBy = "restaurant", cascade= CascadeType.ALL, orphanRemoval = true)
    private List<Menu> menus = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "restaurantpayments",
          joinColumns = @JoinColumn(name = "restaurantid"),
          inverseJoinColumns = @JoinColumn(name = "paymentid"))
    private Set<Payment> payments = new HashSet<>();
    /**
     * Default constructor used primarily by the JPA.
     */
    public Restaurant()
    {
    }

    /**
     * Given the params, create a new restaurant object.
     * <p>
     * restaurantid is autogenerated.
     *
     * @param name         The name (String) of the restaurant.
     * @param address      The address (String) of the restaurant.
     * @param city         The city (String) of the restaurant.
     * @param state        The state (String) of the restaurant.
     * @param telephone    The telephone number (String) of the restaurant.
     * @param seatcapacity The seating capacity (Integer) of the restaurant.
     *                     menus are added outside of this constructor.
     */
    public Restaurant(
            String name,
            String address,
            String city,
            String state,
            String telephone,
            int seatcapacity)
    {
        this.name = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.telephone = telephone;
        this.seatcapacity = seatcapacity;
    }

    /**
     * Getter for restaurantid.
     *
     * @return The primary key number (long) of the restaurant's table.
     */
    public long getRestaurantid()
    {
        return restaurantid;
    }

    /**
     * Setter for the restaurantid - used primarily when seeding data.
     *
     * @param restaurantid The new primary key number (long) of the restaurants table.
     */
    public void setRestaurantid(long restaurantid)
    {
        this.restaurantid = restaurantid;
    }

    /**
     * Getter for name.
     *
     * @return The name (String) of the Restaurant.
     */
    public String getName()
    {
        return name;
    }

    /**
     * Setter for name.
     *
     * @param name The new name (String) of the Restaurant.
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Getter for address.
     *
     * @return The address (String) of the Restaurant.
     */
    public String getAddress()
    {
        return address;
    }

    /**
     * Setter for address
     *
     * @param address The new address (String) for the Restaurant.
     */
    public void setAddress(String address)
    {
        this.address = address;
    }

    /**
     * Getter for city
     *
     * @return The city (String) where the restaurant is located.
     */
    public String getCity()
    {
        return city;
    }

    /**
     * Setter for city
     *
     * @param city The new city (String) of the restaurant.
     */
    public void setCity(String city)
    {
        this.city = city;
    }

    /**
     * Getter for the state.
     *
     * @return The state (String) of the current restaurant.
     */
    public String getState()
    {
        return state;
    }

    /**
     * Getter for the state.
     *
     * @param state The new state (String) of the restaurant.
     */
    public void setState(String state)
    {
        this.state = state;
    }

    /**
     * Getter for the telephone.
     *
     * @return The telephone number (String) of the current restaurant.
     */
    public String getTelephone()
    {
        return telephone;
    }

    /**
     * Setter for the telephone.
     *
     * @param telephone The new telephone number (String) for the restaurant.
     */
    public void setTelephone(String telephone)
    {
        this.telephone = telephone;
    }

    /**
     * Getter for seatcapacity.
     *
     * @return How many (integer) seats this restaurant has.
     */
    public int getSeatcapacity()
    {
        return seatcapacity;
    }

    /**
     * Setter for seatcapacity.
     *
     * @param seatcapacity The new amount (integer) of seats this restaurant has.
     */
    public void setSeatcapacity(int seatcapacity)
    {
        this.seatcapacity = seatcapacity;
    }

    public List<Menu> getMenus()
    {
        return menus;
    }

    public void setMenus(List<Menu> menus)
    {
        this.menus = menus;
    }

    public Set<Payment> getPayments()
    {
        return payments;
    }

    public void setPayments(Set<Payment> payments)
    {
        this.payments = payments;
    }
}