package usualstudent.coursework.database.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import usualstudent.coursework.database.entity.Shop;
import usualstudent.coursework.database.repos.ShopRepo;
import usualstudent.coursework.database.service.ShopService;

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
