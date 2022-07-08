package top.ray4j.common.validator.group;

import javax.validation.GroupSequence;

/**
 * 定义检验顺序，如果AddGroup组失败，则UpdateGroup组不会再校验
 *
 * @author: Cr.
 * @date: 2022/7/7
 */
@GroupSequence({AddGroup.class, UpdateGroup.class})
public interface Group {
}
