package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import top.donl.health.model.po.MentalResource;

import javax.servlet.http.HttpServletResponse;

public interface MentalResourceService extends IService<MentalResource>{

    String uploadFile(MultipartFile file);

    void downloadFile(String fileId, HttpServletResponse response);
}
