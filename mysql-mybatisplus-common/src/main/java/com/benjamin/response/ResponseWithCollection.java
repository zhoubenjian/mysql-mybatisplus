package com.benjamin.response;

import com.benjamin.request.BasePageRequest;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Collection;
import java.util.Collections;

@Data
@Accessors(chain = true)
public class ResponseWithCollection<T> extends BaseResponse {
    private Long page;
    private Long size;
    private Long count;
    private Collection<T> list;


    public ResponseWithCollection() {
        this.page = 1L;
        this.size = 10L;
        this.count = 0L;
        this.list = Collections.emptyList();
    }


    /**
     * 构建分页响应
     * @param request
     * @param list
     * @param count
     * @param <T>
     * @return
     */
    public static <T> ResponseWithCollection<T> buildResponse(BasePageRequest request, Collection<T> list, Long count) {
        return new ResponseWithCollection<T>()
                .setPage(request.getPage())
                .setSize(request.getPageSize())
                .setCount(count).setList(list);

    }

    /**
     * 构建分页响应
     * @param page
     * @param size
     * @param list
     * @param count
     * @param <T>
     * @return
     */
    public static <T> ResponseWithCollection<T> buildResponse(Long page, Long size, Collection<T> list, Long count) {
        return new ResponseWithCollection<T>()
                .setPage(page)
                .setSize(size)
                .setCount(count)
                .setList(list);
    }
}
