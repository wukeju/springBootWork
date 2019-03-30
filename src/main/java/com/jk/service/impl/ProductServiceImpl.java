package com.jk.service.impl;

import com.jk.dao.ProductMapping;
import com.jk.pojo.ProductPojo;
import com.jk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapping productMapping;


    @Override
    public List<ProductPojo> queryProduct() {

        return productMapping.queryProduct();
    }

    @Override
    public ProductPojo huixian(ProductPojo pojo) {
        return  productMapping.huixian(pojo);
    }


    @Override
    public void addProduct(ProductPojo pojo) {

        productMapping.addProduct(pojo);
    }

    @Override
    public void delePro(ProductPojo pojo)
    {
        productMapping.delePro(pojo);
    }

    @Override
    public void upProduct(ProductPojo pojo) {

        productMapping.upProduct(pojo);
    }


}
