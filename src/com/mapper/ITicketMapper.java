package com.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import com.pojo.Ticket;
import com.pojo.Typess;

@Service("TicketMapper")
public interface ITicketMapper {
	//����Ʊ����Ϣ
	public int save (Ticket tk);
	//�޸�Ʊ����Ϣ
	public int Update (Ticket tk);
	//ɾ��Ʊ����Ϣ
	public int delById (Integer t_id);
	//��ѯ����Ʊ����Ϣ
	public Ticket findById (Integer t_id);
	//��ѯ���У���ҳ��
	public List<Ticket> findPageAll (@Param(value="page") Integer page,@Param(value="rows") Integer rows);
	//��ѯ��������
	public int findMaxRows();
	//��ѯ����
	public List<Typess> doint();
	//��ѯ����Ʊ����Ϣ
	public List<Ticket> findBytype(String type_id);

}
