package com.embarkx.jobms.Client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.embarkx.jobms.JobFolder.External.Review;

@FeignClient(name = "REVIEW-SERVICE")
public interface ReviewClinet {

    @GetMapping("/reviews")
    List<Review> getReviews(@RequestParam("companyId") Long id);

}
