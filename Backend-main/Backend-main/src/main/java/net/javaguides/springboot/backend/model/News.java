package net.javaguides.springboot.backend.model;

public class News {
    private Integer idnews;
    private String date;
    private String news;
    public News(){}
    public News(String date,String news){
        super();
        this.date=date;
        this.news=news;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getNews() {
        return news;
    }
    public void setNews(String news) {
        this.news = news;
    }
    

    
    
}
