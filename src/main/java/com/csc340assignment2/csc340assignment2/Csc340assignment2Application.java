package com.csc340assignment2.csc340assignment2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class Csc340assignment2Application 
{

	public static void main(String[] args)
        {
		SpringApplication.run(Csc340assignment2Application.class, args);
                getYgoNameDesc();
                getPCGames();
                System.exit(0);
	}
        
            public static void getYgoNameDesc() {
        try {
            String url = "https://db.ygoprodeck.com/api/v7/cardinfo.php";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String name = root.findValue("name").asText();
            String desc = root.findValue("desc").asText();

            System.out.println("**********Yu-Gi-Oh! Facts********");
            System.out.println("Name: " + name);
            System.out.println("Description: " + desc + "\n");

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Csc340assignment2Application.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getYgoNameDesc");
            }
        }
            
        public static void getPCGames() {
        try {
            String url = "https://www.freetogame.com/api/games?platform=pc";
            RestTemplate restTemplate = new RestTemplate();
            ObjectMapper mapper = new ObjectMapper();

            String jSonFact = restTemplate.getForObject(url, String.class);
            JsonNode root = mapper.readTree(jSonFact);

            String title = root.findValue("title").asText();
            String developer = root.findValue("developer").asText();

            System.out.println("**********Games Facts********");
            System.out.println("Title: " + title);
            System.out.println("Developer: " + developer);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(Csc340assignment2Application.class.getName()).log(
                    Level.SEVERE,
                    null, ex);
            System.out.println("error in getGames");
            }
        }

}
