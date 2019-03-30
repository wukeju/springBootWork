package com.jk.dao;

import com.jk.pojo.ProductPojo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapping {

    @Select("select * from t_product")
    public List<ProductPojo> queryProduct();

    @Select("select * from t_product where proid = #{proid}")
    ProductPojo huixian(ProductPojo pojo);

    @Insert("insert into t_product(proname,price,renshu,img,prodate) values(#{proname}, #{price}, #{renshu},#{img},#{prodate})")
    void addProduct(ProductPojo pojo);

    @Delete("delete from t_product where proid = #{proid}")
    void delePro(ProductPojo pojo);

    @Update("update t_product set proname=#{proname},price=#{price},renshu=#{renshu},prodate=#{prodate} where proid =#{proid}")
    void upProduct(ProductPojo pojo);
}
