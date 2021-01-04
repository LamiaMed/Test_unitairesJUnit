package com.example.service;

import com.example.dao.ICartDao;
import com.example.dao.IOrderDao;
import com.example.dao.IPaymentDao;
import com.example.dao.IProductDao;
import com.example.model.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class EXO3Test {
IProductDao pdao = Mockito.mock(IProductDao.class);
ICartDao cdao = Mockito.mock(ICartDao.class);
IPaymentDao paydao = Mockito.mock(IPaymentDao.class);
IOrderDao odao;
Product prod;
Customer cust;
Payment pay;

    @Test
    public void addProductToCart() {
        prod = new Product("1","asus", "pc",5, 1000L);
        cust = new Customer(1L,"AAAA","BBBB");
        Mockito.when(pdao.getProductQte(prod)).thenReturn(10);
        Mockito.when(cdao.addProductToCart(prod,cust)).thenReturn(true);
        assertTrue(new CartService(pdao,cdao).addProductToCart(prod,cust));
    }
   @Test
    public void addPayment(){
       prod = new Product("1","asus", "pc",5, 1000L);
       cust = new Customer(1L,"AAAA","BBBB");
       List<Product> listProducts = new ArrayList<Product>();
       listProducts.add(prod);
       Date date=new Date(2020,04,11);
       Cart cart = new Cart( listProducts,cust);
       Order ord = new Order(1,cart,date);
       pay =new Payment(1L,ord,5000L,date);
       Mockito.when(paydao.addPayment(pay)).thenReturn(true);
       assertTrue(new PaymentService(odao,paydao).addPayment(pay));

   }
}