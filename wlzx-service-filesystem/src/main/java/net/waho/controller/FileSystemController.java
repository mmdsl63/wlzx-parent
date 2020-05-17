package net.waho.controller;

import net.waho.service.FileSystemService;
import net.wanho.api.filesystem.FileSystemControllerApi;
import net.wanho.common.vo.response.AjaxResult;
import net.wanho.common.web.BaseController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 16:22
 **/
@RestController
@RequestMapping("/filesystem")
public class FileSystemController extends BaseController implements FileSystemControllerApi {

    @Resource
    private FileSystemService service;

    @Override
    @PostMapping("/upload")
    public AjaxResult upload(MultipartFile multipartFile, String fileTag, String businessKey, String metadata) {
        return success(service.upload(multipartFile, fileTag, businessKey, metadata));
    }

}
