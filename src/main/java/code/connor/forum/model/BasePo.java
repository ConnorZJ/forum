package code.connor.forum.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description Pojo基类
 * @Author Connor Xiong
 * @Date 2020-05-13 22:04
 */
@Data
public abstract class BasePo implements Serializable {

    private static final long serialVersionUID = 2149368743585017186L;
    /**
     * id
     */
    private String id;

    /**
     * 创建人
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新人
     */
    private String updater;

    /**
     * 更新时间
     */
    private Date updateTime;

}
