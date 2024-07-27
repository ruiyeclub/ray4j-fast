package top.ray4j.manage.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.Data;

/**
 * @author Cr.
 * @date 2024/5/17
 */
@ApiModel
@Data
public class PageData {

    @ApiParam(value = "分页数")
    private Integer page = 1;
    @ApiParam(value = "分页量")
    private Integer pageSize = 10;
}
