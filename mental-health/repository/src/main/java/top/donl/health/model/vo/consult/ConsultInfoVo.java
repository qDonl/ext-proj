package top.donl.health.model.vo.consult;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import top.donl.health.model.vo.consultReply.ConsultReplyVO;

import java.util.List;

/**
 * @author Crux
 * @since 2023-03-19 11:59:27
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "咨询+回复内容")
public class ConsultInfoVo {

    private ConsultVO consult;

    private List<ConsultReplyVO> replyList;
}
