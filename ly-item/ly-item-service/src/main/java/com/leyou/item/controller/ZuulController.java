package com.leyou.item.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author chendong
 * @date 2018-07-03
 * @description
 */

@Controller
@RequestMapping("/zuul")
public class ZuulController {

    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public ResponseEntity<String> getInfo(){
        return ResponseEntity.ok("get");}

    @RequestMapping(value = "/post",method = RequestMethod.POST)
    public ResponseEntity<String> postInfo(){
        return ResponseEntity.ok("post");}

    @RequestMapping(value = "/delete",method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteInfo()  {
        return ResponseEntity.ok("delete");}

    @RequestMapping(value = "/put",method = RequestMethod.PUT)
    public ResponseEntity<String> putInfo(){
        return ResponseEntity.ok("put");
    }

}
