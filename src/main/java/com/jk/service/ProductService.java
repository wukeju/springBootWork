package com.jk.service;

import com.jk.pojo.ProductPojo;

import java.util.List;

public interface ProductService {


    List<ProductPojo> queryProduct();

    ProductPojo huixian(ProductPojo pojo);

    void addProduct(ProductPojo pojo);


    void delePro(ProductPojo pojo);

    void upProduct(ProductPojo pojo);
}
