package com.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.pojo.PageBean;
import com.pojo.Ticket;
import com.pojo.Typess;
import com.service.ITicketBiz;
import com.util.AJAXUtil;
@Controller
public class TicketController implements ITicketController {
	@Resource(name="TicketBizImpl")
	private ITicketBiz ibiz;
	

	public ITicketBiz getIbiz() {
		return ibiz;
	}

	public void setIbiz(ITicketBiz ibiz) {
		this.ibiz = ibiz;
	}

	@Override
	@RequestMapping(value="save_Ticket.do")
	public String save(HttpServletRequest request, HttpServletResponse response, Ticket tk) {
		System.out.println("11111111111111111111");
		Ticket otk=tk;
		//��ȡ��վ�ĸ�·��
		String realpath = request.getRealPath("/");
		System.out.println("2222222222222222222222");
		/*********�ļ��ϴ�***************/
		//��ȡ�ļ��ϴ�����Ƭ����
		MultipartFile multiparFile=tk.getPic();
		System.out.println("3333333333333333");
		if(multiparFile!=null&& !multiparFile.isEmpty()){
			System.out.println("44444");
			//��ȡ�ļ��ϴ�����
			String t_fname=multiparFile.getOriginalFilename();
			//������Ƭ����
			System.out.println("44444"+t_fname);
			if(t_fname.lastIndexOf(".")!=-1){
				System.out.println("5555555");
				//��ȡ��׺
				String ext =t_fname.substring(t_fname.lastIndexOf("."));
				//�жϺ�׺��ʽ
				if(ext.equalsIgnoreCase(".jpg")){
					String newt_fname = new Date().getTime()+ext;
					//�����ļ�����ָ���ļ����ϴ�·��
					File doFile = new File(realpath+"/uppic/"+newt_fname);					
					//�ϴ�
					try {
						FileUtils.copyInputStreamToFile(multiparFile.getInputStream(), doFile);
						otk.setT_fname(newt_fname);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				}
			}
		}
		/*********�ļ��ϴ�end************/
		int flag=ibiz.save(otk);
		if(flag>0){
			return "redirect:ticketlistupdate.jsp";
		}
		
		
		return "redirect:error.jsp";
	}

	@Override
	@RequestMapping(value="Update_Ticket.do")
	public String Update(HttpServletRequest request, HttpServletResponse response, Ticket tk) {
		//��ȡԭ��Ƭ�����޸���Ƭ��ʱ��չʾԭ��Ƭ
		String oldt_fname=ibiz.findById(tk.getT_id()).getT_fname();
		String realpath=request.getRealPath("/");
		/***************�ļ��ϴ�******************/
		//��ȡ�ļ��ϴ�����Ƭ����
				MultipartFile multiparFile=tk.getPic();
				if(multiparFile!=null&& !multiparFile.isEmpty()){
					//��ȡ�ļ��ϴ�����
					String t_fname=multiparFile.getOriginalFilename();
					//������Ƭ����
					if(t_fname.lastIndexOf(".")!=-1){
						//��ȡ��׺
						String ext =t_fname.substring(t_fname.lastIndexOf("."));
						//�жϺ�׺��ʽ
						if(ext.equalsIgnoreCase(".jpg")){
							String newt_fname = new Date().getTime()+ext;
							//�����ļ�����ָ���ļ����ϴ�·��
							File doFile = new File(realpath+"/uppic/"+newt_fname);					
							//�ϴ�
							try {
								FileUtils.copyInputStreamToFile(multiparFile.getInputStream(), doFile);
								tk.setT_fname(newt_fname);
								System.out.println("�ļ��ϴ��ɹ���");
								//ɾ��ԭ������Ƭ
								File oldfile = new File(realpath+"uppic"+oldt_fname);
								if(oldfile.exists()&&!oldfile.equals("default.jpg")){
									oldfile.delete();//ɾ��
								}
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}					
						}
					}
				}else{
					tk.setT_fname(oldt_fname);
				}
		/***************�ļ��ϴ�end***************/
		String Jsonstr;
		int flag=ibiz.Update(tk);
		if(flag>0){
			 Jsonstr=JSONObject.toJSONString(1);
		}else{
			Jsonstr=JSONObject.toJSONString(0);
		}
		AJAXUtil.printString(response, Jsonstr);
		return null;
	}

	@Override
	@RequestMapping(value="delById_Ticket.do")
	public String delById(HttpServletRequest request, HttpServletResponse response, Integer t_id) {
		String oldt_fname=ibiz.findById(t_id).getT_fname();
		int flag=ibiz.delById(t_id);
		String Jsonstr;
		if(flag>0){
			//ɾ��ԭ������Ƭ
			String realpath=request.getRealPath("/");
			File oldfile=new File(realpath+"uppic"+oldt_fname);
			if (oldfile.exists()&&!oldfile.equals("default.jpg")) {
				oldfile.delete();//ɾ��
			}
			Jsonstr=JSONObject.toJSONString(1);
		}
		else{
			Jsonstr=JSONObject.toJSONString(0);
		}
		AJAXUtil.printString(response, Jsonstr);
		return null;
	}

	@Override
	@RequestMapping(value="findById_Ticket.do")
	public String findById(HttpServletRequest request, HttpServletResponse response, Integer t_id) {
		Ticket oldtk=ibiz.findById(t_id);
		String Jsonstr=JSONObject.toJSONString(oldtk);
		AJAXUtil.printString(response, Jsonstr);
		return null;
	}

	@Override
	@RequestMapping(value="findPageAll_Ticket.do")
	public String findPageAll(HttpServletRequest request, HttpServletResponse response, Integer page, Integer rows) {
		HttpSession session=request.getSession();
	    PageBean pb=(PageBean)session.getAttribute("pb");
	    pb=pb==null?new PageBean():pb;
	    page=page==null||page<1?pb.getPage():page;
	    rows=rows==null||rows<1?pb.getRows():rows;
	    int maxrows=ibiz.findMaxRows();
	    int maxpage=1;
	    if(maxrows>0){
	    	maxpage=maxrows%rows==0?maxrows/rows:maxrows/rows+1;
	    }
	    if(page>maxpage)page=maxpage;
	    pb.setPage(page);
	    pb.setRows(rows);
	    List<Ticket> lsst=ibiz.findPageAll(pb);
	    pb.setMaxpage(maxpage);
	    pb.setPagelist(lsst);
	    session.setAttribute("pb", pb);
	    String Jsonstr=JSONObject.toJSONString(pb);
	    AJAXUtil.printString(response, Jsonstr);
		return null;
	}


	@Override
	public String findBytype(HttpServletRequest request, HttpServletResponse response, Ticket type_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RequestMapping(value="doint_Ticket.do")
	public String doint(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session=request.getSession();
		List<Typess> lsca=ibiz.doint();
		 String jsonstr=JSONObject.toJSONString(lsca);
		 AJAXUtil.printString(response, jsonstr);
		 	return null;
	}


}
