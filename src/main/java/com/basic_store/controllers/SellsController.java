package com.basic_store.controllers;

import com.basic_store.models.OrderedItem;
import com.basic_store.models.SellProduct;
import com.basic_store.models.User;
import com.basic_store.repos.ItemRepo;
import com.basic_store.repos.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

@Controller
public class SellsController {

    @Autowired
    ProductRepo productRepo;
    @Value("${upload.path}")
    private String uploadPath;

    @GetMapping("/sells")
    public String main(Map<String, Object> model) {

        return "sells";
    }

    private void saveFile(@Valid SellProduct product, @RequestParam("file") MultipartFile file) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            //tring uuidFile = UUID.randomUUID().toString();
            //String resultFilename = uuidFile + "." + file.getOriginalFilename();
            String resultFilename = file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            product.setFilename(resultFilename);
        }
    }

    @PostMapping("/sells")
    public String updateMessage(
            @AuthenticationPrincipal User currentUser,
            @RequestParam("type") String type,
            SellProduct product,
            @RequestParam("file") MultipartFile file
    ) throws IOException {


            if (!StringUtils.isEmpty(type)) {
                product.setType(type);
            }

            product.setSeller(currentUser);

            saveFile(product, file);

            productRepo.save(product);


        return "redirect:/home";
    }
}
