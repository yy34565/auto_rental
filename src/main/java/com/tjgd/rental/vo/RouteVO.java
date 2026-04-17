package com.tjgd.rental.vo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.util.RouteMatcher;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class RouteVO {
    private String path;
    private String name;
    private String component;
    private Boolean alwaysShow;
    private List<RouteVO> children;
    private Meta meta;

//    private String redirect;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Meta {
        private String title;
        private String icon;
        private Object[] roles;
    }

}
