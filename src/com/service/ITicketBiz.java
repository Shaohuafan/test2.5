package com.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.pojo.PageBean;
import com.pojo.Ticket;
import com.pojo.Typess;

public interface ITicketBiz {
	//����Ʊ����Ϣ
		public int save (Ticket tk);
		//�޸�Ʊ����Ϣ
		public int Update (Ticket tk);
		//ɾ��Ʊ����Ϣ
		public int delById (Integer t_id);
		//��ѯ����Ʊ����Ϣ
		public Ticket findById (Integer t_id);
		//��ѯ���У���ҳ��
		public List<Ticket> findPageAll (PageBean pb);
		//��ѯ��������
		public int findMaxRows();
		//��ѯ����
		public List<Typess> doint();
		//��ѯ����Ʊ����Ϣ
		public List<Ticket> findBytype(String type_id);


}
