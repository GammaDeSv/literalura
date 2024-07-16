package com.literalura.client;

import com.literalura.model.Libro;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GutendexClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String API_URL = "https://gutendex.com/books/";

    public List<Libro> fetchLibros(String query) {
        String url = API_URL + "?search=" + query;
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);
        if (response != null && response.getResults() != null) {
            return Arrays.stream(response.getResults())
                    .map(book -> new Libro(book.getTitle(), book.getAuthors()[0].getName(), book.getLanguages()[0], book.getUrl()))
                    .collect(Collectors.toList());
        }
        return Arrays.asList(); // Cambiado de List.of() a Arrays.asList()
    }

    static class GutendexResponse {
        private GutendexBook[] results;

        // Getters y setters
        public GutendexBook[] getResults() {
            return results;
        }

        public void setResults(GutendexBook[] results) {
            this.results = results;
        }
    }

    static class GutendexBook {
        private String title;
        private GutendexAuthor[] authors;
        private String[] languages;
        private String url;

        // Getters y setters
        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public GutendexAuthor[] getAuthors() {
            return authors;
        }

        public void setAuthors(GutendexAuthor[] authors) {
            this.authors = authors;
        }

        public String[] getLanguages() {
            return languages;
        }

        public void setLanguages(String[] languages) {
            this.languages = languages;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    static class GutendexAuthor {
        private String name;

        // Getters y setters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
