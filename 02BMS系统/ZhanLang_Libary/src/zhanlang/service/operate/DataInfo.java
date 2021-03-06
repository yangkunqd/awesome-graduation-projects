package zhanlang.service.operate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import zhanlang.entity.Book;
import zhanlang.entity.Manager;
import zhanlang.entity.Person;
import zhanlang.entity.User;

public class DataInfo {
	public static List<Book> bookList = new ArrayList<Book>();
	public static List<Person> perList = new ArrayList<Person>();
	public static Book book;
	public static Person per;
	
	public static void init(){
		try {
			bookList.removeAll(bookList);
			perList.removeAll(perList);
			bookParse();
			PersonParse();
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 解析书数据（查）
	 * @return
	 * @throws DocumentException
	 */
	public static List<Book> bookParse() throws DocumentException {
		//1.获取Docment对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("Book.xml"));
		//2.获取根节点
		Element BookRoot = doc.getRootElement();
		BookRoot.attribute("size");
		//3.获取根节点的子结点对象集合
		List<Element> bookxList = BookRoot.elements();
		
		//4.遍历集合0
		for (Element ele : bookxList) {
			String bookID = ele.elementText("bookID");//图书编号
			String image = ele.elementText("image");//图片
			String bName = ele.elementText("bName");//书名
			String author = ele.elementText("author");//作者
			String press = ele.elementText("press");//出版社
			String inTime = ele.elementText("inTime");//入库时间
			String type = ele.elementText("type");//类型
			String borrow = ele.elementText("borrow");//借阅者
			String outTime = ele.elementText("outTime");//借出时间
			String introduce = ele.elementText("introduce");//借出时间
			book = new Book(bookID,image,bName,author,press,borrow,inTime,outTime,type,introduce);
			bookList.add(book);
		}
		return bookList;
	}
	
	/**
	 * 解析用户数据（查）
	 * @return
	 * @throws DocumentException
	 */
	public static List<Person> PersonParse() throws DocumentException {
		//1.获取Docment对象
		SAXReader reader = new SAXReader();
		Document doc = reader.read(new File("Person.xml"));
		//2.获取根节点
		Element root = doc.getRootElement();
		root.attribute("size");
		//3.获取根节点的子结点对象集合
		List<Element> perxList = root.elements();
		List<Element> userxList = perxList.get(0).elements();
		List<Element> managerxList = perxList.get(1).elements();
		//4.遍历集合
		for (Element ele : userxList) {
			String id = ele.elementText("userid");
			String userName = ele.elementText("userName");
			String password = ele.elementText("password");
			String name = ele.elementText("name");
			String sex=ele.elementText("sex");
			String age = ele.elementText("age");
			String tel=ele.elementText("tel");
			String address=ele.elementText("address");
			per = new User(name, sex, tel, age, address, userName,password);
			System.out.println(per);
			perList.add(per);
		}
		for (Element ele : managerxList){
			String id = ele.elementText("userid");
			String userName = ele.elementText("userName");
			String password = ele.elementText("password");
			per = new Manager(userName,password);
			perList.add(per);
		}
		return perList;
	}
	
	/**
	 * 将添加的数据写入XML(增)
	 * @param per
	 * @return
	 * @throws DocumentException
	 * @throws IOException 
	 */
	public boolean addData(Object obj) throws DocumentException, IOException{
		//1.获取Docment对象
		SAXReader reader = new SAXReader();
		Document doc = null;
		if(obj instanceof Person){
			doc = reader.read(new File("Person.xml"));
		}
		if(obj instanceof Book){
			doc = reader.read(new File("Book.xml"));
		}
		//2.获取根节点
		Element root = doc.getRootElement();
		root.addAttribute("size", ""+(Integer.parseInt(root.attribute("size").getValue())+1));
		
		//3.获取要增加节点的person节点对象
		List<Element> list = root.elements();//得到根节点下所有表的集合
		List<Element> userxList = list.get(0).elements();
		List<Element> managerxList = list.get(1).elements();
		
		if(obj instanceof User){//添加User数据
			User user = (User) obj;	
			System.out.println(user);
			for (Element ele : userxList) {
				if(user.getUserName().equals(ele.elementText("userName"))){
					return false;
				}
			}
			Element ele = list.get(0).addElement("user");//添加user节点的标签
			String id=root.attribute("size").getValue();
			ele.addAttribute("ID", id);
			
			Element userID = ele.addElement("id");
			Element userName=ele.addElement("userName");
			Element name=ele.addElement("name");
			Element tel=ele.addElement("tel");
			Element age=ele.addElement("age");
			Element address=ele.addElement("address");
			Element sex=ele.addElement("sex");
			Element password=ele.addElement("password");
			String userNameBuf=user.getUserName();
			String nameBuf = user.getName();
			String telBuf = user.getTel();
			String ageBuf = user.getAge();
			String addressBuf = user.getAddress();
			String sexBuf = user.getSex();
			String passwordBuff=user.getPassword();
			userID.setText(id);
			userName.setText(userNameBuf);
			name.setText(nameBuf);
			tel.setText(telBuf);
			age.setText(ageBuf);
			address.setText(addressBuf);
			sex.setText(sexBuf);
			password.setText(passwordBuff);
		}
		if(obj instanceof Manager){//添加Manager数据
			Manager manager = (Manager) obj;
			for (Element ele : managerxList) {
				if(manager.getUserName().equals(ele.elementText("userName"))){
					return false;
				}
			}
			Element ele = list.get(1).addElement("manager");//添加manager节点的标签
			String id=root.attribute("size").getValue();
			ele.addAttribute("ID", id);
			Element userID = ele.addElement("id");
			Element userName=ele.addElement("userName");
			Element name=ele.addElement("name");
			Element tel=ele.addElement("tel");
			Element age=ele.addElement("age");
			Element address=ele.addElement("address");
			Element sex=ele.addElement("sex");
			Element password=ele.addElement("password");
			String userNameBuf=manager.getUserName();
			String nameBuf = manager.getName();
			String telBuf = manager.getTel();
			String ageBuf = manager.getAge();
			String addressBuf = manager.getAddress();
			String sexBuf = manager.getSex();
			String passwordBuff=manager.getPassword();
			userID.setText(id);
			userName.setText(userNameBuf);
			name.setText(nameBuf);
			tel.setText(telBuf);
			age.setText(ageBuf);
			address.setText(addressBuf);
			sex.setText(sexBuf);
			password.setText(passwordBuff);
			
		}
		
		if(obj instanceof Book) {//添加book的数据
		/*	Book book = (Book) obj;
//			for (Element ele : list) {
//				if(ele.elementText("ID").equals(book.getID())){
//					return false;
//				}
//			}
			Element ele = root.addElement("book");//添加book节点的标签
			String image = new String(book.getImage());
//			ele.addElement("image", image);
			ele.addElement("bookID", book.getID());
			ele.addElement("bname", book.getbName());
			ele.addElement("author", book.getAuthor());
			ele.addElement("press", book.getPress());
//			ele.addElement("borrow", book.getBorrow());
			ele.addElement("type", book.getType());
			ele.addElement("inTime", book.getInTime());
//			ele.addElement("outTime", book.getOutTime());
			ele.attribute("ID");//添加标签ID
	*/		Book book = (Book) obj;
			Element ele = root.addElement("book");//添加book节点的标签
			String id=root.attribute("size").getValue();
			String name=book.getbName();
			String image=book.getImage();
			String author=book.getAuthor();
			String press=book.getPress();
			String time=book.getInTime();
			String type=book.getType();
			String introduce=book.getIntroduce();
			String borrow = "null";
			ele.addAttribute("ID", id);
			Element eimage=ele.addElement("image");
			Element ebookid=ele.addElement("bookID");
			Element ebname=ele.addElement("bName");
			Element eauthor=ele.addElement("author");
			Element epress=ele.addElement("press");
			Element etype=ele.addElement("type");
			Element einTime=ele.addElement("inTime");
			Element eborrow = ele.addElement("borrow");
			Element eintroduce = ele.addElement("introduce");
			
			etype.setText(type);
			eimage.setText(image);
			ebookid.setText(id);
			ebname.setText(name);
			eauthor.setText(author);
			epress.setText(press);
			einTime.setText(time);
			eborrow.setText(borrow);
			eintroduce.setText(introduce);
		}
		
		//4.将document对象重新写入xml里
		OutputStream file = null;
		if(obj instanceof Person){
			file = new FileOutputStream("Person.xml");
		}
		if(obj instanceof Book){
			file = new FileOutputStream("Book.xml");
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置写出的编码格式
		format.setEncoding("utf-8");
		//创建xml写出对象
		XMLWriter write = new XMLWriter(file,format);
		//写出
		write.write(doc);
		return true;
	}
		
	/**
	 * 删除数据
	 * @param obj
	 * @throws DocumentException 
	 * @throws IOException 
	 */
	public boolean delData(Object obj) throws DocumentException, IOException{
		boolean flage = false;
		//1.获取Docment对象
		SAXReader reader = new SAXReader();
		Document doc = null;
		if(obj instanceof Person){
			doc = reader.read(new File("Person.xml"));
		}
		if(obj instanceof Book){
			doc = reader.read(new File("Book.xml"));
		}
		//2.获取根节点
		Element root = doc.getRootElement();
		//查找是否存在
		List<Element> list = root.elements();//得到根节点下所有表的集合
		List<Element> userxList = list.get(0).elements();
		List<Element> managerxList = list.get(1).elements();
		//3.获取要删除的节点对象\
		Element ele = null;
		if(obj instanceof User){//获取要删除的用户
			User user = (User) obj;
			for (Element ele1 : userxList) {
				if(user.getUserName().equals(ele1.elementText("userName"))){
					flage = true;
				}
			}
			if(!flage){
				return flage;
			}
			ele = root.elementByID("001").elementByID(user.getID());
			
			root.elementByID("001").remove(ele);//删除该节点
		}
		if(obj instanceof Manager){//获取要删除的管理员
			Manager manager = (Manager) obj;
			for (Element ele1 : managerxList) {
				if(manager.getUserName().equals(ele1.elementText("userName"))){
					flage = true;
				}
			}
			if(!flage){
				return flage;
			}
			ele = root.elementByID("002").elementByID(manager.getID());
			root.elementByID("002").remove(ele);//删除该节点
		}
		if(obj instanceof Book){//获取要删除的书
			Book book = (Book) obj;
			for (Element ele1 : list) {
				if(book.getID().equals(ele1.elementText("bookID"))){
					flage = true;
				}
			}
			if(!flage){
				return flage;
			}
			ele = root.elementByID(book.getID());
			root.remove(ele);//删除该节点
		}
		
		//4.将document对象重新写入XML中
		OutputStream file = null;
		if(obj instanceof Person){
			file = new FileOutputStream("Person.xml");
		}
		if(obj instanceof Book){
			file = new FileOutputStream("Book.xml");
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置写出的编码格式
		format.setEncoding("utf-8");
		//创建xml写出对象
		XMLWriter write = new XMLWriter(file,format);
		//写出
		write.write(doc);
		return flage;
	}
	
	/**
	 * 修改数据
	 * @param obj
	 * @throws DocumentException 
	 * @throws IOException 
	 */
	public boolean altData(Object obj,String property,String content) throws DocumentException, IOException{
		boolean flage = false;
		//1.获取Docment对象
		SAXReader reader = new SAXReader();
		Document doc = null;
		if(obj instanceof Person){
			doc = reader.read(new File("Person.xml"));
		}
		if(obj instanceof Book){
			doc = reader.read(new File("Book.xml"));
		}
		//2.获取根节点
		Element root = doc.getRootElement();
		List<Element> list = root.elements();//得到根节点下所有表的集合
		List<Element> userxList = list.get(0).elements();
		List<Element> managerxList = list.get(1).elements();
		//3.获取要修改的子结点对象
		Element ele = null;
		if(obj instanceof User){
			System.out.println("传进来了个什么鬼东西？" + obj);
			User user = (User) obj;
			for (Element ele1 : userxList) {
				if(user.getUserName().equals(ele1.elementText("userName"))){
					flage = true;
				}
			}
			if(!flage){
				return flage;
			}
			System.out.println("传过来个什么属性呢？" + property);
			System.out.println("那里有空指针呢？1" + root.elementByID("001"));
			System.out.println("那里有空指针呢？2" + root.elementByID("001").elementByID(user.getID()));
			System.out.println("那里有空指针呢？3" + user.getID());
			System.out.println("那里有空指针呢？" + property);
			System.out.println("那里有空指针呢？" + root.elementByID("001").elementByID(user.getID()).element(property));
			ele = root.elementByID("001").elementByID(user.getID()).element(property);
		}
		if(obj instanceof Manager){
			Manager manager = (Manager) obj;
			for (Element ele1 : managerxList) {
				if(manager.getUserName().equals(ele1.elementText("userName"))){
					flage = true;
				}
			}
			if(!flage){
				return flage;
			}
			ele = root.elementByID("002").elementByID(manager.getID()).element(property);
		}
		if(obj instanceof Book){
			Book book = (Book) obj;
			for (Element ele1 : list) {
				if(book.getID().equals(ele1.elementText("bookID"))){
					flage = true;
				}
			}
			if(!flage){
				return flage;
			}
			
			ele = root.elementByID(book.getID()).element(property);
		}
		//修改元素内容
		ele.setText(content);
		//4.将document对象重新写入XML中
		OutputStream file = null;
		if(obj instanceof Person){
			file = new FileOutputStream("Person.xml");
		}
		if(obj instanceof Book){
			file = new FileOutputStream("Book.xml");
		}
		OutputFormat format = OutputFormat.createPrettyPrint();
		//设置写出的编码格式
		format.setEncoding("utf-8");
		//创建xml写出对象
		XMLWriter write = new XMLWriter(file,format);
		//写出
		write.write(doc);
		return flage;
	}
	
}
