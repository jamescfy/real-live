//package com.example.demo.recursive;
//
//import lombok.val;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @Author cfy
// * @Date 2021-7-21 下午 4:13
// * @Version 1.0
// */
//public class SunToYe {
//    fun getAssessItemByRole(userId: String?): List<AssessItemNoticeVO>
//
//    {
//        val user = userMapper.selectByPrimaryKey(userId)
//        val role = user!!.role
//        val roleList = role!!.split(",")
//        val list = roleList.toList()
//        var assessItemList: java.util.ArrayList<AssessItemNoticeVO> =ArrayList<AssessItemNoticeVO> ()
//        val itemList = assessItemMapper.selectExecutorRole(list)
//        for (item in itemList) {
//            val assessItem = getParentItem(item)
//            item.parentName = assessItem.parentName
//            assessItemList.add(item)
//        }
//        return assessItemList
//    }
//
//    fun getParentItem(item: AssessItemNoticeVO): AssessItemNoticeVO {
//        var parentName = item.parentName
//        if (Constants.PARENTID.equals(item.parentId)) {
//            return item
//        }
//        val assessItem = assessItemMapper.selectItemByRole(item.parentId)
//        if (StringUtils.isEmpty(assessItem.itemId)) {
//            return item
//        }
//        if (!StringUtils.isEmpty(assessItem.parentName) && !Constants.PARENTID.equals(item.parentId)) {
//            parentName = assessItem.parentName + "/" + parentName
//        }
//        assessItem.parentName = parentName
//        return getParentItem(assessItem)
//    }
//}
