package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pojo.Ticket;

public interface ITicketController {
	public String save(HttpServletRequest request,HttpServletResponse response,Ticket tk);
	public String Update(HttpServletRequest request,HttpServletResponse response,Ticket tk);
	public String delById(HttpServletRequest request,HttpServletResponse response,Integer t_id);
	public String findById(HttpServletRequest request,HttpServletResponse response,Integer t_id);
	public String findPageAll(HttpServletRequest request,HttpServletResponse response,Integer page,Integer rows);
	public String doint(HttpServletRequest request,HttpServletResponse response);
	public String findBytype(HttpServletRequest request,HttpServletResponse response,Ticket type_id);

}
