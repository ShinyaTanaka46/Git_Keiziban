package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import bean.Post;


public class Keizibandao {
	private static final String url = "jdbc:mysql://localhost:3306/javakadai?serverTimezone=JST";
	private static final String user = "root";
	private static final String pw = "Shinya46";

	public static ArrayList<Post> SelectAll(){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM keiziban ORDER BY time DESC";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			ArrayList<Post> PostList = new ArrayList<Post>();

			while( rs.next() ){
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String content = rs.getString("content");
				String time = rs.getString("time");
				String updtime = rs.getString("updtime");
				String imgname = rs.getString("imgname");
				PostList.add(new Post(id,name,mail,content,time,updtime,imgname));
			}

			return PostList;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}


	public static Post SelectId(int updid){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "SELECT * FROM keiziban WHERE id = ?";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, updid);

			// ⑥SQL文を実行してDBMSから結果を受信する
			rs = pstmt.executeQuery();

			Post UpdPost = new Post();

			while(rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String mail = rs.getString("mail");
				String content = rs.getString("content");
				String time = rs.getString("time");
				String updtime = rs.getString("updtime");
				String imgname = rs.getString("imgname");
				UpdPost = new Post(id,name,mail,content,time,updtime,imgname);
			}


			return UpdPost;

		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
		return null;
	}


	public static void InsertPost(String name,String mail,String content,String time,String updtime){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "INSERT INTO keiziban(name,mail,content,time,updtime)"
					+ " VALUE(?,?,?,?,?)";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, time);
			pstmt.setString(5, updtime);

			// ⑥SQL文を実行してDBMSから結果を受信する
			int result = pstmt.executeUpdate();


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}


	public static void InsertPost2(String name,String mail,String content,String time,String updtime,String imgname){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "INSERT INTO keiziban(name,mail,content,time,updtime,imgname)"
					+ " VALUE(?,?,?,?,?,?)";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, name);
			pstmt.setString(2, mail);
			pstmt.setString(3, content);
			pstmt.setString(4, time);
			pstmt.setString(5, updtime);
			pstmt.setString(6, imgname);

			// ⑥SQL文を実行してDBMSから結果を受信する
			int result = pstmt.executeUpdate();


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}



	public static void UpdatePost(int updid, String updtext, String updtime){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "UPDATE keiziban SET content = ?,updtime = ? WHERE id = ?";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, updtext);
			pstmt.setString(2, updtime);
			pstmt.setInt(3, updid);

			// ⑥SQL文を実行してDBMSから結果を受信する
			int result = pstmt.executeUpdate();


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}



	public static void DeletePost(int delid){
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// ②JDBCドライバをロードする
			Class.forName("com.mysql.cj.jdbc.Driver");

			// ③DBMSとの接続を確立する
			con = DriverManager.getConnection(url,user,pw);
			// ④SQL文を作成する
			String sql = "DELETE FROM keiziban WHERE id=?";
			// ⑤SQL文を実行するための準備を行う
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, delid);

			// ⑥SQL文を実行してDBMSから結果を受信する
			int result = pstmt.executeUpdate();


		} catch (ClassNotFoundException e) {
			System.out.println("JDBCドライバが見つかりません。");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DBアクセス時にエラーが発生しました。");
			e.printStackTrace();
		} finally {
			// ⑧DBMSから切断する
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (pstmt != null) {
					pstmt.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
			try {
				if (con != null) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println("DBアクセス時にエラーが発生しました。");
				e.printStackTrace();
			}
		}
	}
}