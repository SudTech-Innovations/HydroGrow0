package vinckier.hydrogrow_v3;

import org.springframework.web.client.RestTemplate;

public class Index {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://trefle.io/api/v1/plants?token={token}&filter_not[common_name]=null&order[common_name]=asc&page_size=10";

        // Remplacez {token} par votre clé API Trefle
        String apiKey = "7e9WnfXHyYnks7ZQpHdmmyplCR1TawDWb7iXOl04pZo";
        String url = apiUrl.replace("{token}", apiKey);

        // Effectue une requête GET sur l'API Trefle en utilisant RestTemplate
        TrefleResponse response = restTemplate.getForObject(url, TrefleResponse.class);

        // Extraire les résultats
        System.out.println("Liste des 10 premiers éléments de l'API Trefle :");
        response.getData().stream().forEach(item -> System.out.println(item.getScientific_name()));
    }
}
