package top.donl.health.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;
import top.donl.health.common.BizErrorEnum;
import top.donl.health.configurer.properties.FileProperty;
import top.donl.health.converter.MentalResourceConverter;
import top.donl.health.mapper.MentalResourceMapper;
import top.donl.health.model.bean.resource.MentalResourceBean;
import top.donl.health.model.po.MentalResource;
import top.donl.health.model.query.resource.MentalResourceQuery;
import top.donl.health.model.vo.resource.MentalResourceVO;
import top.donl.health.service.MentalResourceService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.exceptioins.RestResponseExceptionEnum;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class MentalResourceServiceImpl
        extends ServiceImpl<MentalResourceMapper, MentalResource>
        implements MentalResourceService {

    private final MentalResourceConverter mentalResourceConverter;

    private final FileProperty fileProperty;

    @Override
    public String uploadFile(MultipartFile file) {
        RestResponseExceptionEnum.SYSTEM_ERROR.assertIsTrue(file != null, "请选择要上传的文件");

        String filename = getFileName(file.getOriginalFilename());
        String filePath = getUploadPath();
        String save2File = filePath + File.separator + filename;
        System.out.println(save2File);
        try (BufferedOutputStream out = new BufferedOutputStream(
                new FileOutputStream(new File(save2File))
        )) {
            out.write(file.getBytes());
            out.flush();
        } catch (FileNotFoundException e) {
            log.error("文件上传失败", e);
            BizErrorEnum.FILE_UPLOAD_FAIL.errorMsg("文件上传失败: " + e.getMessage());
        } catch (IOException e) {
            log.error("文件上传失败: ", e);
            BizErrorEnum.FILE_UPLOAD_FAIL.errorMsg("文件上传失败: " + e.getMessage());
        }
        return filename;
    }

    @Override
    public void downloadFile(String fileId, HttpServletResponse response) {
        RestResponseExceptionEnum.CUSTOM_ERROR.assertIsTrue(StringUtils.isNotBlank(fileId), "文件id不能为空");
        String path = getUploadPath();
        String filePath = path + File.separator + fileId;

        try {
            InputStream is = new FileInputStream(filePath);
            response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileId, "UTF-8"));
            IOUtils.copy(is, response.getOutputStream());
            response.flushBuffer();
        } catch (Exception e) {
            log.error("下载文件异常");
            BizErrorEnum.FILE_DOWNLOAD_FAIL.errorMsg();
        }
    }

    @Override
    public MentalResourceVO add(MentalResourceBean bean) {
        MentalResource po = mentalResourceConverter.bean2Po(bean);
        baseMapper.insert(po);
        return mentalResourceConverter.po2Vo(po);
    }

    @Override
    public MentalResourceVO update(MentalResourceBean bean) {
        MentalResource po = mentalResourceConverter.bean2Po(bean);
        baseMapper.updateById(po);
        return mentalResourceConverter.po2Vo(po);
    }

    @Override
    public PageResult<MentalResourceVO> list(MentalResourceQuery query) {
        long total = baseMapper.findTotalCountByQuery(query);
        if (total == 0) {
            return PageResult.toPageResult(null, query, total);
        }

        List<MentalResourceVO> list = baseMapper.findByList(query);
        return PageResult.toPageResult(list, query, total);
    }

    private String getFileName(String fileName) {
        int index = fileName.lastIndexOf(".");
        fileName = fileName.substring(0, index) + "_" + UUID.randomUUID().toString() + fileName.substring(index);
        return fileName;
    }


    /**
     * 获取当前系统路径
     */
    private String getUploadPath() {
        File path = null;
        try {
            path = new File(ResourceUtils.getURL("classpath:").getPath());
            System.out.println(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (!path.exists()) path = new File("");
        File upload = new File(path.getAbsolutePath(), fileProperty.getFolder());
        if (!upload.exists()) upload.mkdirs();
        return upload.getAbsolutePath();
    }
}
