package top.donl.health.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;
import top.donl.health.model.bean.resource.MentalResourceBean;
import top.donl.health.model.po.MentalResource;
import top.donl.health.model.query.resource.MentalResourceQuery;
import top.donl.health.model.vo.resource.MentalResourceVO;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.common.domain.query.BaseQuery;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface MentalResourceService extends IService<MentalResource>{

    String uploadFile(MultipartFile file);

    void downloadFile(String fileId, HttpServletResponse response);

    MentalResourceVO add(MentalResourceBean bean);

    MentalResourceVO update(MentalResourceBean bean);

    PageResult<MentalResourceVO> list(MentalResourceQuery query);
}
