package net.waho.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.tobato.fastdfs.domain.fdfs.StorePath;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import net.waho.mapper.FileSystemMapper;
import net.wanho.common.exception.ExceptionCast;
import net.wanho.common.util.StringUtils;
import net.wanho.po.course.response.CourseCode;
import net.wanho.po.filesystem.FileSystem;
import net.wanho.po.filesystem.response.FileSystemCode;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * @program: wlzx-parent
 * @description
 * @author: 朱旭凡
 * @create: 2020-05-17 16:21
 **/
@Service
public class FileSystemService extends ServiceImpl<FileSystemMapper, FileSystem> {

    @Resource
    private FastFileStorageClient fastFileStorageClient;

    /**
     * 文件上传
     * @param multipartFile
     * @param fileTag
     * @param businessKey
     * @param metadata
     * @return
     */
    public StorePath upload(MultipartFile multipartFile, String fileTag, String businessKey, String metadata) {

        // 如果文件不存在
        if (StringUtils.isEmpty(multipartFile)) {
            ExceptionCast.cast(CourseCode.COURSE_MEDIS_URLISNULL);
        }

        // 上传文件至文件服务器
        // 原始的名字，即上传之前的名字
        String originalFilename = multipartFile.getOriginalFilename();
        // 从最后一个 .开始得到后缀 前包后不包
        assert originalFilename != null;
        String suffix = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        // 自动关闭流
        try (InputStream is = multipartFile.getInputStream()) {
            StorePath storePath = fastFileStorageClient.uploadFile(is, is.available(), suffix, null);

            // 保存到服务器
            FileSystem fileSystem = new FileSystem();
            // 设置上传之后的路径 组名 + 路径
            fileSystem.setFilePath(storePath.getFullPath());
            // 设置原始名字
            fileSystem.setFileName(originalFilename);
            // 设置业务键
            fileSystem.setBusinessKey(businessKey);
            // 设置标签
            fileSystem.setFileTag(fileTag);
            // 添加
            save(fileSystem);

            return storePath;
        } catch (IOException e) {
            ExceptionCast.cast(FileSystemCode.FS_UPLOADFILE_SERVERFAIL);
        }
        return null;
    }

}
