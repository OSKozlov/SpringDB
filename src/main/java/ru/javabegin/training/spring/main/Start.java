package ru.javabegin.training.spring.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.javabegin.training.spring.dao.impls.SQLiteDAO;
import ru.javabegin.training.spring.dao.objects.MP3;

public class Start {

	public static void main(String[] args) {
		MP3 mp3 = new MP3();
		mp3.setName("Song name");
		mp3.setAuthor("Song author");

		// new SQLiteDAO().insertWithJDBC(mp3);

		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		SQLiteDAO sqLiteDAO = (SQLiteDAO) context.getBean("sqliteDAO");

//		sqLiteDAO.insert(mp3);
		List<MP3> list = sqLiteDAO.getMP3ListByAuthor("Ark");
		System.out.println(list.size());
		if (!list.isEmpty()) {
			for(MP3 item : list) {
				System.out.println("-- Author: " + item.getAuthor());
				System.out.println("-- Name: " + item.getName());
			}
		}
	}

}
