package com.sharad.Footwears.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sharad.Footwears.DAO.CategoryDAO;
import com.sharad.Footwears.DAO.ProductDAO;
import com.sharad.Footwears.DAO.SupplierDAO;
import com.sharad.Footwears.modal.Supplier;
import com.sharad.Footwears.modal.productmodel;

@Controller
public class Productcontroller {
	@Autowired
	ProductDAO productDAO;	
	
	@Autowired
	admincontroller admin;//i have created this object so that i can access list function from admin controller
	
	@Autowired
	SupplierDAO supplierDAO;
	@Autowired
	CategoryDAO categoryDAO;
	
	@Autowired
	com.sharad.Footwears.modal.Category category;
	
	@Autowired
	Supplier supplier;
	
	
	
	@Transactional
	@RequestMapping("/validateaddproduct")
	public ModelAndView validateaddproduct(@ModelAttribute productmodel productmodel,@RequestParam("categoryname") String name,@RequestParam("suppliername") String name1,@RequestParam("pid") String prodid,@RequestParam("pname")String proname,@RequestParam("description") String desc,@RequestParam("cost") double cp,@RequestParam("quantity")String qty)
	{
		if(prodid.equals(""))
		{
			ModelAndView mv1= new ModelAndView("forward:/addproduct","command",new productmodel());
			mv1.addObject("idnull", "please enterid");
			return mv1;
		}
		
		if(proname.equals(""))
		{
			ModelAndView mv1= new ModelAndView("forward:/addproduct","command",new productmodel());
			mv1.addObject("namenull", "please enter name");
			return mv1;
		}
		
		if(desc.equals(""))
		{
			ModelAndView mv1= new ModelAndView("forward:/addproduct","command",new productmodel());
			mv1.addObject("descnull", "please enter description");
			return mv1;
		}
		
		if(qty.equals(""))
		{
			ModelAndView mv1= new ModelAndView("forward:/addproduct","command",new productmodel());
			mv1.addObject("qtynull", "please enter quantity");
			return mv1;
		}
		
		if(cp==0.0 && cp==0)
		{
			ModelAndView mv1= new ModelAndView("forward:/addproduct","command",new productmodel());
			mv1.addObject("costnull", "please enter costprice");
			return mv1;
		}
		
		category  = categoryDAO.getcategorybyname(name);
		supplier = supplierDAO.getsupplierbyname(name1);
		productmodel.setCategoryid(category.getId());
		productmodel.setSupplierid(supplier.getId());
		productDAO.Save(productmodel);
		String path="C:\\Users\\Lenovo\\Desktop\\new project\\Footwears\\src\\main\\webapp\\images\\";
		path=path+String.valueOf(productmodel.getPid())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=productmodel.getProductimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
		List<productmodel> list = admin.showlist();
		ModelAndView mv = new ModelAndView("/validateAddProduct");
		mv.addObject("productlist",list);
		mv.addObject("Success","Product Added Successfully");
		return mv;
	}
	
	
	
	@Transactional
	@RequestMapping("/validatedeleteproduct")
	public ModelAndView deleteproduct(@RequestParam("pid")String id)
	{
		if(id.equals(""))
		{
			ModelAndView mv1=new ModelAndView("forward:/deleteproduct","command",new productmodel());
			mv1.addObject("nullid", "please enter id to be deleted");
			return mv1;
		}
		productmodel productmodel=productDAO.getproductbyid(id);
		productDAO.delete(productmodel);
			List<productmodel> list = admin.showlist();
			ModelAndView mv= new ModelAndView("/deleteproduct","command",new productmodel());
			mv.addObject("productlist",list);
			return mv;
	}
	@Transactional
	@RequestMapping("/validateedit")
	public ModelAndView editproduct(@RequestParam("pid")String id,productmodel productmodel)
	{
		String path="C:\\Users\\Lenovo\\Desktop\\new project\\Footwears\\src\\main\\webapp\\images\\";
		productmodel=productDAO.getproductbyid(id);
		System.out.println(id);
		if(id.equals(""))
		{
			ModelAndView mv1=new ModelAndView("forward:/editproduct","command",new productmodel());
			mv1.addObject("nullid", "please enter the id");
			return mv1;
		}
		ModelAndView mv= new ModelAndView("/validateeditproduct","command",new productmodel());
			List<productmodel> list = admin.showlist();
			mv.addObject("productlist",list);
			mv.addObject("productimage",path);
			mv.addObject("PID", id);
			mv.addObject("PNAME",productmodel.getPname());
			mv.addObject("PIMAGE",productmodel.getProductimage());
			mv.addObject("DESC",productmodel.getDescription());
			mv.addObject("QTY",productmodel.getQuantity());
			mv.addObject("CP",productmodel.getCost());
			return mv;
	}
	@Transactional
	@RequestMapping("/validateeditproduct")
	public ModelAndView validateeditproduct(@ModelAttribute productmodel productmodel,@RequestParam("pid")String id)
	{
		System.out.println("in validateeditproduct");
		
		ModelAndView mv = new ModelAndView("/editproduct","command",new productmodel());
		productDAO.update(productmodel);
		String path="C:\\Users\\Lenovo\\Desktop\\new project\\Footwears\\src\\main\\webapp\\images\\";
		path=path+String.valueOf(productmodel.getPid())+".jpg";
		File f=new File(path);
	
		MultipartFile filedet=productmodel.getProductimage();
		
		if(!filedet.isEmpty())
		{
			try
			{
			  byte[] bytes=filedet.getBytes();
			  System.out.println(bytes.length);
			  FileOutputStream fos=new FileOutputStream(f);
              			BufferedOutputStream bs=new BufferedOutputStream(fos);
              			bs.write(bytes);
              			bs.close();
             			 System.out.println("File Uploaded Successfully");
			}
			catch(Exception e)
			{
				System.out.println("Exception Arised"+e);
			}
		}
		else
		{
			System.out.println("File is Empty not Uploaded");
			
		}
		
	
		List<productmodel> list = admin.showlist();
		mv.addObject("productlist",list);
		System.out.println("aftermodelandview");
		System.out.println("afterproductdaoupdate");
		mv.addObject("SuccessU","Product Updated Successfully");
		String path1="C:\\Users\\Lenovo\\Desktop\\new project\\Footwears\\src\\main\\webapp\\images\\";
		mv.addObject("productimage", path1);
		return mv;
	}
	
	@RequestMapping("/viewproducts")
	public ModelAndView showproducts(@ModelAttribute productmodel productmodel)
	{
		String path="C:\\Users\\Lenovo\\Desktop\\new project\\Footwears\\src\\main\\webapp\\images\\";
		List<productmodel> list = admin.showlist();
		 
		ModelAndView mv=new ModelAndView("/productslist");
		mv.addObject("productlist",list);
		mv.addObject("productimage",path);
		return mv;
	}

	
}