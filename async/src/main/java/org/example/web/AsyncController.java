package org.example.web;

import org.example.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

/**
 * @author liguo
 * @Description
 * @date 2020/6/23/023 10:51
 */
@RestController
@RequestMapping("/asnc")
public class AsyncController {
    @Autowired
    AsyncService asyncService;

    @GetMapping("/movies")
    public String comletableFutureTask(){
        //开始时间
        long startTime = System.currentTimeMillis();
        //执行大量异步任务
        List<String> words = Arrays.asList("F", "T", "S", "Z", "J", "C");
        List<CompletableFuture<List<String>>> completableFutureList = words.stream()
                .map(word -> asyncService.completableFutureTask(word))
                .collect(Collectors.toList());
        //join（）方法可以获取他们的结果并将结果连接起来
        List<List<String>> result = completableFutureList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        System.out.println("Elapsed time: " + (System.currentTimeMillis() - startTime));
        return result.toString();
    }

}
