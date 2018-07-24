package com.leyou.item.service.impl;

import com.leyou.item.bean.ItemInfoBean;
import com.leyou.item.mapper.ItemInfoMapper;
import com.leyou.item.service.IItemInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chendong
 * @date 2018-07-03
 * @description
 */

@Service("itemService")
public class ItemserviceInfoImpl implements IItemInfoService {
   private static Logger logger = LoggerFactory.getLogger(ItemserviceInfoImpl.class);

    @Autowired
    private ItemInfoMapper itemInfoMapper;

    public ItemInfoBean queryById(ItemInfoBean item){
        ItemInfoBean result = itemInfoMapper.selectOne(item);
        return result==null?new ItemInfoBean():result;
    }
}
