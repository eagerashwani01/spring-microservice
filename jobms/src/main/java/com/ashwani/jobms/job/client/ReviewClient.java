package com.ashwani.jobms.job.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ashwani.jobms.job.external.Review;

@FeignClient(name = "REVIEWMS")
public interface ReviewClient {
    
    @GetMapping("/reviews")
    List<Review> getAllReview(@RequestParam("companyId") Long companyId);
}
