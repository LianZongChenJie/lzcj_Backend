package cn.iocoder.yudao.module.site.controller.front.teamgallery.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

/**
 * 展示端 - 员工风采 响应 VO
 *
 * @author 联纵宸捷
 */
@Data
@Schema(description = "展示端 - 员工风采 响应 VO")
public class TeamGallerySimpleRespVO {

    @Schema(description = "员工风采列表")
    private List<Item> items;

    public TeamGallerySimpleRespVO() {
    }

    public TeamGallerySimpleRespVO(List<Item> items) {
        this.items = items;
    }

    @Data
    @Schema(description = "员工风采项")
    public static class Item {

        @Schema(description = "主键ID", example = "1")
        private Long id;

        @Schema(description = "图片URL", example = "https://cdn.example.com/site/team/1.jpg")
        private String image;

        @Schema(description = "图片描述", example = "部门团建活动")
        private String description;

    }

}
