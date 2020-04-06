package APITesting.org.classes;

public class PostRequest {
	
	private String id;
	private String title;
	private String author;
	
	public String getId(){
		return id;
	}
	public String getTitle(){
		return title;
	}
	public String getAuthor(){
		return author;
	}
	
	public void setId(String id){
		this.id=id;
	}
	
	public void settitle(String title){
		this.title=title;
	}

	public void setauthor(String author){
		this.author=author;
	}
}
