/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hungkd.daos;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PC
 */
public class CartDTO {
    private String customer;
    private Map<String,TeaDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String customer, Map<String, TeaDTO> cart) {
        this.customer = customer;
        this.cart = cart;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Map<String, TeaDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, TeaDTO> cart) {
        this.cart = cart;
    }
    
    public void add(TeaDTO tea) {
        if (cart == null) {
            cart = new HashMap<>();
        }
        if (cart.containsKey(tea.getId())) {
            int quantity = this.cart.get(tea.getId()).getQuantity();
            tea.setQuantity(quantity + tea.getQuantity());
        }
        cart.put(tea.getId(), tea);
    }
    
    public void delete(String id) {
        if (cart == null) {
            return;
        }
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    
    public void update(TeaDTO tea) {
        if (this.cart != null) {
            if (this.cart.containsKey(tea.getId())) {
                cart.replace(tea.getId(), tea);
            }
        }
    }
}
