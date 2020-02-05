package com.serviceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mapper.ITicketMapper;
import com.pojo.PageBean;
import com.pojo.Ticket;
import com.pojo.Typess;
import com.service.ITicketBiz;
@Service("TicketBizImpl")
@Transactional
public class TicketBizImpl implements ITicketBiz{
	@Resource(name="TicketMapper")
	private ITicketMapper idao;

	public ITicketMapper getIdao() {
		return idao;
	}

	public void setIdao(ITicketMapper idao) {
		this.idao = idao;
	}

	@Override
	public int save(Ticket tk) {
		// TODO Auto-generated method stub
		return idao.save(tk);
	}

	@Override
	public int Update(Ticket tk) {
		// TODO Auto-generated method stub
		return idao.Update(tk);
	}

	@Override
	public int delById(Integer t_id) {
		// TODO Auto-generated method stub
		return idao.delById(t_id);
	}

	@Override
	public Ticket findById(Integer t_id) {
		// TODO Auto-generated method stub
		return idao.findById(t_id);
	}

	@Override
	public List<Ticket> findPageAll(PageBean pb) {
		int page=(pb.getPage()-1)*pb.getRows();
		int rows=pb.getRows();
		return idao.findPageAll(page, rows);
	}

	@Override
	public int findMaxRows() {
		// TODO Auto-generated method stub
		return idao.findMaxRows();
	}

	@Override
	public List<Typess> doint() {
		// TODO Auto-generated method stub
		return idao.doint();
	}

	@Override
	public List<Ticket> findBytype(String type_id) {
		// TODO Auto-generated method stub
		return idao.findBytype(type_id);
	}

}
