package com.jk.controller;

import com.jk.pojo.ProductPojo;
import com.jk.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService  productService;

    @RequestMapping("/queryProduct")
    public String queryProduct(Model model){
        List<ProductPojo> pojoList = productService.queryProduct();
        model.addAttribute("pojoList",pojoList);
        return "index";
    }

    @RequestMapping("addHtml")
    public  String addHtml(){
        return "add";
    }

    @RequestMapping("huixian")
    public  String huixian(ProductPojo pojo,Model model){
       ProductPojo pojo2 = productService.huixian(pojo);
       model.addAttribute("pojo2",pojo2);
        return "xuigai";
    }

    @RequestMapping("addProduct")
    @ResponseBody
    public  String addProduct(ProductPojo pojo){
        productService.addProduct(pojo);
        return "product/queryProduct";
    }

    @RequestMapping("delePro")
    @ResponseBody
    public  void delePro(ProductPojo pojo){
        productService.delePro(pojo);

    }

    @RequestMapping("upProduct")
    @ResponseBody
    public  void upProduct(ProductPojo pojo){
        productService.upProduct(pojo);

    }



    /**
     *
     * @param img
     * @param req
     * @return
     * @throws Exception
     */
    @RequestMapping("uploadimg")
    @ResponseBody
    public String uploadimg(MultipartFile img, HttpServletRequest req) throws Exception{
        //获取原文件名称
        String fileName = img.getOriginalFilename();
        System.out.println("上传的文件名是："+fileName);
        String folderPath = req.getSession().getServletContext().getRealPath("/")+
                "upload/";
        System.out.println("当前项目再tomcat下的绝对路径（磁盘地址）："+folderPath);
        File file = new File(folderPath);
//	        该目录是否已经存在
        if(!file.exists()){
            //   创建文件夹
            file.mkdir();
        }
//	        保证文件名的唯一性：uuid  或者 时间戳
        String onlyFileName = UUID.randomUUID().toString()+fileName.substring(fileName.lastIndexOf('.'));
//	        文件输出流
        FileOutputStream fos = new FileOutputStream(folderPath+onlyFileName);
        fos.write(img.getBytes());
        fos.flush();
        fos.close();
        return  "upload/"+onlyFileName;
    }

}
