package com.kodilla.hibernate.invoice;

import com.kodilla.hibernate.invoice.dao.ItemDao;
import com.kodilla.hibernate.invoice.dao.ProductDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;


@SpringBootTest
public class ItemProductDaoTestSuite {

    @Autowired
    private ProductDao productDao;
    @Autowired
    private ItemDao itemDao;
    private Product product1 = new Product("Product 1");
    private Product product2 = new Product("Product 2");
    private Item item1 = new Item(product1, new BigDecimal(2.5), 10);
    private Item item2 = new Item(product1, new BigDecimal(1.5), 3);
    private Item item3 = new Item(product2, new BigDecimal(1.55), 5);
    private Item item4 = new Item(product2, new BigDecimal(2.25), 7);
    private Item item5 = new Item(product1, new BigDecimal(20.5), 12);



    @Test
    void testProductSave(){
        //Given
        //When
        productDao.save(product1);
        productDao.save(product2);

        int id1 = product1.getId();
        int id2 = product2.getId();
        Optional<Product> resultProduct1 = productDao.findById(id1);
        Optional<Product> resultProduct2 = productDao.findById(id2);

        //Then
        assertEquals("Product 1", resultProduct1.get().getName());
        assertEquals("Product 2", resultProduct2.get().getName());

        //CleanUp
        productDao.deleteById(id1);
        productDao.deleteById(id2);
        productDao.deleteAll();
    }

    // Do omówienia z mentroem
    @Test
    void testItemSave(){
        //Given
        product1.getItems().add(item1);
        product1.getItems().add(item2);
        product1.getItems().add(item5);
        product2.getItems().add(item3);
        product2.getItems().add(item4);
//
//        item1.setProduct(product1);
//        item2.setProduct(product1);
//        item3.setProduct(product2);
//        item4.setProduct(product2);
//        item5.setProduct(product1);


        //When
 //       productDao.save(product1);
//        product1.getItems().remove(item1);
        productDao.save(product1);
        productDao.save(product2);
//        itemDao.save(item1);
//        itemDao.save(item2);
//        itemDao.save(item3);
//        itemDao.save(item4);
//        itemDao.save(item5);

   //     productDao.deleteAll();

    }
}
