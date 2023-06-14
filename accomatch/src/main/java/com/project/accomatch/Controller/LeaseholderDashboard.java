package com.project.accomatch.Controller;

import com.project.accomatch.Model.Posts;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/leaseowner/dashboard")
public class LeaseholderDashboard {


    @GetMapping("/get/list/post")
    public List<String> getListOfPosts() {
        List<Posts> listOfPosts = new ArrayList<>();
        Posts application = new Posts(
                12345,
                12345667,
                "Application Title",
                "Application Subtitle",
                "123 Main Street",
                "City Name",
                1000,
                "Single Room",
                "https://example.com/image.jpg", // Image URL
                500.00,
                "Other Preferences",
                new Date(),
                20,
                30,
                true,
                new Date(),
                new Date()
        );
        listOfPosts.add(application);

        return null;
    }
}
