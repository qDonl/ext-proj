package top.donl.health.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import top.donl.util.exceptioins.BaseAssert;

@Getter
@AllArgsConstructor
public enum BizErrorEnum implements BaseAssert {

    /**
     * 文件上传失败
     */
    FILE_UPLOAD_FAIL(8000_001, "文件上传失败"),

    /**
     * 文件未找到
     */
    FILE_NOT_FOUND(8000_002, "文件未找到"),

    /**
     * 文件下载失败
     */
    FILE_DOWNLOAD_FAIL(8000_003, "文件下载失败"),
    ;

    private final Integer code;
    private final String msg;
}
