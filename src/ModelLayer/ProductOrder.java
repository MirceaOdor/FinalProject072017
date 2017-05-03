package ModelLayer;

import java.util.*;

/**
 * Created by Vlad Mataoanu on 03.05.2017.
 */
public class ProductOrder extends Order{
    private ArrayList<Product> productsOrdered;

    public ProductOrder(String id, Date deliveryDate, String orderStatus, double totalPrice, String companyId, String type) {
        super(id, deliveryDate, orderStatus, totalPrice, companyId, type);
        productsOrdered=new ArrayList<>();
    }

    public void addProductsOrdered(Product product){
        productsOrdered.add(product);
    }

    public ArrayList<Product> getProductsOrdered(){
        return productsOrdered;
    }

    public void deleteProduct(Product product){
        productsOrdered.remove(product);
    }
}
