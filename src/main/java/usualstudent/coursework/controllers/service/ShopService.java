package usualstudent.coursework.controllers.service;

import org.springframework.stereotype.Service;
import usualstudent.coursework.controllers.entity.Shop;

import java.util.List;

@Service
public interface ShopService {

    Shop addProduct(Shop shop);

    void removeProduct(Shop shop);

    List<Shop> getAll();

    Shop editProduct(Shop shop);

}
