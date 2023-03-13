package top.donl.health.model.vo.dict;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import top.donl.health.common.model.dto.BaseDictDTO;

import java.util.List;

/**
 * <p>基础字典表</p>
 *
 * @author crux
 * @since 2023/03/13 09:36:50
 */

@Data
@AllArgsConstructor
public final class BaseDictVO {

    @ApiModelProperty(value = "用户角色")
    private final List<BaseDictDTO> roleList;
}
