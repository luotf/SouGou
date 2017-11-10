package com.ltf.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DB {
	// (1)定义属性：
	Connection conn;
	PreparedStatement ps;
	ResultSet rs;
	DataSource ds;
	
	public DB() {
			
			try {
				Context ctx = new InitialContext();
				ctx = (Context) ctx.lookup("java:comp/env");
				ds = (DataSource) ctx.lookup("TestJNDI"); // 获取连接池对象
				conn=ds.getConnection();
				System.out.println("数据库连接成功！");
			} catch (Exception e) {
				System.out.println("数据库连接失败！");
			}
			
		}

		// (3)编写一个update方法，用来完成数据库的增、删、该操作：
		public int excuteUpdate(String sql, String[] param) {
			System.out.println("执行语句："+sql);
			int num = 0;
			// 处理SQL，执行SQL
			try {
				ps = conn.prepareStatement(sql);// 得到PreparedStatement对象
				if (param != null) {
					for (int i = 0; i < param.length; i++) {
						ps.setString(i + 1, param[i]);
					}
				}
				// 执行SQL语句
				num = ps.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return num;

		}

		// （4）编写一个excuteQuery()方法，用来完成数据库的查询操作
		public ResultSet excuteQuery(String sql, String[] param) {
				System.out.println("执行语句："+sql);
			try {
				ps = conn.prepareStatement(sql);// 得到PreparedStatement对象
				if (param != null) {
					for (int i = 0; i < param.length; i++) {
						ps.setString(i + 1, param[i]);
					}
				}
				rs = ps.executeQuery();

			} catch (SQLException e) {
				e.printStackTrace();
			}
			return rs;
		}

		// (5)编写一个关闭方法。
		public void closeAll() throws Exception {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		}
}
