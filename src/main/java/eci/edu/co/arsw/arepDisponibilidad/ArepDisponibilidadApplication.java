package eci.edu.co.arsw.arepDisponibilidad;

import static spark.Spark.*;

import java.io.IOException;

import spark.Request;
import spark.Response;

import eci.edu.co.arsw.arepDisponibilidad.model.Hanoi;
import spark.Response; 
public class ArepDisponibilidadApplication {

	public static void main(String[] args) {
		staticFileLocation("/static");
		
		port(getPort());
		post("/result",(request,response)-> {
            int num = Integer.parseInt(request.body());
            return resultPage(num);
		});
		get("/",(req, res)->{
            res.redirect("index.html");
        return null;
		});
		
	}
	/**
	 * Responde al request del usuario y envia la cantidad de movimientos 
	 * @param num numero de discos de la torre de Hanoi 
	 * @return String con el resultado de los pasos 
	 * @throws IOException Exceptiom
	 */
	 private static String resultPage(int num) throws IOException{
        System.out.println("Hola perra");
        Hanoi hanoi = new Hanoi(num);
        String result = hanoi.getResult();
        int numMove = hanoi.getNumMove();
        System.out.println(numMove);
        String resultado = ("Number of movements = " +numMove);
        
        
        return resultado;

	}
	public static int getPort() {
		 if (System.getenv("PORT") != null) {
	            return Integer.parseInt(System.getenv("PORT"));
	        }
	        return 4567;
	}

}
