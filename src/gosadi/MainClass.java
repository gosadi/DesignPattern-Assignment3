/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gosadi;

import gosadi.model.Cart;
import gosadi.model.Color;
import gosadi.model.Fabric;
import gosadi.model.Size;
import gosadi.model.TShirt;
import gosadi.strategy.PaymentStrategy;

/**
 *
 * @author alkinoos
 */
public class MainClass {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Cart cart = Cart.getCart();
        cart.fillCart(5);
        cart.printCartItems();

        System.out.println("The total Price of cart is : " + cart.computeTotalPrice());
        cart.payTotal();

    }

}
