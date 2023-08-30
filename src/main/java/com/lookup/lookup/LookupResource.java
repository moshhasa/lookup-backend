package com.lookup.lookup;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class LookupResource {

    @GetMapping(path ="/lookup/{customerEmail}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Response lookup(@PathVariable("customerEmail")String customerEmail)
    {
        Random rand = new Random();
        int randomNum = rand.nextInt((10 - 1) + 1) + 1;
        String message =  "Customer " + customerEmail + " has a credit rating of " + randomNum;
        if(randomNum <= 4) return new Response(randomNum, "danger", message);
        if(randomNum <= 7) return new Response(randomNum, "info", message);
        return new Response(randomNum, "success", message);
    }

    public static class Response {
        private int rating;
        private String ratingIndicator;
        private String message;

        public Response()
        {}

        public Response(int rating,  String ratingIndicator, String message) {
            this.rating = rating;
            this.message = message;
            this.ratingIndicator = ratingIndicator;
        }

        public String getRatingIndicator() {
            return ratingIndicator;
        }

        public void setRatingIndicator(String ratingIndicator) {
            this.ratingIndicator = ratingIndicator;
        }

        public int getRating() {
            return rating;
        }

        public void setRating(int rating) {
            this.rating = rating;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
