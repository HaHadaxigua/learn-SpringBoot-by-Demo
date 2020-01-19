package dh.study.springbootuploadingfiles.controller;


import com.sun.org.apache.xml.internal.security.keys.storage.StorageResolverException;
import dh.study.springbootuploadingfiles.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.stream.Collectors;

@Controller
public class FileUploadController {
    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping(path = "/")
    public String listFiles(Model model)throws Exception{
        model.addAttribute("files", storageService.loadAll().map(
                path -> MvcUriComponentsBuilder.fromMethodName(FileUploadController.class,
                        "serverFile", path.getFileName().toString()).build().toString())
                .collect(Collectors.toList())
        );

        return "uploadForm";
    }

    @GetMapping(path = "/file/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serverFile(@PathVariable String filename){
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+file.getFilename())
                                  .body(file);
    }

    @PostMapping(path = "/")
    public String handleUploadFile(@RequestParam("file") MultipartFile file){
        storageService.store(file);
        return "redirect: /";
    }

    @ExceptionHandler(StorageResolverException.class)
    public ResponseEntity<?> handleStorageFileNotFind(StorageResolverException exc){
        return ResponseEntity.notFound().build();
    }
}














