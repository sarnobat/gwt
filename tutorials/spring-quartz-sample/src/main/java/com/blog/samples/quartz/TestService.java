package com.blog.samples.quartz;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	private static final Logger logger_c = Logger.getLogger(TestService.class);
	String DIR_PATH = "/Users/sarnobat/Windows/favorites/ind/btt/";
	String[] EXTENSIONS = { "jpg" };

	public void testServiceMethod() {
		Date date = new Date();
		logger_c.debug("test service method invoked: " + date.toString());
		// load the sqlite-JDBC driver using the current class loader
		try {
			Class.forName("org.sqlite.JDBC");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			return;
		}
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName("org.sqlite.JDBC");
		ds.setUrl("jdbc:sqlite:/Users/sarnobat/Desktop/mac-sync/src/java/ImageScheduler/images.db");

		QueryRunner runner = new QueryRunner(ds);
		File dir = new File(DIR_PATH);
		if (!dir.exists()) {
			System.err.println("Doesn't exist: " + DIR_PATH);
			return;
		}
		Collection<File> files = FileUtils.listFiles(dir, EXTENSIONS, true);
		for (File f : files) {
			try {
				String md5 = DigestUtils.md5Hex(FileUtils
						.readFileToByteArray(f));
				System.out.println(md5 + "\t-\t" + f.getName());

				// Add new files to the DB
				try {
					runner.update(
							"insert into images (md5, filename, date_added) values (?,?,current_timestamp)",
							md5, f.getName());
				} catch (SQLException e) {
					if (e.getMessage().startsWith("[SQLITE_CONSTRAINT")) {
						System.out.println("Already in db: " + f.getName()
								+ "(" + md5 + ")");
					} else {
						e.printStackTrace();
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("classpath:spring-config.xml");
	}

	public static void m() {

	}
}