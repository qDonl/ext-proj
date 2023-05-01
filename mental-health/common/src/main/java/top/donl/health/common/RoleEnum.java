package top.donl.health.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.apache.commons.lang3.StringUtils;
import top.donl.health.common.model.dto.BaseDictDTO;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * <p>用户角色</p>
 *
 * @author crux
 * @since 2023/03/13 09:27:30
 */


@Getter
@AllArgsConstructor
public enum RoleEnum {

    /**
     * 学生
     */
    STUDENT(0, "学生"),
    /**
     * 教师
     */
    TEACHER(1, "教师"),
    /**
     * 管理员
     */
    ADMIN(2, "管理员"),
    ;

    public static String getName(Integer code) {
        Optional<RoleEnum> opt = Arrays.stream(values()).filter(v -> v.getCode().equals(code)).findFirst();
        if (opt.isPresent()) {
            return opt.get().getName();
        }

        return StringUtils.EMPTY;
    }

    private final Integer code;
    private final String name;

    public static List<BaseDictDTO> dictDto() {
        return Arrays.stream(values()).map(v -> new BaseDictDTO(v.getCode(), v.getName())).collect(Collectors.toList());
    }
}
