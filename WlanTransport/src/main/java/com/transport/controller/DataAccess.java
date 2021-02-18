package com.transport.controller;

import com.transport.utils.DataAccessUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/data")
@CrossOrigin
public class DataAccess {

    @Autowired
    DataAccessUtils dataAccessUtils;

    @GetMapping("/directory")
    String search(@RequestParam("filepath") String filepath){
        return dataAccessUtils.searchDirectory(filepath);
    }

    @RequestMapping("/download")
    String download(@RequestParam("file") String file, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        Boolean flag = dataAccessUtils.downloadFile(file, response);
        return flag ? "Download successfully!":"Download fail!";
    }

    @RequestMapping("/video")
    String videoDownload(HttpServletResponse response) throws IOException {
        return dataAccessUtils.videoLoad(response);
    }
}
