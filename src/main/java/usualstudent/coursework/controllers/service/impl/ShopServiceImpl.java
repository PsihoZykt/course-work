package usualstudent.coursework.controllers.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import usualstudent.coursework.controllers.entity.Shop;
import usualstudent.coursework.controllers.repos.ShopRepo;
import usualstudent.coursework.controllers.service.ShopService;

import java.util.List;

/**
 * Created by PsihoZ on 11.10.2018.
 */
public class ShopServiceImpl implements ShopService {


    @Autowired
    ShopRepo shopRepo;

    @Override
    public Shop addProduct(Shop shop) {
        return shopRepo.saveAndFlush(shop);
    }

    @Override
    public void removeProduct(Shop shop) {
        shopRepo.delete(shop);

    }

    @Override
    public List<Shop> getAll() {
        return shopRepo.findAll();
    }

    @Override
    public Shop editProduct(Shop shop) {
        return shopRepo.saveAndFlush(shop);
    }
}
