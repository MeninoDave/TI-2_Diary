package app;

import service.NoticiaService;
import spark.Filter;

import static spark.Spark.*;

public class Aplicacao {
	
	private static NoticiaService noticiaService = new NoticiaService();
	
	public static void main(String[] args) throws Exception{
		after((Filter) (request, response) -> {
            response.header("Access-Control-Allow-Origin", "*");
            response.header("Access-Control-Allow-Methods", "GET");
        });

		//pegar noticias do banco de dados e mostrar no site
		get("/news/:perfil", (request, response) -> noticiaService.getNews(request, response));
    }
}