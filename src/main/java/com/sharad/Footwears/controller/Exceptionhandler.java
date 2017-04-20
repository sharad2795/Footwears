package com.sharad.Footwears.controller;

import javax.validation.ConstraintViolationException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class Exceptionhandler
{
	@ExceptionHandler(ConstraintViolationException.class)
	public ModelAndView gotConstraintException(Exception e)
	{
		
		ModelAndView mv=new ModelAndView("/errorpage");
		mv.addObject("errormsg", e.getMessage());
		return mv;
	}
	
}
