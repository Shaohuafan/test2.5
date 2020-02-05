package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.PageBean;
import com.pojo.Ticket;
import com.pojo.Typess;

public interface ITicketBiz {
	//增加票务信息
		public int save (Ticket tk);
		//修改票务信息
		public int Update (Ticket tk);
		//删除票务信息
		public int delById (Integer t_id);
		//查询单个票务信息
		public Ticket findById (Integer t_id);
		//查询所有（分页）
		public List<Ticket> findPageAll (PageBean pb);
		//查询所有行数
		public int findMaxRows();
		//查询种类
		public List<Typess> doint();
		//查询种类票务信息
		public List<Ticket> findBytype(String type_id);


}
