package com.project.accomatch.Controller;

import com.project.accomatch.Model.Posts;
import com.project.accomatch.Model.Posts;
import com.project.accomatch.Service.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.accomatch.Service.Implementation.LeaseHolderDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/admin")
public class AdminController {


    @Autowired
    AdminInterface adminInterface;

    @PostMapping("/admin/verifyone")
    public String verifySingleAd(@RequestBody Posts posts){
        return adminInterface. VerifyOneAd(posts);
    }

    @PostMapping("/admin/verifyall")
    public String verifyAllAd(@RequestBody Posts posts){
        return adminInterface.VerifyAllAd(posts);
    }
    @Autowired
    private LeaseHolderDashboardService dashboardService;

    /**
     * Retrieves the list of posts for Admin.
     * @author Ramandeep kaur
     * @return The list of posts.
     */
    @GetMapping("/get/list/post")
    public List<Posts> getListOfPosts() {
        return dashboardService.getListOfPosts();
    }

    /**
     * Retrieves the list of posts for Admin bases on status.
     * @author Ramandeep kaur
     * @return The list of posts.
     */
    @GetMapping("/get/list/post/{status}")
    public List<Posts> getListOfPostsByStatus(int status)
    {
        return dashboardService.getListOfPostsByStatus(status);
    }

}