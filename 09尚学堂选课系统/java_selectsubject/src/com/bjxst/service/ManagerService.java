package com.bjxst.service;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.bjsxt.dao.ManagerDao;
import com.bjsxt.entity.Course;
import com.bjsxt.entity.Student;
import com.bjsxt.entity.Teacher;
import com.bjsxt.utils.Utils;

public class ManagerService {
	
	//验证密码
	public boolean admPW(String id,String password){
		ManagerDao ma=new ManagerDao();
		boolean flag = false;
		List list=ma.getManList();
		if(id.equals(list.get(0))&&password.equals(list.get(2))){
			return true;
		}else{
			return false;
		}
	} 
	

	//添加学生
	public void addStu(String id,String name,String password,String age,String sex ){
		//获取Document对象
		SAXReader reader=new SAXReader();
		try {
			Document doc=reader.read(new File("userXML.xml"));
			//获取根节点
			Element root=doc.getRootElement();
			//获取要增加节点的对象
			Element Students=root.elementByID("1");
			//给Students增加子节点
			Element student = Students.addElement("student");
			student.addAttribute("ID", id);
			Element Name =student.addElement("name");
			Name.setText(name);
			Element Password=student.addElement("password");
			Password.setText(password);
			Element Age=student.addElement("age");
			Age.setText(age);
			Element Sex=student.addElement("sex");
			Sex.setText(sex);
			//将document对象从新写入到XML中
			Utils.ToXml(new File("userXML.xml"), doc);
			//调用 将学生添加到CoureViewXML可选课程 方法
			addStuCour(id);
		} catch (DocumentException e) {
			e.printStackTrace();
		}	
	}
	//将学生添加到CoureViewXML
	public void addStuCour(String id){
				//获取Document对象
				SAXReader reader=new SAXReader();
					Document doc;
					try {
						doc = reader.read(new File("CourseViewXMl.xml"));
						//获取根节点
						Element root=doc.getRootElement();
						//获取要增加节点的对象
						List<Element> list=root.elements();
						//可选课程节点
						Element courseUp=list.get(0);
						//已选课程节点
						Element courseDown=list.get(1);
						//给courseUp增加子节点
						Element student = courseUp.addElement("student");
						student.addAttribute("ID", id);
						Element student1 = courseDown.addElement("student");
						student1.addAttribute("ID", id);
						List<Course> course=Utils.getAllCourse();
						for(int i=0;i<course.size();i++){
							Element cour=student.addElement("course");
							cour.addAttribute("ID",course.get(i).getId());
							Element Name=cour.addElement("name");
							Name.setText(course.get(i).getName());
							Element Teacher=cour.addElement("teacher");
							Teacher.addAttribute("ID",course.get(i).getTeaId());
							Teacher.setText(course.get(i).getTeacher());	
						}
						//将document对象从新写入到XML中
						Utils.ToXml(new File("CourseViewXML.xml"), doc);
					} catch (DocumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
	}
	
	//添加老师
	public void addTea(String id,String name,String password,String age,String sex){
				//获取Document对象
				SAXReader reader=new SAXReader();
				try {
					Document doc=reader.read(new File("userXML.xml"));
					//获取根节点
					Element root=doc.getRootElement();
					//获取要增加节点的对象
					Element Teachers=root.elementByID("2");
					//给Students增加子节点
					Element teacher = Teachers.addElement("teacher");
					teacher.addAttribute("ID", id);
					Element Name =teacher.addElement("name");
					Name.setText(name);
					Element Password=teacher.addElement("password");
					Password.setText(password);
					Element Age=teacher.addElement("age");
					Age.setText(age);
					Element Sex=teacher.addElement("sex");
					Sex.setText(sex);
					Element Course=teacher.addElement("course");
					Course.setText("暂无课程");
					//将document对象从新写入到XML中
					Utils.ToXml(new File("userXML.xml"), doc);
				} catch (DocumentException e) {
					e.printStackTrace();
				}	
		
		
		
	}
	
	//根据指定id查看user信息
	public String showInfo(String id){
		StringBuilder b=new StringBuilder();
		//学生信息
		if(id.length()==6){
			List<Student> stu=new ArrayList();
			stu=Utils.getUser("1");
			boolean x=false;
			for(int i=0;i<stu.size();i++){
				if(id.equals(stu.get(i).getID())){
					x=true;
					  b.append("ID:"+stu.get(i).getID()+";");
					  b.append("姓名:"+stu.get(i).getName()+";");
					  b.append("密码:"+stu.get(i).getPassword()+";");
					  b.append("年纪:"+stu.get(i).getAge()+";");
					  b.append("性别:"+stu.get(i).getSex());
				}
				
				//return b.toString();
			}
			if(!x){
				return "us:null;us:null;us:null;us:null;us:null";
			}
			
		}
		//教师信息
		if(id.length()==4){
			List<Teacher> tea=new ArrayList();
			tea=Utils.getUser("2");
			boolean x=false;
			for(int i=0;i<tea.size();i++){
				if(id.equals(tea.get(i).getId())){
					x=true;
					  b.append("ID:"+tea.get(i).getId()+";");
					  b.append("姓名:"+tea.get(i).getName()+";");
					  b.append("密码:"+tea.get(i).getPassword()+";");
					  b.append("年纪:"+tea.get(i).getAge()+";");
					  b.append("性别:"+tea.get(i).getSex()+";");
					  b.append("课程"+tea.get(i).getCourse());
				}
			}
			if(!x){
				return "us:null;us:null;us:null;us:null;us:null";
			}
				//return b.toString();
			}
		//管理员信息
		if(id.length()==2){
			List<String> adm=new ArrayList();
			adm=Utils.getUser("3");
			boolean x=false;
			if(id.equals(adm.get(0))){
				x=true;
					  b.append("ID:"+adm.get(0)+";");
					  b.append("姓名:"+adm.get(1)+";");
					  b.append("密码:"+adm.get(2));
			}
			if(!x){
				return "us:null;us:null;us:null;us:null;us:null";
			}
				//return b.toString();
			}
			return b.toString();
			
		}
		
		
		
	
	

}
