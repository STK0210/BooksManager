package com.lky.one.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.html.HtmlSelectOneListbox;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import com.lky.one.domain.Book;
import com.lky.one.utils.ComponentUtils;

@ManagedBean(eager = false)
@SessionScoped
public class BookCtrl {

	public BookCtrl() {
		System.out.println("工具BookCtrl初始化");
	}

	@EJB
	private static com.lky.one.ejb.BookAddListStateful bookAddList;

	public void selectKind(ValueChangeEvent e) {
		System.out.println("调用了类别选择方法");
		//System.out.println(bookAddList);

		FacesContext ctx = FacesContext.getCurrentInstance();

		HtmlSelectOneListbox box = (HtmlSelectOneListbox) ComponentUtils.findComponent(ctx.getViewRoot(), "bid");
		box.getChildren().clear();

		int tempkind = (int) e.getNewValue();
		Book book = getNewBook();
		book.setSubKind(tempkind);
		ctx.renderResponse();
	}

	public void addClick(ActionEvent e) {
		try {
			Book book = getNewBook();
			logFile(book.toString());
			System.out.println("点击了addclick，存储了日志，日志内容为：" + book.toString());
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	public Book getNewBook() {
		return (Book) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("book");
	}

	public String addBook() throws SQLException {

//		System.out.println("添加书addbook：" + book);
//		FacesMessage msg = new FacesMessage("添加成功", book.toString());
//		FacesContext.getCurrentInstance().addMessage("addBookForm:addBook", msg);
//		
//		
//		DB_Book db_Book = new DB_Book();
//		db_Book.addBook(book);
		Book book = getNewBook();
		// System.out.println("往临时list中添加书addbook：" + book);
		// System.out.println("FacesContext:" +
		// FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("book"));
		bookAddList.addBook(book);
		FacesMessage msg = new FacesMessage("添加成功", book.toString());
		FacesContext.getCurrentInstance().addMessage("addBookForm:addBook", msg);

		FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("book", null);
		return book.toString();
	}

	public static void clearBooks() {
		if (bookAddList != null) {
			bookAddList.clearBookList();
		}
	}

	public static List<Book> getBookAddList() {
		// System.out.println("@@@@@" + bookAddList);
		if (bookAddList == null) {
			return null;
		} else {
			// System.out.println("@@@@@" + bookAddList.getBookAddList());
			return bookAddList.getBookAddList();
		}
	}

	private void logFile(String log) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter("config.txt", true)); // 需要在尾部追加
		bw.write(log);
		bw.newLine();
		bw.close();
	}

}
