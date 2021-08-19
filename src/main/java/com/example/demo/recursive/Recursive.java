//import java.util.Objects;
//
//package com.example.demo.recursive;
////
////import com.example.demo.easy.excel.OrderExcelModel;
////
////import java.util.ArrayList;
////import java.util.List;
////import java.util.Map;
////
/////**
//// * @Author cfy
//// * @Date 2021-5-12 下午 2:54
//// * @Version 1.0
//// */
////public class Recursive {
////    private List<Map<String, Object>> getLevelData(List<Map<String, Object>> dbList, Integer parentcode) {
////        List<Map<String, Object>> resultList = new ArrayList<>();
////        for (Map<String, Object> data : dbList) {
////            if (data.get("parentcode") == parentcode) {
////                List<Map<String, Object>> childList = getLevelData(dbList, (Integer)data.get("code"));
////                data.put("children", childList);
////                resultList.add(data);
////            }
////        }
////        return resultList;
////    }
////
////    public static List<OrderExcelModel> treeMenuList(List<OrderExcelModel> menuList, int pid){
////        for(OrderExcelModel mu: menuList){
////            //遍历出父id等于参数的id，add进子节点集合
////            if(Integer.valueOf(mu.getPid())==pid){
////                //递归遍历下一级
////                treeMenuList(menuList,Integer.valueOf(mu.getId()));
////                childMenu.add(mu);
////            }
////        }
////        return childMenu;
////
////}
//public class Recursive {
//    public TblCategory getParentCategoryObject(TblCategory category) {
//        if (category.getParentId() == 1) {
//            return category;
//        }
//
//        TblCategory tblCategory = allCategory.stream().filter(
//                x -> Objects.equals(x.getCategoryId(), category.getParentId())
//        ).findFirst().get();
//
//        return getParentCategoryObject(tblCategory);
//    }
//}
