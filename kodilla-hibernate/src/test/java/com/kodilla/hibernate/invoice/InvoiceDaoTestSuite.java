package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.InvoiceDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@SpringBootTest
public class InvoiceDaoTestSuite  {

    @Autowired
    private InvoiceDao invoiceDeo;
    @Autowired
    private ProductDao productDao;

    @Test
    void testInvoiceDaoSave(){
        //Given
         Product product1 = new Product("Product 1");
         Product product2 = new Product("Product 2");
         Item item1 = new Item(product1, new BigDecimal(2.5), 10);
         Item item2 = new Item(product1, new BigDecimal(1.5), 3);
         Item item3 = new Item(product2, new BigDecimal(1.55), 5);
         Item item4 = new Item(product2, new BigDecimal(2.25), 7);
         Item item5 = new Item(product1, new BigDecimal(20.5), 12);
//        product1.getItems().add(item1);
//        product1.getItems().add(item2);
//        product1.getItems().add(item5);
//        product2.getItems().add(item3);
//        product2.getItems().add(item4);
         List<Item> items = new ArrayList<>();
         items.add(item1);
         items.add(item2);
         items.add(item3);
         items.add(item4);
         items.add(item5);
         Invoice invoice = new Invoice("1", items);
//         item1.setInvoice(invoice);
//         item2.setInvoice(invoice);
//         item3.setInvoice(invoice);
//         item4.setInvoice(invoice);
//         item5.setInvoice(invoice);

         //When
        invoiceDeo.save(invoice);
        int invoiceId = invoice.getId();

        //Then
        assertNotEquals(0, invoiceId);

        //CleanUp
        invoiceDeo.deleteById(invoiceId);




    }
}
