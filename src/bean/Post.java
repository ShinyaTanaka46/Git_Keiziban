package bean;

public class Post {
	private int id;
	private String name;
	private String mail;
	private String content;
	private String time;
	private String updtime;
	private String imgname;

	public Post(int id, String name, String mail, String content, String time, String updtime, String imgname) {
		super();
		this.id = id;
		this.name = name;
		this.mail = mail;
		this.content = content;
		this.time = time;
		this.updtime = updtime;
		this.imgname = imgname;
	}

	public Post() {
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getUpdtime() {
		return updtime;
	}
	public void setUpdtime(String updtime) {
		this.updtime = updtime;
	}
	public String getImgname() {
		return imgname;
	}
	public void setImgname(String imgname) {
		this.imgname = imgname;
	}

}