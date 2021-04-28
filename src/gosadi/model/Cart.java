/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gosadi.model;

import gosadi.strategy.BankTransferPayment;
import gosadi.strategy.CashPayment;
import gosadi.strategy.CreditCardPayment;
import gosadi.strategy.PaymentStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alkinoos
 */
public class Cart {

    private PaymentStrategy paymentStrategy;
    private static Cart cart;
    private List<TShirt> tshirts;

    private Cart() {
        tshirts = new ArrayList<>();
    }

    public static Cart getCart() {
        if (cart == null) {
            cart = new Cart();
        }
        return cart;
    }

    public void addTshirts(TShirt tshirt) {
        tshirts.add(tshirt);
    }

    public void removeTshirts(TShirt tshirt) {
        tshirts.remove(tshirt);
    }

    public double computeTotalPrice() {
        double sum = 0;
        for (TShirt t : tshirts) {
            sum += t.getPrice();
        }
        return sum;
    }

    public void payTotal() {
        double total = computeTotalPrice();
        if (total <= 50) {
            paymentStrategy = new CashPayment();
        } else if (total < 100) {
            paymentStrategy = new CreditCardPayment("Visa", "1234", "321", 2220);
        } else {
            paymentStrategy = new BankTransferPayment("Peiraius", "183213");
        }
        
        paymentStrategy.pay(total);
    }
    
    public void fillCart(int numberOfTshirts) {
        for (int i = 0; i < numberOfTshirts; i++) {
            TShirt t = new TShirt();
             addTshirts(t);
        }
    }

    public void printCartItems(){
        System.out.println(">>>Your cart contains the following t-shirts<<<");
        for(TShirt t : tshirts){
            System.out.println(t);
        }
    }
}
