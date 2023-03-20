package top.donl.health.model.bean.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.donl.health.common.validation.InsertGroup;
import top.donl.health.common.validation.UpdateGroup;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <p></p>
 *
 * @author crux
 * @since 2023/03/06 09:54:53
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "资源推荐")
public class MentalResourceBean {

    @ApiModelProperty(value = "资源推荐ID")
    @NotNull(message = "资源ID不能为空", groups = {UpdateGroup.class})
    private Long id;

    @Max(value = 50, message = "标题最长50字符", groups = {InsertGroup.class, UpdateGroup.class})
    @NotBlank(message = "标题不能为空", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "资源标题", required = true)
    private String title;

    @Max(value = 512, message = "资源缩略图地址资源最长512", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "资源缩略图")
    private String thumbnail;

    @NotBlank(message = "请上传资源", groups = {InsertGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "上传后的资源ID", required = true)
    private String attachment;
}
