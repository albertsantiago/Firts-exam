import static spark.Spark.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Servidor {
	
    public static void main(String[] args) {
    	port(1234);
    	staticFileLocation("/");
    	
    	Logger logger = LoggerFactory.getLogger(Servidor.class);
    	
    	/**
         * Codigos de respuestas:
         */
    	
    	get("/home", (req, res) -> {
    		res.status(200);
    		res.header("content-type", "text/html");
    		res.redirect("/home.html");
    		return null;
    	});
    	
    	
    	
        get("/*", (req, res) -> {
        	logger.info("Esta url no existe");
        	res.status(404);
        	res.header("content-type", "text");
        	return "404: Pagina no encontrada (Esta url no existe)";
        });
        
        

    	get("/home", (req, res) -> {
    		logger.info("/home :: entramos por la homepage");;
    		res.header("content-type", "text-html-css");
    		res.redirect("/home.html");
    		return null;
    	});
    	
    	get("/contact", (req, res) -> {
    		logger.warn("/contact :: Habra Peligro si completas mal los campos!");
    		res.redirect("/contact.html");
    		return null;
    	});
    	
    	get("/aboutus", (req, res) -> {
    		logger.info("/about :: entramos a la ruta de quien es la empresa");;
    		res.redirect("/aboutus.html");
    		return null;
    	});
    }
}
