package com.kodilla.good.patterns.challenges;

public class MailService implements InformationServices{

    @Override
    public void inform(User user, Product product) {

            System.out.println(product.getProductName() + " is ordered successfully by: " + user.getName());


    }

}
