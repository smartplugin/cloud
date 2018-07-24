package com.leyou.item.controller;

import com.leyou.item.bean.ItemInfoBean;
import com.leyou.item.service.IItemInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author chendong
 * @date 2018-07-03
 * @description
 */
@Controller
public class ItemInfoController {

    @Autowired
    private IItemInfoService itemService;


    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ItemInfoBean> queryItemInfoBeanById(@PathVariable Long id) {
        if (id == null || "".equals(id.toString())) {
            return ResponseEntity.status(500).body(null);
        }
        ItemInfoBean item = new ItemInfoBean();
        item.setGoodId(id.intValue());
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date sDate = null;
        try {
            java.util.Date date3 = sdf2.parse("2018-07-04");
            sDate = new java.sql.Date(date3.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(sDate); // 2017-12-01
        item.setOperDate(sDate);
        ItemInfoBean item1 = itemService.queryById(item);
        if (item1 == null) {
            return ResponseEntity.status(500).body(item1);
        }
        return ResponseEntity.ok(item1);
    }
}
