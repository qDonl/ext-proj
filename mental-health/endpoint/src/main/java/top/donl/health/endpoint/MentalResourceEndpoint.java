package top.donl.health.endpoint;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;
import top.donl.health.model.bean.resource.MentalResourceBean;
import top.donl.health.model.query.resource.MentalResourceQuery;
import top.donl.health.model.vo.resource.MentalResourceVO;
import top.donl.health.service.MentalResourceService;
import top.donl.util.common.domain.page.PageResult;
import top.donl.util.response.BaseResponse;

import javax.servlet.http.HttpServletResponse;


@Api(tags = "资源管理")
@RestController
@RequestMapping(value = "/mental-resource")
@RequiredArgsConstructor
public class MentalResourceEndpoint {

    private final MentalResourceService mentalResourceService;

    @ApiOperation(value = "上传文件")
    @PostMapping("/upload")
    public BaseResponse<String> upload(@RequestParam("file") MultipartFile file) {
        return BaseResponse.success(mentalResourceService.uploadFile(file));
    }

    @GetMapping("/download")
    @ApiOperation(value = "下载附件")
    public void download(@RequestParam("attachmentId") String attachmentId, HttpServletResponse response) {
        mentalResourceService.downloadFile(attachmentId, response);
    }

    @ApiOperation(value = "添加资源")
    @PostMapping("/add")
    public BaseResponse<MentalResourceVO> add(@Validated(value = {InsertGroup.class}) @RequestBody MentalResourceBean bean) {
        return BaseResponse.success();
    }

    @ApiOperation(value = "更新资源")
    @PutMapping("/update")
    public BaseResponse<MentalResourceVO> upodate(@Validated(value = {UpdateGroup.class}) @RequestBody MentalResourceBean bean) {
        return BaseResponse.success();
    }

    @ApiOperation(value = "资源列表")
    @GetMapping("/list")
    public BaseResponse<PageResult<MentalResourceVO>> list(@RequestParam MentalResourceQuery query) {
        return BaseResponse.success();
    }
}
