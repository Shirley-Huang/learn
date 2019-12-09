package com.dandan.work.handler.api.problem;

import com.dandan.work.handler.api.ServiceResponse;
import lombok.Data;

import java.util.List;

/**
 * @Description
 * @Author dandan
 * @Date 2019-12-06
 */
@Data
public class SearchProblemsResponse  extends ServiceResponse {

    private List<Problem> problems;

}
